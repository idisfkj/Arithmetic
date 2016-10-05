package com.idisfkj.arithmetic.LeetCode;


/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama"is a palindrome.
 * "race a car"is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Created by idisfkj on 16/10/5.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("1a1"));
        System.out.println(new ValidPalindrome().isPalindrome(null));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 1)
            return true;
        int start = 0;
        int end = s.length() - 1;
        char[] ch = s.toLowerCase().toCharArray();
        while (start < end) {
            if ((ch[start] == ch[end]) || (!isChar(ch[start]) && !isChar(ch[end]))) {
                start++;
                end--;
            } else if (isChar(ch[start]) && !isChar(ch[end])) {
                end--;
            } else if (!isChar(ch[start]) && isChar(ch[end])) {
                start++;
            } else return false;
        }
        return true;
    }

    public boolean isChar(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
}
