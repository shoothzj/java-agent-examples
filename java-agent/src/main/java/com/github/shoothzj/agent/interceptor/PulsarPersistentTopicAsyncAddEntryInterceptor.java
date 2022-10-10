package com.github.shoothzj.agent.interceptor;

import com.github.shoothzj.agent.constant.PulsarConst;
import com.github.shoothzj.agent.util.ReflectUtil;
import net.bytebuddy.asm.Advice;

public class PulsarPersistentTopicAsyncAddEntryInterceptor {

    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin("#m") String methodName,
                             @Advice.AllArguments Object[] args, @Advice.This Object thisObj) {
        try {
            if (methodName.equals(PulsarConst.METHOD_ASYNC_ADD_ENTRY)) {
                System.out.printf("topic %s add entry", ReflectUtil.getObjectField(thisObj, "topic"));
            }
        } catch (Exception e) {
            System.err.printf("intercept method %s error %s", methodName, e);
        }
    }
}
