package com.kimyeonghan.advanced.v1;

import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId){
        // 저장 로직

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepository.save()");

            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }

            sleep(1000);

            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; // 예외 꼭 다시 던져주기
        }


    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
