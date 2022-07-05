package com.daryl.practice.zaixianbiancheng;

import com.daryl.practice.leetcode.LeetCode002;

import java.util.ArrayList;

/**
 * 反转链表
 *
 * @author wl
 * @create 2022-06-15
 */
public class BM1 {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        System.out.println(ReverseList(l2));

    }

    public static ListNode ReverseList(ListNode head) {
        ListNode start = null;
        ListNode end = null;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        int i = list.size()-1;
        while (i>=0){
            if (start == null) {
                start = end = new ListNode(list.get(i));
            } else {
                end.next = new ListNode(list.get(i));
                end = end.next;
            }
            i--;
        }
        return start;
    }

  static  class ListNode {

        private int value;

        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {
        }

       public ListNode(int value, ListNode next) {
           this.value = value;
           this.next = next;
       }

       @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
