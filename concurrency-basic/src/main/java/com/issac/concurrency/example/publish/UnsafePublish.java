package com.issac.concurrency.example.publish;

import com.issac.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.states));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.states));

    }
}
