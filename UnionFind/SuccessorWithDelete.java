public class SuccessorWithDelete {
    private int[] id;
    private int[] size;
   
    public SuccessorWithDelete(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int x) {
        if (id[x] == x)  return x;
        id[x] = root(id[x]);
        return id[x];
    }
    
    private void union(int x, int y) {
        int i = root(x), j = root(y);
        if (i == j)     return;

        if (size[i] >= size[j]) {
            id[j] = i;
            size[i] += size[j];
        }
        else {
            id[i] = j;
            size[j] += size[i];
        }
    }
    
    public void remove(int x) {
        union(x, x + 1);
    }

    public int successor(int x) {
        return root(x + 1);
    }

}
