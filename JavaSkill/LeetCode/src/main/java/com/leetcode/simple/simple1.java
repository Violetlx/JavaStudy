package com.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 *
 * @author lixuan
 * @Date 2025/4/16 11:03
 */
public class simple1 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     * 你可以按任意顺序返回答案。
     * <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
     */
    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

//    private static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            // key 为当前值，value 为当前值对应的下标
            map.put(nums[i], i);
        }
        return null;
    }
}
