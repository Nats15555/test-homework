package generator.user.data;

import generator.RandomData;

public class Surname implements RandomData {
    @Override
    public String random() {
        return "Фамилия " + RANDOM.nextBoolean();
    }
}
