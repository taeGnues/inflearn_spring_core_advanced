package com.kimyeonghan.advanced.trace.template;

import com.kimyeonghan.advanced.trace.TraceStatus;
import com.kimyeonghan.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;


    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
        TraceStatus status = null;

        try{
            status = trace.begin(message);

            T result = call(); // 로직 호출

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    protected abstract T call();
}
