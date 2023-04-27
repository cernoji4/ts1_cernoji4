package cz.cvut.fel.ts1.testing;

import cz.cvut.fel.ts1.shop.ShoppingCart;
import cz.cvut.fel.ts1.shop.Order;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

public class OrderTest {
    private ShoppingCart shoppingCart1 = new ShoppingCart(new ArrayList<>());
    private ShoppingCart shoppingCart2 = new ShoppingCart();

    @Test
    public void constructor_test_short(){
        Order order1 = new Order(shoppingCart1, "Garry", "In galaxy far far away", 1);
        Assertions.assertEquals(true, order1 != null);
        Order order2 = new Order(shoppingCart2, null, null, 1);
        Assertions.assertEquals(true, order2 != null);
    }

    @Test
    public void constructor_test_long(){
        Order order3 = new Order(shoppingCart1, "Garry", "In galaxy far far away");
        Assertions.assertEquals(true, order3 != null);
        Order order4 = new Order(shoppingCart2, null, null);
        Assertions.assertEquals(true, order4 != null);
    }
}
