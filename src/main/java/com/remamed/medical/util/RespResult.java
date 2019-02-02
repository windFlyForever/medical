package com.remamed.medical.util;

import lombok.Data;

@Data
public class RespResult {

    private Object data;
    private String msg;
    private String code;


    public RespResult() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RespResult(String msg) {
        this.msg = msg;
    }

    public RespResult(Object data) {
        this.data = data;
    }

    public RespResult(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public RespResult( String code,Object data) {
        this.data = data;
        this.code = code;
    }


}
