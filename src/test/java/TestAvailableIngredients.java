import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class TestAvailableIngredients {

    @Test
    public void testAvailableIngredientsReturnAllElements(){
        Database database = new Database();
        int actual = database.availableIngredients().size();
        assertEquals(6, actual);

    }
    public void testAvailableIngredientsReturnCorrectTypeOfElements(){
        Database database = new Database();
        Object actual = database.availableIngredients().get(1).getClass();
        assertEquals(Ingredient.class, actual);

    }
}
