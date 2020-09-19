package com.etc.studentsystem.entity;

/**
 * 定义一个node类，用来表示结点
 */
public class Node<N, S>  {

    //     为了更好的表示元素内容，我们使用key,value的方式
    public N key;
    public S value;
    //    定义下一个结点
    public Node<N,S> next;
    public Node() {
    }
    //    添加构造方法，用来创建结点的时候添加元素
    public Node(N key, S value) {
        this.key = key;
        this.value = value;
    }
}
