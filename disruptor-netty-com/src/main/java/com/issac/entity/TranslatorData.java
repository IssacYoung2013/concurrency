package com.issac.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * author:  ywy
 * date:    2019-01-03
 * desc:
 */
@Data
public class TranslatorData implements Serializable {

    private static final long serialVersionUID = 4976498515081603548L;

    private String id;

    private String name;

    /**
     * 传输消息体内容
     */
    private String message;

}
