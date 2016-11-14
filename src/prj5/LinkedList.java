package prj5;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 *  This is a doubly linked list with a head and tail sentinel node
 *  implementation. This data structure has adding, removing,
 *  replacing and clearing methods as well as an inner iterator
 *  class. 
 * @author Phillip Hrinko
 * @version 2016.11.10
 * @param <E> The type of data to be stored in the list.
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
        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

     /** Adds the element at the end of the linked list.
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
        head = new Node<E>(null);
        tail = new Node<E>(null);
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
     * Sees whether this list is empty
     * @return True if the size of the list is zero, false if not
     * @return True if the size of the list is zero.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Gets the length of this list.
     * @return the integer number of entries currently in the list
     * @return the length of the list.
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * Replaces the entry at the specified position in this list.
     * @param index The index that specifies the position of the 
     *          entry to be replaced.
     * @param newEntry The object that will replace the entry at the 
     *                  specified position.
     * @return E the old data that was replaced
     */
    @Override
    public E replace(int index, E newEntry) {
        Node<E> nodeToBeChanged = getNodeAtIndex(index);
        E replacedData = nodeToBeChanged.getData();
        nodeToBeChanged.data = newEntry;
        return replacedData;
    }

    @Override
    public Object[] toArray() {
        return null;
    }
    /**
     * A new iterator that iterates through the LinkedList
     * @return a iterator object
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>();
    }
    
    @SuppressWarnings("hiding")
    private class LinkedListIterator<E> implements Iterator<E> {
        
        private Node<E> currentNode;

        /**
         * Initializes the currentNode to the head sentinel node.
         */
        @SuppressWarnings("unchecked")
        public LinkedListIterator() {
            currentNode = (Node<E>) head;
        }

        /**
         * Checks if there are more elements in the list.
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return currentNode.next() != tail;
        }

        /**
         * Gets the next value in the list
         * @return the next value
         * @throws NoSuchElementException if there are no nodes left in the list.
         */
        @Override
        public E next() {
            if (hasNext()) {
                currentNode = currentNode.next();
                return currentNode.getData();
            } 
            else {
                throw new NoSuchElementException("if there are " + "no nodes left in the list");
            }
        }
    }
    
    /**
     * insertion sort according to
     * the specified comparator
     * 
     * @param comp     the comparator used
     */
    public void sort(Comparator<Object> comp)
    {
        Node<E> currentNode = this.head.next();
        while (currentNode.next() != null)
        {
            E data = currentNode.getData();
            Node<E> tempNode = currentNode;
            while (tempNode.previous().getData() != null 
                    && comp.compare(data, tempNode.previous().getData()) < 0)
            {
                tempNode.data = tempNode.previous().getData();
                tempNode = tempNode.previous();
            }
            tempNode.data = data;
            currentNode = currentNode.next();
        }
    }
    
    /**
     * Return the size field
     * @return size
     */
    public int getSize()
    {
        return this.size;
    }
}
