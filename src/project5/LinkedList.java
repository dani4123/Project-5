package project5;

import list.ListInterface;

/**
 * 
 * @author Phillip Hrinko
 * @version 2016.11.10
 * @param <E>
 */
public class LinkedList<E> implements ListInterface<E> {

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }

        public void setPrevious(Node<E> lastNode) {
            previous = lastNode;
        }

        public Node<E> next() {
            return next;
        }

        public Node<E> previous() {
            return previous;
        }

        public E getData() {
            return data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * This constructor instantiates a head and tail sentinel node
     * and sets the size to be 0.
     */
    public LinkedList() {
        head = new LinkedList.Node<E>(null);
        tail = new LinkedList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * Adds the element at the end of the linked list.
     * @param anEntry the element to be added to the list
     * @return True if it was added.
     * @throws IllegalArgumentException if anEntry is null.
     */
    public void add(E anEntry) {
        add(size, anEntry);
    }

    /**
     * Adds the element at the specified index in the list.
     * @param index the index in which the entry should be added to.
     * @param anEntry the element to be added to the list.
     * @throws IndexOutOfBoundsException if the index is greater than the size
     *          or the index if negative
     * @throws IllegalArgumentException if anEntry is null.
     */
    public void add(int index, E anEntry) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (anEntry == null) {
            throw new IllegalArgumentException("Cannot add null " + "objects to a list");
        }
        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        } else {
            nodeAfter = getNodeAtIndex(index);
        }
        Node<E> newNode = new Node<E>(anEntry);
        newNode.setPrevious(nodeAfter.previous());
        newNode.setNext(nodeAfter);
        nodeAfter.previous().setNext(newNode);
        nodeAfter.setPrevious(newNode);
        size++;
    }

    /**
     * Gets the node at that index
     * 
     * @param index the index in the list
     * @return node at that index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("No element exists at " + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }

    /**
     * Removes the Node at the specified index and returns its data.
     * @param index The index where the Node should be removed
     * @return E the data stored in the Node.
     * @throws IndexOutOfBoundsException if the index is negative
     *          or greater or equal to the size.
     */
    @Override
    public E remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return nodeToBeRemoved.getData();
    }

    /**
     * Clears the list of all entries.
     */
    @Override
    public void clear() {
        head = new LinkedList.Node<E>(null);
        tail = new LinkedList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * Gets the data stored in the Node at the specified index
     * @param index The index in the list 
     * @return E the data stored in the Node, or null if the list 
     *          is empty or the index is greater than the size.
     */
    public E getEntry(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head.next();
        int currentIndex = 0;
        E data = null;
        while (current != tail) {
            if (currentIndex == index) {
                data = current.getData();
                break;
            }
            currentIndex++;
            current = current.next();
        }
        // check if the data was null;
        if (data == null) {
            throw new IndexOutOfBoundsException(); 
        }
        return data;
    }

    /**
     * Checks the list to see if it contains the object 
     * in the parameter. 
     * @param obj the Object you are looking for in the list.
     * @return True if the list contains the object
     */
    @Override
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head.next();
        while (current != tail) {
            if (obj.equals(current.getData())) {
                return true;
            }
            current = current.next();
        }
        return false;
    }

    /**
     * @return True if the size of the list is zero.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the length of the list.
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * Replaces the Nodes data at the specified index to be the
     * data in the parameter.
     */
    @Override
    public E replace(int index, E anEntry) {
        Node<E> nodeToBeChanged = getNodeAtIndex(index);
        E replacedData = nodeToBeChanged.getData();
        nodeToBeChanged.data = anEntry;
        return replacedData;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }
}