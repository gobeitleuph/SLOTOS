package com.example.order.tests;

import org.assertj.core.api.Assertions;
import com.example.order.component.behaviour.OrderController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrderApplicationTests {

    @Autowired
    OrderController orderController;

    @Test
    void contextLoads() {
        Assertions.assertThat(orderController).isNotNull();
    }

}
