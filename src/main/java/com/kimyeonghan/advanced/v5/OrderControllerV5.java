package com.kimyeonghan.advanced.v5;

import com.kimyeonghan.advanced.trace.callback.TraceCallback;
import com.kimyeonghan.advanced.trace.callback.TraceTemplate;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;
import com.kimyeonghan.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template; // 싱글톤. Spring 빈으로 등록 받아도 됨.

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) { // trace 의존관계 주입을 받음.
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(@RequestParam("itemId") String itemId){

        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}