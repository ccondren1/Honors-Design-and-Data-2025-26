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
		if (values == null) {
			throw new IllegalArgumentException("The array is null. ");
		}

		if (values.length == 0) {
			nodeCount = 0;
			SENTINEL.setNext(SENTINEL);
			SENTINEL.setPrevious(SENTINEL);
			return;
		} else {
			ListNode2<Nucleotide> current = SENTINEL.getNext();
			nodeCount = 1;
			
			for (int i = 1; i < values.length; i++){
				ListNode2<Nucleotide> newNode = new ListNode2<>(values[i]);
				current.setNext(newNode);
				//current.setPrevious();
				current = newNode;
				nodeCount++;
			}
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
		if (nodeCount == 0) {
			throw new IllegalArgumentException("List in empty. ");
		}

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
		if (nodeCount == 0) {
			throw new IllegalArgumentException("List is empty.");
		}

		int i = indexOf(obj);
		Nucleotide n = get(i);
		

	}

	// Returns the i-th element.               
	public Nucleotide get(int i) {
		if (nodeCount == 0 || i < 0 || i >= nodeCount) {
			return null;
		}

		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}

		return current.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}
	
	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		
	}
	
	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		
	}
	
	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		
	}
	
	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		
	}

}
