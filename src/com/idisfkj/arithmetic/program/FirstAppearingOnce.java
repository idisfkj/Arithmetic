package com.idisfkj.arithmetic.program;


/**
 * 字符流中第一个不重复的字符
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * Created by idisfkj on 16/9/19.
 */
public class FirstAppearingOnce {
    public static StringBuffer str = new StringBuffer();
    public static int[] save = new int[256];
    public static void main(String[] args){

    }

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        str.append(ch);
        if(save[ch] == 0){
            save[ch] = 1;
        }else{
            save[ch] +=1;
        }
    }
    //return the first appearence once char in current stringstream
    public static char solution()
    {
        char[] ch = str.toString().toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(save[ch[i]] == 1){
                return ch[i];
            }
        }
        return '#';
    }
}
