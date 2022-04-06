package generator.massage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGeneratorMassage {

    public static final Random RANDOM = new SecureRandom();
    private static final List<String> massages = Arrays.asList("Привет","Как ты","Как дела");

    public static String getMassage(){
        return massages.get(1 + RANDOM.nextInt(massages.size())) + (1 + RANDOM.nextInt());
    }
}
