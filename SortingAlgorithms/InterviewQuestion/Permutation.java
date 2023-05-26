package SortingAlgorithms.InterviewQuestion;

import edu.princeton.cs.algs4.Shell;

public class Permutation {
    int[] a;
    int[] b;

    public Permutation(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean isPermutation() {
        if (a.length != b.length) return false;
        
        Shell.sort(a);
        Shell.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        
        return true;
    }
}
