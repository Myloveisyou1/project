package com.flowyj.pcenter.enums;

/**
 * @Author: 刘英杰
 * @Description: 返回值枚举
 * @Date: Created in 2017/12/26 13:38
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"系统繁忙,请稍后再试!"),
    EMPTY_ERROR(404,"参数不全"),
    SUCCESS(200,"成功"),
    ERROR(201,"失败"),
    NOT_EXIST(202,"code不存在"),
    TYPE_MIS_MATCH(203,"参数类型不匹配"),
    DATA_MIS_MATCH(204,"数据格式不对"),
    EMAIL_FROM(205,"1193418905@qq.com"),
    KILL_FAIL(206,"秒杀失败"),
    ERROR_PASSWORD(207,"密码错误"),
    UNKNOW_ACCOUNT(208,"账户不存在"),
    NOT_LOGIN(209,"账户未登录或登陆已失效"),
    EMPTY_SESSIONID(210,"sessionId不能为空"),
    PAGENUM_ERROR(211,"页码必须大于0"),
    USER_DISABLED(212,"账户被禁用"),
    ERROR_OLD_PASSWORD(213,"原始密码错误"),
    SAME_USER(214,"账户已存在"),
    ROLE_DISABLED(215,"角色被禁用"),
    SAME_ROLE(216,"角色已存在"),
    NO_PERMISSION(217,"暂无此权限" );
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
