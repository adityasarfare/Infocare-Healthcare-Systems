package com.javaguides.clientapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "second-server", url = "http://localhost:8070")
public interface SecondServerProxy {
    @PostMapping("/multiply")
    double multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2);
}
