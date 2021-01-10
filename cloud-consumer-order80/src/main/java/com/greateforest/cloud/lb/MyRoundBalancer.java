package com.greateforest.cloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyRoundBalancer implements LoadBalancer {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public ServiceInstance chooseService(List<ServiceInstance> services) {
        int size = services.size();
        int index = incrementAndGetIndex(size);
        return services.get(index);
    }

    private int incrementAndGetIndex(int size) {
        while (true) {
            int current = counter.get();
            int next = current >= Integer.MAX_VALUE ? 0 : current+1;
            log.info("访问次数：{}", next);
            if (counter.compareAndSet(current, next)) {
                return current % size;
            }
        }
    }
}
