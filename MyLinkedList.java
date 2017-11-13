/* Name: James Ponwith and Patrick Hall
 * Authors: James Ponwith and Patrick Hall
 * Date:  date
 * Description: (a 1-4 sentences on what this program does)
 */

public class MyLinkedList<T> {
    // the Node class is a private inner class used (only) by the LinkedList class
    private class Node<T> {
        private Object data;
        private Node<T> next;
        
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
        if (isEmpty())
            return false;
        
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
    
    public String toString() {
        StringBuilder result = new StringBuilder();  //String result = "";
 
        for (Node curr = first; curr != null; curr = curr.next)
            result.append(curr.data + "->");  //result = result + curr.data + "->";

        result.append("[null]");
        return result.toString();   //return result + "[null]";
    }
    
    // ------------------------  HW4 methods start here ------------------------
    
    public Object getFirst() {
        return null;
    }
    
    public Object getLast() {


        return null;
    }
    
    public void add(Object value) {
        return;
    }
    
    public void addAfter(int index, Object value) {
        return;
    }
    
    public Object set(int index, Object newValue) {
        return null;
    }
    
    public int lastIndex(Object value) {
        return 42;
    }
    
    public MyLinkedList clone() {
        return null;
    }
    
    public void removeAll(Object value) {
        return;
    }

    @Override 
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        return result;
    }
    
    public MyLinkedList split() {
        return null;
    }
    
    public void doubler() {
        
    }
    
    public void sublist(int i, int j) {
        
    }
    
    public static void main(String[] args) {
        // here is where you can create some lists (use lists of Strings
        // to test) and thoroughly test each of your new methods
    }
}
