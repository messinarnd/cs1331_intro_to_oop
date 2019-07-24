/* I worked with Kenneth Yang, Sabrina Seibel,
    Jodeci Wheaden, Sophia Worley, and Tanya Chu
*/
import java.util.Collection;

/**
* This class implements the LinkedList interface.
* The YikYak uses these methods to create the YikYak
* application.
* @author Christopher Messina
* @version 1.0
* @param <T> the type of the elements to store in the linked list
*/
public class SinglyLinkedList<T> implements LinkedList<T> {
    /**
    * The head of the linked list.
    */
    private Node<T> head;
    /**
    * The tail of the linked list.
    */
    private Node<T> tail;
    /**
    * The number of nodes in the list.
    */
    private int size;

    /**
    * A private inner class within the SinglyLinkedList class.
    * @param <T> the type of the Node
    */
    private class Node<T> {
        /**
        * A T object in the Node.
        */
        private T data;
        /**
        * The next Node in the list.
        */
        private Node<T> next;
        /**
        * Node's only constructor.
        * @param element a T object
        */
        public Node(T element) {
            data = element;
        }
    }

    /**
    * Retrieves the T object within the Node at the specified index.
    * @param index The index to retrieve the object
    * @return a T object from the given index
    */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else if (index == 0) {
            return head.data;
        } else if (index == size - 1) {
            return tail.data;
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
    * Adds a T object to the end of the list.
    * @param data A T object to be added
    */
    public void add(T data) {
        Node<T> x = new Node<>(data);
        if (size == 0) {
            head = x;
        } else {
            tail.next = x;
        }
        tail = x;
        size++;
    }

    /**
    * Adds a T object at the specified index in the list.
    * @param index The postion of the new object
    * @param data The T object to be added
    * @return a boolean that's true if the object was
    *         able to be added at that index and false if not
    */
    public boolean add(int index, T data) {
        Node<T> x = new Node<>(data);
        if (index < 0 || index > size) {
            return false;
        } else if (index == 0) {
            if (size == 0) {
                head = x;
                tail = x;
                size++;
                return true;
            } else {
                x.next = head;
                head = x;
                size++;
                return true;
            }
        } else if (index == size) {
            tail.next = x;
            tail = x;
            size++;
            return true;
        } else if (index == 1) {
            x.next = head.next;
            head.next = x;
            size++;
            return true;
        } else if (index == 2) {
            x.next = head.next.next;
            head.next.next = x;
            size++;
            return true;
        }

        Node<T> temp = head;
        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        x.next = temp.next.next;
        temp.next.next = x;
        size++;
        return true;
    }

    /**
    * Adds all the T objects in the collection to the end of the list.
    * @param c A collection of T objects
    */
    public void addAll(Collection<? extends T> c) {
        for (T elt : c) {
            add(elt);
        }
    }

    /**
    * Tells you if the list contains thi T object.
    * @param data A T object
    * @return a boolean that's true if the list does contain
    *         it and false if not
    */
    public boolean contains(T data) {
        if (head == null) {
            return false;
        }
        if (tail.data.equals(data)) {
            return true;
        }

        Node<T> temp = head;
        for (int i = 0; i < size ; i++) {
            if (temp.data.equals(data)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    /**
    * Checks if all of the T objects in the collection are in the list.
    * @param c A collection of T objects
    * @return a boolean true if all are in list and false if not
    */
    public boolean containsAll(Collection<? extends T> c) {
        for (T element : c) {
            if (!(contains(element))) {
                return false;
            }
        }
        return true;
    }

    /**
    * Removes a T object.
    * @param data A T object
    * @return a boolean true if it was removed
    */
    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        } else if (head.next.data.equals(data)) {
            head.next = head.next.next;
            size--;
            return true;
        }

        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            if (temp.next.next == tail) {
                if (data.equals(tail.data)) {
                    tail = temp.next;
                    tail.next = null;
                    size--;
                    return true;
                }
                return false;
            }
            if (temp.next.next.data.equals(data)) {
                temp.next.next = temp.next.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
    * Removes a T object at a given index.
    * @param index The index to remove an object
    * @return the T object removed
    */
    public T remove(int index) {
        if (index >= size || index < 0) {
            return null;
        } else if (index == 0) {
            Node<T> ret = head;
            head = head.next;
            if (size == 1) {
                tail = null;
            }
            ret.next = null;
            size--;
            return ret.data;
        }

        if (index == size - 1) {
            Node<T> prev = head;
            for (int i = 0; i < index - 2; i++) {
                prev = prev.next;
            }
            Node<T> temp = tail;
            tail = prev.next;
            tail.next = null;
            size--;
            return temp.data;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node<T> temp = prev.next;
            prev.next = prev.next.next;
            size--;
            temp.next = null;
            return temp.data;
        }
    }

    /**
    * Removes a collection of T objects.
    * @param c A collection of T objects
    * @return a boolean true if all objects wer removed
    */
    public boolean removeAll(Collection<? extends T> c) {
        boolean b = true;
        for (T element : c) {
            if (!(remove(element))) {
                b = false;
            }
        }
        return b;
    }

    /**
    * Gets the size of the list.
    * @return an int - the size
    */
    public int size() {
        return size;
    }

    /**
    * Checks if the list is empty.
    * @return a boolean true if it is empty
    */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
    * Clears the list.
    */
    public void clear() {
        head.next = null;
        head = null;
        tail = null;
        size = 0;
    }
}