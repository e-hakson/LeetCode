class Solution {
  
    // Check if each subarray is an arithmetic array and return a list of boolean values
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
      
        // Iterate over all the given subarrays
        for (int i = 0; i < l.length; ++i) {
            // Check each subarray and add the result to the answer list
            result.add(isArithmeticArray(nums, l[i], r[i]));
        }
        return result;
    }

    // Helper function to check if a subarray is an arithmetic array
    private boolean isArithmeticArray(int[] nums, int left, int right) {
        Set<Integer> set = new HashSet<>();
        int subArraySize = right - left + 1;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
      
        // Populate the set with values from the subarray and find min and max
        for (int i = left; i <= right; ++i) {
            set.add(nums[i]);
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
      
        // Check if the difference between max and min is perfectly divisible by the size - 1
        // This condition helps to determine if we can have an equal difference 'd'
        if ((maxValue - minValue) % (subArraySize - 1) != 0) {
            return false;
        }
      
        // Calculate common difference 'd'
        int commonDifference = (maxValue - minValue) / (subArraySize - 1);
      
        // Check if every element that should be present in an arithmetic array is in the set
        for (int i = 1; i < subArraySize; ++i) {
            if (!set.contains(minValue + (i - 1) * commonDifference)) {
                return false;
            }
        }
        return true; // The subarray is arithmetic
    }
}
