import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private Feline feline;
    private Lion lion;
        @Parameterized.Parameter
        public String sex;
        @Parameterized.Parameter(1)
        public boolean hasMane;
        @Parameterized.Parameters(name = "{index}: Пол {0}, Ожидаемая грива: {1}")
        public static Object[][] data() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            };
        }
    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец");
    }
    @Test
    public void hasManeTest() throws Exception{
        Lion lion = new Lion(sex);
        Assert.assertEquals("Для льва с полом " + sex + " неверно определено наличие гривы.",
                hasMane, lion.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        lion = new Lion("Львенок");
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
