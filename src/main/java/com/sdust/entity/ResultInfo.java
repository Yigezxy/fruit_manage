package com.sdust.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    private Integer code;
    private String msg;
    private Object data;

    public ResultInfo(int code) {
        this.code = code;
    }

    public ResultInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultInfo(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}


