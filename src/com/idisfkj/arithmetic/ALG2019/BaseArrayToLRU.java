package com.idisfkj.arithmetic.ALG2019;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现LRU算法
 * Created by idisfkj on 2019/1/24.
 */
public class BaseArrayToLRU<T> {
    /**
     * 默认容器大小
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;

    /**
     * 缓存数组
     */
    private T[] cacheArry;

    /**
     * 容器大小
     */
    private int capacity;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 辅助变量
     */
    private Map<T, Integer> assistMap;

    public BaseArrayToLRU() {
        this(DEFAULT_CAPACITY);
    }

    public BaseArrayToLRU(int capacity) {
        this.capacity = capacity;
        this.cacheArry = (T[]) new Object[capacity];
        this.assistMap = new HashMap<>(capacity);
    }

//    public void cache(T value) {
//        Integer cachePosition = assistMap.get(value);
//        // 在缓存数组中
//        if (cachePosition != null) {
//            // 不在首位,移动到首位
//            if (cachePosition != 0) {
//                rightShift(cachePosition);
//            }
//        } else {
//            // 不在缓存中
//            // 缓存已满
//            if (size == capacity) {
//                rightShift(capacity - 1);
//            } else {
//                //未满
//                rightShift(size);
//                ++size;
//            }
//        }
//        assistMap.put(value, 0);
//        cacheArry[0] = value;
//    }

    /**
     * 模拟操作
     *
     * @param value 操作的值
     */
    public void single(T value) {
        Integer position = assistMap.get(value);
        if (position != null) {
            update(position);
        } else {
            if (size == capacity) {
                removeAndCache(value);
            } else {
                cache(value, size);
            }
        }
    }

    /**
     * 更新缓存
     *
     * @param position 需要更新的位置
     */
    public void update(int position) {
        T target = cacheArry[position];
        rightShift(position);
        cacheArry[0] = target;
        assistMap.put(target, 0);
    }

    /**
     * 移除与缓存
     *
     * @param value 缓存的值
     */
    public void removeAndCache(T value) {
        // 同步删除辅助map中的相应key、value
        assistMap.remove(cacheArry[size - 1]);
        cacheArry[--size] = null;
        cache(value, size);
    }

    /**
     * 缓存
     *
     * @param value 缓存的值
     * @param end   需要右移的边界位置
     */
    public void cache(T value, int end) {
        rightShift(end);
        cacheArry[0] = value;
        assistMap.put(value, 0);
        ++size;
    }

    /**
     * 右移
     *
     * @param position 需要右移的边界位置
     */
    private void rightShift(int position) {
        for (int i = position; i > 0; --i) {
            cacheArry[i] = cacheArry[i - 1];
            assistMap.put(cacheArry[i], i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(cacheArry[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BaseArrayToLRU<Integer> lru = new BaseArrayToLRU<>(5);
        lru.single(1);
        System.out.println(lru);
        lru.single(2);
        System.out.println(lru);
        lru.single(1);
        System.out.println(lru);
        lru.single(4);
        System.out.println(lru);
        lru.single(5);
        System.out.println(lru);
        lru.single(6);
        System.out.println(lru);
        lru.single(3);
        System.out.println(lru);
        lru.single(1);
        System.out.println(lru);
        lru.single(4);
        System.out.println(lru);
    }
}
