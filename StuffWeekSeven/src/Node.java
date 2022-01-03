public class Node<T> {

    // public for testing purposes only!!
    public int data; // element in the list
    public Node next; // link to next node

    public Node(int dataPortion) {
        this(dataPortion, null);
    }

    public Node(int dataPortion, Node nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int newData) {
        data = newData;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nextNode) {
        next = nextNode;
    }
}