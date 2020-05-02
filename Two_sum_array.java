import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> lst = map.get(nums[i]);
                lst.add(i);
                map.put(nums[i],lst);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(nums[i],lst);
            }
        }
        int firstIndex = 0, secondIndex = 0;
        for (int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                List<Integer> lst = map.get(diff);
                if (lst.size() > 1) {
                    firstIndex = i;
                    if (lst.get(0) == i) {
                        secondIndex = lst.get(1);
                    }
                    else {
                        secondIndex = lst.get(0);
                    }
                } else if (diff != nums[i]){
                    firstIndex = i;
                    secondIndex = lst.get(0);
                }
            }
        }
        
        int[] arr = new int[2];
        if (firstIndex < secondIndex) {
            arr[0] = firstIndex;
            arr[1] = secondIndex;
        } else {
            arr[0] = secondIndex;
            arr[1] = firstIndex;
        }
        return arr;
    }
}
