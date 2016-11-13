package project5;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author Phillip
 * @param <E>
 */
public class LinkedList<E> implements List<E> {
    
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
    
    public LinkedList() {
        head = new LinkedList.Node<E>(null);
        tail = new LinkedList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    @Override
    public boolean add(E anEntry) {
        add(size, anEntry);
        return true; 
    }

    @Override
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
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at " + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    

    @Override
    public void clear() {
        head = new LinkedList.Node<E>(null);
        tail = new LinkedList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

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

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E get(int index) {
        if (isEmpty() || index > size) {
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
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return nodeToBeRemoved.getData();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

}
