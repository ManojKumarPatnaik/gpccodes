


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Timsort {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada[] = br.readLine().split(" ");
        int arr[] = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            arr[i] = Integer.parseInt(entrada[i]);
        }
        timSort(arr, arr.length);
        print(arr, arr.length);

    }
    static int RUN = 32;

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (arr[j] > temp && j >= left) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void timSort(int[] arr, int n) {
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                merge(arr, left, mid, right);
            }
        }
    }

    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
