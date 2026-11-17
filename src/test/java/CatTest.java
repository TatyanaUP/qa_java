import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundShouldReturnMeow() {
        // Arrange (Подготовка)
        Cat cat = new Cat(feline);
        // Act
        String actualSound = cat.getSound();

        // Assert
        assertEquals("Мяу", actualSound);
    }
    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        // Arrange: создаем кота с моком и учим мок возвращать список еды при вызове eatMeat()
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        // Act: вызываем тестируемый метод у кота
        List<String> actualFood = cat.getFood();

        // Assert: сверяем полученный список и проверяем, что метод мока был вызван 1 раз
        assertEquals(expectedFood, actualFood);

    }


}
