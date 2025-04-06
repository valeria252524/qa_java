import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParamTest {
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
        feline = mock(Feline.class); // Мокируем объект Feline
        lion = new Lion(sex, feline); // Передаем мок в конструктор
    }

    @Test
    public void hasManeTest() throws Exception {
        Assert.assertEquals("Для льва с полом " + sex + " неверно определено наличие гривы.",
                hasMane, lion.doesHaveMane());
    }

}
