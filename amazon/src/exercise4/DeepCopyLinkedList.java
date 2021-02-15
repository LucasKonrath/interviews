package exercise4;

import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {

    public static class Node {
        int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        final Map<Integer, Integer> referenceMap = new HashMap<>();

        final Node newLinkedList = new Node(head.val);

        Node newLinkedListTail = newLinkedList;

        Node currentNode = head.next;

        final HashMap<Node, Node> nodeHashMap = new HashMap<>();

        while(currentNode != null){
            newLinkedListTail.next = new Node(currentNode.val);
            newLinkedListTail.next.random = currentNode.random;

            nodeHashMap.put(currentNode.random, newLinkedList.next.random);

            newLinkedListTail = newLinkedListTail.next;
            currentNode = currentNode.next;
        }

        Node currentNodeMap = newLinkedList;

        while (currentNodeMap != null){
            if(currentNodeMap.random != null){
                Node newNode = nodeHashMap.get(currentNode.random);
                currentNodeMap.random = newNode;
            }
            currentNodeMap = currentNodeMap.next;
        }

        return newLinkedList;
    }
}
