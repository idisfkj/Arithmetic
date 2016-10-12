package com.idisfkj.arithmetic.LeetCode;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it
 * by returning all possible valid IP address combinations.
 * For example:
 * Given"25525511135",
 * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * <p>
 * Created by idisfkj on 16/10/12.
 */
public class RestoreIpAddresses {
    public ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> res = new RestoreIpAddresses().restoreIpAddresses("25525511135");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() > 12 || s.length() < 4)
            return result;
        String item = "";
        restoreIpAddresses(s, 0, item);
        return result;
    }

    public void restoreIpAddresses(String s, int start, String item) {
        if (start == s.length() && item.split("\\.").length == 4) {
            result.add(item);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (isCheckout(s.substring(start, i))) {
                String str;
                if (item.length() > 0)
                    str = item + "." + s.substring(start, i);
                else
                    str = s.substring(start, i);
                restoreIpAddresses(s, i, str);
            } else
                return;
        }
    }

    public boolean isCheckout(String s) {
        if (s == null || s.length() > 3 || s.length() == 0)
            return false;
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        if (Integer.parseInt(s) <= 255)
            return true;
        return false;
    }
}
