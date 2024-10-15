package com.kimyeonghan.advanced.v1;

import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV0;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV0.save(itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; // 예외 꼭 다시 던져주기
        }
    }



}
