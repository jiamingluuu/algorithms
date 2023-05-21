package StackAndQueue.PA;

import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void  main(String[] args) {
        int len = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        
        for (int i = 1; i <= len; i++) {
            rq.enqueue(args[i]);
        }
        
        while (!rq.isEmpty()) {
            StdOut.println(rq.dequeue());
        }
    }
}
