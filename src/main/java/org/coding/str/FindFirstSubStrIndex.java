package org.coding.str;

public class FindFirstSubStrIndex {

    /**
     * 朴素算法
     * 时间复杂度 O(n × m)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int indexS = 0;
        while (indexS <= haystack.length() - needle.length()) {
            int cur = indexS, indexN = 0;
            while (cur < haystack.length()
                    && indexN < needle.length()
                    && haystack.charAt(cur) == needle.charAt(indexN)) {
                cur++;
                indexN++;
            }
            if (indexN == needle.length()) {
                return indexS;
            }
            indexS++;
        }
        return -1;
    }

    /**
     * 时间复杂度：
     * 预处理 next 数组：O(m)
     * <p>
     * 匹配过程：O(n)
     * "匹配成功一起进，匹配失败退 k 吧；next 记录最长前，找重复别从头。"
     * 匹配失败不是去看当前的 j，而是回退已有的前缀 k，所以用 k = next[k] 来一步步回退。
     * 所以总复杂度：O(n + m)，比暴力法高效很多。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        // 特殊情况：空串应当返回 0
        if (needle.length() == 0) return 0;

        // 构建 KMP 的 next 数组
        int[] next = buildNext1(needle);

        int i = 0; // 指向 haystack 的指针
        int j = 0; // 指向 needle 的指针

        // 开始匹配过程
        while (i < haystack.length()) {
            // 如果字符匹配，或者 j == -1（代表刚开始或已退到头），则两个指针都前进
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                // 当 j 到达 needle 尾部，说明找到完整匹配
                if (j == needle.length()) {
                    return i - j; // 返回匹配的起始位置
                }
            } else {
                // 匹配失败时，根据 next 数组回退 j（主串指针 i 不回退）
                j = next[j];
            }
        }

        // 没有找到匹配项
        return -1;
    }

    // 构建 next 数组，表示前缀与后缀相等的最长长度
    private int[] buildNext1(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;       // 当前字符位置
        int k = -1;      // 记录前一位最长相同前后缀的末尾位置
        next[0] = -1;    // 第一个字符没有前缀后缀，设为 -1

        // 构建过程
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                // 如果前缀和后缀的字符相等，或 k 回退到了起点
                j++;
                k++;
                next[j] = k; // 更新 next 数组
            } else {
                // 不相等时回退 k 到 next[k]
                k = next[k];
            }
        }

        return next;
    }

}