import org.w3c.dom.Node;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		// if (values == null) {
		// 	throw new IllegalArgumentException("The array is null. ");
		// }

		if (values.length == 0) {
			nodeCount = 0;
			SENTINEL.setNext(SENTINEL);
			SENTINEL.setPrevious(SENTINEL);
			return;

		} else {
			ListNode2<Nucleotide> prev = SENTINEL;
			nodeCount = 0;
			
			for (int i = 0; i < values.length; i++){
				ListNode2<Nucleotide> newNode = new ListNode2<>(values[i]);
				prev.setNext(newNode);
				newNode.setPrevious(prev);	
				prev = newNode;
				nodeCount++;
			}

			prev.setNext(SENTINEL);
			SENTINEL.setPrevious(prev);
		}
	}
	
	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}
	
	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}
	
	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
	}


	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
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
	public boolean contains(Nucleotide obj) {
		listIsNull();

		for (ListNode2<Nucleotide> current = SENTINEL.getNext(); current != null; current = current.getNext()) {
			if (current.getValue() == obj || (current.getValue() == null && obj == null)) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		int index = 0;

		for (ListNode2<Nucleotide> current = SENTINEL.getNext(); current != null; current = current.getNext()) {
			if (current.getValue() == obj || (current.getValue() == null && obj == null)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2<Nucleotide> newNode = new ListNode2<>(obj);

		if (nodeCount == 0) {
			SENTINEL.setNext(newNode);
			SENTINEL.setPrevious(newNode);
		} else {
			SENTINEL.getPrevious().setNext(newNode);
			newNode.setNext(SENTINEL);
			newNode.setPrevious(SENTINEL.getPrevious());
			SENTINEL.setPrevious(newNode);
		}

		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		listIsNull();

		int i = indexOf(obj);
		ListNode2<Nucleotide> n = getNode(i);
		
		//remove middle object
		if (i > 0 && i < nodeCount - 1) {
			ListNode2<Nucleotide> previousNode = n.getPrevious();
			ListNode2<Nucleotide> nextNode = n.getNext();
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
			return true;
		}

		//remove first object
		if (i == 0) {
			(n.getNext()).setPrevious(SENTINEL);
			SENTINEL.setNext(n.getNext());
			return true;
		}

		//remove last object
		if (i == nodeCount - 1) {
			n.getPrevious().setNext(SENTINEL);
			SENTINEL.setPrevious(n.getPrevious());
			return true;
		}

		return false;
	}

	// Returns the i-th element.               
	public ListNode2<Nucleotide> getNode(int i) {
		indexOutOfBounds(i);

		if (nodeCount == 0) {
			return null;
		}

		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}

		return current;
	}

	public Nucleotide get(int i) {
		return getNode(i).getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		indexOutOfBounds(i);

		ListNode2<Nucleotide> node = getNode(i);
		Nucleotide value = node.getValue();
		node.setValue(obj);
		return value;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		indexOutOfBounds(i);

		if (i == nodeCount - 1) {
			add(obj);
		}
		
		ListNode2<Nucleotide> addedNode = new ListNode2<>(obj);
		ListNode2<Nucleotide> nextNode = getNode(i + 1);
		ListNode2<Nucleotide> previousNode = SENTINEL;
		if (i != 0) {
			previousNode = getNode(i-1);
		}

		previousNode.setNext(addedNode);
		addedNode.setPrevious(previousNode);
		addedNode.setNext(nextNode);
		nextNode.setPrevious(addedNode);

		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		indexOutOfBounds(i);
		listIsNull();

		ListNode2<Nucleotide> removedValue = null;

		if (i == 0) {
			removedValue = SENTINEL.getNext();
			if (nodeCount == 1) {
				SENTINEL.setNext(SENTINEL);
				SENTINEL.setPrevious(SENTINEL);
			} else {
				SENTINEL.setNext(SENTINEL.getNext().getNext());
				SENTINEL.getNext().getNext().setPrevious(SENTINEL);
			}
		} else if (i == nodeCount - 1) {
			removedValue = SENTINEL.getPrevious();
			SENTINEL.setPrevious(removedValue.getPrevious());
			removedValue.getPrevious().setNext(SENTINEL);
		} else {
			ListNode2<Nucleotide> previousNode = getNode(i - 1);
			ListNode2<Nucleotide> nextNode = getNode(i + 1);
			removedValue = getNode(i);
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
		}
		
		nodeCount--;
		return removedValue.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		while (current != SENTINEL) {
			str.append(current.getValue());
			if (current.getNext() != SENTINEL) {
				str.append(", ");
			}
			current = current.getNext();
		}

		str.append("]");
		return str.toString();
	}
	
	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		for (ListNode2<Nucleotide> current = seg.SENTINEL.getNext(); current.getNext() != seg.SENTINEL; current = current.getNext()) {
			Nucleotide newValue = current.getValue();
			this.add(newValue);
		}
	}
	
	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)

	//what to do if there's only 5 nodes? do you start removing from beggining or throw error?
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		int i = 1;
		for (ListNode2<Nucleotide> current = nodeBefore.getNext(); current.getNext() != SENTINEL || i == 17; current = current.getNext()) {
			remove(current.getValue());
			i++;
		}
	}
	
	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		listIsNull();
		seg.listIsNull();
		
		boolean remove = false;

		for (ListNode2<Nucleotide> segCurrent = seg.SENTINEL.getNext(); segCurrent.getNext() != SENTINEL; segCurrent = segCurrent.getNext()) {
			for (ListNode2<Nucleotide> current = SENTINEL.getNext(); current.getNext() != SENTINEL; current = current.getNext()) {
				if (current == segCurrent) {
					remove = true;
				}
			}
		}

		if (remove == true) {
			for (ListNode2<Nucleotide> current = SENTINEL.getNext(); current.getNext() != SENTINEL; current = current.getNext()) {
				remove(current.getValue());
			}
		}
		return remove;

	}
	
	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		if (nodeCount < 3) {
			return false;
		}

		getNode(nodeCount - 4).setNext(SENTINEL);
		SENTINEL.setPrevious(getNode(nodeCount-4));
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		for (ListNode2<Nucleotide> current = SENTINEL.getNext(); current.getNext() != SENTINEL; current = current.getNext()) {
			if (current.getValue() == Nucleotide.A) {
				int index = indexOf(Nucleotide.A);
				set(index, Nucleotide.T);
				add(index + 1, Nucleotide.A);
				add(index + 2, Nucleotide.C);
				current = current.getNext().getNext();
			}
		}
	}

	public void indexOutOfBounds(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}
	}

	public void listIsNull() {
		if (nodeCount == 0) {
			throw new IllegalArgumentException("List is null. ");
		}
	}
}
