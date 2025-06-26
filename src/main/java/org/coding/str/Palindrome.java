package org.coding.str;

/**
 * @author qinverse
 * @date 2025/6/24 8:24
 * @description 回文
 * | 算法    | 时间复杂度 | 空间复杂度 | 是否推荐            |
 * | ----- | ----- | ----- | --------------- |
 * | 中心扩展法 | O(n²) | O(1)  | ✅ 推荐，简单易实现，空间最优 |
 * | 动态规划法 | O(n²) | O(n²) | ⚠️ 空间大，不适合超长字符串 |
 */
public class Palindrome {


    /**
     * 动态规划
     *
     * @param str
     * @return
     */
    public String maxSubPalindrome(String str) {
        int n = str.length();
        if (n < 2) return str;
        boolean[][] dp = new boolean[n][n];
        int maxL = 1, start = 0;
        //初始化，单个字符一定是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //枚举子串长度
        for (int len = 2; len <= n; len++) {
            // 枚举左边界 i，右边界 j = i + len - 1
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (len == 2) {
                        // 长度为 2 且两字符相等
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 如果是回文且更长，则更新记录
                if (dp[i][j] && len > maxL) {
                    maxL = len;
                    start = i;
                }
            }

        }
        return str.substring(start, start + maxL);
    }

    /**
     * 中心扩展算法
     *
     * @param str
     * @return
     */
    public String longestPalindromeCenter(String str) {
        if (str == null || str.length() < 1) return "";
        int start = 0, end = 0;
        // 遍历每一个字符
        for (int i = 0; i < str.length(); i++) {
            // 以一个字符为中心，奇数长度
            int l1 = expandAroundCenter(str, i, i);
            // 以两个字符为中心，偶数长度
            int l2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                // 新的回文起点 = 当前中心向左延伸的距离
                start = i - (len - 1) / 2;
                // 新的回文终点 = 当前中心向右延伸的距离
                end = i + len / 2;
            }
        }
        // 截取最长回文子串
        return str.substring(start, end + 1);
    }

    // 辅助函数：从中心向左右扩展，返回扩展出的回文长度
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // right - left - 1 是回文的实际长度
        return right - left - 1;
    }

    //中心扩展法
    public String cneterExpand(String str) {
        if (str == null || str.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            //奇数长度
            int l1 = getN(str, i, i);
            //偶数长度
            int l2 = getN(str, i, i + 1);
            int n = Math.max(l1, l2);
            if (n > end - start) {
                start = i - (n-1)/2;
                end = i + n/2 ;
            }
        }
        return str.substring(start, end + 1);
    }

    public int getN(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }

        }
        return right - left - 1;
    }

}
