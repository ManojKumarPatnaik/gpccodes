//Estructura de datos que permite procesar 
//consultas por rangos y actualizaciones 
//individuales sobre un arreglo.

public class FenwickTree {
    // Max tree size 

    final static int MAX = 1000;

    static int BITree[] = new int[MAX];

    /* n --> No. of elements present in input array. 
	BITree[0..n] --> Array that represents Binary 
					Indexed Tree. 
	arr[0..n-1] --> Input array for which prefix sum 
					is evaluated. */
    // Returns sum of arr[0..index]. This function 
    // assumes that the array is preprocessed and 
    // partial sums of array elements are stored 
    // in BITree[]. 
    static int getSum(int index) {
        int sum = 0; // Iniialize result 

        // index in BITree[] is 1 more than 
        // the index in arr[] 
        index = index + 1;

        // Traverse ancestors of BITree[index] 
        while (index > 0) {
            // Add current element of BITree 
            // to sum 
            sum += BITree[index];

            // Move index to parent node in 
            // getSum View 
            index -= index & (-index);
        }
        return sum;
    }

    // Updates a node in Binary Index Tree (BITree) 
    // at given index in BITree. The given value 
    // 'val' is added to BITree[i] and all of 
    // its ancestors in tree. 
    public static void updateBIT(int n, int index,
            int val) {
        // index in BITree[] is 1 more than 
        // the index in arr[] 
        index = index + 1;

        // Traverse all ancestors and add 'val' 
        while (index <= n) {
            // Add 'val' to current node of BIT Tree 
            BITree[index] += val;

            // Update index to that of parent 
            // in update View 
            index += index & (-index);
        }
    }

    /* Function to construct fenwick tree 
	from given array.*/
    static void constructBITree(int arr[], int n) {
        // Initialize BITree[] as 0 
        for (int i = 1; i <= n; i++) {
            BITree[i] = 0;
        }

        // Store the actual values in BITree[] 
        // using update() 
        for (int i = 0; i < n; i++) {
            updateBIT(n, i, arr[i]);
        }
    }

    // Main function 
    public static void main(String args[]) {
        int freq[] = {2, 1, 1, 3, 2, 3,
            4, 5, 6, 7, 8, 9};
        int n = freq.length;
        // Build fenwick tree from given array 
        constructBITree(freq, n);
        System.out.println("Sum of elements in arr[0..5]"
                + " is " + getSum(5));
        // Let use test the update operation 
        freq[3] += 6;
        // Update BIT for above change in arr[] 
        updateBIT(n, 3, 6);
        // Find sum after the value is updated 
        System.out.println("Sum of elements in arr[0..5]"
                + " after update is " + getSum(5));
    }
}
