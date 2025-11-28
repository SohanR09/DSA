class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generateSubsets(A, 0, list, result);
        return result;
    }
    private void generateSubsets(ArrayList<Integer> A, int idx, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(idx == A.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        // include element
        list.add(A.get(idx));
        generateSubsets(A, idx + 1, new ArrayList<>(list), result);

        // exclude element
        list.remove(list.size() - 1);
        generateSubsets(A, idx + 1, new ArrayList<>(list), result);
    }
}