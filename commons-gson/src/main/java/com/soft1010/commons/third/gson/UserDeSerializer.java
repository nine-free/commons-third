package com.soft1010.commons.third.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by jifuzhang on 17/8/8.
 */
public class UserDeSerializer implements JsonDeserializer<User>{
    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        //TODO
        return null;
    }
}
