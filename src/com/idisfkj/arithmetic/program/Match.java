package com.idisfkj.arithmetic.program;

/**
 * 正则表达式匹配
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * Created by idisfkj on 16/9/14.
 */
public class Match {
    public static void main(String[] args) {
        char[] str = new char[]{'a', 'a', 'a'};
        char[] pattern = new char[]{'a', '*', '.'};
        System.out.println(solution(str, pattern));
    }

    public static boolean solution(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return match(str, 0, pattern, 0);
    }

    public static boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;

        //模式第2个为*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //第一个字符匹配
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (strIndex != str.length && pattern[patternIndex] == '.')) {
                return (match(str, strIndex, pattern, patternIndex + 2))//模式后移2位,视为不匹配
                        || (match(str, strIndex + 1, pattern, patternIndex + 2))//字符后移1位,模式后移2位,视为匹配1位
                        || (match(str, strIndex + 1, pattern, patternIndex));//字符后移1位,视为匹配1位后,继续匹配下面的字符
            } else {//第一个字符不匹配
                return match(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
