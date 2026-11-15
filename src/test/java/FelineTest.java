import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    /** Класс Feline не зависит от других классов, поэтому моки не нужны
     * используем @Spy, чтобы  проверить, что внутренние методы класса правильно вызывают друг друга
     * (например, eatMeat() вызывает getFood("Хищник"), а getKittens() вызывает getKittens(1))
     */

@Spy
    private Feline feline;

@Test
    /** возвращает список еды. Мы сверяем этот список с эталоном (List.of("Животные", "Птицы", "Рыба"))
     * и с помощью verify убеждаемся, что в getFood была передана именно строка "Хищник"
     */
public void eatMeatShouldReturnPredatorFood() throws Exception {
    // Arrange (Подготовка)
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    // Act (Действие) — вызывается реальный метод eatMeat(), который дергает getFood("Хищник") из родительского класса Animal
    List<String> actualFood = feline.eatMeat();

    // Assert (Проверка)
    assertEquals(expectedFood, actualFood);
    Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
}

    @Test
    // Убеждаемся, что метод getFamily() возвращает строку "Кошачьи"
    public void getFamilyShouldReturnFelineFamily() {

        // Act
        String actualFamily = feline.getFamily();

        // Assert
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    // проверяем, что вернул 1
    public void getKittensWithoutParamsShouldReturnOne() {
        // Act
        int actualKittens = feline.getKittens();

        // Assert — проверяем не только результат 1, но и то, что внутри вызвался перегруженный метод getKittens(1)
        assertEquals(1, actualKittens);
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    // проверяем, что вернул переданное ему число
    public void getKittensWithParamsShouldReturnPassedCount() {
        // Arrange
        int expectedCount = 5;

        // Act
        int actualKittens = feline.getKittens(expectedCount);

        // Assert
        assertEquals(expectedCount, actualKittens);
    }
}




