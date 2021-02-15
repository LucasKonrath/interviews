import java.util.Stack;
import java.util.stream.Collectors;

import exercise1.Solution_1;
import exercise2.Solution_2;
import exercise3.MergeTwoLinkedLists;
import exercise3.MergeTwoLinkedLists.ListNode;
import exercise4.DeepCopyLinkedList;
import exercise4.DeepCopyLinkedList.Node;

public class Runner {

    public static void main(String[] args) {
        Solution_1 solution1 = new Solution_1();

        System.out.println("Exercício 1 - Missing Number");
        System.out.println(solution1.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println("Exercício 2 - Two Sum");
        System.out.println(Solution_2.areThereTwoSums(new int[]{5, 7, 1, 2, 8, 4 , 3}, 10));

        System.out.println("Exercício 3 - Merge Linked List");
        MergeTwoLinkedLists mergeTwoLinkedLists = new MergeTwoLinkedLists();

        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(8);
        node1.next.next = new ListNode(15);
        node1.next.next.next = new ListNode(19);

        ListNode node2 = new ListNode(7);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(10);
        node2.next.next.next = new ListNode(16);

        ListNode merged = mergeTwoLinkedLists.mergeTwoLists(node1, node2);
        merged.print();

        System.out.println("Exercício 4 - Deep Copy Random Linked List");

        final DeepCopyLinkedList deepCopyLinkedList = new DeepCopyLinkedList();

        Node nodedeep = new Node(7);
        nodedeep.next = new Node(9);
        nodedeep.next.next = new Node(10);
        nodedeep.next.next.next = new Node(16);
        nodedeep.random = nodedeep.next.next;
        nodedeep.next.random = null;
        nodedeep.next.next.random = nodedeep.next.next;
        Stack<Integer> integerStack = new Stack<>();
        integerStack.stream().collect(Collectors.toList());
//        deepCopyLinkedList.copyRandomList(nodedeep);
    }
}
