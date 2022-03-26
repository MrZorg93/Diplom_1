import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestRemoveIngredient {

    private final int index;
    public List<Ingredient> ingredientsNew = new ArrayList<>();

    public TestRemoveIngredient(int index) {
        this.index = index;
    }


    @Parameterized.Parameters
    public static Object[][] Index() {
        return new Object[][]{
                {0},
                {1},
                {6},
        };
    }

    @Test
    public void checkRemoveIngredientRemoveCorrectElement() {
        Burger burger = new Burger();
        for (int i = 0; i <= 10; i++) burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "test", i));
        System.out.println(burger.ingredients);
        ingredientsNew = burger.ingredients;
        burger.removeIngredient(index);
        ingredientsNew.remove(index);
        assertEquals(burger.ingredients, ingredientsNew);
    }
}
