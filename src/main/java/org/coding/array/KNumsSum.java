package org.coding.array;

import java.util.*;

public class KNumsSum {

    /**
     * 两数之和
     *
     * @param array
     * @param target
     * @return
     */
    public int[] targetIndex(int[] array, int target) {
        Map<Integer, Integer> resultIndexMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (resultIndexMap.containsKey(complement)) {
                return new int[]{resultIndexMap.get(complement), i};
            }
            resultIndexMap.put(array[i], i);
        }
        return new int[]{-1, -1};
    }

    public List<List<Integer>> existThreeSumZero(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        if (a == null || a.length < 3) {
            return res;
        }
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) break;
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int left = i + 1, right = a.length - 1;
            while (left < right) {
                int sum = a[left] + a[i] + a[right];
                if (sum == 0) {
                    res.add(Arrays.asList(a[i], a[left], a[right]));
                    while (left < right && a[left] == a[left + 1]) {
                        left++;
                    }
                    while (left < right && a[right] == a[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;
    }

    /**
     * 滑动窗口计算n数之和为target
     */
    public List<List<Integer>> fixedWindowNSum(int[] nums, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int windSum = 0;
        for (int i = 0; i < n; i++) {
            windSum += nums[i];
        }
        if (windSum == target) {
            res.add(toList(nums, 0, n));
        }
        for (int i = n; i < nums.length; i++) {
            windSum = windSum - nums[i - n] + nums[i];
            if (windSum != target) {
                continue;
            }
            res.add(toList(nums, i - n + 1, i + 1));
        }
        return res;
    }

    private List<Integer> toList(int[] nums, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(nums[i]);
        }
        return list;
    }


    public List<List<Integer>> kSum2(int[] nums, int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < k) return res;

        Arrays.sort(nums); // 排序后便于去重和使用双指针
        kSumHelper2(nums, 0, k, target, new ArrayList<>(), res);
        return res;
    }

    private void kSumHelper2(int[] nums, int start, int k, int target,
                             List<Integer> path, List<List<Integer>> res) {
        int end = nums.length;
        if (nums[start] * k > target || nums[end - 1] * k < target) return;
        if (k == 2) {
            int left = start, right = end - 1;
            while (start < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> tmpList = new ArrayList<>(path);
                    tmpList.addAll(List.of(nums[left], nums[right]));
                    while (nums[left] == nums[left + 1]) left++;
                    while (nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        } else {
            for (int i = start; i < k; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] * k > target) break;
                path.add(nums[i]);
                kSumHelper2(nums, start + 1, k - 1, target - nums[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
