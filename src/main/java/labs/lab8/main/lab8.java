package labs.lab8.main;

import labs.lab8.frame.MyFrame8;
import org.apache.log4j.Logger;

/**
 * Лабораторная работа № 8
 * Организация многопоточных приложений
 * Жигунов Александр
 */

public class lab8 {

    public static final Logger logger = Logger.getLogger(lab8.class);

    public static void main(String[] args) {
        logger.info("Запуск программы");

        new MyFrame8().show();
    }
}
