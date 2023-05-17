package StackAndQueue.InterviewQuestion;

import edu.princeton.cs.algs4.Stack;

public class TwoStackQueue<Item> {
    Stack<Item> s;
    int N;

    public TwoStackQueue() {
        s = new Stack<Item>();
        N = 0;
    }
    
    public boolean isEmpty() {
        return s.isEmpty();
    }
    
    public void enqueue(Item item) {
        s.push(item);
    }
    
    public Item dequeue() {
        Stack<Item> s2 = new Stack<Item>();

        while (!s.isEmpty()) {
            s2.push(s.pop());
        }
        
        Item item = s2.pop();

        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
        
        return item;
    }

}