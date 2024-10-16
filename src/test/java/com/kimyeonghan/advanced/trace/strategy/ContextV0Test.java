package com.kimyeonghan.advanced.trace.strategy;

import com.kimyeonghan.advanced.trace.strategy.code.strategy.ContextV1;
import com.kimyeonghan.advanced.trace.strategy.code.strategy.Strategy;
import com.kimyeonghan.advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.kimyeonghan.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV0Test {
    @Test
    void contextMethodV0(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행

        log.info("비즈니스 로직1 실행");

        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행

        log.info("비즈니스 로직2 실행");

        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);

    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    /**
     * 전략 패턴 사용 (익명 클래스)
     */
    @Test
    void strategyV2(){
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        log.info("strategyLogic1={}", strategyLogic1.getClass());

        ContextV1 contextV2 = new ContextV1(() -> log.info("비지니스 로직 2 실행"));
        // 익명 내부 클래스를 람다로 짧게 작성 가능.
        // 단, 인터페이스에 단 1개의 메소드만 존재해야함.
        contextV2.execute();


    }

}
