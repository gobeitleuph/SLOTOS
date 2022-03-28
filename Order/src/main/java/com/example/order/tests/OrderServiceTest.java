package com.example.order.tests;

import com.example.order.component.behaviour.OrderService;
import com.example.order.component.behaviour.Order_Repository;
import com.example.order.component.structure.CartItemDto;
import com.example.order.component.structure.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;
import org.springframework.web.client.RestTemplate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    OrderService orderServiceTest;

    @Mock
    Order_Repository mockRepository;

    @Mock
    RestTemplate mockRestTemplate;

    @BeforeEach
    void setUp() {
        this.orderServiceTest = new OrderService(mockRestTemplate, mockRepository);
    }

    @Test
    void shouldProcessOrder() {
        Set<CartItemDto> cartItemSet = new HashSet<CartItemDto>();

        CartItemDto item1 = new CartItemDto(1, 1, 2);
        CartItemDto item2 = new CartItemDto(1, 2, 3);
        CartItemDto item3 = new CartItemDto(1, 3, 1);
        CartItemDto item4 = new CartItemDto(1, 4, 6);
        CartItemDto item5 = new CartItemDto(1, 5, 8);
        cartItemSet.add(item1);
        cartItemSet.add(item2);
        cartItemSet.add(item3);
        cartItemSet.add(item4);
        cartItemSet.add(item5);

        Order testOrder = orderServiceTest.processOrder(cartItemSet);

        final Set<Pair<Integer, Integer>> cartItemPairs = cartItemSet
                .stream()
                .map(it -> Pair.of(it.getArticleId(), it.getQuantity()))
                .collect(Collectors.toSet());

        final Set<Pair<Integer, Integer>> orderPositionPairs = testOrder.getOrderPositions()
                .stream()
                .map(it -> Pair.of(it.getArticleId(), it.getQuantity()))
                .collect(Collectors.toSet());

        assertIterableEquals(orderPositionPairs, cartItemPairs);







    }
}
