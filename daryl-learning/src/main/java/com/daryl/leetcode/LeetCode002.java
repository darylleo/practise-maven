package com.daryl.leetcode;

/**
 * @author wl
 * @create 2021-12-06
 */
public class LeetCode002 {

    public static void main(String[] args) {
        //addTwoNumbers2
        //System.out.println((char) 55);
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9))); ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        System.out.println(addTwoNumbers2(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        String string = hasNext(l1, sb);
        String s = hasNext(l2, sb2);
        System.out.println(string);
        System.out.println(s);
        if (string.length() > s.length()) {
            sb3.append(string).reverse();
            sb4.append(s);
        }
        if (string.length() < s.length()) {
            sb3.append(s).reverse();
            sb4.append(string);
        }


/*        int max = Math.abs(s.length() - string.length());
        if (s.length() > string.length()) {
            for (int i = 0; i < max; i++) {
                string = string + "0";
            }
        }
        if (s.length() < string.length()) {
            for (int i = 0; i < max; i++) {
                s = s + "0";
            }
        }
        char[] chars1 = string.toCharArray();
        char[] chars2 = s.toCharArray();
        for (int i = 0; i < chars1.length - 1; i++) {
            int value = ((int) chars1[i] - 48) + ((int) chars2[i] - 48);
            int nextValue = ((int) chars1[i + 1] - 48) + ((int) chars2[i + 1] - 48);
            if (value >= 10) {
                value = value - 10;
                nextValue = nextValue + 1;
            }
            sb3.append(value).append(nextValue);
        }*/

/*        for (int i = chars2.length - 1; i >= 0; i--) {
            sb4.append(chars2[i]);
        }*/

/*        BigDecimal bigDecimal = new BigDecimal(sb3.toString());
        BigDecimal bigDecimal1 = new BigDecimal(sb4.toString());
        bigDecimal.add(bigDecimal1);
        BigDecimal bigDecimal2 = bigDecimal + bigDecimal1;*/
        System.out.println(sb3.toString());
        System.out.println(sb4.toString());
        int i = Integer.parseInt(sb3.toString()) + Integer.parseInt(sb4.toString());
        System.out.println(i);
        String s1 = String.valueOf(i);
        char[] chars = s1.toCharArray();
        ListNode listNode = new ListNode();
        return getListNode(chars, listNode, chars.length - 1);
    }

    public static ListNode getListNode(char[] chars, ListNode listNode, int length) {
        if (length >= 0) {
            listNode.val = chars[length] - 48;
            if (length == 0) {
                listNode.val = chars[0] - 48;
                return listNode;
            }
            length--;
            listNode.next = new ListNode();
            getListNode(chars, listNode.next, length);
        }
        return listNode;
    }

    public static String hasNext(ListNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.next != null) {
            node = node.next;
            hasNext(node, sb);
        }
        return sb.toString();
    }

    //完美答案   head tail  标记头尾，头不动  尾改变，
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        ListNode tail = null;
        int sum;
        int count = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = val1 + val2 + count;
            count = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        tail.next = count >= 1 ? new ListNode(count) : null;

        return head;
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
