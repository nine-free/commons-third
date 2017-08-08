package com.soft1010.commons.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Date;

/**
 * Created by jifuzhang on 17/8/8.
 */
public class FastjsonTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(12);
        user.setName("name");
        user.setEmail("zhangjifu@corp.netease.com");
        user.setDate(new Date());
        String jsonstr = JSON.toJSONString(user);
        System.out.println(jsonstr);

        System.out.println("===========");

        User user1 = JSON.parseObject(jsonstr,User.class);
        System.out.println(JSON.toJSONString(user1,true));

        System.out.println("===========");

        Response<User> response = new Response<User>();
        response.setErrorMsg("msg");
        response.setErrorCode("0");
        response.setT(user);

        String str = JSON.toJSONString(response);
        System.out.println(str);
        System.out.println("============");
        Response<User> response1 = JSON.parseObject(str,new TypeReference<Response<User>>(){});
        System.out.println(JSON.toJSONString(response1));

    }
}
