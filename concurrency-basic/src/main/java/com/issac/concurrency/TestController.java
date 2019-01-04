package com.issac.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@RestController
@Slf4j
public class TestController {


    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
