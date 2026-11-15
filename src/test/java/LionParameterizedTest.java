import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex; //пол
    private final boolean expectedHasMane; //грива



    // Конструктор принимает данные из метода getSexData()
    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Mock
    private Feline felineMock; //поле для заглушки

    @Before
    public void setUp() {
        // Вручную инициализируем @Mock, так как класс запущен через Parameterized
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Пол: {0}, наличие гривы: {1}")
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
               // {"Неизвестно", true} //добавляем, чтоб отработала ветка else с ошибкой,
                // не сработало, сложно разбираться как впихнуть, пока перенесу в обычный тест
        };
    }

    @Test
    public void doesHaveManeShouldReturnCorrectBoolean() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
