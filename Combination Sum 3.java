import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int n, int start) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (k == 0 || n < 0 || start > 9) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k - 1, n - i, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k1 = 3, n1 = 7;
        int k2 = 3, n2 = 9;
        int k3 = 4, n3 = 1;

        System.out.println(solution.combinationSum3(k1, n1)); // Output: [[1,2,4]]
        System.out.println(solution.combinationSum3(k2, n2)); // Output: [[1,2,6],[1,3,5],[2,3,4]]
        System.out.println(solution.combinationSum3(k3, n3)); // Output: []
    }
}
