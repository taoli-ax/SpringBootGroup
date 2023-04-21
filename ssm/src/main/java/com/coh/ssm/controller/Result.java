package com.coh.ssm.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
    private Boolean success;
    private Object data;
    private String message;

    public Result(Boolean success,Object data){
        this.success=success;
        this.data=data;
    }
}
