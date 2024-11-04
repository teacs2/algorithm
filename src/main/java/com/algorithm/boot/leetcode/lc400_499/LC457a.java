package com.algorithm.boot.leetcode.lc400_499;

/**
 * 457. 环形数组是否存在循环
 */
public class LC457a {
    /**
     * 判断有没有环，一般用快慢指针
     * 对数组的每个点进行判断，会走很多重复的路
     * 将走过的节点置为0可以减少重复，符合条件就返回true
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = next(nums, i);
            // 判断非0，且方向相同,分别保证奇数步和偶数步情况
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    // 长度大于0
                    if (slow != next(nums, slow)) {
                        return true;
                    } else break;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 将i节点的环路径所有点置0,保证>0,小于0是上面while循环还没有走过的路
            int j = i;
            while (nums[j] * nums[next(nums, j)] > 0) {
                int tmp = j;
                j = next(nums, j);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        // 下一个位置的索引，可能大于n，也可能小于-n
        int index = i + nums[i];
        // 保证在[0,n)之间
        return ((index % n) + n) % n;
    }
}
