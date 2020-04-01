package com.example.yangpeng.utils;

/**
 * 返回json
 */
public class ResultJson {
    private Integer code = 200;
    private boolean success = true;
    private Object obj;
    private String host;
    private String msg;
    private String fakedKey;

    @Override
    public String toString() {
        return "ResultJson{" +
                "code=" + code +
                ", success=" + success +
                ", obj=" + obj +
                ", host='" + host + '\'' +
                ", msg='" + msg + '\'' +
                ", key='" + fakedKey + '\'' +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFakedKey() {
        return fakedKey;
    }

    public void setFakedKey(String fakedKey) {
        this.fakedKey = fakedKey;
    }
}
