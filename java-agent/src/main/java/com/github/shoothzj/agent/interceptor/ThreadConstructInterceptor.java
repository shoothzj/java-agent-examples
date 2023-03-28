package com.github.shoothzj.agent.interceptor;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class ThreadConstructInterceptor {

    @Advice.OnMethodExit
    public static void intercept(@Advice.This Object inst) throws Exception {
        Thread thread = (Thread) inst;
        String msg = String.format("%s create thread %s", LocalDateTime.now().toString(), thread.getName());
        System.out.println(msg);
    }

}
