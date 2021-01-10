package com.greateforest.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance chooseService(List<ServiceInstance> services);
}
