package com.flowyj.pcenter.exception;

import com.flowyj.pcenter.enums.ResultEnum;
import lombok.Data;

@Data
public class PCenterException extends RuntimeException{

    private Integer code;


    public PCenterException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
