package com.huanyu.fun.crawler.controller;

import com.huanyu.fun.crawler.entity.WeChatOfficialAccount;
import com.huanyu.fun.crawler.service.IWeChatOfficialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: sunsf
 * @date: 2020/3/18 13:47
 */
@RestController
@RequestMapping("/weChatOfficialAccount")
public class WeChatOfficialAccountController {

    @Autowired
    private IWeChatOfficialAccountService weChatOfficialAccountService;

    @PostMapping("/save")
    public void create(@RequestBody WeChatOfficialAccount WeChatOfficialAccount) {
        System.out.println(123);
        weChatOfficialAccountService.save(WeChatOfficialAccount);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id", required = true) Integer id) {
        weChatOfficialAccountService.delete(id);
    }

    @GetMapping("/query/{id}")
    public void query(
            @PathVariable(value = "id", required = true) Integer id) {
        weChatOfficialAccountService.query(id);
    }


}
