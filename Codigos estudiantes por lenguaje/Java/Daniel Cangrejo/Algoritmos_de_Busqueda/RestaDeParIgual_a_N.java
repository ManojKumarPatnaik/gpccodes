//RestaDeParIgual_a_N
public class Busquedas2 {
	
    static boolean findPair(int arr[], int n) {
        int size = arr.length;
        int i = 0, j = 1;
        while (i < size && j < size) {
			if (i != j && arr[j] - arr[i] == n) {
				System.out.println("Par encontrado: " + arr[i] + " - " + arr[j]);
			    i++;
			    j++;
			}else if(arr[j] - arr[i] < n) {
				j++;
				
			}else {
				i++;
			}
		}
        System.out.println("Par no encontrado");
        return false;
  
    }
	
    public static void main(String[] args) {
	 int arr[] = {1,8,30,40,90,100};
	 int n = 60;
	 findPair(arr, n);

	}

}
