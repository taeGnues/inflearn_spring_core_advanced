package com.kimyeonghan.advanced.v5;

import com.kimyeonghan.advanced.trace.callback.TraceTemplate;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;
import com.kimyeonghan.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId){
        // 저장 로직
        template.execute("OrderRepository.save()", () -> {
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
