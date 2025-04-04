import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;



public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedFood + ", но получено: " + actualFood, expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedFamily + ", но получено: " + actualFamily, expectedFamily, actualFamily);
    }

    @Test
    public void getKittensDefaultTest() {
        int expectedNumberKittens = 1;
        int actualNumberKittens = feline.getKittens();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: " + expectedNumberKittens + ", но получено: " + actualNumberKittens, expectedNumberKittens, actualNumberKittens);
    }

    @Test
    public void getKittensWithArgumentTest() {
        int expectedKittens = 4;
        int actualKittens = feline.getKittens(expectedKittens);
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают. Ожидалось: "
                + expectedKittens + ", но получено: " + actualKittens, expectedKittens, actualKittens);
    }

}
