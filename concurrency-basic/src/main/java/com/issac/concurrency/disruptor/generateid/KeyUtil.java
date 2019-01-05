package com.issac.concurrency.disruptor.generateid;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class KeyUtil {

    public static String generatorUUID() {
        TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator();
        return timeBasedGenerator.generate().toString();
    }

    public static void main(String[] args) {
        log.info(generatorUUID());
        log.info(generatorUUID());
    }
}
