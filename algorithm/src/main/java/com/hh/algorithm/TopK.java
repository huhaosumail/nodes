package com.hh.algorithm;

import java.util.PriorityQueue;

/**
 * 总结表格
 * 方法	功能描述	异常处理（队列为空时）	适用场景
 * add(e)	插入元素	抛出 IllegalStateException	强制插入，依赖异常处理
 * offer(e)	插入元素	返回 false	需要明确插入结果
 * peek()	查看队首元素（不移除）	返回 null	安全检查队首元素
 * element()	查看队首元素（不移除）	抛出 NoSuchElementException	强制检查队首元素
 * poll()	移除队首元素并返回	返回 null	安全移除队首元素
 * remove()	移除队首元素并返回	抛出 NoSuchElementException	强制移除队首元素
 */
public class TopK {

    //new int[]{}表示空数组
    //new int[0]
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 3, 6};
        int k = 2;
        int[] result = topK(arr, k);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] topK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> miniTop = new PriorityQueue<Integer>(k);
        //维持最大的k个元素在堆中
        for (int i = 0; i < arr.length; i++) {
            if (miniTop.size() < k) {
                miniTop.offer(arr[i]);
            } else if (miniTop.peek() < arr[i]) {
                //替换堆顶的最小元素为现在这个值 先去除再添加
                miniTop.poll();
                miniTop.offer(arr[i]);
            }
        }
        //输出堆中元素
        int[] reuslt = new int[miniTop.size()];
        for (int j = reuslt.length - 1; j >= 0; j--) {
            reuslt[j] = miniTop.poll();
        }
        return reuslt;
    }


}
