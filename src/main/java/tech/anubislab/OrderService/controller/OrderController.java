package tech.anubislab.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import tech.anubislab.OrderService.model.OrderRequest;
import tech.anubislab.OrderService.service.OrderService;


@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    private ResponseEntity<Long> placerOrder(@RequestBody OrderRequest orderRequest){
        long orderId = orderService.placerOrder(orderRequest);
        log.info("Identifiant de commande: {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}