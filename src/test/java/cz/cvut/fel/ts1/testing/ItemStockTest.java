package cz.cvut.fel.ts1.testing;

import cz.cvut.fel.ts1.shop.Item;
import cz.cvut.fel.ts1.shop.StandardItem;
import cz.cvut.fel.ts1.storage.ItemStock;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ItemStockTest {
    private int id = 1;
    private String name = "food";
    private float price = (float) 5.5;
    private String category = "food";
    private int loyalPoints = 3;
    private StandardItem item = new StandardItem(id, name, price, category, loyalPoints);
    private ItemStock itemStock = new ItemStock(item);
    @Test
    public void constructor_test(){
        ItemStock itemStock1 = new ItemStock(new Item(1, "banana", (float)5.5, "food") {
        });

    }
    @ParameterizedTest
    @CsvSource({"5","0","-1"})
    public void increaseItemCount_test(int number){
        int expected = itemStock.getCount() + number;
        itemStock.IncreaseItemCount(number);
        Assertions.assertEquals(expected, itemStock.getCount());
    }
    @ParameterizedTest
    @CsvSource({"5","0","-1"})
    public void decreaseItemCount_test(int number){
        int expected = itemStock.getCount() - number;
        itemStock.decreaseItemCount(number);
        Assertions.assertEquals(expected, itemStock.getCount());
    }
}
