package com.idisfkj.arithmetic.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * Created by idisfkj on 16/9/7.
 */
public class PrintMinNumber {
    public static void main(String[] args){
        int[] array = new int[]{3,32,321};
        System.out.println(solution(array));
    }

    /**
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public static String solution(int[] numbers){
        String result = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1 = o1 + o2;
                o2 = o2 + o1;
                return o1.compareTo(o2);
            }
        });
        for (int j = 0; j < list.size();j++){
            result+=list.get(j);
        }
        return result;
    }
}
