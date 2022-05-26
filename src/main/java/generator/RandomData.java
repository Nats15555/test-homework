package generator;

import java.security.SecureRandom;
import java.util.Random;

public interface RandomData {

    Random RANDOM = new SecureRandom();

    String random();

}
