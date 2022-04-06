public class Node {

    public int value;
    public Node next; // next е референция,която ни води

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
