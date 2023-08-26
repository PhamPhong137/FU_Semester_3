package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nguyentosanhdieu {

    public static void main(String[] args) {    
        Set<Long> primeSquares = new HashSet<>();
        for (long i = 2; i <= 1_000_000; i++) {
            if (isPrime(i)) {
                primeSquares.add(i * i);
            }
        }
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();

            if (primeSquares.contains(x)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean isPrime(long n) {
        if (n < 4) {
            return n == 2 || n == 3;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
