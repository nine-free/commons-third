package com.soft1010.commons.third.gson;

import java.lang.annotation.*;

/**
 * Created by jifuzhang on 17/8/7.
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestAnnotation {
}
