package agh.ics.oop;

import java.util.Arrays;

public class World {

    private static final String[] VALID_ARGS = {"f", "b", "r", "l"};

    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }

    private static void run(String[] args) {
        System.out.println("Zwierzak idzie do przodu");
        int i = 1;
        int count_printed = 0;
        for (String s: args) {
            if(Arrays.stream(World.VALID_ARGS).anyMatch(e -> e.equals(s)))
            {
                if(count_printed != 0)
                    System.out.print(", ");
                System.out.print(s);
                count_printed++;
            }
            if (i == args.length && count_printed != 0)
                System.out.println();
            i++;
        }
    }
}