package Day2_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {
    // 先不考虑random 构造深拷贝链表 将原列表和新列表的节点一一对应存入map中，key为原列表A value为新列表a
    // 再遍历一遍构造random
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node copyCur = new Node(head.val);
        Node copyDummy = new Node(-1);
        copyCur = copyDummy;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node tmp = new Node(cur.val);
            copyCur.next = tmp;
            map.put(cur, tmp);
            cur = cur.next;
            copyCur = copyCur.next;
        }
        cur = head;
        copyCur = copyDummy.next;
        while (cur != null) {
            if (cur.random != null) {
                copyCur.random = map.get(cur.random);
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyDummy.next;
    }

    /**
     * 解法2 复制原链表后按奇偶拆开
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copyDummy = new Node(-1);
        copyDummy.next = cur.next;
        while(cur != null){
            Node tmp = cur.next;
            if(cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = tmp;
        }
        return copyDummy.next;
    }
}
