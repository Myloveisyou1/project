package com.jiemin.wages.exception;

import com.jiemin.wages.enums.ResultEnum;

/**
 * @Author: 刘英杰
 * @Description:
 * @Date: Created in 2017/12/26 13:27
 */
public class FarmException extends RuntimeException {

    private Integer code;

    public FarmException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
