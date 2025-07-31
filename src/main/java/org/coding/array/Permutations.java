package org.coding.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinverse
 * @date 2025/6/23 7:55
 * @description 生成全排列
 */
public class Permutations {

    /**
     * 全排列
     *
     * @param nums 数据
     * @param used 标记已经使用过的数组元素
     * @param path 当前递归路径下已经选出来的数字组成的排列
     * @param res  存放最终结果的二维数组
     */
    public void generateAllPermutations(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            // 保存当前路径的副本
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 跳过已经使用过的元素
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            // 递归
            generateAllPermutations(nums, used, path, res);
            // 撤销选择（回溯）
            used[i] = false;
            // 移除最后一个元素（回溯）
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used, res);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public void generateAllPermutations1(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            generateAllPermutations1(nums, used, list, res);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 下一个排列
     * 其元素按升序排列
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Step 1: 从后向前找第一个下降的位置 i：
        while (i>= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i>= 0) {
            int j = n-1;
            // Step 2: 从后向前找第一个大于 nums[i] 的 j
            while (j>= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        // Step 4: 反转 i+1 后的所有元素（因为是降序）
        reverse(nums, i + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


}
