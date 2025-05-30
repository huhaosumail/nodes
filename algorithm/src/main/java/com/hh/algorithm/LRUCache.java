package com.hh.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类： LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 int get(int key)
 * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 void put(int key, int value)
 * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000 0 <= key <= 10000 0 <= value <= 105 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {
    private int capacity;
    // memory维护key和Node的关系
    private Map<Integer, Node> memory;
    // 利用链表维护最近最久未使用的Node
    private LinkedList<Node> linkedList;

    /**
     * Node用来保存key和value的关系
     */
    private class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.memory = new HashMap<>();
        this.linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!memory.containsKey(key)) {
            return -1;
        }
        Node node = memory.get(key);
        //因为有访问 所以重新放在第一个
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (memory.containsKey(key)) {
            //这里长度不会变大
            // 获取对应Node
            Node node = memory.get(key);
            // 更新value
            node.value = value;
            //因为有访问 所以重新放在第一个
            linkedList.remove(node);
            linkedList.addFirst(node);
            return;
        }

        if (memory.size() == capacity) {
            //就删除最后一个Node 保证长度先符合规范
            Node node = linkedList.removeLast();
            memory.remove(node.key);
        }
        //存入新的node
        Node node =new Node(key,value);
        memory.put(key,node);
        linkedList.addFirst(node);
    }
}
