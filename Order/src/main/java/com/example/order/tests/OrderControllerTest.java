package com.example.order.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.example.order.component.behaviour.OrderController;
import com.example.order.component.structure.OrderPosition;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.order.component.structure.Order;
import com.example.order.component.behaviour.OrderService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @MockBean
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {

        Set<OrderPosition> orderPosition= Set.of();
                new OrderPosition(5,1,1);
        Order order = new Order(1, orderPosition);
        List<Order> orders = Arrays.asList(order);

        Mockito.when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    }

}
