package com.kimyeonghan.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 로그의 시작과 끝을 위한 정보
@Getter
@AllArgsConstructor
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;
}
