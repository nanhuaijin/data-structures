package com.breeze.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : breeze
 * @date : 2021/12/6
 * @desc : 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *         你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *         输入：[3,2,3]
 *         输出：3
 *         输入：[2,2,1,1,1,2,2]
 *         输出：2
 *         进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class 多数元素_简单_001 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 1, 1};
        majorityElement05(nums);
    }

    /**
     * 摩尔投票算法
     * @param nums
     */
    public static void majorityElement05(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        System.out.println("数组：" + Arrays.toString(nums));
        System.out.println(String.format("多数元素为：%s, 次数：%s", candidate, count));
    }

    /**
     * 摩尔投票算法
     * @param nums
     */
    public static void majorityElement04(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                candidate = nums[i];
            }
        }
        System.out.println("数组：" + Arrays.toString(nums));
        System.out.println(String.format("多数元素为：%s, 次数：%s", candidate, count));
    }

    /**
     * 排序 - 题中保证必有一个众数，排序完成后，n/2位置的必是众数
     * @param nums
     */
    public static void majorityElement03(int[] nums) {
        Arrays.sort(nums);
        System.out.println("数组：" + Arrays.toString(nums));
        System.out.println(String.format("多数元素为：%d, 次数：%s", nums[nums.length / 2], "未知"));
    }

    /**
     * 哈希
     * @param nums
     * @return
     */
    public static void majorityElement02(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && counts.containsKey(nums[i])) {
                Integer count = counts.get(nums[i]);
                counts.put(nums[i], ++count);
            } else {
                counts.put(nums[i], 1);
            }
            if (counts.get(nums[i]) > nums.length / 2) {
                maxVal = nums[i];
            }
        }
        System.out.println("数组：" + Arrays.toString(nums));
        System.out.println(String.format("多数元素为：%d, 次数：%d", maxVal, counts.get(maxVal)));
    }

    /**
     * 暴力算法（双重循环）
     * @param nums
     * @return
     */
    public static void majorityElement01(int[] nums) {
        //参数校验
        int length = nums.length;
        if (length <= 0) {
            throw new RuntimeException("数组不能为空");
        }

        int maxCount = 0;
        int maxVal = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //设置数字出现次数
            int currCount = 1;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == nums[i]) {
                    currCount++;
                }
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                maxVal = nums[i];
            }
        }
        System.out.println("数组：" + Arrays.toString(nums));
        System.out.println(String.format("多数元素为：%d, 次数：%d", maxVal, maxCount));
    }
}
