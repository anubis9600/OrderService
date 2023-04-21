package tech.anubislab.OrderService.service;

import tech.anubislab.OrderService.model.OrderRequest;

public interface OrderService {

    long placerOrder(OrderRequest orderRequest);
    
}
