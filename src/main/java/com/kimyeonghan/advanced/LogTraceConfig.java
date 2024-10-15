package com.kimyeonghan.advanced;

import com.kimyeonghan.advanced.trace.logtrace.LogTrace;
import com.kimyeonghan.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace(); // 싱글톤으로 빈 등록. => JVM에 딱 1개 있는 인스턴스라는 의미임. 즉, traceIdHolder에 여러 쓰레드가 동시에 접근하여 문제 발생.
    }
}
