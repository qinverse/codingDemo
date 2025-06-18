package org.coding.str;

public class ReversStr {


    /**
     * 反转字符串
     *
     * @param source
     * @return
     */
    public String reversStr(char[] source) {
        StringBuilder str = new StringBuilder();
        for (int i = source.length - 1; i >= 0; i--) {
            str.append(source[i]);
        }
        return str.toString();
    }
}
