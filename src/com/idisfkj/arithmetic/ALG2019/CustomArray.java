package com.idisfkj.arithmetic.ALG2019;

/**
 * 自定义int数组,实现查找、插入与删除
 * Created by idisfkj on 2019/1/24.
 */
public class CustomArray {
    /**
     * 数组
     */
    private int[] array;

    /**
     * 数组容量
     */
    private int capacity;

    /**
     * 数组大小
     */
    private int size;

    public CustomArray(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 查找
     *
     * @param index 在数组中要查找的位置
     */
    public int find(int index) {
        // 查找位置超出数组范围
        if (index < 0 || index > size) {
            System.out.println("查找超出范围");
            return -1;
        }
        return array[index];
    }

    /**
     * 插入
     *
     * @param index 在数组中要插入的位置
     * @param value 要插入的值
     */
    public boolean insert(int index, int value) {
        // 数组已满
        if (size == capacity) {
            System.out.println("数组已满");
            return false;
        }
        // 插入位置超出数组范围
        if (index < 0 || index > size) {
            System.out.println("插入超出范围");
            return false;
        }
        for (int i = size; i > index; --i) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++size;
        return true;
    }

    /**
     * 删除
     *
     * @param index 在数组中要删除的位置
     */
    public boolean delete(int index) {
        // 删除位置超出数组范围
        if (index < 0 || index >= size) {
            System.out.println("删除超出范围");
            return false;
        }

        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        --size;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < size; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray(10);
        customArray.insert(0, 1);
        customArray.insert(0, 2);
        customArray.insert(1, 3);
        customArray.insert(0, 4);
        customArray.insert(3, 5);

        customArray.printAll();

        int findResult = customArray.find(3);
        System.out.println(findResult);

        customArray.delete(2);
        customArray.printAll();
    }
}
