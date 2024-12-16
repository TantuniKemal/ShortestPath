public class CustomQueue<E> {

    // Creating own Node
    static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            this.next=null;
        }
    }
    private Node<E> front;
    private Node<E> back;
    private int size;

    public CustomQueue(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }
    // check is queue is empty?
    // Time complexity: O(1)
    public boolean isEmpty(){
        return front == null;
    }
    // FIFO (First In First Out)


    // add element
    // Time complexity: O(1)
    public void insert(E data){
        Node<E> newNode = new Node<>(data);

        if(isEmpty()){
            front = newNode;
            back = newNode;
        }else{
             back.next= newNode;
             back=newNode;
        }
        size++;
    }
    // remove head of queue
    // Time complexity: O(1)
    public E deinsert(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return null;
        }
        E firstElement=front.data;
        front= front.next;
        if(front == null){
            back=null;
        }
        size--;
        return firstElement;
    }
    // call of queue's head
    // Time complexity: O(1)
    public E head(){
        if (isEmpty()){
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }
    // size of queue
    // Time complexity: O(1)
    public int getSize(){
        return size;
    }
}


