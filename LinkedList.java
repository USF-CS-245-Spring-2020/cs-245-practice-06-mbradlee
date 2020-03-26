import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>{

    protected Node head;
    protected int items;

    /**
     * LinkedList constructor
     */
    public LinkedList(){
        items = 0;
        head = null;
    }

    public void add(T data){
        if(head == null){
            Node curr = new Node(data);
            head = curr;
            items++;
        }else{
            Node prev = head;
            for(int i = 0; i < items; i++){
                prev = prev.next;
            }
            Node add = new Node(data);
            prev.next = add;
            items++;
        }
    }

    public void add(int pos, T data){
        if(pos < 0){
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0 && head == null){
            Node curr = new Node(data);
            head = curr;
            items++;
        }else if(pos == 0){
            Node curr = new Node(data);
            curr.next = head;
            head = curr;
            items++;
        }else{
            Node prev = head;
            for(int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            Node curr = new Node(data);
            curr.next = prev.next;
            prev.next = curr;
            items++;
        }

        //tail case?
    }

    public T get(int pos){
        if(pos < 0 || pos > items){
            throw new IndexOutOfBoundsException();
        }

        if(head == null){
            throw new NoSuchElementException();
        }

        Node curr = head;
        for(int i = 0; i < pos; i++){
            curr = curr.next;
        }

        return (T)curr.data;
    }

    public T remove(int pos) {
        if(pos < 0 || pos > items){
            throw new IndexOutOfBoundsException();
        }

        if(head == null){
            throw new NoSuchElementException();
        }

        if(pos == 0){
            Node curr = head;
            head = curr.next;
            items--;
            return (T)curr.data;
        }else{
            Node curr = head;
            for(int i = 0; i < pos - 1; i++){
                curr = curr.next;
            }

            Node rem = curr.next;
            curr.next = rem.next;

            items--;

            return (T)rem.data;
        }
    }

    public int size(){
        return items;
    }

}
