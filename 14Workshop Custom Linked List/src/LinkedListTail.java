import java.util.function.Consumer;

public class LinkedListTail {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.next = head;
        }
        this.head = newNode;
        size++;
    }

    public int get(int index) {
        checkIfValid(index);
        int result = 0;
        int currentIndex = 0;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentIndex == index) {
                result = currentNode.value;
                break;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        return result;
    }

    private void checkIfValid(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds");
        }
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        Node currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        this.size++;
    }

    public int removeLast() {
        if (this.size < 2) {
            return removeFirst();
        }
        int result = 0;
        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        result = currentNode.next.value;
        currentNode.next = null;
        this.size--;
        return result;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can`t remove from empty list");
        }
        int result = this.head.value;
        this.head = this.head.next;
        this.size--;
        return result;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            array[counter] = currentNode.value;
            currentNode = currentNode.next;
            counter++;
        }
        return array;
    }

}
