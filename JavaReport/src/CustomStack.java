public class CustomStack<E> {

    // Creating own Node
    static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data=data;
            this.next=null;
        }
    }
    private Node<E> top;
    private int size;

    public  CustomStack(){
        this.top=null;
        this.size=0;
    }
    // check stack is empty?
    // Time complexity: O(1)
    public boolean isEmpty(){
        return  top == null;
    }
    // LIFO (Last In First Out)
    // add element
    // Time complexity: O(1)
    public void add(E data){
        Node<E> newNode= new Node<>(data);
        newNode.next=top;
        top=newNode;
        size++;
    }
    // remove of stack for last element
    // Time complexity: O(1)
    public E remove(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
       E lastElement= top.data;
        top = top.next;
        size--;
        return  lastElement;
    }
    // call of stack's element
    public E head(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
        }
        return top.data;
    }
    // size of stack
    // Time complexity: O(1)
    public int getSize(){
        return  size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = top;

        // Stack'in tüm elemanlarını al ve ters sırayla ekle
        CustomStack<E> reverse = new CustomStack<>();  // Yardımcı stack
        while (current != null) {
            reverse.add(current.data);  // Elemanı ters stack'e ekle
            current = current.next;
        }

        // Ters sıradaki elemanları yazdır
        current = reverse.top;  // Reverse stack'in başına git
        while (current != null) {
            sb.append(current.data);  // Elemanı ekle
            if (current.next != null) {
                sb.append(",");  // Virgül ekle
            }
            current = current.next;  // Bir sonraki elemana geç
        }
        return sb.toString();  // Elemanları ters sırayla yazdır
    }

}
