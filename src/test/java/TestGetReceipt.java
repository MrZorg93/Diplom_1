import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class TestGetReceipt {

    private final float price;
    private final String name;

    public TestGetReceipt(float price, String name) {
        this.price = price;
        this.name = name;
    }
    @Parameterized.Parameters
    public static Object[][] BunPrice() {
        return new Object[][]{
                {0, "test1"},
                {1, "t"},
                {123, "test133"},
                {20000, "testtesttesttesttesttesttesttest" },
                {-12, "!@#$%^&*"},
        };
    }

    @Test
    public void testGetReceiptReturnCorrectFormWithoutFillings(){
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(new Bun(name, price));
        Mockito.doReturn(name).when(bun).getName();
        Mockito.doReturn(price*2).when(burger).getPrice();
        String actual = burger.getReceipt();
        String expected = "(==== " + name + " ====)\r\n"
        + "(==== " + name + " ====)\r\n"
        + String.format("\r\nPrice: %f\r\n", price*2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetReceiptReturnCorrectFormWithFillings(){
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(new Bun(name, price));
        burger.addIngredient(new Ingredient(FILLING, name, price));
        burger.addIngredient(new Ingredient(FILLING, name, price));
        Mockito.doReturn(name).when(bun).getName();
        Mockito.doReturn(name).when(ingredient).getName();
        Mockito.doReturn(FILLING).when(ingredient).getType();
        Mockito.doReturn(price*4).when(burger).getPrice();
        String actual = burger.getReceipt();
        String expected = "(==== " + name + " ====)\r\n"
                + "= filling " + name + " =\r\n"
                + "= filling " + name + " =\r\n"
                + "(==== " + name + " ====)\r\n"
                + String.format("\r\nPrice: %f\r\n", price*4);
        assertEquals(expected, actual);
    }
}
