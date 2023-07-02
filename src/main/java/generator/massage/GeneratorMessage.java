package generator.massage;

import java.util.Arrays;
import java.util.List;

import generator.RandomData;

public class GeneratorMessage implements RandomData {
    private static final List<String> messages = Arrays.asList("Привет","Как ты","Как дела");

    @Override
    public String random() {
        return messages.get(1 + RANDOM.nextInt(messages.size() - 1)) + (1 + RANDOM.nextInt());
    }
}
