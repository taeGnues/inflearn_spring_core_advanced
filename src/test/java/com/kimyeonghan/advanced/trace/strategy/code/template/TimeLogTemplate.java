package com.kimyeonghan.advanced.trace.strategy.code.template;

import com.kimyeonghan.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        callback.call(); //위임 "바뀌는 부분임". Context는 Strategy 인터페이스에만 의존함.
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}
