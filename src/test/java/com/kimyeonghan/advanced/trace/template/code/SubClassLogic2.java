package com.kimyeonghan.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate{


    @Override
    protected void call() {
        log.info("비즈니스 로직 실행2");
    }
}
