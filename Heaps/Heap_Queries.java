public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int P = A.get(i).get(0);
            int Q = A.get(i).get(1);
            if(P == 1){
                if(!pq.isEmpty()){
                    int res = pq.poll();
                    result.add(res);
                }else{
                    result.add(Q);
                }
            }else if(P == 2){
                pq.offer(Q);
            }
        }
        return result;
    }
}
