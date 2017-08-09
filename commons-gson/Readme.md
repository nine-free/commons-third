

###  google gson


实例化
```
Gson gson = new GsonBuilder()
        //序列化null
        .serializeNulls()
        // 设置日期时间格式，另有2个重载方法
        // 在序列化和反序化时均生效
        .setDateFormat("yyyy-MM-dd")
        // 禁此序列化内部类
        .disableInnerClassSerialization()
        //生成不可执行的Json（多了 )]}' 这4个字符）
        .generateNonExecutableJson()
        //禁止转义html标签
        .disableHtmlEscaping()
        //格式化输出
        .setPrettyPrinting()
        .create();

Gson gson = new Gson();

```
运用
```
Gson提供了fromJson()和toJson() 两个直接用于解析和生成的方法，前者实现反序列化，后者实现了序列化

```

注解
```
@SerializedName
@Expose

```
高级
```
TypeAdapter
JsonSerializer
JsonDeserializer
注解 @JsonAdapter

```
具体参考demo

参考:http://www.jianshu.com/p/3108f1e44155





