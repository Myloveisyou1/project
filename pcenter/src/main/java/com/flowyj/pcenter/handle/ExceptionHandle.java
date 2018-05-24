package com.flowyj.pcenter.handle;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.exception.PCenterException;
import com.flowyj.pcenter.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 刘英杰
 * @Description: 异常捕获
 * @Date: Created in 2017/12/26 13:23
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 自定义异常和系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if(e instanceof PCenterException){
            PCenterException emailException = (PCenterException) e;
            return ResultUtil.error(emailException.getCode(),emailException.getMessage());
        }else{
            log.error("系统异常{}",e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMsg());
        }
    }

    /**
     * 参数类型错误异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = TypeMismatchException.class)
    @ResponseBody
    public Result typeMisMatchException(TypeMismatchException ex) {

        log.info("参数类型错误异常{}",ex);

        return ResultUtil.error(ResultEnum.TYPE_MIS_MATCH.getCode(),"参数"+ex.getPropertyName()+"类型应为"+ex.getRequiredType());

    }

    /**
     * 参数不全异常
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public Result requestMissingServletRequest(MissingServletRequestParameterException ex){

        log.info("参数不全异常{}",ex);

        return ResultUtil.error(ResultEnum.EMPTY_ERROR.getCode(), "参数" + ex.getParameterName()+"不能为空");
    }
}
