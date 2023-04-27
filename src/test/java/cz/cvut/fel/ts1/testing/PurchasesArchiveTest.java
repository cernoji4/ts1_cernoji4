package cz.cvut.fel.ts1.testing;

import cz.cvut.fel.ts1.shop.Order;
import cz.cvut.fel.ts1.shop.ShoppingCart;
import cz.cvut.fel.ts1.shop.StandardItem;
import cz.cvut.fel.ts1.archive.PurchasesArchive;
import cz.cvut.fel.ts1.archive.ItemPurchaseArchiveEntry;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class PurchasesArchiveTest {
    private int id = 1;
    private String name = "banana";
    private float price = (float) 5.5;
    private String category = "food";
    private int loyalPoints = 3;
    private StandardItem item = new StandardItem(id, name, price,category, loyalPoints);
    private ItemPurchaseArchiveEntry itemEntry = new ItemPurchaseArchiveEntry(item);
    private ShoppingCart shoppingCart = new ShoppingCart();
    private String customerName = "Garry";
    private String address = "In a galaxy far far away";
    private int state = 1;
    private Order order = new Order(shoppingCart, customerName, address, state);
    private HashMap hashMap = new HashMap();
    private ArrayList arrayList = new ArrayList();

    public PurchasesArchive purchasesArchive_filled(){
        hashMap.put(1,itemEntry);
        arrayList.add(order);
        PurchasesArchive purchasesArchive = new PurchasesArchive(hashMap, arrayList);
        return purchasesArchive;
    }
    @Test
    public void printItemPurchaseStatistics_test_empty() {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        PurchasesArchive purchasesArchive = new PurchasesArchive();

        purchasesArchive.printItemPurchaseStatistics();
        String result = byteStream.toString();
        String expected = "ITEM PURCHASE STATISTICS:\r\n";
        Assertions.assertArrayEquals(expected.toCharArray(),result.toCharArray());
    }
    @Test
    public void printItemPurchaseStatistics_test_filled() {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));

        purchasesArchive_filled().printItemPurchaseStatistics();
        String result = byteStream.toString();
        String expected = "ITEM PURCHASE STATISTICS:\r\n" +
                "ITEM  Item   ID 1   NAME banana   CATEGORY food   PRICE 5.5   LOYALTY POINTS 3   HAS BEEN SOLD 1 TIMES\r\n";
        Assertions.assertArrayEquals(expected.toCharArray(),result.toCharArray());
    }
    @Test
    public void getHowManyTimesHasBeenItemSold_test_empty() {
        PurchasesArchive purchasesArchive = new PurchasesArchive();
        int expected = 0;
        int result = purchasesArchive.getHowManyTimesHasBeenItemSold(item);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void getHowManyTimesHasBeenItemSold_test_filled() {
        int expected = 1;
        int result = purchasesArchive_filled().getHowManyTimesHasBeenItemSold(item);
        Assertions.assertEquals(expected, result);
    }
    //@Test
    public void getHowManyTimesHasBeenItemSold_test_mock() {

    }
    @Test
    public void putOrderToPurchasesArchive_test_single() {
        purchasesArchive_filled().putOrderToPurchasesArchive(order);
        int expected = 1;
        int result = itemEntry.getCountHowManyTimesHasBeenSold();
        Assertions.assertEquals(expected,result);
    }

}
