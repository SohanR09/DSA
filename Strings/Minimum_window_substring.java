public class Solution {
    public String minWindow(String A, String B) {
        if ( A.length() < 1 || B.length() < 1 || A.length() < B.length() ) {
            return "-1";
        }
        int n = A.length(), m = B.length();
        // B string Characters map
        Map<Character, Integer> mapBchar = new HashMap<>();
        for ( char b: B.toCharArray() ) {
            mapBchar.put(b, mapBchar.getOrDefault(b, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        int left = 0, right = 0;

        while ( right < n ) {
            char cur = A.charAt(right);
            window.put(cur, window.getOrDefault(cur, 0) + 1);

            // shrink the window
            while (cmp(window, mapBchar)) {
                // Update minLen and other necessary variables
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                // Remove the leftmost character from the window
                char leftChar = A.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                // Move the left pointer
                left++;

                // Break if the window no longer contains all required characters
                if (!cmp(window, mapBchar)) {
                    break;
                }
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "-1" : A.substring(minStart, minStart + minLen);
    }
    private boolean cmp( Map<Character, Integer> window, Map<Character, Integer> mapBchar ) {
        // get B Characters
        Set<Character> BcharKeys = mapBchar.keySet();
        // loop through the Characters
        for ( Character ch: BcharKeys ) {
            // check if the Character exist or not
            // also check for the fequency must be equal or greater than
            if ( !window.containsKey(ch) || mapBchar.get(ch) > window.get(ch) ) return false;
        }
        return true;
    }
}
