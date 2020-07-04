package org.reflection.test;

import java.lang.reflect.Field;

public class Tool {

    //此方法用于将obj对象中名为propertyName的属性的值设置为value
    public void setProperty(Object obj, String propertyName, Object value) throws Exception {
        Class clazz = obj.getClass();
        Field f = clazz.getDeclaredField(propertyName);
        f.setAccessible(true);
        f.set(obj, value);



    }
}
