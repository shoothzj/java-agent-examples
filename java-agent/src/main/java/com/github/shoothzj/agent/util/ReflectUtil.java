package com.github.shoothzj.agent.util;

public class ReflectUtil {

    public static Object getObjectField(Object obj, String fieldName) {
        Class<?> aClass = obj.getClass();
        while (aClass != null) {
            try {
                final java.lang.reflect.Field field = aClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(obj);
            } catch (NoSuchFieldException e) {
                aClass = aClass.getSuperclass();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("field not found");
    }

}
