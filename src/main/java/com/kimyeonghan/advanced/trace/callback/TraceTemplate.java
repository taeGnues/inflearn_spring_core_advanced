package com.kimyeonghan.advanced.trace.callback;

import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {
    private final LogTrace trace;


    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;

        try{
            status = trace.begin(message);

            T result = callback.call(); // 로직 호출

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
