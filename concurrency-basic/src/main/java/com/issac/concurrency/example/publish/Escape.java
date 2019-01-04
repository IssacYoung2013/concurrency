package com.issac.concurrency.example.publish;

import com.issac.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class  InnerClass {
        public InnerClass() {
            // 对象未完成构造之前 不能发布对象
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
