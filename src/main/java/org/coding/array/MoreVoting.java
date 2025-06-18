package org.coding.array;

import java.util.*;

public class MoreVoting {
    public int moresVoting(int[] nums) {
        // 找出可能的候选人
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count==0) {
                candidate = nums[i];
            };
            if (candidate == nums[i]) {
                count++;
            }  else {
                count--;
            }
        }
        //验证
        int countVerify = 0;
        for (int num: nums) {
            if (num == candidate) {
                countVerify++;
            }
        }

        return countVerify > nums.length/2 ? candidate:-1;
    }

    /**
     * 时间换空间，不用保存每次的结果
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> moresKVoting(int[] nums, int k) {
        //阶段1找出可能得候选人
        Map<Integer, Integer> candidateMap = new HashMap<>();
        for (int num : nums) {
            if (candidateMap.get(num) != null) {
                candidateMap.put(num, candidateMap.get(num) + 1);
            } else if (candidateMap.size() < k -1){
                candidateMap.put(num, 1);
            } else {
                Iterator<Map.Entry<Integer, Integer>> iterator= candidateMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> next = iterator.next();
                    int value = next.getValue();
                    if (--value == 0) {
                        iterator.remove();
                    } else {
                        next.setValue(value);
                    }
                }
            }
        }
        //阶段二验证
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> verifyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (candidateMap.containsKey(nums[i])) {
                verifyMap.put(nums[i], verifyMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> item : verifyMap.entrySet()) {
            if (item.getValue() < nums.length/k) {
                res.add(item.getKey());
            }
        }

        return res;
    }

}
