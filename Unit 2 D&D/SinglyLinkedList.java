// Implements a singly-linked list.
//make new node everytime you add something
//move through nodes: i is a node, starts at head, until it equals tail


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		//Object[] list = new Object[nodeCount];
		this.head = null;
		this.tail = null;
	}

	// Constructor: creates a list that contains all elements from the array values, in the same order
	@SuppressWarnings("unchecked")
	public SinglyLinkedList(Object[] values) {
		if (values == null) {
			throw new IllegalArgumentException("The array is null");
		}

		this.head = (ListNode<E>)values[0];
		this.tail = (ListNode<E>)values[values.length - 1];


		for (int i = 0; i < values.length - 1; i++) {
			ListNode<E> newNode= new ListNode((E)values[i], (ListNode<E>)values[i+1]);
			add(newNode);
			nodeCount++;
		}
		
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

		for (ListNode<E> current = head; current != tail; current = current.getNext()) {
			if (current.getValue() == obj) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int index = 0;

		for (ListNode<E> current = head; current != tail; current = current.getNext()) {
			if (current.getValue() == obj) {
				return index;
			}
			index++;
		}

		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = ListNode(obj);
		tail.setNext(obj);
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		
	}

	// Returns the i-th element.               
	public E get(int i) {
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}
	

}
