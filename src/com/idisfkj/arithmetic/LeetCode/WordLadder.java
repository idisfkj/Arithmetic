package com.idisfkj.arithmetic.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * Created by idisfkj on 16/10/5.
 */
public class WordLadder {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(new WordLadder().ladderLength(start, end, dict));
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        return bfs(start, end, dict);
    }

    public int bfs(String start, String end, HashSet<String> dict) {
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        queue.offer("#");
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (!poll.equals("#")) {
                char[] ch = poll.toCharArray();
                //字符串逐个遍历
                for (int i = 0; i < ch.length; i++) {
                    char temp = ch[i];
                    //每一位从a~z逐个替换,是否在dict中存在
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) continue;
                        ch[i] = j;
                        if (String.valueOf(ch).equals(end)) return result + 1;
                        if (dict.contains(String.valueOf(ch))) {
                            queue.offer(String.valueOf(ch));
                            dict.remove(String.valueOf(ch));
                        }
                    }
                    ch[i] = temp;
                }
            } else if (!queue.isEmpty()) {//遇到分层符# 且队列不为空
                queue.offer("#");
                result++;
            }
        }
        return 0;
    }
}
