package org.coding.linkedlist;

import org.coding.node.MyNode;

public class MergeList {

    public MyNode mergeList(MyNode cur1, MyNode cur2) {
        MyNode root = new MyNode();
        MyNode next = root;

        while (cur1 != null && cur2 != null) {
            if (cur1.value > cur2.value) {
                next.next = cur2;
                cur2 = cur2.next;
            } else {
                next.next = cur1;
                cur1 = cur1.next;
            }
            next = next.next;
        }
        if (cur1 != null) {
            next.next = cur1;
        }
        if (cur2 != null) {
            next.next = cur2;
        }
        return root.next;
    }
}
