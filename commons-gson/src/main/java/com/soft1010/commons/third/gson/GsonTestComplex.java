package com.soft1010.commons.third.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jifuzhang on 17/8/7.
 */
public class GsonTestComplex {

    public static void main(String[] args) {
        Gson gson = new Gson();
        AExt aExt = new AExt();
        aExt.setaExt("aext");
        B b = new B();
        b.setB("b");
        List<B> listb = new ArrayList<B>();
        listb.add(b);
        aExt.setbList(listb);

        C c = new C();
        c.setC("c");
        List<C> cList = new ArrayList<C>();
        cList.add(c);
        aExt.setcList(cList);
        System.out.println(gson.toJson(aExt));

        System.out.println("=================");

        AExt aExt1 = gson.fromJson(gson.toJson(aExt),AExt.class);
        System.out.println(gson.toJson(aExt1));

    }


    static class AExt{
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

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

    static class C{
        private String c ;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}
