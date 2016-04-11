package hotlineTest.HotlinePages;

import java.util.Random;

public class StringGenerator {

    private String generate;

    public String generator(int length) {
        generate = "";
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            generate = generate + (char) (r.nextInt(26) + 'a');
        }
        return generate;
    }

}
