package templates;

import java.util.List;

public class BinarySearch {

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
}
