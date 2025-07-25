package org.coding.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    void backtrack(List<String> ans, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            ans.add(cur.toString());
        }
        if (open < n) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, n);
//            cur.deleteCharAt(cur.length() - 1);
        }
        if (open > close) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, n);
//            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        backtrack1(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }


    public void backtrack1(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
        }
        if (open < max) {
            cur.append("(");
            backtrack1(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack1(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
