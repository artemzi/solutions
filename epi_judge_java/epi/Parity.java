package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Parity {
    @EpiTest(testDataFile = "parity.tsv")
    public static short parity(long x) {
        short r = 0;
        while(x != 0) { // improve performance from O(n) to O(k), where k is number of bits set to 1 in word
//            r ^= (x & 1);
//            x >>>= 1;
            r ^= 1;
            x &= (x - 1); // Drops the lowest set bit of x.
        }
        return r;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "Parity.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
