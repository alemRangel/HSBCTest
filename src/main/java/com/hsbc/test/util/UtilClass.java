package com.hsbc.test.util;

public class UtilClass {
    public boolean isStringNullOrEmpty(String str){
        return str == null || str.trim().equals("");
    }
}
