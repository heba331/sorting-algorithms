package hm;
import java.util.Random;

public class Hm {
//    -------------------- heba mohamed salah
// ارقام عشوائية
    public static int[] a(int n){
        int[] arr = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = rand.nextInt(n);
        } 
        return arr;
    }
    //----------------------

// ترتيب تنازلي
    public static int[] b(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = n - i;
        } 
        return arr; 
    }
  //  ----------------
    // مرتبة
    public static int[] c(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i;
        } 
        return arr; 
    }
      //-----------
    // نص ترتيب
    public static int[] d(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){ 
             arr[i] = i;
        } 
        Random r = new Random();
        for (int k = 0; k < n * 0.2; k++){ 
             int k1 = r.nextInt(n);
             int k2 = r.nextInt(n);
             int temp = arr[k1];
             arr[k1] = arr[k2];
             arr[k2] = temp;
        } 
        return arr;
    }    
    //----------
// insertion sort 
    public static void insertionsort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j = j - 1;
            } 
            arr[j + 1] = key;
        }
    }

// selection sort
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int m = i;
            for(int j = i + 1; j < n; j++){
                if(arr[m] > arr[j])
                    m = j;
            }
            int temp = arr[i];
            arr[i] = arr[m];
            arr[m] = temp;
        }
    }

// bubble sort
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

// -------------------------
// quick sort المعدلة والآمنة
    public static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }

    public static void quicksort(int[] arr, int l, int h){
        if(l < h){
            int piv = partition(arr, l, h);
            quicksort(arr, l, piv - 1);
            quicksort(arr, piv + 1, h);
        }
    }

// -------------------------------
// merge sort
    public static void mergesort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

// -------------------------------
    public static void main(String[] args) {
        int n = 100000;

        int[] arr1 = a(n);
        int[] arr2 = b(n);
        int[] arr3 = c(n);
        int[] arr4 = d(n);

        long start = System.nanoTime();
        insertionsort(arr1);
        long end = (System.nanoTime() - start) / 1000;

        long strt = System.nanoTime();
        insertionsort(arr2);
        long nd = (System.nanoTime() - strt) / 1000;
        
        long sart = System.nanoTime();
        insertionsort(arr3);
        long en = (System.nanoTime() - sart) / 1000;
        
        long stat = System.nanoTime();
        insertionsort(arr4);
        long ed = (System.nanoTime() - stat) / 1000;

        int[] arr5 = a(n);
        int[] arr6 = b(n);
        int[] arr7 = c(n);
        int[] arr8 = d(n);
        
        long s = System.nanoTime();
        selectionsort(arr5);
        long e = (System.nanoTime() - s) / 1000;
        
        long t = System.nanoTime();
        selectionsort(arr6);
        long z = (System.nanoTime() - t) / 1000;
        
        long r = System.nanoTime();
        selectionsort(arr7);
        long q = (System.nanoTime() - r) / 1000;
        
        long l = System.nanoTime();
        selectionsort(arr8);
        long m = (System.nanoTime() - l) / 1000;

        int[] arr9 = a(n);
        int[] arr10 = b(n);
        int[] arr11 = c(n);
        int[] arr12 = d(n);

        long o = System.nanoTime();
        bubblesort(arr9);
        long mm = (System.nanoTime() - o) / 1000;
        
        long st = System.nanoTime();
        bubblesort(arr10);
        long ee = (System.nanoTime() - st) / 1000;
        
        long sr = System.nanoTime();
        bubblesort(arr11);
        long dd = (System.nanoTime() - sr) / 1000;
        
        long sa = System.nanoTime();
        bubblesort(arr12);
        long ad = (System.nanoTime() - sa) / 1000;

        int[] arr13 = a(n);
        int[] arr14 = b(n);
        int[] arr15 = c(n);
        int[] arr16 = d(n);
        
        long qStart1 = System.nanoTime();
        quicksort(arr13, 0, arr13.length - 1);
        long qEnd1 = (System.nanoTime() - qStart1) / 1000;
        
        long qStart2 = System.nanoTime();
        quicksort(arr14, 0, arr14.length - 1);
        long qEnd2 = (System.nanoTime() - qStart2) / 1000;
        
        long qStart3 = System.nanoTime();
        quicksort(arr15, 0, arr15.length - 1);
        long qEnd3 = (System.nanoTime() - qStart3) / 1000;

        long qStart4 = System.nanoTime();
        quicksort(arr16, 0, arr16.length - 1);
        long qEnd4 = (System.nanoTime() - qStart4) / 1000;

        int[] arr17 = a(n);
        int[] arr18 = b(n);
        int[] arr19 = c(n);
        int[] arr20 = d(n);
        
        long mStart1 = System.nanoTime();
        mergesort(arr17, 0, arr17.length - 1);
        long mEnd1 = (System.nanoTime() - mStart1) / 1000;
        
        long mStart2 = System.nanoTime();
        mergesort(arr18, 0, arr18.length - 1);
        long mEnd2 = (System.nanoTime() - mStart2) / 1000;

        long mStart3 = System.nanoTime();
        mergesort(arr19, 0, arr19.length - 1);
        long mEnd3 = (System.nanoTime() - mStart3) / 1000;

        long mStart4 = System.nanoTime();
        mergesort(arr20, 0, arr20.length - 1);
        long mEnd4 = (System.nanoTime() - mStart4) / 1000;

        System.out.println("insertionsort");
        System.out.println("Random array: " + end);
        System.out.println("Reversely sorted: " + nd);
        System.out.println("Fully sorted: " + en);
        System.out.println("Partially sorted: " + ed);
        System.out.println("____________________________________________");

        System.out.println("selectionsort");
        System.out.println("Random array: " + e);
        System.out.println("Reversely sorted: " + z);
        System.out.println("Fully sorted: " + q);
        System.out.println("Partially sorted: " + m);
        System.out.println("____________________________________________");

        System.out.println("bubblesort");
        System.out.println("Random array: " + mm);
        System.out.println("Reversely sorted: " + ee);
        System.out.println("Fully sorted: " + dd);
        System.out.println("Partially sorted: " + ad);
        System.out.println("-----------------------------");

        System.out.println("--- quicksort ---");
        System.out.println("Random array: " + qEnd1);
        System.out.println("Reversely sorted: " + qEnd2);
        System.out.println("Fully sorted: " + qEnd3);
        System.out.println("Partially sorted: " + qEnd4);

        System.out.println("-----------------------------");
        System.out.println("--- mergesort ---");
        System.out.println("Random array: " + mEnd1);
        System.out.println("Reversely sorted: " + mEnd2);
        System.out.println("Fully sorted: " + mEnd3);
        System.out.println("Partially sorted: " + mEnd4);
    }
}