/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAlgorithms;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Sort {

    int a[];
    int n;

    public Sort(int n) {
        this.n = n;
        a = new int[n];
    }

    /**
     * @param args the command line arguments
     */
    public int[] selection() {
        int b[] = a;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (b[j] < b[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = b[min];
                b[min] = b[i];
                b[i] = tmp;
            }
        }
        return b;
    }

    public void Quick(int a[], int f, int l) {
        int p;
        if (f < l) {
            p = partition(a, f, l);
            Quick(a, f, p - 1);
            Quick(a, p + 1, l);
        }
    }

    public int[] bubble() {
        int A[] = a;
        int count = 0;
        boolean swap = true;
        for (int i = 0; i < n; i++) {
            swap = false;
            for (int j = 1; j < n; j++) {
                count++;
                if (a[j] < a[j - 1]) {
                    swap = true;
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;

                }
            }
            if (!swap) {
                break;
            }
        }
        System.out.println("count = " + count);
        return A;
    }

    public int[] insert() {
        int A[] = a;
        for (int i = 0; i < n; i++) {

            int j = i;
            int tmp = A[j];
            while (j > 0 && tmp < A[j - 1]) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tmp;
        }
        return A;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int[] A = { 2, 6, 8, 9, 18, 3, 100000, 150, 4, 7, 20, 15, 16, 300, 999, 555, 888, 9999, 1111, 3333 };
        int n = A.length;
        Sort sort = new Sort(n);
        sort.a = A;
        // int[] B = sort.selection();
        // System.out.println("before sort");
        // sort.display(n, sort.a);

        // sort.display(n, B);
        System.out.println("The List before sort");
        sort.display();
        // sort.heapSort();
        sort.radix();
        System.out.println("The List after sorted");
        sort.display();
    }

    public void heapSort() {
        a = array2Heap();
        a = head2Array();
    }

    public int[] array2Heap() {
        int heap[] = new int[n];
        int f = 0, x;
        int leftSon = 2 * f + 1;
        int rightSon = 2 * f + 2;
        int son = leftSon > rightSon ? leftSon : rightSon;
        for (int i = 1; i < n; i++) {
            x = a[i];
            son = i;
            f = (son - 1) / 2;
            while (son > 0 && x > a[f]) {
                a[son] = a[f];
                son = f;
                f = (son - 1) / 2;

            }
            a[son] = x;
        }
        return a;
    }

    public int[] head2Array() {
        int x, s, f;
        for (int i = n - 1; i > 0; i--) {
            x = a[i];
            a[i] = a[0];
            f = 0;
            s = 2 * f + 1;
            if (s + 1 < i && a[s] < a[s + 1]) {
                s++;
            }
            while (s < i && x < a[s]) {
                a[f] = a[s];
                f = s;
                s = 2 * f + 1;
                if (s + 1 < i && a[s] < a[s + 1]) {
                    s++;
                }
            }
            a[f] = x;
        }
        return a;
    }

    public void display(int n, int a[]) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void merge(int f, int l) {
        if (f >= l) {
            return;
        }
        int mid = (f + l) / 2;
        merge(f, mid);
        merge(mid + 1, l);
        merge(f, mid, l);
    }

    private int partition(int[] a, int f, int l) {
        int ind = f;
        int tmp;
        int up = f + 1;
        int down = l;
        while (up <= down) {
            if (a[up] < a[f]) {
                ind++;
                tmp = a[up];
                a[up] = a[ind];
                a[ind] = tmp;
            }
            up++;
        }
        // ind--;
        tmp = a[f];
        a[f] = a[ind];
        a[ind] = tmp;
        return ind;
    }

    private void merge(int f, int mid, int l) {
        if (!(f <= mid && mid <= l)) {
            return;
        }
        int b[] = new int[n];
        int i = f;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= l) {
            if (a[i] < a[j]) {
                b[t++] = a[i++];
            } else {
                b[t++] = a[j++];
            }
        }
        while (i <= mid) {
            b[t++] = a[i++];
        }
        while (j <= l) {
            b[t++] = a[j++];
        }
        for (int k = f; k <= l; k++) {
            a[k] = b[k - f];
        }
    }

    public void radix() {
        ArrayList<Integer> list[][] = new ArrayList[7][10];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                list[i][j] = new ArrayList();
            }
        }

        boolean cont = false;
        int div = 1;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int one = a[i] / div % 10;
            list[num][one].add(a[i]);
            if (a[i] > 10) {
                cont = true;
            }
        }
        // sort by ten's
        while (cont) {
            div = div * 10;
            cont = false;
            for (int i = 0; i < 10; i++) {
                int len = list[num][i].size();
                // int len = list1[i].size();
                for (int k = 0; k < len; k++) {
                    // int ten = (int) list1[i].get(k) / 10 % 10;
                    int ren = list[num][i].get(k) / div % 10;
                    // System.out.println("ten = " + ren);
                    list[num + 1][ren].add(list[num][i].get(k));
                    if (list[num][i].get(k) / div >= 10) {
                        cont = true;
                    }
                    // list2[ten].add(list1[i].get(k));
                }
            }
            num++;
        }
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < list[num][i].size(); j++) {
                a[k++] = list[num][i].get(j);
            }

        }
    }

    void partition(int[] a, int low, int up) // return pivot index

    {
        int pivotval, i, j;

        pivotval = a[low];// select the first element as the pivot value

        i = low;
        j = up;

        while (i < j)

        {
            while (a[i] <= pivotval && i < up)
                i++;// stop at the first i, where a[i]>pivotval

            while (a[j] > pivotval)
                j--;// stop at the first j, where a[j]<=pivotval if(i<j) swap(a,i,j);// swap the
                    // values a[i] and a[j]

        }

        swap(a, low, j);

    }
}
