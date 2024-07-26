package org.choongang.statistic.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberStatisticService {

    @Scheduled(fixedRate = 5000) // 5초 간격
    public void makeData() {
        log.info("실행!!!");
    }
}