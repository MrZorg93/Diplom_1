import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class TestAvailableBuns {
    @Test
    public void testAvailableBunsReturnAllElements(){
        Database database = new Database();
        int actual = database.availableBuns().size();
        assertEquals(3, actual);

    }
    @Test
    public void testAvailableBunsReturnCorrectTypeOfElements(){
        Database database = new Database();
        Object actual = database.availableBuns().get(1).getClass();
        assertEquals(Bun.class, actual);

    }
}
