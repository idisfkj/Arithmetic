package com.idisfkj.arithmetic.program;

/**
 * 数组中只出现一次的数字
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by idisfkj on 16/9/9.
 */
public class FindNumsAppearOnce {
    public static String str = "";
    public static int[] result = new int[]{0,0};

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        solution1(array);
        System.out.println(result[0] + ":" + result[1]);
    }

    /**
     * 异或 相同的抵消最后只留下不像同的进行异或
     * @param array
     */
    public static void solution1(int[] array) {
        int first = 0;
        for (int i = 0; i < array.length; i++) {
            //做异或
            first ^= array[i];
        }
        int index = 0;
        //找到二进制第一个1的位置
        while ((first&1) ==0){
            first = first >> 1;
            index++;
        }
        for (int j = 0; j < array.length;j++){
            //第index个位置为1的分为一组,不为1的分为另一组
            if (((array[j]>>index)&1) ==1){
                result[0]^=array[j];
            }else {
                result[1]^=array[j];
            }
        }

    }

    /**
     * 一般
     *
     * @param array
     */
    public static void solution(int[] array) {
        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }
        int count = 0;
        int len = str.length();
        for (; count < 2 && len > 0; ) {
            int pre = str.length();
            String temp = String.valueOf(str.charAt(0));
            str = str.replaceAll(temp, "");
            int cur = str.length();
            if (pre - cur == 1) {
                result[count++] = Integer.parseInt(temp);
                len--;
            } else {
                len -= 2;
            }
        }
    }
}
