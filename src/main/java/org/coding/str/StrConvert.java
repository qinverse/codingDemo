package org.coding.str;

public class StrConvert {

   public int minDistance(String word1, String word2) {
       int m = word1.length(), n = word2.length();
       int dp[][] = new int[m + 1][n + 1];

       //初始化
       for (int i = 0; i <= m; i++) {
          //将 word1 的前 i 个字符变成空串，只能执行 i 次删除。
         dp[i][0] = i;
       }
       for (int j = 0; j <= n; j++) {
           //将空串变成 word2 的前 j 个字符，只能执行 j 次插入。
           dp[0][j] = j;
       }
       //状态转移
       for (int i = 1; i <= m ; i++) {
           for (int j = 1; j <= n ; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i-1][j],//删除
                        Math.min(dp[i][j-1],//插入
                        dp[i-1][j-1])//替换
                        );
            }
           }
       }
       return dp[m][n];
   }
}
