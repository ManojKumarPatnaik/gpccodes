
public class Main{
    
    static int jumpSearch(int arr[], int x){
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev=0;
        while(arr[Math.min(step, n)]-1 <x){
            prev=step;
            step+=(int) Math.floor(Math.sqrt(n));
            if(prev >= n){
                return -1;
            }
        }
        while (arr[prev]<x){
            prev++;
            if(prev==Math.min(step, n)){
                return -1;
            }
        }
        if(arr[prev]==x){
            return prev;
        }
        return -1;
    }
    
    public static void main(String[] args){
        int arr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21,34, 55, 89, 144, 233, 377, 610};
 
 int x = 55;
 //Encontrar el indice de 'x' usando Jump Search
 int index = jumpSearch(arr, x);
 // Imprime el indice donde x fue encontrado
 System.out.println("\nNúmero " + x+ " esta en el indice " + index);
 
    }
}
