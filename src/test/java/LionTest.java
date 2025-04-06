import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensTest() {
        when(feline.getKittens()).thenReturn(1);
        int expectedNumberKittens = 1;
        int actualNumberKittens = lion.getKittens();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают.", expectedNumberKittens, actualNumberKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals("Ожидаемые и фактические значения не совпадают.", food, actualFood);
    }
    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        lion = new Lion("Некорректный Пол", feline);
    }
}
