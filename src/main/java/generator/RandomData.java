package generator;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Интерфейс показывает, что класс использует паттерн Data Registry
 */
public interface RandomData {
    Random RANDOM = new SecureRandom();

    String random();

}
