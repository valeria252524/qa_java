import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CatTest {
    private Cat cat;
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
        cat = new Cat(feline);
    }
    @Test
    public void getSoundTest(){
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedSound + ", но получено: " + actualSound, expectedSound, actualSound);
    }
    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedFood + ", но получено: " + actualFood, expectedFood, actualFood);
    }

}
