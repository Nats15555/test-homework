package generator.post;

import generator.RandomData;

public class GeneratorPost implements RandomData {
    @Override
    public String random() {
        return "Я нахожусь на этой планете уже: " + (1 + RANDOM.nextInt()) + " дней!!!";
    }
}
