package com.example.demo.behaviour;



import com.example.demo.structure.Article;
import com.example.demo.structure.CartEntity;
import com.example.demo.structure.CartItemEntity;
import com.example.demo.structure.CustomerEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
class MicroserviceCustomer_ServiceTest {

    MicroserviceCustomer_Service serviceUnderTest;

    @Mock
    Customer_Repository mockRepository;

    @Mock
    RestTemplate mockRestTemplate;

    @BeforeEach
    void setUp() {
        this.serviceUnderTest = new MicroserviceCustomer_Service(mockRestTemplate, mockRepository);
    }

    @Test
    void shouldAddItemToCart() {
        CartEntity cart = new CartEntity();
        cart.setItems(Sets.newHashSet());
        CustomerEntity customerEntity = new CustomerEntity(1, "Peter Maffai", "Wohlers Allee 38", cart);
        CustomerEntity customer = mockRepository.getById(1);
        CartItemEntity cartItem = new CartItemEntity(customer.getId(), customer.getCart(), 1);

        Mockito.when(mockRepository.getById(1)).thenReturn(customerEntity);
        Mockito.when(mockRepository.save(Mockito.any())).thenReturn(customerEntity);

        serviceUnderTest.addArticleToCart(1, 1);

        HashSet<CartItemEntity> expectedItems = Sets.newHashSet(cartItem);
        assertIterableEquals(expectedItems, customer.getCart().getItems());

    }
}