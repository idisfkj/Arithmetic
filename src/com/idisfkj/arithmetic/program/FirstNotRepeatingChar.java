package com.idisfkj.arithmetic.program;

/**
 * 第一个只出现一次的字符
 * Created by idisfkj on 16/9/7.
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args){
        String str = "googgle";
        System.out.println(solution1(str));

    }

    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由大小写字母组成)中找到第一个只出现一次的字符,并返回它的位置
     *
     * 借用2个辅助String
     * @param str
     * @return
     */
    public static int solution(String str){
        if (str.length() ==0 || str.length() >10000)
            return -1;
        String result= "";
        String same = "";
        int position =0;
        for (int i=0; i < str.length();i++){
            String ver = String.valueOf(str.charAt(i));
            if (result.contains(ver)){
                result = result.replace(ver,"");
                same+=ver;
            }else if (!same.contains(ver)){
                result+=ver;
            }
        }
        if (!result.equals("")){
            position = str.indexOf(result.charAt(0));
        }
        return position;
    }

    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由大小写字母组成)中找到第一个只出现一次的字符,并返回它的位置
     *
     * 借助2个String改进版
     * 其中一个保持遍历中不相同的数据,另一个存储结果
     * @param str
     * @return
     */
    public static int solution1(String str){
        if (str.length() ==0 || str.length() >10000)
            return -1;
        String result= str;
        String same = "";
        int position =0;
        for (int i=0; i < result.length();i++){
            String ver = String.valueOf(result.charAt(i));
            if (same.contains(ver)){
                //移除结果集中与其相同的数据
                result= result.replace(ver,"");
                i-=2;
            }else{
                //保存遍历的数据(数据源为str中去掉重复出现的数据)
                same+=ver;
            }
        }
        if (!result.equals("")){
            position = str.indexOf(result.charAt(0));
        }
        return position;
    }
}
