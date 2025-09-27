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
			add((E)newNode);
			nodeCount++;
		}
		
	}
	
	public ListNode<E> getHead() {
		if (head == null) {
			return null;
		}
		return head;
	}
	
	public ListNode<E> getTail() {
		if (tail == null) {
			return null;
		}
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
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

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
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode(obj);
		tail.setNext(newNode);
		tail = newNode;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	@SuppressWarnings("unchecked")
	public boolean remove(E obj) {
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

		int index = indexOf(obj);
		
		ListNode<E> previousNode = (ListNode<E>)(get(index - 1));
		ListNode<E> nextNode = (ListNode<E>)(get(index + 1));
		

		if (index > 0 || index < nodeCount - 2) {
			previousNode.setNext(nextNode);
			nodeCount --;
			return true;
		} else if (index == 0) {
			head = nextNode;
			nodeCount --;
			return true;
		} else if (index == nodeCount - 1) {
			tail = previousNode;
			nodeCount --;
			return true;
		} else {
			nodeCount --;
			return false;
		}
	}

	// Returns the i-th element.              
	public E get(int i) {
		if (head == null || i < 0 || i >= nodeCount) {
			return null;
		}

		ListNode<E> current = head;
		for (int j = 0; j < i; j++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}

		return current.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	@SuppressWarnings("unchecked") 
	public E set(int i, Object obj) {
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

		ListNode<E> node = (ListNode<E>)(get(i));
		if (node == null) {
			return null;
		}

		E value = node.getValue();
		node.setValue((E)obj);
		return value;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	@SuppressWarnings("unchecked") 
	public void add(int i, Object obj) {
		ListNode<E> previousNode = (ListNode<E>)get(i - 1);
		ListNode<E> nextNode = (ListNode<E>)get(i + 1);
		ListNode<E> addedNode = new ListNode<>((E)obj);
		
		if (head == null && i > 0) {
			throw new IllegalArgumentException("List in null");
		}
		if (head == null && i == 0) {
			add((E)obj);
			head = addedNode;
			tail = addedNode;
		}

		addedNode.setNext(nextNode);
		previousNode.setNext(addedNode);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	@SuppressWarnings("unchecked") 
	public E remove(int i) {
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

		ListNode<E> previousNode = (ListNode<E>)get(i - 1);
		ListNode<E> nextNode = (ListNode<E>)get(i + 1);
		previousNode.setNext(nextNode);
		nodeCount--;
		return get(i);
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder str = new StringBuilder();
		ListNode<E> current = head;
		for (int j = 0; j < nodeCount; j++) {
			if (current.getNext() == null) {
				return null;
			}
			str.append(current.getValue());
			current = current.getNext();
		}
		
		return str.toString();
	}
	

}
