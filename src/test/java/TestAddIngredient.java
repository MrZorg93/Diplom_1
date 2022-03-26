import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestAddIngredient {

    private final Ingredient ingredient;


    public TestAddIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] Ingredient() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "test1", 0)},
                {new Ingredient(IngredientType.SAUCE, "test2", 1)},
                {new Ingredient(IngredientType.SAUCE, "test3", 100)},
                {new Ingredient(IngredientType.FILLING, "test4", 0)},
                {new Ingredient(IngredientType.FILLING, "test5", 1)},
                {new Ingredient(IngredientType.FILLING, "test6", 100)},
                {new Ingredient(IngredientType.SAUCE, "7", -66)},
                {new Ingredient(IngredientType.SAUCE, "a5", -66)},
                {new Ingredient(IngredientType.SAUCE, "testtetsttest11", -66)},
                {new Ingredient(IngredientType.FILLING, "k", -66)},
                {new Ingredient(IngredientType.FILLING, "a7", -66)},
                {new Ingredient(IngredientType.FILLING, "testtetsttest11", -66)},
        };
    }

    @Test
    public void checkAddIngredientCanAddIt() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

}
