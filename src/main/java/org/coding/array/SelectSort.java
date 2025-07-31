package org.coding.array;

public class SelectSort {

    public void selectSort(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            j = i + 1;
            int minI = i;
            while (j < nums.length) {
                if (nums[minI] > nums[j]) {
                    minI = j;
                }
                j++;
            }
            int tmp = nums[i];
            nums[i] = nums[minI];
            nums[minI] = tmp;
            i++;
        }
    }
}
