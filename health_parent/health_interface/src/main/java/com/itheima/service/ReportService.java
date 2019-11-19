package com.itheima.service;

import java.util.Map;

/**
 * @author JinLu
 */
public interface ReportService {
    /**
     * 获取业务报告数据
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> getBusinessReport() throws Exception;
}
