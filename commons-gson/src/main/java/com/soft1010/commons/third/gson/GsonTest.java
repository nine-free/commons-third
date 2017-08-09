package com.soft1010.commons.third.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jifuzhang on 17/8/7.
 */
public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();
        int str = gson.fromJson("1",int.class);
        System.out.println(str);

        System.out.println("==================");

        Teacher teacher = new Teacher("zhang",30);
        String teacherstr =  gson.toJson(teacher);
        System.out.println(teacherstr);

        System.out.println("==================");

        Teacher teacher1 = gson.fromJson(teacherstr,Teacher.class);
        System.out.println(teacher.getName()+" "+teacher1.getAge());
    }


    static class Teacher{
        @SerializedName(value = "n")
        private String name;
        @SerializedName(value = "a")
        private int age;

        public Teacher() {
        }

        public Teacher(String name, int age) {
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
}
