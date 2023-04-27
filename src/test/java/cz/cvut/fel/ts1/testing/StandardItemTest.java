package cz.cvut.fel.ts1.testing;

import cz.cvut.fel.ts1.shop.StandardItem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StandardItemTest {

    private StandardItem standardItem1 = new StandardItem(1, "banana", (float)20.5, "food", 5);
    private StandardItem standardItem2 = new StandardItem(1, "banana", (float)20.5, "food", 5);

    @ParameterizedTest
    @CsvSource({"1, banana, 20.5, food, 5","2, apple, 10.5, food, 3"})
    public void constructor_test(int id, String name, float price, String category, int loyaltyPoints){
        StandardItem standardItem = new StandardItem(id, name, price, category, loyaltyPoints);
        Assertions.assertEquals(true, standardItem != null);
    }
    @Test
    public void copy_test(){
        StandardItem standardItem = new StandardItem(1, "banana", (float)20.5, "food", 5);
        Assertions.assertEquals(standardItem, standardItem.copy());
    }
    @ParameterizedTest
    @CsvSource("standardItem1,standardItem2")
    public void equals_test(Object standardItemA, Object standardItemB){
        Assertions.assertEquals(true, standardItemA.equals(standardItemB));
    }
}
