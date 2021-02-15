package exercise3;

public class MergeTwoLinkedLists {

    public static class ListNode {

        int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public void print() {
            if (next == null) {
                System.out.print("null");
            } else {
                System.out.print(val + " ->");
                next.print();
            }
        }
    }

    public ListNode mergeTwoLists(
        ListNode l1,
        ListNode l2) {

        ListNode mergedList;
        ListNode mergedListTail;

        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if (l1.val <= l2.val) {
            mergedList = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            mergedList = new ListNode(l2.val);
            l2 = l2.next;
        }

        mergedListTail = mergedList;

        while (l1 != null || l2 != null) {
            System.out.println(l1);
            System.out.println(l2);
            if (l1 == null) {
                mergedListTail.next = l2;
                mergedListTail = mergedListTail.next;
                l2 = l2.next;
            } else if (l2 == null) {
                mergedListTail.next = l1;
                mergedListTail = mergedListTail.next;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                mergedListTail.next = l1;
                mergedListTail = mergedListTail.next;
                l1 = l1.next;
            } else {
                mergedListTail.next = l2;
                mergedListTail = mergedListTail.next;
                l2 = l2.next;
            }
        }

        return mergedList;
    }
}
