package com.kimyeonghan.advanced.v2;

import com.kimyeonghan.advanced.trace.TraceId;
import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; // 예외 꼭 다시 던져주기
        }
    }



}
