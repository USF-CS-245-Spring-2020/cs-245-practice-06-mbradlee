public class LinkedList<T>{

    protected Node head;
    protected int size;

    /**
     * LinkedList constructor
     */
    public LinkedList(){
        size = 0;
        head = null;
    }

    public void add(int pos, T data){
        if(pos > size || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        //case 1: head, head == null
        //case 2: head
        //case 3: tail
        //case 4: everything else
        if(pos == 0 && head == null){
            Node curr = new Node(data);
            head = curr;
            size++;
        }else if(pos == 0){
            Node curr = new Node(data);
            curr.next = head;
            head = curr;
            size++;
        }else if(pos == size){
            Node prev = head;
            for(int i = 0; i < size; i++){
                prev = prev.next;
            }
            prev.next = new Node(data);
            size++;
        }else{
            Node prev = head;
            for(int i = 0; i < pos; i++){
                prev = prev.next;
            }
            prev.next = new Node(data);
            size++;
        }
    }

    public void add(T data){
        if(head == null){
            Node curr = new Node(data);
            head = curr;
            size++;
        }else{
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }
            prev.next = new Node(data);
            size++;
        }
    }

    public T remove(int pos){
        if(pos > size || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        //case 1: head
        //case 2: everything else
        if(pos == 0){
            Node prev = head;
            head = prev.next;
            prev.next = null;
            size--;
            return prev.data; //how??
        }else{
            Node prev = head;
            for(int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            Node ret = prev.next;
            prev.next = ret.next;
            size--;
            return ret.data; //HOW??????
        }
    }

    public T get(int pos){
        if(pos > size || pos < 0){
            throw new IndexOutOfBoundsException();
        }

        Node curr = head;
        for(int i = 0; i < pos; i++){
            curr = curr.next;
        }
        return curr.data;
    }

    public int size(){
        return size;
    }
    
}
