package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Maths {

    /*** BASIC OPERATIONS ***/

    public static long MOD = 1000000007;

    public static long add(long a, long b) {
        return (a + b) % MOD;
    }

    public static long sub(long a, long b) {
        if (a < b)
            return (MOD + a - b) % MOD;
        return (a - b) % MOD;
    }

    public static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    public static long div(long a, long b) {
        a = a % MOD;
        long inv_b = binExp(b, MOD - 2);
        return mul(a, inv_b);
    }

    public static long binExp(long a, long b) {
        if (b == 0)
            return 1;
        long half = binExp(a, b / 2);
        long temp = mul(half, half);
        if (b % 2 == 0)
            return temp;
        return mul(a, temp);
    }

    public static long binExpItr(long a, long b) {
        long ans = 1;
        for (int i = 0; i < 62; i++) {
            long bit = (b >> i) & 1L;
            if (bit == 1L) {
                ans = mul(ans, a);
            }
            a = mul(a, a);
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (b < a)
            return gcd(a % b, b);
        return gcd(b % a, a);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long log(long a, long b) {
        return (long) (Math.log(a) / Math.log(b));
    }

    /*** PRIME NUMBERS & SIEVE ***/

    public static boolean[] isPrime;
    public static List<Long> primes;

    public static void sieve(int size) {
        isPrime = new boolean[size + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (long i = 2; i * i <= size; i++) {
            if (!isPrime[(int) i])
                continue;
            for (long j = i * i; j <= size; j += i) {
                isPrime[(int) j] = false;
            }
        }
        primes = new ArrayList<>();
        for (long i = 2; i <= size; i++) {
            if (isPrime[(int) i])
                primes.add(i);
        }
    }

    public static int[] spf;

    public static void getSmallestPrimeFactors(int size) {
        spf = new int[size + 1];
        for (int i = 0; i <= size; i++)
            spf[i] = i;
        for (int i = 2; i <= size; i++) {
            if (spf[i] < i)
                continue;
            for (int j = 2 * i; j <= size; j += i) {
                spf[j] = Math.min(spf[j], i);
            }
        }
    }

    public static void getPrimeFactors(Map<Long, Integer> primeFatctors, long num) {
        long temp = num;
        for (long i : primes) {
            if (i * i > num)
                break;
            if (!isPrime[(int) i])
                continue;
            int cnt = 0;
            while (temp % i == 0) {
                cnt++;
                temp /= i;
            }
            if (cnt > 0)
                primeFatctors.put(i, cnt);
            if (temp == 1)
                break;
        }
        if (temp > 1) {
            primeFatctors.put(temp, primeFatctors.getOrDefault(temp, 1));
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*** PERMUTATION & COMBINATION ***/

    public static long[] fact;

    public static void fillFact() {
        int LIMIT = 200001;
        fact = new long[LIMIT];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < LIMIT; i++) {
            fact[i] = mul(fact[i - 1], i);
        }
    }

    public static long nCr(int n, int r) {
        return div(fact[n], mul(fact[n - r], fact[r]));
    }

    /*** MEX ***/

    public static int getMEX(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int e : arr)
            set.add(e);
        int mex = 0;
        while (mex <= Integer.MAX_VALUE) {
            if (!set.contains(mex))
                break;
            mex++;
        }
        return mex;
    }

    /*** EXTRA ***/

    public static long sqrtFloor(long a) {
        long lo = 0;
        long hi = 1000000000L;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    public static long ceil(long a, long b) {
        return a % b == 0 ? a / b : (1 + a / b);
    }

}
