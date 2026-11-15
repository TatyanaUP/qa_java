import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getFriendsShouldReturnListOfFriends() throws Exception { //список друзей
        Alex alex = new Alex(feline);
        List<String> expectedFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actualFriends  = alex.getFriends();
        assertEquals(expectedFriends, actualFriends);
    }

    @Test
    public void getPlaceOfLivingShouldReturnNewYorkZoo() throws Exception{ //место жительства
        Alex alex = new Alex(feline);
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
        String actualPlaceOfLiving = alex.getPlaceOfLiving();
        assertEquals(expectedPlaceOfLiving, actualPlaceOfLiving);

    }
    @Test
    public void getKittensShouldReturnZero() throws Exception {
        Alex alex = new Alex(feline);
        int actualKittens = alex.getKittens();

        // Assert — проверяем  результат 0, но и то, что внутри вызвался перегруженный метод getKittens()
        assertEquals(0, actualKittens);
        Mockito.verify(feline, Mockito.never()).getKittens(); //(Запомнить) - невер здесь проверяет, что Алекс
        //не запрашивает котят у фелин.(потому что родительский лион фелин.геткитенс)

    }
    @Test
    public void doesHaveManeShouldReturnTrue() throws Exception {
        Alex alex = new Alex(feline);
        boolean actualHaveMane = alex.doesHaveMane();
        assertTrue(actualHaveMane);

    }
    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = alex.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }

}
