package topLiked;

/**
 * @see <a bref="https://leetcode.com/problems/add-two-numbers" />
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2){
            return null;
        }
        //头结点,作为返回值
        ListNode head = null;
        //生成每个链表节点的指针
        ListNode p = null;
        //两个链表的移动指针
        ListNode p1 = l1;
        ListNode p2 = l2;
        //上一轮两个节点值之和是>=10
        boolean flag = false;
        boolean first = true;
        //某条单链表是否已经遍历完成
        boolean endsOne = false;
        while( p1 !=null || p2 != null){
            if(null == p1){
                endsOne = true;
                if(flag){
                    flag=false;
                    p2.val++;
                    if(p2.val>=10){
                        flag = true;
                        p2.val-=10;
                    }
                }
                p.next = p2;
                p = p2;
                p2 = p2.next;
                continue;
            }
            if(null == p2){
                endsOne = true;
                if(flag){
                    flag=false;
                    p1.val++;
                    if(p1.val >=10){
                        flag= true;
                        p1.val-=10;
                    }
                }
                p.next = p1;
                p = p1;
                p1 = p1.next;
                continue;
            }
            int res = p1.val + p2.val;
            if(flag){
                flag = false;
                res++;

            }
            int value = res;
            if(res >= 10){
                value = res - 10;
                flag = true;
            }
            ListNode temp = new ListNode(value);
            if(first){
                head = temp;
                first = false;
                p = head;
            }
            else{
                p.next = temp;
                p = temp;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if(flag){
            ListNode end = new ListNode(1);
            p.next = end;
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        ListNode temp;
        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean firstPair = true;
        boolean maxThanTen = false;
        boolean l1ends = false;
        boolean l2ends = false;
        int value1=0;
        int value2=0;
        int value=0;
        while( null!=p1 || null !=p2){
            value1=0;
            value2=0;
            value=0;
            if(!l1ends){
                value1 = p1.val;
            }
            if(!l2ends){
                value2 = p2.val;
            }
            value = maxThanTen?(value1+value2+1):(value1+value2);
            maxThanTen = false;
            if(value>=10){
                value-=10;
                maxThanTen=true;
            }
            temp = new ListNode(value);
            if(firstPair){
                head = temp;
                p = head;
                firstPair = false;
            }
            else{
                p.next= temp;
                p = temp;
            }
            if(!l1ends){
                p1 = p1.next;
            }
            if(!l2ends){
                p2 = p2.next;
            }
            l1ends = (null == p1);
            l2ends = (null == p2);
        }
        if(maxThanTen){
            p.next = new ListNode(1);
            maxThanTen = false;
        }
        return head;
    }

    public static void main(String[] args){

//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n2 = new ListNode(2);
//        n4.next = n3;
//        n2.next = n4;
//        ListNode n42 = new ListNode(4);
//        ListNode n6 = new ListNode(6);
//        ListNode n5 = new ListNode(5);
//        n6.next = n42;
//        n5.next = n6;

        ListNode n3 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        n2.next = n3;
        ListNode n5 = new ListNode(9);


//        ListNode n3 = new ListNode(9);
//        ListNode n4 = new ListNode(9);
//        ListNode n2 = new ListNode(9);
//        n4.next = n3;
//        n2.next = n4;
////        ListNode n42 = new ListNode(4);
////        ListNode n6 = new ListNode(6);
//        ListNode n5 = new ListNode(1);
////        n6.next = n42;
////        n5.next = n6;

        ListNode h = addTwoNumbers2(n2,n5);
        while(h!=null){
            System.out.println(h.val);
            h = h.next;
        }

    }


}
