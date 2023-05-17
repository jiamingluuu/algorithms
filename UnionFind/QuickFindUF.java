public class QuickFindUF {
    private int[] id;
    private int[] size;

    public QuickFindUF (int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    /* @assume: 0 <= p, q < N */
    public int root (int p) {
        if (id[p] == p)     return p;
        id[p] = root(id[p]);
        return id[p];
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }
    
    public void union (int p, int q) {
        int i = root(p), j = root(q);

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
}