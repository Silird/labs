package labs.lab9;

import org.junit.*;
import labs.lab9.HelpingClass;

/**
 * Юнит тесты
 */
public class HelpingClassTest {

    /**
     * Тест умножения
     */
    @Test
    public void testMultiplication() {
        Assert.assertEquals(0, HelpingClass.Multiplication(0, 1));
        Assert.assertEquals(0, HelpingClass.Multiplication(1, 0));
        Assert.assertNotSame(0, HelpingClass.Multiplication(1, 1));
    }

    /**
     * Тест ввода пустой строки
     */
    @Test
    public void testEmptyOnlyOneWord() {
        Assert.assertFalse(HelpingClass.OnlyOneWord(null));
        Assert.assertFalse(HelpingClass.OnlyOneWord(""));
    }

    /**
     * Тесть ввода верной строки
     */
    @Test
    public void testTrueOnlyOneWord() {
        Assert.assertTrue(HelpingClass.OnlyOneWord("Hello"));
    }

    /**
     * Тест ввода неверной строки
     */
    @Test
    public void testFalseOnlyOneWord() {
        Assert.assertFalse(HelpingClass.OnlyOneWord("Hello World"));
    }

    @BeforeClass
    public static void AllTestStarted() {
        System.out.print("Тесты начаты!\n");
    }

    @AfterClass
    public static void AllTestFinished() {
        System.out.print("Все тесты выполнены\n");
    }

    @Before
    public void TestStarted() {
        System.out.print("Тест начат\n");
    }

    @After
    public void TestFinished() {
        System.out.print("Тест выполнен\n");
    }
}
