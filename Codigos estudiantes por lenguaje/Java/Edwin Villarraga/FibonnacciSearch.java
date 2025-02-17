public class Main {
	public static int min(int x, int y) {
		return (x <= y) ? x : y;
	}

	public static int fibMonaccianSearch(int arr[], int x, int n) {
		int fibMMm2 = 0;
		int fibMMm1 = 1;
		int fibM = fibMMm2 + fibMMm1;
		while (fibM < n) {
			fibMMm2 = fibMMm1;
			fibMMm1 = fibM;
			fibM = fibMMm2 + fibMMm1;
		} 
		int offset = -1;
		while (fibM > 1) {
			int i = min(offset + fibMMm2, n - 1);
			if (arr[i] < x) {
				fibM = fibMMm1;
				fibMMm1 = fibMMm2;
				fibMMm2 = fibM - fibMMm1;
				offset = i;
			} else if (arr[i] > x) {
				fibM = fibMMm2;
				fibMMm1 = fibMMm1 - fibMMm2;
				fibMMm2 = fibM - fibMMm1;
			} else {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
		int n = 11;
		int x = 85;
		System.out.println("elemento encontrado en la posicion " + fibMonaccianSearch(arr, x, n));
	}
}
