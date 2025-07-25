package org.coding.array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int countVal = 0;
        int slow = 0, flast = 0;
        while (flast < nums.length) {
            if (nums[flast] != val) {
                nums[slow] = nums[flast];
                slow++;
            } else {
                nums[flast] = Integer.MAX_VALUE;
                countVal++;
            }
            flast++;
        }
        return nums.length - countVal;
    }
}
