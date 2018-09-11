package com.example.demo.domain;

import net.sf.json.JSONObject;

import java.util.ArrayList;

public class ResultModel {
    public static JSONObject success(String message, Object date) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("message", message);
        jsonObject.put("content", date);
        return jsonObject;
    }

    public static JSONObject success(String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("message", message);
        jsonObject.put("content", new ArrayList<>());
        return jsonObject;
    }

    public static JSONObject fail(String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", -1);
        jsonObject.put("message", message);
        jsonObject.put("content", new ArrayList<>());
        return jsonObject;
    }
}
