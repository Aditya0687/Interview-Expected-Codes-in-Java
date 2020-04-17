import java.util.*;

public class LLImplement {
    public static class DoubleNode{
        Node<Integer> head;
        Node<Integer> tail;
        DoubleNode(Node<Integer> head,Node<Integer> tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //1.Taking Input
        Node<Integer> head = takeInput();
        //2.Inserting At ith position recursively
//        System.out.println("Which Position you want to insert the new node: ");
//        int pos = s.nextInt();
//        System.out.println("What data you want to insert: ");
//        int data = s.nextInt();
//        Node<Integer> undated = insertRec(head,pos,data);
//        printRec(updated);
        //3.Deleting Recursively
//        int pos = s.nextInt();
//        Node<Integer> newHead = delete_Rec(head,pos);
//        printRec(newHead);
        //4.Reverse the LL recursively but TC is O(n^2)
//        Node<Integer> rev_LL = reverse_Rec(head);
//        printRec(rev_LL);
        //5.Reverse the LL recursively but TC will be O(n)
//        DoubleNode rev = rev_LLBetter(head);
//        Node<Integer> optimalReverse = reverse(rev);
//        printRec(optimalReverse);
        //6.Find Mid-Point of A LinkedList
//        int mid = midLL(head);
//        System.out.println(mid);

    }

    private static int midLL(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private static Node<Integer> reverse(DoubleNode rev) {
        return rev.head;
    }

    private static DoubleNode rev_LLBetter(Node<Integer> head) {
        DoubleNode ans;
        if(head == null || head.next == null){
            ans = new DoubleNode(head,head);
            return ans;
        }
        DoubleNode smallLL = rev_LLBetter(head.next);
        smallLL.tail.next = head;
        head.next = null;
        ans = new DoubleNode(smallLL.head,head);
        return ans;
    }


    public static Node<Integer> delete_Rec(Node<Integer> head, int pos) {
        if(pos==0) {
            return head.next;
        }
        if(pos>=length(head)){
            return head;
        }
        Node<Integer> smallLL = delete_Rec(head.next,pos-1);
        head.next = smallLL;
        return head;
    }

    public static Node<Integer> reverse_Rec(Node<Integer> head) {
        if(head == null || head.next==null){
            return head;
        }
        Node<Integer> revHead = reverse_Rec(head.next);
        Node<Integer> temp = revHead;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return revHead;
    }

    public static int length(Node<Integer> head){
        int c = 0;
        Node<Integer> temp = head;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }
    public static Node<Integer> insertRec(Node<Integer> head, int pos, int data) {
        Node<Integer> current = new Node<>(data);
        if(pos>length(head)){
            return head;
        }
        if(pos == 0) {
            current.next = head;
            head = current;
            return head;
        }
        Node<Integer> smallLL = insertRec(head.next,pos-1,data);
        head.next = smallLL;
        return head;
    }

//    public static void printRecRev(Node<Integer> head) {
//        if(head==null){
//            return;
//        }
//        printRecRev(head.next);
//        System.out.print(head.data+" ");
//    }

    public static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data= s.nextInt();
        Node<Integer> head = null,tail=null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<>(data);
            if(head==null){
                head = currentNode;
                tail = currentNode;
            }else{
                tail.next = currentNode;
                tail = tail.next;
            }
            data =  s.nextInt();
        }
        return head;
    }

    public static void printRec(Node<Integer> head) {
        if(head == null){
            return;
        }
        System.out.print(head.data+" ");
        printRec(head.next);
    }
}

