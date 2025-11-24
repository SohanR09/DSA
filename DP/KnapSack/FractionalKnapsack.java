public class Solution {
    private class Cake {
        int wt;
        int h;
        double cost;

        public Cake(int wt, int h) {
            this.wt = wt;
            this.h = h;
            this.cost = (double) h / wt;
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();

        List<Cake> cakes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cakes.add(new Cake(B.get(i), A.get(i)));
        }
        Collections.sort(cakes, (a, b) -> Double.compare(b.cost, a.cost));

        double ans = 0.0d;

        for (Cake cake: cakes) {
             if (cake.wt <= C) {
                ans += cake.h;
                C -= cake.wt;
            } else {
                ans = ans + (cake.cost * (double)C);
                break;
            }            
        }

        // return ans * 100
        ans *= 1000;
        return (int)(ans / 10);
    }
}
