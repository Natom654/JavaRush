import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Console {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);

        Runner runner = new Runner();
        runner.run(args);
    }
}


