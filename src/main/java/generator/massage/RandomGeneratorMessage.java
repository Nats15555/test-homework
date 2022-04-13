package generator.massage;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGeneratorMessage {

    public static final Random RANDOM = new SecureRandom();
    private static final List<String> messages = Arrays.asList("Привет","Как ты","Как дела");

    public static String getMessage(){
        return messages.get(1 + RANDOM.nextInt(messages.size())) + (1 + RANDOM.nextInt());
    }
}
