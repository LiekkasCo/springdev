package com.lc.springdev.controller;

import com.lc.springdev.config.RabbitConfig;
import com.lc.springdev.data.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用rabbit生产者
 * @author liangchen
 */
@RestController
public class RabbitController extends BaseController {
    @PostMapping("/rabbit/test")
    public JsonResult testRabbit(){
        service().rabbitService.send(RabbitConfig.DIRECT_EXCHANGE_TEST,RabbitConfig.ROUTER_KEY_TEST);
        return success();
    }
}
