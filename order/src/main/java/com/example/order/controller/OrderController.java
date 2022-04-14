package com.example.order.controller;

import com.example.order.VO.RespnseTempleteVO;
import com.example.order.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping    ("/purchase/{id}")
    public void respnseTempleteVO(@PathVariable Long id){
         orderService.buyABook(id);
    }



}
