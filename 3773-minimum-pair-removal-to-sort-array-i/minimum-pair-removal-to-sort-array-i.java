class Solution {
    public int minimumPairRemoval(int[] nums) {
        // Use an ArrayList for easy removal/insertion
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        
        int operations = 0;
        
        while (true) {
            // 1. Check if sorted
            boolean isSorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    isSorted = false;
                    break;
                }
            }
            
            if (isSorted) {
                return operations;
            }
            
            // 2. Find the minimum sum pair (leftmost tie-break)
            int minSum = Integer.MAX_VALUE;
            int index = -1;
            
            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            
            // 3. Perform the merge operation
            // Update the left element to the sum
            arr.set(index, minSum);
            // Remove the right element
            arr.remove(index + 1);
            
            operations++;
        }
    }
}