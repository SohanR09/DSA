public class Solution {
    int mod = 10000003;

    public int seats(String A) {
        int n = A.length();
        ArrayList<Integer> pos = new ArrayList<>();

        // add x seat positions
        int i = 0;
        for (char ch: A.toCharArray()) {
            if (ch == 'x') pos.add(i);
            i++;
        }

        int size = pos.size();
        int mid = size / 2, left = mid - 1, right = mid + 1, temp = 1;
        int res = 0;

        while (left >= 0) {
            res = (res + pos.get(mid) - pos.get(left) - temp) % mod;
            left--;
            temp++;
        }
        
        // reset temp
        temp = 1;
        while (right < size) {
            res = (res + pos.get(right) - pos.get(mid) - temp) % mod;
            right++;
            temp++;
        }

        return res;
    }
}
