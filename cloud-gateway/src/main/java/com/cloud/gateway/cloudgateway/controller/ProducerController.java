package com.cloud.gateway.cloudgateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProducerController {

  @RequestMapping("/hi")
  public String hi(@RequestParam String name) {
    log.info("[client服务] [hi方法]收到请求");
    return "hi " + name + ",i am from service-client";
  }
}