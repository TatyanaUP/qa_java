import com.example.Feline;

import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensShouldReturnExpectedCount() throws Exception {
        // Arrange (Подготовка)
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);

        // Act (Действие)
        int actual = lion.getKittens();

        // Assert (Проверка)
        assertEquals(1, actual);
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test(expected = Exception.class)
    public void constructorWithInvalidSexShouldThrowException() throws Exception {
        //такая запись Lion lion = new Lion("Неизвестно", feline); не нужна, т.к. объект не создастся, сохранять в переменную не имеет смысла
        new Lion("Неизвестно", feline);
    }

}
