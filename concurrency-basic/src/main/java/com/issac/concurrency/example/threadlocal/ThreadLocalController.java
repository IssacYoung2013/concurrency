package com.issac.concurrency.example.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
       return RequestHolder.getId();
    }
}
