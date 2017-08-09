package com.soft1010.commons.third.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by jifuzhang on 17/8/8.
 */
public class UserTypeAdapter extends TypeAdapter<User> {

    @Override
    public User read(JsonReader jsonReader) throws IOException {
        User user = new User();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            switch (name) {
                case "name":
                    user.setName(jsonReader.nextString());
                    break;
                case "age":
                    user.setAge(jsonReader.nextInt());
                    break;
                case "email":
                case "email_address":
                    user.setEmail(jsonReader.nextString());
                    break;
            }
        }
        jsonReader.endObject();
        return user;
    }

    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("name").value(user.getName());
        jsonWriter.name("age").value(user.getAge());
        jsonWriter.name("email").value(StringUtils.isBlank(user.getEmail()) ? user.getEmail_address() : user.getEmail());
        jsonWriter.endObject();
        jsonWriter.close();
    }
}
