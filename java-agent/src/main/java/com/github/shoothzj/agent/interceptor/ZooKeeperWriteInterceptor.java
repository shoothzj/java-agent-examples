package com.github.shoothzj.agent.interceptor;

import net.bytebuddy.asm.Advice;

public class ZooKeeperWriteInterceptor {

    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin("#t #m") String signature) {
    }

}
