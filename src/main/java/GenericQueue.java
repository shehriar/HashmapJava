import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T>{
    Node<T> tail;

    GenericQueue(){
        Node<T> node = new Node();
        this.setHead(node);
        this.tail = node;
        this.setLength(1);
    }
    GenericQueue(T data){
        Node<T> node = new Node(data);
        this.setHead(node);
        this.tail = node;
        this.setLength(1);
    }
    GenericQueue(T data, int code){
        Node<T> node = new Node(data, code);
        this.setHead(node);
        this.tail = node;
        this.setLength(1);
    }
    public void add(T data){
        Node<T> node = new Node(data);
        if(getHead() == null){
            setHead(node);
            setLength(1);
            return;
        }

        this.tail.next = node;
        tail = tail.next;
        setLength(getLength()+1);
    }

    public void add (T data, int code){
        Node<T> node = new Node(data);
        node.code = code;

        if(getHead() == null){
            setHead(node);
            setLength(1);
            return;
        }

        this.tail.next = node;
        tail = tail.next;
        setLength(getLength()+1);
    }

    public T delete(){
        if(getHead() == null){
            return null;
        }

        T result = tail.data;
        Node<T> node = getHead();
        while(node.next != tail){
            node = node.next;
        }

        this.setLength(this.getLength()-1);
        tail = node;
        return result;
    }

    public void enqueue(T data){
        add(data);
    }

    public T dequeue(){
        return delete();
    }

    public Iterator<T> iterator(){
        GLLIterator<T> itr = new GLLIterator(getHead());
        return itr;
    }
}
