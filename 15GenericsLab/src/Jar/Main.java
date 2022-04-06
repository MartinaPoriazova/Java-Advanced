package Jar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<String> firstJar = new Jar<String>();
        Jar<Integer> secondJar = new Jar<Integer>();

        firstJar.add("some text");
        firstJar.add("word");
        secondJar.add(5);
        secondJar.add(55);

        System.out.println(firstJar.remove());
        System.out.println(firstJar.remove());
        System.out.println(secondJar.remove());
        System.out.println(secondJar.remove());
    }
}
