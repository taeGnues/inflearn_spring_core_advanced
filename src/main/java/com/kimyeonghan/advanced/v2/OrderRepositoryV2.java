package com.kimyeonghan.advanced.v2;

import com.kimyeonghan.advanced.trace.TraceId;
import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId){
        // 저장 로직

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "OrderRepository.save()");

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
