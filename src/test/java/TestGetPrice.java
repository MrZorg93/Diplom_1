import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestGetPrice {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final float price;
    public TestGetPrice(float price){
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] BunPrice() {
        return new Object[][]{
                {0},
                {1},
                {123},
                {20000},
                {-12},
        };
    }

    @Test
    public void testGetPriceForBurgerWithoutFillings(){
        //Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Burger burger = new Burger();
        burger.setBuns(new Bun("name", price));
        float expected = price*2;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetPriceForBurgerWithOneFilling(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Burger burger = new Burger();
        burger.setBuns(new Bun("name", price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", price));
        float expected = price*3;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetPriceForBurgerWithTwoFillings(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Burger burger = new Burger();
        burger.setBuns(new Bun("name", price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", price));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name", price+100));
        float expected = price*4 + 100;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetPriceForBurgerWithFiveFillings(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Burger burger = new Burger();
        burger.setBuns(new Bun("name", price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", price));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name2", price+100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name3", price+200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name4", price+300));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name5", price+400));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name6", price+500));
        float expected = price*8 + 1500;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

}
