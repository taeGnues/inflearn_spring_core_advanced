package com.kimyeonghan.advanced.trace;

import lombok.Getter;

// 로그의 시작과 끝을 위한 정보
@Getter
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
