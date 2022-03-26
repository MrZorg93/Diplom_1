import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class TestMoveIngredient {
    @Test
    public void testMoveIngredientsCanMoveItFromFirstToSecondPlace(){
        Burger burger = new Burger();
        burger.ingredients.add(new Ingredient(FILLING, "component1", 123));
        burger.ingredients.add(new Ingredient(FILLING, "component2", 321));
        String expected = burger.ingredients.get(0).getName();
        burger.moveIngredient(0,1);
        String actual = burger.ingredients.get(1).getName();
        assertEquals(expected,
                actual);

    }

    @Test
    public void testMoveIngredientsCanMoveItFromFirstToThirdPlace(){
        Burger burger = new Burger();
        burger.ingredients.add(new Ingredient(FILLING, "component1", 123));
        burger.ingredients.add(new Ingredient(FILLING, "component2", 321));
        burger.ingredients.add(new Ingredient(SAUCE, "component3", 456));
        burger.ingredients.add(new Ingredient(FILLING, "component4", 654));
        String expected = burger.ingredients.get(0).getName();
        burger.moveIngredient(0,2);
        String actual = burger.ingredients.get(2).getName();
        assertEquals(expected,
                actual);

    }

    @Test
    public void testMoveIngredientsCanMoveItFromFirstToLastPlace(){
        Burger burger = new Burger();
        burger.ingredients.add(new Ingredient(FILLING, "component1", 123));
        burger.ingredients.add(new Ingredient(FILLING, "component2", 321));
        burger.ingredients.add(new Ingredient(SAUCE, "component3", 456));
        burger.ingredients.add(new Ingredient(FILLING, "component4", 654));
        String expected = burger.ingredients.get(0).getName();
        int lastIndex = burger.ingredients.size()-1;
        burger.moveIngredient(0,lastIndex);
        String actual = burger.ingredients.get(lastIndex).getName();
        assertEquals(expected,
                actual);

    }
}
