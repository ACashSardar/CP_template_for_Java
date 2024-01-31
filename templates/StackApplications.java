package templates;

import java.util.Stack;

public class StackApplications {

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
