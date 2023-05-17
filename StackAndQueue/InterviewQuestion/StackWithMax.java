package StackAndQueue.InterviewQuestion;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MaxPQ;

public class StackWithMax<Item> {
    Stack<Item> s;
    MaxPQ<Item> pq;
    
    public StackWithMax() {
        s = new Stack<Item>();
        pq = new MaxPQ<Item>(1, null);
    }
    
    public void push(Item item) {
        s.push(item);
        pq.insert(item);
    }
    
    public Item pop() {
        Item item = s.pop();
    }
    
}