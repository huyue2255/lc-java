package Basic;

/**
 * Created by yuehu on 10/23/17.
 */
public class SinglyLinkedList {

    //private ListNode head; // head all elements it hold
    //Given a ListNode, print all elements it hold


    public void deleteNode(ListNode head, int value) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == value) {
            head = head.next;
            return;
        }
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return ;
        }
        temp.next = current.next;
    }

    public ListNode insertAtBeginning(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            System.out.println("hhhh");
            return newNode;

        }
        System.out.println("ggg");
        newNode.next = head;
       // head = newNode;

       // return head;
        return newNode;
    }

//    public ListNode insertAtPosition(ListNode head, int data, int position) {
//
//        int size = findLength(head);
//        ListNode previous = head;
//        ListNode newNode = new ListNode(data);
//
//        if(position < 1 || position > size + 1){
//            System.out.println("InValid Position");
//            return  head;
//        }
//
//        if(position == 1){
//            newNode.next = head;
//            return newNode;
//        }else{
//            int count = 1;
//            while( count < position -1 ){
//                previous = previous.next;
//                count++;
//            }
//            newNode.next = previous.next;
//            previous.next = newNode;
//        }
//
//        return  head;
//
//
//    }
//
    public ListNode insertAtPosition(ListNode head, int data, int position) {
        //perform boundary checks


        int size = findLength(head);
        if (position > size + 1 || position < 1) {
            System.out.println("Invalide position");
            return head;
        }


        ListNode previous = head;
        ListNode newNode = new ListNode(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        } else {
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }

            //  ListNode current = previous.next;

            newNode.next = previous.next;
            previous.next = newNode;

        }
        return newNode;
    }

    public ListNode insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public void insertAfter(ListNode previous, int data) {
        if (previous == null) {
            System.out.println("The given previous node cannot be null ");
            return;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = previous.next;
        previous.next = newNode;

    }

    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        //loop each element till end of the list
        //last node points to null
        while (current != null) {
            System.out.print(current.data + "-->");
            //print current element's data
            //then move to next element

            current = current.next;
        }
        System.out.println(current);
    }

    public int findLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;

    }


    public static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }


    public static void main(String args[]) {
        //Lets create a linked list demonstrated in slide
        //10--> 8--> 1--> 11--> null
        //10 as head node of linked list

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);

        //Attach them together to form a list

        head.next = second;
        second.next = third;
        third.next = fourth;

        SinglyLinkedList s = new SinglyLinkedList();
        //s.display(head);

        //       System.out.println(s.findLength(head));

//        ListNode newhead = s.insertAtBeginning(head,15);
//        s.display(newhead);
//
//        ListNode newhead1 = s.insertAtEnd(head,25);
//        s.display(newhead1);
//
        //s.insertAtPosition(head, 100, 3);
//        s.display(head);
//
//        s.deleteNode(head, 1);
        s.display(head);
        ListNode target = s.insertAtPosition(head,55,1);
        s.display(target);




    }


}
