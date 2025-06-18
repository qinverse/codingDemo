package org.coding;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }







    public void quickSort1(int[] numbers, int start, int end) {
        if (start >= end) return;
        int pivot = numbers[end];
        int minLeft = start;
        for (int i = start; i < end; i++) {
            if (numbers[i] <= pivot) {
                if (i != minLeft) {
                    int tmp = numbers[minLeft];
                    numbers[minLeft] = numbers[i];
                    numbers[i] = tmp;
                }
                minLeft++;
            }
        }
        if (minLeft != end) {
            int tmp = numbers[minLeft];
            numbers[minLeft] = numbers[end];
            numbers[end] = tmp;
        }
        quickSort1(numbers, start, minLeft - 1);
        quickSort1(numbers, minLeft + 1, end);
    }







}