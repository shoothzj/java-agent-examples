package com.github.shoothzj.agent;

import com.github.shoothzj.agent.constant.PulsarConst;
import com.github.shoothzj.agent.interceptor.PulsarPersistentTopicAsyncAddEntryInterceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.security.ProtectionDomain;

public class AgentTransformer implements AgentBuilder.Transformer {
    @Override
    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                                            ClassLoader classLoader, JavaModule module,
                                            ProtectionDomain protectionDomain) {
        try {
            String typeName = typeDescription.getTypeName();
            System.out.printf("begin to transform %s\n", typeName);
            if (typeName.equals(PulsarConst.CLASS_PERSISTENT_TOPIC)) {
                System.out.printf("agent transform %s\n", typeName);
                final Advice advice = Advice.to(PulsarPersistentTopicAsyncAddEntryInterceptor.class);
                return builder.visit(advice.on(ElementMatchers.named("asyncAddEntry")));
            }
        } catch (Throwable e) {
            System.err.printf("agent transform error %s\n", e.getMessage());
        }
        return builder;
    }
}
