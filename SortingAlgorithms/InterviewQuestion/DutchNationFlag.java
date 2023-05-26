package SortingAlgorithms.InterviewQuestion;

import edu.princeton.cs.algs4.StdOut;

public class DutchNationFlag {
    public int[] buckets;
    
    public DutchNationFlag(int[] a) {
        this.buckets = a;
    }
    
    public void swap(int i, int j) {
        if (i >= buckets.length || j >= buckets.length) {
            throw new IllegalArgumentException("index out of range");
        }
        
        int tmp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = tmp;
    }
    
    public String color(int i) {
        if (i >= buckets.length) {
            throw new IllegalArgumentException("index out of range");
        }
        
        switch(buckets[i]) {
            case 0: return "red";
            case 1: return "white";
            case 2: return "blue";
            default: return null;
        }
    }
    
    public void sort() {
        int i = 0, lo = 0, hi = buckets.length - 1;
        
        while (i < hi) {
            if (color(i) == "red") {
                swap(lo++, i++);
            }
            else if (color(i) == "blue") {
                swap(hi--, i);
            }
            else {
                i++;
            }
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < buckets.length; i++) {
            str += Integer.toString(buckets[i]) + " ";
        }
        
        return str;
    }
    
    public static void main(String args[]) {
        int[] a = {1,2,0,1,2,0,0,2,1,2,1,0,2};
        DutchNationFlag d = new DutchNationFlag(a);
        d.sort();
    }
}
