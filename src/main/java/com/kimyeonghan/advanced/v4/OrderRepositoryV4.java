package com.kimyeonghan.advanced.v4;

import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;
import com.kimyeonghan.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId){
        // 저장 로직

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {

            @Override
            protected Void call() {
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
