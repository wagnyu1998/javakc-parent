package com.javakc.commonutils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class APICODE {

    private Integer code;

    private String messages;

    private Boolean success;

    private Map<String,Object> data=new HashMap<>();

    private APICODE(){

    }

    /**
     * 统一数据格式返回
     * 成功方法
     * @return
     */
    public static APICODE OK(){
        APICODE apicode=new APICODE();
        apicode.setCode(ResultCode.SUCCESS);
        apicode.setMessages("服务器调用成功");
        apicode.setSuccess(true);
        return apicode;
    }

    /**
     * 失败方法
     * @return
     */
    public static APICODE ERROR(){
        APICODE apicode=new APICODE();
        apicode.setCode(ResultCode.ERROR);
        apicode.setMessages("服务器调用失败");
        apicode.setSuccess(false);
        return apicode;
    }

    public APICODE code(Integer code){
        this.setCode(code);
        return this;
    }

    public APICODE messages(String messages){
        this.setMessages(messages);
        return this;
    }

    public APICODE success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public APICODE data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public APICODE data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
