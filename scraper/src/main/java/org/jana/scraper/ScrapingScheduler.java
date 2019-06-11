package org.jana.scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScrapingScheduler {

    private static final Logger log = LoggerFactory.getLogger(ScrapingScheduler.class);

    @Scheduled(fixedDelay = 1000)
    public void runThisScheduler() {
        System.out.println("log = " + log);
    }

}
