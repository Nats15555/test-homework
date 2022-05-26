package generator.user.data;

import generator.RandomData;

public class Name implements RandomData {
    @Override
    public String random() {
        return "Имя " + RANDOM.nextBoolean();
    }
}
