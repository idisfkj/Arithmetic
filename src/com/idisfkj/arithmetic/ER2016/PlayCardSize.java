package com.idisfkj.arithmetic.ER2016;

import java.util.Scanner;

/**
 * Created by idisfkj on 16/9/23.
 */
public class PlayCardSize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String scan = in.nextLine();
            int index = scan.indexOf("-");
            String first = scan.substring(0, index);
            String second = scan.substring(index + 1);
            String[] sFirst = first.split(" ");
            String[] sSecond = second.split(" ");
            if (sFirst.length != sSecond.length) {
                if (sFirst.length == 2) {
                    if (first.contains("joker") && first.contains("JOKER")) {
                        System.out.println(first);
                        continue;
                    }
                } else if (sSecond.length == 2) {
                    if (second.contains("joker") && second.contains("JOKER")) {
                        System.out.println(second);
                        continue;
                    }
                } else if (sFirst.length == 4)
                    System.out.println(first);
                else if (sSecond.length == 4)
                    System.out.println(second);
                else System.out.println("ERROR");

            } else {
                if (count(sFirst[0]) > count(sSecond[0])) {
                    System.out.println(first);
                } else {
                    System.out.println(second);
                }
            }
        }
    }
    private static int count(String str) {
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }
}
