
import java.util.Arrays;

public class Sieve_Of_Eratosthenes {

    public static boolean[] sieveEratosthenes(int N) {
        boolean prime[] = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= N; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= N; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        boolean res[] = sieveEratosthenes(1000);
        for (int i = 0; i < res.length; i++) {
            System.out.println(i + ": " + res[i]);
        }
    }
}
