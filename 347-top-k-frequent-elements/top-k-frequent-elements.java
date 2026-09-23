import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Store all distinct numbers
        List<Integer> elements = new ArrayList<>(frequency.keySet());

        // Sort by frequency in descending order
        elements.sort((a, b) -> frequency.get(b) - frequency.get(a));

        // Take the first k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }

        return result;
    }
}