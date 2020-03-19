public class Node<T>{
    T data;
    Node next;

    /**
     * Node constructor
     * @param data of type T
     */
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
