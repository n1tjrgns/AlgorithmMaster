public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    //노드 정의
    class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    //맨 앞에 저장
    public void addFirst(Object data){
        Node newNode = new Node(data);

        //맨 앞에 삽입하기 떄문에 새로운 노드가 head가되고
        //기존 노드는 .next로 밀리게된다.
        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    //맨 뒤에 저장
    public void addLast(Object data){
        Node newNode = new Node(data);

        if(size == 0){
            addFirst(data);
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    //중간에 저장
    public void addMiddle(Object data, int idx){
        if(idx == 0){
            addFirst(data);
        }else{
            //삽입할 노드보다 앞 부분
            Node tmp1 = new Node(idx-1);
            //삽입할 노드보다 뒷 부분
            Node tmp2 = tmp1.next;

            Node newNode = new Node(data);

            tmp1.next = newNode;
            newNode.next = tmp2;

            if (newNode.next == null){
                tail = newNode;
            }
        }
    }

    //처음 삭제
    public Object removeFirst(){
        Node tmp = head;
        head = head.next;
        Object data = tmp.data;
        tmp = null;
        size--;
        return data;
    }

    //마지막 삭제
    public Object removeLast(){
        Node tmp = tail;
        tail = new Node(size-2);
        tail.next = null;
        Object data = tmp.data;
        tmp = null;
        return data;
    }
    //중간 삭제
}
