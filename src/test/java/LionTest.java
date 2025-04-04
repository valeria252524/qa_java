import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LionTest {
    private Feline feline;
    private Lion lion;
    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец");
    }

    @Test
    public void getKittensTest(){
         int expectedNumberKittens = 1;
         int actualNumberKittens = lion.getKittens();
         Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedNumberKittens + ", но получено: " + actualNumberKittens, expectedNumberKittens, actualNumberKittens);
    }
    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedFood + ", но получено: " + actualFood, expectedFood, actualFood);
    }
}
