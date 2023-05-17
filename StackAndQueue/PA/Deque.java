package StackAndQueue.PA;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    int size;

    private class Node {
        Item item;
        Node pred;
        Node next;

        private Node (Item item) {
            this.item = item;
            this.pred = null;
            this.next = null;
        }
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("inserted item cannot be null");
        }

        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        }
        else if (size == 1) {
            first = node;
            first.next = last;
            last.pred = first;
        }
        else {
            node.next = first;
            first.pred = node;
            first = node;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("inserted item cannot be null");
        }

        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        }
        else if (size == 1) {
            last = node;
            first.next = last;
            last.pred = first;
        }
        else {
            node.pred = last;
            last.next = node;
            last = node;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        Item item = first.item;

        first = first.next;
        first.pred = null;
        
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        Item item = last.item;
        
        last = last.pred;
        last.next = null;
            
        return item;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() { return new ListIterator(); }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public void remove() {
            throw new UnsupportedOperationException("remove() method unimplemented");
        }
        
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    
    }
}
