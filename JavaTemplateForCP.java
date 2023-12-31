import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class JavaTemplateForCP implements Runnable {

	public static void main() throws IOException {

	}

	public void run() {
		try {
			int tc = fr.readInteger();
			for (int tt = 1; tt <= tc; tt++) {
				main();
				flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new JavaTemplateForCP(), "akashsardar383@gmail.com", 1 << 30).start();
	}

	private static FastReader fr = new FastReader();
	private static PrintWriter pw = new PrintWriter(System.out);

	static class FastReader {
		private BufferedReader br;

		public FastReader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		public int readInteger() throws NumberFormatException, IOException {
			return Integer.parseInt(this.br.readLine());
		}

		public long readLong() throws NumberFormatException, IOException {
			return Long.parseLong(this.br.readLine());
		}

		public double readDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(this.br.readLine());
		}

		public char readCharacter() throws IOException {
			String s = this.br.readLine();
			if (s.length() > 1) {
				throw new IOException("Invalid Character!");
			}
			return s.charAt(0);
		}

		public String readString() throws IOException {
			return this.br.readLine();
		}

		public int[] readArray(int n) throws IOException {
			String[] strArr = this.br.readLine().split(" ");
			if (strArr.length != n) {
				throw new IOException("Invalid array size!");
			}
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}
			return arr;
		}

		public long[] readLongArray(int n) throws IOException {
			String[] strArr = this.br.readLine().split(" ");
			if (strArr.length != n) {
				throw new IOException("Invalid array size!");
			}
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(strArr[i]);
			}
			return arr;
		}

		public String[] readStringArray() throws IOException {
			return this.br.readLine().split(" ");
		}

		public List<Integer> readList() throws IOException {
			String[] strArr = this.br.readLine().split(" ");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < strArr.length; i++) {
				list.add(Integer.parseInt(strArr[i]));
			}
			return list;
		}
	}

	public static void print(String s) {
		pw.print(s);
	}

	public static void flush() {
		pw.flush();
	}

	/*** MATH / NUMBER THEORY ***/

	static int MOD = 1000000007;

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

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (b < a)
			return gcd(a % b, b);
		return gcd(b % a, a);
	}

	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean[] primes;

	public static void sieve(int size) {
		primes = new boolean[size + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i <= size; i++) {
			if (!primes[i])
				continue;
			for (int j = 2 * i; j <= size; j += i) {
				primes[j] = false;
			}
		}
	}

	public int getMEX(int[] arr) {
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

	/*** COMBINATORICS ***/

	public static long[] dp;

	public static void fillFact() {
		int LIMIT = 200001;
		dp = new long[LIMIT];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < LIMIT; i++) {
			dp[i] = mul(dp[i - 1], i);
		}
	}

	public static long nCr(int n, int r) {
		return div(dp[n], mul(dp[n - r], dp[r]));
	}

	/*** BINARY SEARCH ***/

	public static int binSearch(int lo, int hi, int[] arr, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	public static int lowerBound(int lo, int hi, int[] arr, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}

	public static int upperBound(int lo, int hi, int[] arr, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] <= key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}

	public static int binSearch(int lo, int hi, List<Integer> arr, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr.get(mid) == key) {
				return mid;
			} else if (arr.get(mid) < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	public static int lowerBound(int lo, int hi, List<Integer> list, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (list.get(mid) < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}

	public static int upperBound(int lo, int hi, List<Integer> list, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (list.get(mid) <= key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}

	/*** DISJOINT SET & UNION FIND ***/

	static class DisjointSet {
		private int[] size, parent;

		public DisjointSet(int n) {
			size = new int[n + 1];
			parent = new int[n + 1];
			Arrays.fill(size, 1);
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
		}

		public int findUPar(int node) {
			if (parent[node] == node) {
				return node;
			}
			return parent[node] = findUPar(parent[node]);
		}

		public void unionBysize(int u, int v) {
			int ulp_u = findUPar(u);
			int ulp_v = findUPar(v);
			if (ulp_u == ulp_v) {
				return;
			}
			if (size[ulp_u] < size[ulp_v]) {
				parent[ulp_u] = ulp_v;
				size[ulp_v] += size[ulp_u];
			} else {
				parent[ulp_v] = ulp_u;
				size[ulp_u] += size[ulp_v];
			}
		}
	}

	/*** GRAPHS ***/

	// DFS in a 2D matrix
	public static void dfs(int i, int j, int n, int[][] mat, int[][] vis) {
		vis[i][j] = 1;
		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {
				int i1 = i + di;
				int j1 = j + dj;
				if (Math.abs(di) != Math.abs(dj) && i1 >= 0 && i1 < n && j1 >= 0 && j1 < n && vis[i1][j1] != 1) {
					dfs(i1, j1, n, mat, vis);
				}
			}
		}
	}

	/*** SEGMENT TREE ***/
	static class SegTree {
		int[] seg;

		public SegTree(int size) {
			seg = new int[size + 1];
		}

		public void build(int ind, int lo, int hi, int[] arr) {
			if (lo == hi) {
				seg[ind] = arr[lo];
				return;
			}
			int mid = lo + (hi - lo) / 2;
			build(2 * ind + 1, lo, mid, arr);
			build(2 * ind + 2, mid + 1, hi, arr);
			seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
		}

		public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
			if (lo >= l && hi <= r) {
				return seg[ind];
			} else if (hi < l || lo > r) {
				return Integer.MIN_VALUE;
			}
			int mid = lo + (hi - lo) / 2;
			int left = query(2 * ind + 1, lo, mid, l, r, arr);
			int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
			return Math.max(left, right);
		}

		public void update(int ind, int lo, int hi, int i, int val, int[] arr) {
			if (lo == hi) {
				seg[ind] = arr[i] = val;
				return;
			}
			int mid = lo + (hi - lo) / 2;
			if (i <= mid) {
				update(2 * ind + 1, lo, mid, i, val, arr);
			} else {
				update(2 * ind + 2, mid + 1, hi, i, val, arr);
			}
			seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
		}
	}

	/*** LAZY PROPAGATION (RANGE UPDATE) ***/

	static class SegTreeLazy {
		int[] seg;
		int[] lazy;

		public SegTreeLazy(int size) {
			seg = new int[size + 1];
			lazy = new int[size + 1];
		}

		public void build(int ind, int lo, int hi, int[] arr) {
			if (lo == hi) {
				seg[ind] = arr[lo];
				return;
			}
			int mid = lo + (hi - lo) / 2;
			build(2 * ind + 1, lo, mid, arr);
			build(2 * ind + 2, mid + 1, hi, arr);
			seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
		}

		public void update(int ind, int lo, int hi, int l, int r, int val, int[] arr) {
			if (lazy[ind] != 0) {
				seg[ind] += (hi - lo + 1) * lazy[ind];
				if (lo != hi) {
					lazy[2 * ind + 1] += lazy[ind];
					lazy[2 * ind + 2] += lazy[ind];
				}
				lazy[ind] = 0;
			}
			if (hi < l || lo > r) {
				return;
			}
			if (lo >= l && hi <= r) {
				seg[ind] += (hi - lo + 1) * val;
				if (lo != hi) {
					lazy[2 * ind + 1] += val;
					lazy[2 * ind + 2] += val;
				}
				return;
			}
			int mid = lo + (hi - lo) / 2;
			update(2 * ind + 1, lo, mid, l, r, val, arr);
			update(2 * ind + 2, mid + 1, hi, l, r, val, arr);
			seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
		}

		public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
			if (lazy[ind] != 0) {
				seg[ind] += (hi - lo + 1) * lazy[ind];
				if (lo != hi) {
					lazy[2 * ind + 1] += lazy[ind];
					lazy[2 * ind + 2] += lazy[ind];
				}
				lazy[ind] = 0;
			}
			if (lo >= l && hi <= r) {
				return seg[ind];
			} else if (hi < l || lo > r) {
				return 0;
			}
			int mid = lo + (hi - lo) / 2;
			int left = query(2 * ind + 1, lo, mid, l, r, arr);
			int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
			return left + right;
		}
	}

	/*** SORTING ***/
	// Arrays.sort() is bad

	public static void sort(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int e : arr)
			list.add(e);
		Collections.sort(list);
		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
	}

	public static void sort(long[] arr) {
		List<Long> list = new ArrayList<>();
		for (long e : arr)
			list.add(e);
		Collections.sort(list);
		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
	}

	public static <T> void sort(T[] arr, Comparator<? super T> cmp) {
		List<T> list = new ArrayList<>();
		for (T e : arr)
			list.add(e);
		Collections.sort(list, cmp);
		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
	}

	/*** NEXT GREATER ELEMENT ***/
	public static void getNGE(int[] arr, int n) {
		int[] nge = new int[n];
		Stack<Integer> stk = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
				stk.pop();
			}
			if (!stk.isEmpty()) {
				nge[i] = stk.peek();
			} else {
				nge[i] = n;
			}
			stk.push(i);
		}
	}
}
