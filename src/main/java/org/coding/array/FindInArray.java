package org.coding.array;

public class FindInArray {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (nums[i] > target && i > 0) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 时间复杂度为 O(logN + K)（K 为目标元素个数
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mind = (left + right) / 2;
            if (nums[mind] == target) {
                return findStartEnd(mind, nums);
            } else if (nums[mind] > target) {
                right = mind - 1;
            } else {
                left = mind + 1;
            }
        }
        return new int[]{-1, -1};
    }

    int[] findStartEnd(int index, int[] nums) {
        int start = index, end = index;
        while (start >= 1 && nums[start - 1] == nums[start]) {
            start--;
        }
        while (end <= nums.length - 2 && nums[end + 1] == nums[end]) {
            end++;
        }
        return new int[]{start, end};
    }

    public int[] searchRange1(int[] nums, int target) {
        return new int[]{findLeft(target, nums), findright(target, nums)};
    }

    /**
     * 所以你不能直接 return mid，而是要继续向左压缩，直到找不到为止。
     * @param target
     * @param nums
     * @return
     */
    int findLeft(int target, int[] nums) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (target <= nums[mid]) {
                if (nums[mid]== target) res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    /**
     * 即便当前 nums[mid] == target，你还是要继续向右逼近，看看有没有更右边的值也等于 target。
     * @param target
     * @param nums
     * @return
     */
    int findright(int target, int[] nums) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (target >= nums[mid]) {
                if (nums[mid]== target) res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
