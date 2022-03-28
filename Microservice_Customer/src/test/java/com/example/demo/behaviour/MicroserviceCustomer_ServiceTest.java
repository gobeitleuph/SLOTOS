package com.example.demo.behaviour;




import com.example.demo.structure.CartEntity;
import com.example.demo.structure.CartItemEntity;
import com.example.demo.structure.CustomerEntity;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MicroserviceCustomer_ServiceTest {

    MicroserviceCustomer_Service serviceUnderTest;



    @Mock
    RestTemplate mockRestTemplate;

    @Mock
    Customer_Repository mockRepository;

    @Mock
    CartItemRepository mockCartitemRepository;

    @Mock
    CartRepository mockCartRepository;

    @BeforeEach
    void setUp() {
        this.serviceUnderTest = new MicroserviceCustomer_Service(mockRestTemplate, mockRepository, mockCartRepository, mockCartitemRepository);
    }


    @Test
    void shouldDecrementArticleQuantity(){

        CartEntity cart = new CartEntity();
        cart.setItems(Sets.newHashSet());
        CartItemEntity cartItem = new CartItemEntity(1, 1);
        cartItem.setQuantity(4);
        cart.getItems().add(cartItem);
        CustomerEntity customerEntity = new CustomerEntity(1, "Peter Maffai", "Wohlers Allee 38", cart);

        Mockito.when(mockRepository.getById(1)).thenReturn(customerEntity);
        Mockito.when(mockRepository.save(Mockito.any())).thenReturn(customerEntity);

        serviceUnderTest.decrementArticleQuantity(1, 1);

        assertEquals(cartItem.getQuantity(), 3);
    }

    @Test
    void shouldDeleteItemFromCart(){

        CartEntity cart = new CartEntity();
        cart.setItems(Sets.newHashSet());
        CartItemEntity cartItem = new CartItemEntity(1, 1);
        cart.getItems().add(cartItem);
        CustomerEntity customerEntity = new CustomerEntity(1, "Peter Maffai", "Wohlers Allee 38", cart);
        Mockito.when(mockRepository.getById(1)).thenReturn(customerEntity);

        serviceUnderTest.deleteArticleFromCart(1, 1);

        assertTrue(cart.getItems().isEmpty());

    }
}