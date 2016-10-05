package com.idisfkj.arithmetic.LeetCode;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * Created by idisfkj on 16/10/5.
 */
public class WordLadderii {
    public ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<String> items = new ArrayList<>();
    public HashMap<String, ArrayList<String>> mapPath = new HashMap<>();

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        ArrayList<ArrayList<String>> res = new WordLadderii().findLadders("hot","dog",dict);
        for (int i = 0; i < res.size(); i++){
            for (int j = 0; j < res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        bfs(start, end, dict);
        getPath(start, end, items);
        return result;
    }

    public void bfs(String start, String end, HashSet<String> dict) {
        boolean flag = false;
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
                        if (String.valueOf(ch).equals(end)) {
                            flag = true;
                            ArrayList<String> list = mapPath.get(end);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.add(String.valueOf(poll));
                            mapPath.put(end, list);
                            break;
                        }
                        if (dict.contains(String.valueOf(ch))) {
                            ArrayList<String> list = mapPath.get(end);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.add(String.valueOf(poll));
                            mapPath.put(String.valueOf(ch), list);
                            queue.offer(String.valueOf(ch));
                            dict.remove(String.valueOf(ch));
                        }
                    }
                    ch[i] = temp;
                }
            } else if (!queue.isEmpty()) {//遇到分层符# 且队列不为空
                if (flag) return;
                queue.offer("#");
            }
        }
    }

    public void getPath(String start, String end, ArrayList<String> item) {
        item.add(end);
        if (end.equals(start)) {
            ArrayList<String> copy = (ArrayList<String>) item.clone();
            Collections.reverse(copy);
            result.add(copy);
            item.remove(item.size() - 1);
            return;
        }
        for (int i = 0; i < mapPath.get(end).size(); i++) {
            getPath(start, mapPath.get(end).get(i), item);
        }
        item.remove(item.size() - 1);
    }
}
