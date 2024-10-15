package com.kimyeonghan.advanced;

import com.kimyeonghan.advanced.trace.logtrace.FieldLogTrace;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace(); // 싱글톤으로 빈 등록.
    }
}
