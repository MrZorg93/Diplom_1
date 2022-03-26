import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSetBuns {

    private final float price;
    private final String name;

    public TestSetBuns(float price, String name){
        this.price = price;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] Buns() {
        return new Object[][]{
                {0, ""},
                {1, "f"},
                {123, "test"},
                {20000, "bigonebigonebigonebigone"},
                {-12, "!@#$%^&*()"},
        };
    }

    @Test
    public void testSetBunReturnOurBun(){
        Burger burger = new Burger();
        burger.setBuns(new Bun(name, price));
        List<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(String.valueOf(price));
        List<String> actual = new ArrayList<>();
        actual.add(burger.bun.getName());
        actual.add(String.valueOf(burger.bun.getPrice()));
        assertEquals(expected ,actual);
    }
}
