package tech.anubislab.OrderService.service;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import tech.anubislab.OrderService.entity.Order;
import tech.anubislab.OrderService.model.OrderRequest;
import tech.anubislab.OrderService.repository.OrderRepository;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placerOrder(OrderRequest orderRequest) {

        log.info("Passation de la commande..");

        Order order = Order
            .builder()
            .productId(orderRequest.getProductId())
            .quantity(orderRequest.getQuantity())
            .orderDate(Instant.now())
            .orderStatus("CREATED")
            .amount(orderRequest.getTotalAmount())
            .build();
        
        orderRepository.save(order);

        log.info("Commande passee avec l identifiant {}",order.getId());
        return order.getId();
    }
    
}
