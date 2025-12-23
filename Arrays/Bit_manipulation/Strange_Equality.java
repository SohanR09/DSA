public class Solution {
    public int solve(int A) {
        long x = 0;
        long y = 0;
        int bit = 0;
        // find x
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }
        // find y
        y = y | (1 << bit);
        // return x xor y
        return (int)(x ^ y);
    }
}
