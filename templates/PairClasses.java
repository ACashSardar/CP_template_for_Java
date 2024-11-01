package templates;

public class PairClasses {

    /*** Int, Int */

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "[" + first + ", " + second + "] ";
        }
    }

    /*** Long, Long */

    // static class Pair {
    // long first;
    // long second;

    // Pair(long first, long second) {
    // this.first = first;
    // this.second = second;
    // }

    // @Override
    // public String toString() {
    // return "[" + first + ", " + second + "] ";
    // }
    // }

    /*** Graph related */

    // static class Node {
    // int u, v, wt;

    // Node(int u, int v, int wt) {
    // this.u = u;
    // this.v = v;
    // this.wt = wt;
    // }
    // }

    // static class Pair {
    // int node;
    // int wt;

    // Pair(int node, int wt) {
    // this.node = node;
    // this.wt = wt;
    // }
    // }

    /*** Int, Int, Int */

    // static class Tup {
    // int first;
    // int second;
    // int third;

    // Tup(int first, int second, int third) {
    // this.first = first;
    // this.second = second;
    // this.third = third;
    // }

    // @Override
    // public String toString() {
    // return "[" + first + ", " + second + ", " + third + "] ";
    // }
    // }
}