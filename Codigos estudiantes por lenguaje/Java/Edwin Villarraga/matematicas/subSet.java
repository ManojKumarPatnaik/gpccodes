public class Main {

    static void printSubsets(String[] set) {
        int n = set.length;
        for (int i = 0; i <(1<<n); i++) {
            System.out.print("{");
            for (int j = 0; j < n; j++) {
                if((i&(1<<j))>0){
                    System.out.print(set[j]+" ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        String[] colores={"negro","blanco","amarillo","morado"};
        printSubsets(colores);
    }
}
