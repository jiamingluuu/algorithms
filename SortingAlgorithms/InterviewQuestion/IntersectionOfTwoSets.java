package SortingAlgorithms.InterviewQuestion;

import edu.princeton.cs.algs4.Shell;

public class IntersectionOfTwoSets {
    private class Point implements Comparable<Point>{
        private int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point that) {
            if (that.x < this.x || that.y < this.y)    return 1;
            if (that.x > this.x || that.y > this.y)    return -1;
            return 0;
        }
    }
    
    Point[] a;
    Point[] b;

    public IntersectionOfTwoSets(int[] ax, int[] ay, int[] bx, int[] by) {
        if (ax.length != ay.length || bx.length != by.length) {
            throw new IllegalArgumentException("The length of coordinate array is unmatched");
        }
        
        for (int i = 0; i < ax.length; i++) {
            this.a[i] = new Point(ax[i], ay[i]);
        }
        
        for (int i = 0; i < bx.length; i++) {
            this.b[i] = new Point(bx[i], by[i]);
        }
    }
    
    public int countIntersection(Point[] a, Point[] b) {
        Shell.sort(a);
        Shell.sort(b);
        int count = 0, i = 0, j = 0;
        
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[i]) == 0) {
                i++;
                j++;
                count++;
            }
            else if(a[i].compareTo(b[i]) < 0) {
                i++;
            }
            else {
                j++;
            }
        }

        return count;
    }
    
    public static void main(String args[]) {
        
    }

}