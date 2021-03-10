package com.javakc.cms.book.controller;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/user")
@CrossOrigin
public class LoginController {

    @PostMapping("login")
    public APICODE login() {
        return APICODE.OK().data("token", "admin");
    }

    @GetMapping("info")
    public APICODE info() {
        return APICODE.OK().data("roles", "[admin]").data("name", "admin");
    }

}