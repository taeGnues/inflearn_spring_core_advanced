package com.kimyeonghan.advanced.trace.hellotrace;

import com.kimyeonghan.advanced.trace.TraceId;
import com.kimyeonghan.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }
    public void end(TraceStatus status){
        complete(status, null);
    }
    public void exception(TraceStatus status, Exception e){
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = new TraceId();
        if(e==null){
            log.info("[{}] {}{} time={}ms", traceId.getId(), status.getMessage(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), resultTimeMs);
        }else{
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), status.getMessage(), addSpace(EX_PREFIX, traceId.getLevel()), resultTimeMs, e.getClass() );
        }
    }

    // level = 0
    // level = 1 |-->
    // level = 2 |   |-->

    // level = 2 ex |   |<X-
    // level = 1 ex |<X-
    private static String addSpace(String prefix, int level){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i==level-1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
