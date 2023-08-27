package org.example;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(2);
        clock();
    }


    public static String pluralize(String Aname, int Acount) {
        if (Acount != 1) {
            return Aname + 's';
        } else {
            return Aname;
        }
    }

    public static void flipNHeads(int n) {
        Random random = new Random();
        int flips = 0;
        int consecutiveHeads = 0;

        while (consecutiveHeads < n) {
            boolean isHeads = random.nextBoolean();
            if (isHeads) {
                System.out.println("heads");
                consecutiveHeads++;
            } else {
                System.out.println("tails");
                consecutiveHeads = 0;
            }
            flips++;
        }
        System.out.println("It took " + flips + " flips to flip " + n + " head in a row.\n");
    }
    public static void clock() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String previousFormattedTime = "";

        while (true) {
            LocalDateTime currentTime = LocalDateTime.now();
            String formattedTime = currentTime.format(formatter);

            if (!formattedTime.equals(previousFormattedTime)) {
                System.out.println(formattedTime);
                previousFormattedTime = formattedTime;
            }
        }
    }
}