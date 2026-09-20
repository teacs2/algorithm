package com.algorithm.boot.other.HWod.od2026;

public class OD0826b {

    /**
     * 找出删除一个字符后，可以使剩余字符串成为回文串的所有下标。
     *
     * @param s 只包含小写字母的字符串
     * @return 所有合法删除下标，升序排列
     */
    public int[] findDeletionIndices(String s) {
        int n = s.length();

        int left = 0;
        int right = n - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        // 出现不匹配
        if (left < right) {
            boolean deleteLeft = isPalindrome(left + 1, s, right);
            boolean deleteRight = isPalindrome(left, s, right - 1);

            if (deleteLeft && deleteRight) {
                return new int[]{left, right};
            }
            if (deleteLeft) {
                return new int[]{left};
            }
            if (deleteRight) {
                return new int[]{right};
            }
            return new int[0];
        }

        // 本身就是回文串
        // 找出中间部分连续相同的字符
        int centerLeft = (n - 1) / 2;
        int centerRight = (n) / 2;
        while (centerLeft > 0 && s.charAt(centerLeft - 1) == s.charAt(centerRight)) {
            centerLeft--;
        }

        while (centerRight < n - 1 && s.charAt(centerRight + 1) == s.charAt(centerLeft)) {
            centerRight++;
        }
        int[] res = new int[centerRight - centerLeft + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = centerLeft;
            centerLeft++;
        }

        return res;
    }

    /**
     * 判断s[left...right]是否为回文串。
     */
    private boolean isPalindrome(int left, String s, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }
}
