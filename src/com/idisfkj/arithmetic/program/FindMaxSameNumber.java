package com.idisfkj.arithmetic.program;

/**
 * 定义一个字符串只有数字与大小写字母组成,找出其中重复数字次数最多数字,并返回他们的和。
 * Created by idisfkj on 16/9/9.
 */
public class FindMaxSameNumber {
    public static void main(String[] args){
        String str = "33jA133dk133df33d33";
        System.out.println(solution(str));
    }
    public static int solution(String str){
        String flag = "";
        boolean ca = false;
        for(int i = 0; i < str.length();i++){
            char temp = str.charAt(i);
            if((temp >='A' && temp<='Z')||(temp>='a' && temp<='z')){
                ca = true;
                flag+=String.valueOf(temp);
            }else{
                if(ca){
                    i = i - flag.length()+1;
                    str = str.replace(flag,",,");
                    flag = "";
                    ca = false;
                }
            }
        }
        if(ca){str = str.replaceAll(flag,",");}else {str+=",";}
        str =","+str;
        String[] array = str.split(",");
        int count = 0;
        int result = 0;
        for(int j = 0; j < array.length;j++){
            if (!array[j].equals("")) {
                String temp = array[j];
                int pre = str.length();
                str = str.replaceAll(","+String.valueOf(temp) + ",", ",");
                int cur = str.length();
                int n = (pre - cur) / (String.valueOf(temp).length()+1);
                if (n > count) {
                    count = n;
                    result = Integer.parseInt(temp);
                }
            }
        }
        return result*count;
    }
}
