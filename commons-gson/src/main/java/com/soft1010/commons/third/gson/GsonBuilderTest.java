package com.soft1010.commons.third.gson;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jifuzhang on 17/8/7.
 */
public class GsonBuilderTest {

    static Gson gson = new GsonBuilder()
            //序列化null
            .serializeNulls()
            // 设置日期时间格式，另有2个重载方法
            // 在序列化和反序化时均生效
            .setDateFormat("yyyy-MM-dd")
            // 禁此序列化内部类
            .disableInnerClassSerialization()
            //生成不可执行的Json（多了 )]}' 这4个字符）
//            .generateNonExecutableJson()
            //禁止转义html标签
            .disableHtmlEscaping()
            //配合         @Expose(serialize = true,deserialize = true) 使用
//          .excludeFieldsWithoutExposeAnnotation()
            //格式化输出
            .setPrettyPrinting()
            .addDeserializationExclusionStrategy(new ExclusionStrategy() {
                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                    Annotation annotation = fieldAttributes.getAnnotation(TestAnnotation.class);
                    if(annotation!=null){
                        return true;
                    }
                    return false;
                }

                public boolean shouldSkipClass(Class<?> aClass) {
                    Annotation annotation = aClass.getAnnotation(TestAnnotation.class);
                    if(annotation!=null){
                        return true;
                    }
                    return false;
                }
            })
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
            .create();

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        AExt aExt = new AExt();
        aExt.setaExt("aext");
        B b = new B();
        b.setB(null);
        b.setTimestamp(null);
        List<B> listb = new ArrayList<B>();
        listb.add(b);
        aExt.setbList(listb);

        C c = new C();
        c.setC("c");
        c.setNow(new Date());
        List<C> cList = new ArrayList<C>();
        cList.add(c);
        aExt.setcList(cList);
        System.out.println(gson.toJson(aExt));

        System.out.println("=================");

        AExt aExt1 = gson.fromJson(gson.toJson(aExt),AExt.class);
        System.out.println(gson.toJson(aExt1));

    }


    static class AExt{
        @Expose(serialize = true,deserialize = true)
        @TestAnnotation
        private String aExt;
        @SerializedName("listb")
        private List<B> bList;
        @SerializedName(value = "listc")
        private List<C> cList;

        public String getaExt() {
            return aExt;
        }

        public void setaExt(String aExt) {
            this.aExt = aExt;
        }

        public List<B> getbList() {
            return bList;
        }

        public void setbList(List<B> bList) {
            this.bList = bList;
        }

        public List<C> getcList() {
            return cList;
        }

        public void setcList(List<C> cList) {
            this.cList = cList;
        }
    }

    static class A{
        private String a;
        private B b;
        private C c;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        public C getC() {
            return c;
        }

        public void setC(C c) {
            this.c = c;
        }
    }

    static class B{
        private String b;
        private Timestamp timestamp;

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

    static class C{
        private String c ;

        private Date now;

        public Date getNow() {
            return now;
        }

        public void setNow(Date now) {
            this.now = now;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }


}
