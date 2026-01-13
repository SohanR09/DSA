public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size(), m = B.size();

        for (int i = 0; i < n; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }

        for (int j = 0; j < m; j++) {
            int cur = B.get(j);
            if (map.containsKey(cur)) {
                for (int k = 0; k < map.get(cur); k++) {
                    result.add(cur);
                }
                map.remove(cur);
            }
        }

        for (Integer key: map.keySet()){
            for(int i = 0; i < map.get(key); i++){
                result.add(key);
            }
        }
        return result;
    }
}
