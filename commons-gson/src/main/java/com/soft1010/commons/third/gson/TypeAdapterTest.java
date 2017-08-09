package com.soft1010.commons.third.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jifuzhang on 17/8/8.
 */
public class TypeAdapterTest {

    static  final Gson gson = new GsonBuilder().create();
    public static void main(String[] args) {
        User user = new User("name",12,"","5920301652@qq.com");
        System.out.println(gson.toJson(user));

       User u = gson.fromJson(gson.toJson(user),User.class);
        System.out.println(u.getName());
    }
}
