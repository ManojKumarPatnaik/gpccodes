import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int NO_OF_CHARS = 256;

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static void badCharHeuristic(char[] str, int size, int badchar[]) {
        int i;
        Arrays.fill(badchar, -1);
        for (i = 0; i < size; i++) {
            badchar[(int) str[i]] = i;
        }
    }

    static void boyerMoore(char txt[], char[] pat) {
        int m = pat.length;
        int n = txt.length;
        int badchar[] = new int[NO_OF_CHARS];
        badCharHeuristic(pat, m, badchar);
        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;
            while (j <= 0 && pat[j] == txt[s + j]) {
                j--;
            }
            if (j > 0) {
                System.out.println("Patron encontrado en salto = " + s);
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
            } else {
                s += max(1, j - badchar[txt[s + j]]);
            }
        }
    }

    public static void main(String[] args) {
        char txt[]="lalalalalalalala".toCharArray();
        char pat[]="lala".toCharArray();
        boyerMoore(txt, pat);
    }
}
