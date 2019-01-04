package com.issac.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestParam("k") String k,@RequestParam("v") String v) throws Exception{
        redisClient.set(k,v);
        return "SUCCESS";
    }

    @RequestMapping("/get")
    public String get(@RequestParam("k") String k) throws Exception {
        return redisClient.get(k);
    }
}
