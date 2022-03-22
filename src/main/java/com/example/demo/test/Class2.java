package com.example.demo.test;

import cn.hutool.core.codec.Base64;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author cnh
 * @date 2021-10-22
 */
public class Class2 extends Class1{



    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] decode = Base64.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VUeXBlIjo0LCJhdWQiOlsiYXBpLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImR0fDgyY2M0NGE4NDAyY2ZjNjYyZTg2ZWU0YTg5NTQ4NGFkfDEzMDcyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXSwiZGV2aWNlTm8iOiI4MmNjNDRhODQwMmNmYzY2MmU4NmVlNGE4OTU0ODRhZCIsImV4cCI6MTY0NTkyMzk3MSwiZXhwaXJlQXQiOiIyMDIyLTAyLTI3IDA5OjA2OjExIiwidXNlcklkIjoxMzA3MiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjRjN2JlYjA5LTg0MjctNDIyNy1hYWIzLWFkNzYwMjExOTUyNCIsImNyZWF0ZUF0IjoiMjAyMi0wMi0yNCAwOTowNjoxMSIsImNsaWVudF9pZCI6ImR0In0.EQnMKke_PVUYdRbJ8cag1l2O7GNX5UFke8TP3x_OncMkxhg53q8Twb_7BAipOkKcjB4IiZLCbQFWNCsI8svC9hEA7F554oFcG7FoGbkiFo7DehcQM7CJHg1xq2RC1hEe2vTT13skd2JZSRRD1RwSKgqFTVzvAItar82R4bQm2tayGWG2_nNMxS8KPfH4vUrGLVguY5J8stQRZha-zcHumeV-JR0vQcnzIY00fjqO--SErRdqEHC7amAyP4WxG3l6UQa65dskbgJIPrWZLj0hbCQQzDbje8Wm9CPbZD3Ul1lZ5-fZnjjuD6ns8e-ugS-A1ZgoBcYwnWdKnHaOU62bSg");
        System.out.println(new String(decode, "UTF-8"));



    }
}
