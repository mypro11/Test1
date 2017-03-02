/**
 * Created by BraslavetsIryna on 26.02.2017.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Task3 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = getSum(l1, l2);
        byte one_more = 0;
        final int ten = 10;
        ListNode list;
        if (val >= ten) {
            list = new ListNode(val - ten);
            one_more = 1;
        } else {
            list = new ListNode(val);
        }
        ListNode result = list;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            val = getSum(l1, l2) + one_more;
            one_more = 0;
            if (val >= ten) {
                val = val - ten;
                one_more = 1;
            }
            list.next = new ListNode(val);
            list = list.next;
        }
        if (one_more == 1) {
            list.next = new ListNode(one_more);
            list = list.next;
        }
        return result;
    }

    private static int getSum(ListNode l1, ListNode l2) {
        int var1 = 0;
        int var2 = 0;
        if (l1 != null) {
            var1 = l1.val;
        }
        if (l2 != null) {
            var2 = l2.val;
        }
        return var1 + var2;
    }

    public static void main(String[] args) {
        int[] ll1 = {5, 9, 9, 9};
        int[] ll2 = {5};
        ListNode l1 = newList(ll1);
        ListNode l2 = newList(ll2);
        ListNode newList = addTwoNumbers(l1, l2);
    }

    static ListNode newList(int[] array) {
        ListNode l = new ListNode(array[0]);
        ListNode ll = l;
        for (int i = 1; i < array.length; i++) {
            l.next = new ListNode(array[i]);
            l = l.next;
        }
        return ll;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
