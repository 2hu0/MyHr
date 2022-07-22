package com.vhr.model.bean;

public class RespBean {
    private Integer status;
    private String message;
    private Object object;

    public RespBean(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public RespBean() {

    }

    public static RespBean build() {
        return new RespBean();
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RespBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public RespBean setObject(Object object) {
        this.object = object;
        return this;
    }

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean err(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }
}
