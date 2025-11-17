class Solution {
    public int[] buildHeap(int[] A) {
        // code here
        int n = A.length;
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            heapify(A, n, i);
        }
        return A;
    }
    public void heapify(int[] A, int n, int pi) {
        while (pi < n / 2) {
            int smallest = pi;
            int left = 2 * pi + 1;
            int right = 2 * pi + 2;

            if (left < n && A[left] < A[smallest]) smallest = left;
            if (right < n && A[right] < A[smallest]) smallest = right;

            if (smallest == pi) break;

            swap(A, smallest, pi);
            pi = smallest;
        }
    }
    public void swap(int[] A, int s, int e) {
        int temp = A[s];
        A[s] = A[e];
        A[e] = temp;
    }
}