package com.itheima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JinLu
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    /**
     * 调用此方法要求当前用户必须具有add权限
     * @return
     */
    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('add')")
    public String add(){
        System.out.println("add...");
        return "success";
    }

    /**
     * 调用此方法要求当前用户必须具有ROLE_ADMIN角色
     * @return
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(){
        System.out.println("delete...");
        return "success";
    }
}
