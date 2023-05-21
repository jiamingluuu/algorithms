package StackAndQueue.PA;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;
    
    // construct an empty randomized queue
    public RandomizedQueue() { 
        queue = (Item []) new Object[1];
        this.size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) { throw new IllegalArgumentException("item cannot be null"); }
        queue[size] = item;
        size++;

        if (queue.length == size) {
            resize(size * 2);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (this.isEmpty()) { throw new NoSuchElementException("queue is empty"); }

        int index = StdRandom.uniformInt(size);
        Item item = queue[index];
        queue[index] = queue[--size];
        
        if (queue.length == size / 4) {
            resize(size / 4);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.isEmpty()) { throw new NoSuchElementException("queue is empty"); }

        int index = StdRandom.uniformInt(size);
        Item item = queue[index];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item>{
        private int i = 0;

        public boolean hasNext() { return i < size; }
        public void remove() { throw new UnsupportedOperationException("remove() method is unimplemented"); }
        public Item next() { return queue[i++]; }
    }
    
    private void resize(int newSize) {
        Item [] newQueue = (Item []) new Object[newSize];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }
        
        queue = newQueue;
    }

    // unit testing (required)
    public static void main(String[] args) {
        
    }
}
