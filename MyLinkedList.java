/* Name: Generic LinkedList implementation 
 * Authors: James Ponwith and Patrick Hall
 * Date:  11/12/2017
 * Description: 
 * This program provides a usable, generic LinkedList class.
 * Methods available to this class are written blelow. 
 * Main method of this program tests the methods written.
 */

import java.util.LinkedList;

public class MyLinkedList<T> {
    // the Node class is a private inner class used (only) by the LinkedList class
    private class Node {
        private Object data;
        private Node next;

        public Node(Object a, Node n) {
            data = a;
            next = n;
        }
    }

    private Node first;
    private int length;  // to enable an O(1) size method

    public MyLinkedList() {
        first = null;
        length = 0;  // added after considering the size() method
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(Object d) {
        /* These two lines can be reduced to the single line which follows
         *   Node temp = first;
         *   first = new Node(d,temp);
         */        
        first = new Node(d,first);
        length++;
    }

    public int size() {
        /*  This O(n) loop can be replaced by the O(1) return once we have the length field
            int count = 0;
            for (Node curr = first; curr != null; curr = curr.next)
            count++;
            return count;
            */
        return length;
    }

    public void clear() {
        first = null;
        length = 0;
    }

    public boolean contains(Object value) {
        for (Node curr = first; curr != null; curr = curr.next) {
            if (value.equals(curr.data)) {
                // this implies that the data must have an overridden .equals() method!
                return true;
            }
        }
        return false;
    }

    public Object get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }
        Node curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }

    public boolean remove(Object m) {
        if (isEmpty()) {
            return false;
        }
        if (m.equals(first.data)) {
            first = first.next;
            length--;
            return true;
        }
        Node curr = first;
        while (curr.next != null) {
            if (m.equals(curr.next.data)) {
                // this implies that the data must have an overridden equals() method!
                curr.next = curr.next.next;
                length--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();  //String result = "";

        for (Node curr = first; curr != null; curr = curr.next) {
            result.append(curr.data + "->");  //result = result + curr.data + "->";
        }
        result.append("[null]");
        return result.toString();   //return result + "[null]";
    }

    // ------------------------  HW4 methods start here ------------------------

    /**
     * Returns the first element's data of the list
     */
    public Object getFirst() {
        if (first == null) {
            System.out.println("Error - Linked List is empty");
            return null;
        }
        return first.data;
    }

    /**
     * Returns the last element's data
     */
    public Object getLast() {
        Node start = this.first;
        if (start == null) {
            System.out.println("Error - Linked List is empty");
            return null;
        }
        // loop through to the last element
        while(start.next != null) {
            start = start.next;
        }
        return start.data;
    }

    /**
     * Adds an node with the paramater's value
     * to the end of the list
     */
    public void add(Object value) {
        Node start = this.first;
        if (start == null) {
            addFirst(value);
            return;
        }
        // Loop through to end of the list
        while(start.next != null) {
            start = start.next;
        }
        Node newNode = new Node(value, null);
        start.next = newNode;
        length++;
    }

    /**
     * Add an element, (2nd param) after the specified index (1st param)
     */
    public void addAfter(int index, Object value) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
        }

        Node start = this.first;
        // loop up to index
        for(int counter = 0; counter < index; counter++) {
            start = start.next;
        }
        Node nextNode = start.next;
        // insert node at current location, having it point to the node after
        start.next = new Node(value, nextNode);
        length++;
    }

    /**
     * Set the value(2nd param) of the node at specified index (1st param)
     */
    public Object set(int index, Object newValue) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }

        Node start = this.first;
        // loop until specified index
        for(int counter = 0; counter < index; counter++) {
            start = start.next;
        }
        // copy old data
        Object oldData = start.data;
        // set data to newValue
        start.data = newValue;
        return oldData;
    }

    /**
     * Returns the index of the last element
     */
    public int lastIndex(Object value) {
        Node start = this.first;
        int lastOccur = -1;

        for(int counter = 0; counter < this.size(); counter++) {
            if(start.data == value) {
                lastOccur = counter;
            }
            start = start.next;
        }

        if(lastOccur == -1) {
            return -1;
        }

        return lastOccur;
    }

    // Check  
    /**
     * Creates a shallow copy of this list
     */
    public MyLinkedList<T> clone() {
        MyLinkedList<T> clone = this;
        return clone;
    }

    /**
     * Removes all instances of the value passed
     */
    public void removeAll(Object value) {
        Node start = this.first;
        while (start.next != null) {
            if (start.next.data == value) {
                start.next = start.next.next;
            }
            else {
                start = start.next;
            }
        }
    }

    /**
     * Checks arrays are equal size and each element is equal
     */
    @Override
    public boolean equals(Object o) {
        MyLinkedList<T> list = null;
        try {
            @SuppressWarnings("unchecked")
            MyLinkedList<T> tempList = (MyLinkedList<T>)o;
            list = tempList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Node start1 = this.first;
        Node start2 = list.first;
        int counter = 0;
        if(this.length == list.length) {
            while(counter < list.length) {
                if(start1.data == start2.data) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
                else {
                    return false;
                }
                counter++;
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + length;
        return hash;
        //return Objects.hash(length);
    } 

    /**
     * Splits the original list leaving the original with the
     * first half of the list and returns a reference to
     * a new list which contains the second half of the list
     */
    public MyLinkedList<T> split() {
        if (this.size() == 0) {
            System.out.println("Cannot split");
            return this;
        }
        Node start = this.first;
        for (int i = 0; i < (this.size() / 2); i++) {
            start = start.next; 
        }
        MyLinkedList<T> back = new MyLinkedList<>();

        while (start.next != null) {
            Node newNode = new Node(start.data, start.next);
            back.add(newNode);
            start = start.next;
        }
        Node end = this.first;
        for (int i = 0; i < (this.size() / 2); i++) {
            end = end.next;
        }
        end.next = null;
        return back;
    }

    /**
     * Doubles each element of the list
     * Ex. Original: 1, 2, 3 --> 1, 1, 2, 2, 3, 3
     */
    public void doubler() {
        if (length == 0) {
            System.out.println("List is empty");
        }
        Node start = this.first;
        int pos = 0;
        //Loop to last element
        while (start.next != null) {
            this.addAfter(pos, start.data);
            start = start.next.next;
            pos += 2;
            length++;
        }
        // Add the last element 
        add(start.data);
    }

    /**
     * Returns a reference to a sublist of the original list
     */
    public MyLinkedList<T> sublist(int i, int j) {
        if ((i < 0 || i >= length) || (j < 0 || j >= length)) {
            System.out.println("Index of out of range");
            return null;
        }

        MyLinkedList<T> sub = new MyLinkedList<>();
        Node start = this.first;
        int pos = 0;
        while(pos < i) {
            start = start.next;
            pos++;
        }
        sub.add(start);
        while(start.next != null) {
            start = start.next;
            sub.add(start);
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println("\ngetFirst() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<String> gf1 = new MyLinkedList<String>();
        MyLinkedList<String> gf2 = new MyLinkedList<String>();
        MyLinkedList<String> gf3 = new MyLinkedList<String>();
        
        gf1.add("node1");

        gf2.add("node1");
        gf2.add("node2");

        gf3.add("node1");
        gf3.add("node2");
        gf3.add("node3");

        System.out.println("1-element list: \t" + gf1);
        System.out.println("First element: \t\t" + gf1.getFirst());

        System.out.println("2-element list: \t" + gf2);
        System.out.println("First element: \t\t" + gf2.getFirst());

        System.out.println("3-element list: \t" + gf3);
        System.out.println("First element: \t\t" + gf3.getFirst());

        /*=====================================================*/

        System.out.println("\n\ngetLast() Test:");
        System.out.println("------------------------------------");

        System.out.println("1-element list: \t" + gf1);
        System.out.println("Last element: \t\t" + gf1.getLast());

        System.out.println("2-element list: \t" + gf2);
        System.out.println("Last element: \t\t" + gf2.getLast());

        System.out.println("3-element list: \t" + gf3);
        System.out.println("Last element: \t\t" + gf3.getLast());

        /*====================================================*/

        System.out.println("\n\nadd() Test:");
        System.out.println("------------------------------------");
        System.out.println("Element to add: \tadded"); 

        System.out.println("1-element list: \t" + gf1);
        gf1.add("added");
        System.out.println("After adding: \t\t" + gf1);

        System.out.println("2-element list: \t" + gf2);
        gf2.add("added");
        System.out.println("After adding: \t\t" + gf2);

        System.out.println("3-element list: \t" + gf3);
        gf3.add("added");
        System.out.println("After adding: \t\t" + gf3);

        /*====================================================*/
        MyLinkedList<String> af1 = new MyLinkedList<String>();
        MyLinkedList<String> af2 = new MyLinkedList<String>();
        MyLinkedList<String> af3 = new MyLinkedList<String>();
        
        af1.add("1");
        af1.add("2");
        af1.add("3");

        af2.add("1");
        af2.add("2");
        af2.add("3");
        af2.add("4");

        af3.add("1");
        af3.add("2");
        af3.add("3");
        af3.add("4");
        af3.add("5");
        af3.add("6");

        System.out.println("\n\naddAfter() Test:");
        System.out.println("------------------------------------");
        System.out.println("Element to add: \tadded"); 
        int index = 0;


        System.out.println("Index to add after:\t" + index);
        System.out.println("List 1: \t\t" + af1);
        af1.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af1);

        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println("List 2: \t\t" + af2);
        af2.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af2);
        
        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println("List 3: \t\t" + af3);
        af3.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af3);

        /*====================================================*/

        System.out.println("\n\nset() Test:");
        System.out.println("------------------------------------");
        
        index = 2;
        System.out.println("index to set: " + index);
        System.out.println("set value: " + 2.5);
        System.out.println("List beofre setting: \t\t" + af2);
        af2.set(index, "2.5");
        System.out.println("List after setting: \t\t" + af2);

        /*====================================================*/

        System.out.println("\n\nlastIndex() Test:");
        System.out.println("------------------------------------");
        System.out.println("Testing for value of 2");
        System.out.println("List: \t\t" + af2);
        int last = af2.lastIndex("2");
        System.out.println("Last index: " + last); 
        af2.add("2");
        System.out.println("List: \t\t" + af2);
        last = af2.lastIndex("2");
        System.out.println("Last index: " + last); 

        /*====================================================*/

        System.out.println("\n\nclone() Test:");
        System.out.println("------------------------------------");

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        LinkedList<Integer> listClone = new LinkedList<>();
        listClone = list.clone();

        /*====================================================*/

        System.out.println("\n\nremoveAll() Test:");
        System.out.println("------------------------------------");


    }
}
