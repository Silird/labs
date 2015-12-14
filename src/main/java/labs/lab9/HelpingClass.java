package labs.lab9;

public class HelpingClass {

    /**
     * Умножение
     * @param a
     * @param b
     * @return
     */
    public static int Multiplication(int a, int b) {
        return (a*b);
    }

    /**
     * Возвращает истину если на вход было доно только одно не пустое слово
     * @param str
     * @return
     */
    public static boolean OnlyOneWord(String str) {
        if ((str == null) || (str.equals(""))) {
            return false;
        }
        if (str.split(" ").length == 1) {
            return true;
        }
        return false;
    }
}
