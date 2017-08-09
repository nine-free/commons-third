package com.soft1010.commons.third.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by jifuzhang on 17/8/7.
 */
public class ResponseTest {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        Response<Result> response = new Response<Result>();
        Result result = new Result();
        result.setName("name");
        result.setAge(20);
        response.setData(result);
        response.setErrorMsg("ok");
        response.setErrorCode(0);
        System.out.println(gson.toJson(response));
        System.out.println("===============");


        Response<Result> re = gson.fromJson(gson.toJson(response),new TypeToken<Response<Result>>(){}.getType());
        System.out.println(re.getData().getName());
    }

}

class Result{
    private String name;
    private int age;

    public Result() {
    }

    public Result(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
