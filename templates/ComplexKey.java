package templates;

// Instead of String concatenation use this for hasing Complex Keys 🔥🔥
public class ComplexKey {
    static class CompKey {
        int fst;
        int sec;

        CompKey(int fst, int sec) {
            this.fst = fst;
            this.sec = sec;
        }

        @Override
        public int hashCode() {
            return ((fst * 79) + (sec * 67) + (fst ^ sec) + (fst & sec));
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof CompKey) {
                CompKey ck = (CompKey) other;
                return this.fst == ck.fst && this.sec == ck.sec;
            }
            return false;
        }
    }
}
