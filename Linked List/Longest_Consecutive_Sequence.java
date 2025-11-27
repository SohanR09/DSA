public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        for (int cur: A) {
            set.add(cur);
        }

        int maxCount = 0;
        for (int cur: A) {
            if (!set.contains(cur - 1)) {
                int currentNum = cur;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                maxCount = Math.max(maxCount, currentStreak);
            }
        }

        return maxCount;
    }
}
