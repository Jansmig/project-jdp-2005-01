package com.kodilla.ecommercee.entity;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void saveCartTest(){
        //Given:
        List<Product> emptyProductsList = new ArrayList<>();
        Cart cart1 = new Cart();
        cart1.setProducts(emptyProductsList);
        Cart cart2 = new Cart();
        cart2.setProducts(emptyProductsList);

        //When:
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        Long cart1Id = cart1.getCartId();
        Long cart2Id = cart2.getCartId();

        //Then:
        Assert.assertNotNull(cart1Id);
        Assert.assertNotNull(cart2Id);

        //Clean-up:
        cartRepository.deleteById(cart1Id);
        cartRepository.deleteById(cart2Id);
    }

    @Test
    public void getAllCartsTest(){
        //Given:
        List<Product> emptyProductsList = new ArrayList<>();
        Cart cart1 = new Cart();
        cart1.setProducts(emptyProductsList);
        Cart cart2 = new Cart();
        cart2.setProducts(emptyProductsList);

        //When:
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        List<Cart> carts = cartRepository.findAll();

        //Then:
        Assert.assertEquals(2, carts.size());

        //Clean-up:
        cartRepository.deleteAll();
    }


}