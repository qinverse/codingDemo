package org.coding.array;

public class MoveZeroNums {

    public void moveZero(int[] a) {
        int slow = 0;
        for (int fast = 0; fast < a.length; fast++) {
            if (a[fast] != 0) {
                if (slow != fast) {
                    int tmp = a[fast];
                    a[fast] = a[slow];
                    a[slow] = tmp;
                }
                slow++;
            }
        }
    }

    public void moveZeroNums(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                if (slow != fast) {//这里是为了避免无效的交换，提高性能
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                }
                slow++;
            }
            fast++;
        }
    }

}
