package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.service.MemberService;
import com.itheima.service.ReportService;
import com.itheima.service.SetmealService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 报表操作
 *
 * @author JinLu
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Reference
    private MemberService memberService;

    @Reference
    private SetmealService setmealService;

    @Reference
    private ReportService reportService;

    /**
     * 会员数量折线图数据
     *
     * @return
     */
    @RequestMapping("/getMemberReport")
    public Result getMemberReport() {
        Map<String, Object> map = new HashMap<>(16);
        List<String> months = new ArrayList();
        //获得日历对象，模拟时间就是当前时间
        Calendar calendar = Calendar.getInstance();
        //计算过去一年的12个月
        //获得当前时间往前推12个月的时间
        calendar.add(Calendar.MONTH, -12);
        int a = 12;
        for (int i = 0; i < a; i++) {
            //获得当前时间往后推一个月日期
            calendar.add(Calendar.MONTH, 1);
            Date date = calendar.getTime();
            months.add(new SimpleDateFormat("yyyy.MM").format(date));
        }
        map.put("months", months);

        List<Integer> memberCount = memberService.findMemberCountByMonths(months);
        map.put("memberCount", memberCount);
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS, map);
    }

    /**
     * 获取套餐报告
     *
     * @return
     */
    @RequestMapping("/getSetmealReport")
    public Result getSetmealReport() {
        //使用模拟数据测试使用什么样的java对象转为饼形图所需的json数据格式
        Map<String, Object> data = new HashMap<>(16);

        try {
            List<Map<String, Object>> setmealCount = setmealService.findSetmealCount();
            data.put("setmealCount", setmealCount);

            List<String> setmealNames = new ArrayList<>();
            for (Map<String, Object> map : setmealCount) {
                //套餐名称
                String name = (String) map.get("name");
                setmealNames.add(name);
            }

            data.put("setmealNames", setmealNames);
            return new Result(true, MessageConstant.GET_SETMEAL_COUNT_REPORT_SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_SETMEAL_COUNT_REPORT_FAIL);
        }
    }

    /**
     * 获取业务报告数据
     *
     * @return
     */
    @RequestMapping("/getBusinessReportData")
    public Result getBusinessReportData() {
        try {
            Map<String, Object> data = reportService.getBusinessReport();
            return new Result(true, MessageConstant.GET_BUSINESS_REPORT_SUCCESS, data);
        } catch (Exception e) {
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        }
    }

    /**
     * 导出Excel表格
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/exportBusinessReport")
    public Result exportBusinessReport(HttpServletRequest request, HttpServletResponse response) {
        //远程调用报表服务获取报表数据
        try {
            Map<String, Object> result = reportService.getBusinessReport();
            //取出返回结果数据，准备将报表数据写入到Excel文件中
            String reportDate = (String) result.get("reportDate");
            Integer todayNewMember = (Integer) result.get("todayNewMember");
            Integer totalMember = (Integer) result.get("totalMember");
            Integer thisWeekNewMember = (Integer) result.get("thisWeekNewMember");
            Integer thisMonthNewMember = (Integer) result.get("thisMonthNewMember");
            Integer todayOrderNumber = (Integer) result.get("todayOrderNumber");
            Integer thisWeekOrderNumber = (Integer) result.get("thisWeekOrderNumber");
            Integer thisMonthOrderNumber = (Integer) result.get("thisMonthOrderNumber");
            Integer todayVisitsNumber = (Integer) result.get("todayVisitsNumber");
            Integer thisWeekVisitsNumber = (Integer) result.get("thisWeekVisitsNumber");
            Integer thisMonthVisitsNumber = (Integer) result.get("thisMonthVisitsNumber");
            List<Map> hotSetmeal = (List<Map>) result.get("hotSetmeal");

            String filePath = request.getSession().getServletContext().getRealPath("template") + File.separator + "report_template.xlsx";
            //基于提供的Excel模板文件在内存中创建一个Excel表格对象
            XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File(filePath)));
            //读取第一个工作表
            XSSFSheet sheet = excel.getSheetAt(0);

            XSSFRow row = sheet.getRow(2);
            //日期
            row.getCell(5).setCellValue(reportDate);

            row = sheet.getRow(4);
            //新增会员数（本日）
            row.getCell(5).setCellValue(todayNewMember);
            //总会员数
            row.getCell(7).setCellValue(totalMember);

            row = sheet.getRow(5);
            //本周新增会员数
            row.getCell(5).setCellValue(thisWeekNewMember);
            //本月新增会员数
            row.getCell(7).setCellValue(thisMonthNewMember);

            row = sheet.getRow(7);
            //今日预约数
            row.getCell(5).setCellValue(todayOrderNumber);
            //今日到诊数
            row.getCell(7).setCellValue(todayVisitsNumber);

            row = sheet.getRow(8);
            //本周预约数
            row.getCell(5).setCellValue(thisWeekOrderNumber);
            //本周到诊数
            row.getCell(7).setCellValue(thisWeekVisitsNumber);

            row = sheet.getRow(9);
            //本月预约数
            row.getCell(5).setCellValue(thisMonthOrderNumber);
            //本月到诊数
            row.getCell(7).setCellValue(thisMonthVisitsNumber);

            int rowNum = 12;
            //热门套餐
            for (Map map : hotSetmeal) {
                String name = (String) map.get("name");
                Long setmeal_count = (Long) map.get("setmeal_count");
                BigDecimal proportion = (BigDecimal) map.get("proportion");
                row = sheet.getRow(rowNum++);
                //套餐名称
                row.getCell(4).setCellValue(name);
                //预约数量
                row.getCell(5).setCellValue(setmeal_count);
                //占比
                row.getCell(6).setCellValue(proportion.doubleValue());
            }

            //使用输出流进行表格下载,基于浏览器作为客户端下载
            OutputStream out = response.getOutputStream();
            //代表的是Excel文件类型
            response.setContentType("application/vnd.ms-excel");
            //指定以附件形式进行下载
            response.setHeader("content-Disposition", "attachment;filename=report.xlsx");
            excel.write(out);

            out.flush();
            out.close();
            excel.close();
            return null;
        } catch (Exception e) {
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        }
    }
}

