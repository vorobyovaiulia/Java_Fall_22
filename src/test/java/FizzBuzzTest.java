import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FizzBuzzTest {

    //1. if (start <= end) {
    // return array;
    @Test
    public void testStartLessThanEnd_HappyPath() {
        //ArrangeActAssert
        int start = 1;//Arrange
        int end = 20;
        String[] expectedResult = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
                "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz"};

        //Act; Неверно: String[] actualResult = fizzBuzz() - метод не вызовется, тк он не static - нужно создать объект класса и от него вызвать метод
        // Поэтому можно так: FizzBuzz fizzBuzz = new FizzBuzz();
        // и дальше так: String[] actualResult = fizzBuzz.fizzBuzz()
        // но мы обойдемся без дополнительной переменной (объекта fizBuzz)
        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        Assert.assertEquals(actualResult, expectedResult);//Assert
    }

    //2 if (start == end) - Positive Testing
    // return array;
    @Test
    public void testStartEqualsEnd_HappyPath() {
        int start = 1;//Arrange
        int end = 1;
        String[] expectedResult = {"1"};

        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);//Act;

        Assert.assertEquals(actualResult, expectedResult);   //Assert
    }

    //@Ignore - если нужно, чтобы запускались все тесты, кроме этого
    @Test
    public void testStartLessThanEnd_StartEndAreNegative_HappyPath() {
        int start = -20;//Arrange
        int end = -1;
        String[] expectedResult = {"Buzz", "-19", "Fizz", "-17", "-16", "FizzBuzz", "-14", "-13",
                "Fizz", "-11", "Buzz", "Fizz", "-8", "-7", "Fizz", "Buzz", "-4", "Fizz", "-2", "-1"};

        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        Assert.assertEquals(actualResult, expectedResult);//Assert
    }

    //теперь Negative testing: if (start > end)
    //return new String[0];
    @Test
    public void testStartGreaterThanEnd_Negative() {
        int start = 20;//Arrange
        int end = 1;
        String[] expectedResult = {};

        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
