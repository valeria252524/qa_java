import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//Вообще, я сделала отдельный класс для параметризованных тестов (как написано в ТЗ), но видимо, некорректно запушила изменения, что они не подтянулись(

// Оставила комментарий в пулл реквесте, но вы не ответили, подскажите пожалуйста,
// что имеется вид под "очень много пустых классов", не понимаю, что надо править

// Касаемо комментария про шпион, я его добавила, так как один метод зависит от другого,
// но удалила в итоге, раз не нужен

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
        lion = new Lion("Самец");
    }

    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals("Для льва с полом " + sex + " неверно определено наличие гривы.",
                hasMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        lion = new Lion("Львенок");
    }
}