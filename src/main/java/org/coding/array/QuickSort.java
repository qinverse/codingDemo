package org.coding.array;

public class QuickSort {
    public void quikSort(int[] numbers, int start, int end) {
        if (start >= end) return;
        //分区找主元
        int minLeft = start;
        int pivot = numbers[end];
        for (int j = start; j < end; j++) {
            if (numbers[j] <= pivot) {
                int tmp = numbers[minLeft];
                numbers[minLeft] = numbers[j];
                numbers[j] = tmp;
                minLeft++;
            }
        }

        int tmp = numbers[minLeft];
        numbers[minLeft] = numbers[end];
        numbers[end] = tmp;

        quikSort(numbers, start, minLeft - 1);
        quikSort(numbers, minLeft + 1, end);
    }

}
