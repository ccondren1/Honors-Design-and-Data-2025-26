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
		this.nodeCount = 0;
	}

	// Constructor: creates a list that contains all elements from the array values, in the same order
	@SuppressWarnings("unchecked")
	public SinglyLinkedList(Object[] values) {
		if (values == null) {
			throw new IllegalArgumentException("The array is null");
		}

		if (values.length == 0) {
			head = null;
			tail = null;
			nodeCount = 0;
			return;
		}

		this.head = new ListNode<>((E)values[0], null);
		ListNode<E> current = head;
		nodeCount = 1; 


		for (int i = 1; i < values.length; i++) {
			ListNode<E> newNode= new ListNode<>((E) values[i], null);
			current.setNext(newNode);
			current = newNode;
			nodeCount++;
		}

		this.tail = current;
		
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

		for (ListNode<E> current = head; current != null; current = current.getNext()) {
			if (current.getValue() == obj || (current.getValue() == null && obj == null)) {
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

		for (ListNode<E> current = head; current != null; current = current.getNext()) {
			if (current.getValue() == obj || (current.getValue() == null && obj == null)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode<>(obj);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}

		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (head == null) {
			return false;
		}

		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		
		remove(index);
		return true;
	}

	              
	public ListNode<E> getNode(int i) {
		if (head == null || i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		ListNode<E> current = head;
		for (int j = 0; j < i; j++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}

		return current;
	}

	// Returns the i-th element.
	public E get(int i) {
		return getNode(i).getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	@SuppressWarnings("unchecked") 
	public E set(int i, Object obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		ListNode<E> node = (ListNode<E>)(getNode(i));
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
		if (i < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}
		if (i > nodeCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		if (i == nodeCount - 1) {
			add((E)obj);
		}

		ListNode<E> previousNode = (ListNode<E>)getNode(i - 1);
		ListNode<E> nextNode = (ListNode<E>)getNode(i);
		ListNode<E> addedNode = new ListNode<>((E)obj);

		
		if (head == null && i == 0) {
			add((E)obj);
			head = addedNode;
			tail = addedNode;
		} else if (head != null && i == 0) {
			addedNode.setNext(head);
			head = addedNode;

		addedNode.setNext(nextNode);
		previousNode.setNext(addedNode);
		nodeCount++;
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (head == null) {
			throw new IllegalArgumentException("List in null");
		}

		if (i < 0 || i >= nodeCount){
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}
		
		
		E removedValue = null;


		if (i == 0) {
			removedValue = head.getValue();
			if (nodeCount == 1) {
				head = null;
				tail = null;
			} else {
				head = head.getNext();
			}
		} else if (i == nodeCount - 1) {
			removedValue = tail.getValue();
			tail = getNode(i - 1);
			tail.setNext(null);
		} else {
			ListNode<E> previousNode = (ListNode<E>)getNode(i - 1);
			ListNode<E> nextNode = (ListNode<E>)getNode(i + 1);
			removedValue = get(i);
			previousNode.setNext(nextNode);
		}

		nodeCount--;
		return removedValue;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		ListNode<E> current = head;
		while (current != null) {
			str.append(current.getValue());
			if (current.getNext() != null) {
				str.append(", ");
			}
			current = current.getNext();
		}
		
		str.append("]");
		return str.toString();
	}
	

}

