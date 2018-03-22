package com.jiemin.wages.domain;

/**
 * @Author: 刘英杰
 * @Description: Http请求返回的最外层对象
 * @Date: Created in 2017/12/26 13:02
 */
public class Result<T> {

    /** 错误码 **/
    private Integer code;
    /** 错误提示 **/
    private String msg;
    /*** 具体的内容 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
