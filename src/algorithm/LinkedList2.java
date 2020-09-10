public class LinkedList2 {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data; //자신의 값
        private Node next; // 다음 값을 가리킬 레퍼런스 변수

        public Node(Object data){
            this.data = data;
            this.next= null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object data){
        //노드 생성
        Node newNode = new Node(data);

        //현재 head의 값을 새로 맨 앞에 삽입될 노드의 다음 으로 지정
        newNode.next = head;

        //head에 새로 삽입 할 노드 지정
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    public void addLast(Object data){
        //노드 생성
        Node newNode = new Node(data);

        //리스트의 노드가 없다면 첫번째 노드 추가 메소드 사용
        if (size==0){
            addFirst(data);
        }else{
            //마지막 노드의 다음 노드를 새로 생성한 노드로 지정
            tail.next = newNode;

            //마지막 노드 갱신
            tail = newNode;
            size++;
        }
    }

    //특정 위치의 노드를 찾아내는 방법 get
    //노드는 특정 노드의 의치를 찾으려면 전부 순회를해야한다.
    Node node(int index){
        Node x = head;
        for(int i=0; i<index; i++){
            x = x.next;
        }
        return x;
    }

    //노드의 중간 위치(index위치)에 추가
    public void add(int index, Object data){
        //index가 0이면 제일 맨 앞에 추가이므로 addFirst 사용
        if (index == 0){
            addFirst(data);
        }else{
            Node temp1 = node(index-1);
            Node temp2 = temp1.next;

            Node newNode = new Node(data);

            //삽입 위치 -1의 다음을 새로 생긴 노드로
            temp1.next = newNode;
            //새로 생긴 노드의 다음을 기존의 다음 노드를 가리키도록
            newNode.next = temp2;
            size++;

            //새로운 노드의 다음 노드가 없다면 마지막 노드이기때문에에
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }

    //탐색
    public String toString(){
        //노드가 있는지
        if (head == null){
            return "[]";
        }

        //탐색 시작
        Node temp = head;
        String str = "[";
        //다음 노드가 없을 떄까지 반복 실행
        //마지막 노드는 다음 노드가 없기때문에 마지막 노드는 제외됨
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }

        //마지막 노드를 포함
        str += temp.data;
        return str+"]";
    }

    //##############################################################
    public Object removeFirst(){
        //첫번째 노드를 삭제해야하기 때문에 첫번째 노드를 temp로 지정하고, head의 값을 두번째 노드로 변경한다.
        Node temp = head;
        head = temp.next;

        //삭제하기전에 값을 임시 변수에 담는다.
        Object returnData = temp.data;
        temp = null;
        size--;

        return returnData;
    }

    //중간 노드 삭제
    public Object remove(int index){
        if(index == 0){
            return removeFirst();
        }

        //k-1번째 노드를 temp로 지정, 중간삽입과 비슷한 모습
        Node temp = node(index-1);
        Node deleteNode = temp.next;

        Object returnData = deleteNode.data;
        if(deleteNode == tail){
            tail = temp;
        }

        deleteNode = null;
        size--;

        return returnData;
    }

    //마지막 삭제
    public Object removeLast(){
        Node tmp = tail;
        tail = node(size-2);
        tail.next = null;
        Object data = tmp.data;
        tmp = null;
        return data;
    }

    //특정한 값을 가진 엘리먼트의 인덱스 찾기
    public int indexOf(Object data){
        //탐색 대상이 되는 노드를 temp로 지정
        Node temp = head;
        int index = 0;

        while(temp.data != data){
            temp = temp.next;
            index++;

            //temp가 null이면 더 이상 탐색 대상이 없다
            if(temp == null) return -1;
        }

        //대상이 있으면 인덱스 값 리턴
        return index;
    }




    public static void main(String[] args) {
        LinkedList2 numbers = new LinkedList2();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        System.out.println(numbers);

        System.out.println(numbers.removeFirst());
        System.out.println(numbers);
        numbers.removeLast();
        System.out.println(numbers);
        System.out.println(numbers.indexOf(20));


        /*ListIterator it = numbers.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
    }

    //반복
    //ArrayList와 다르게 LinkedList에서 for문으로 반복을 돌리면, get을 호출할 때마다 내부적으로 반복문이 실행된다.
    //이 경우 Iterator를 사용하는 것이 유리하다.
    //Iterator가 반복 처리된 노드가 무엇인지에 대한 정보를 유지한다.
    /*public ListIterator listIterator() {
        return new ListIterator();
    }

    public class ListIterator{
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        ListIterator(){
            next = head;
            nextIndex = 0;
        }
    }*/
}
