public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		if (head == null) {
			return;
		}
		printListInReverse(head.getNext());
		System.out.println(head.getValue());
	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r < 0 || c < 0 ||  r >= grid.length || c >= grid[0].length) {
			return;
		}

		String atLocation = grid[r][c];

		if (atLocation.equals("infected") || atLocation.equals("vaccinated")) {
			return;
		}

		grid[r][c] = "infected";
		if (r < grid.length - 1) {
			infect(grid, r + 1, c);
		} 
		if (r > 0) {
			infect(grid, r - 1, c);
		}
		if (c < grid[0].length - 1) {
			infect(grid, r, c + 1);
		}
		if (c > 0) {
			infect(grid, r, c - 1);
		}
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2;
		}

		if (n == 2) {
			return 3;
		}

		return countNonConsecutiveSubsets(n-1) + countNonConsecutiveSubsets(n-2);

	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		return countWaysToJumpUpStairs(n-1) + countWaysToJumpUpStairs(n-2) + countWaysToJumpUpStairs(n-3);
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice


	
	public static void subsetHelper(String str, int index, String prev) {
		//break string into pieces
		//combine
		if (index == str.length()) {
			System.out.println(prev);
			return;
		}

		subsetHelper(str, index + 1, prev);
		String newString = prev + str.charAt(index);
		subsetHelper(str, index + 1, newString);
	}

	public static void printSubsets(String str) {
		//calls helper
		//base case: str = "a" subset would be "a" 
		//if str = "ab" subset would be "a", "b", "ab"
		subsetHelper(str, 0, "");
	}







	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void permutationsHelper(String prev, String end) {
		//start with first index
		//loop through remaining and add to prev
		//remove added from end - this way you can 
		if (end.length() == 0) {
			System.out.println(prev);
			return;
		}

		for (int i = 0; i < end.length(); i++) {
			String newPrev = prev + end.charAt(i);
			String newEnd = end.substring(0, i) + end.substring(i+1);

			permutationsHelper(newPrev, newEnd);
		}


	}
	public static void printPermutations(String str) {
		permutationsHelper("", str);
	}






	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeHelper(int[] ints, int[] left, int[] right) {
		//must merge 2 sorted halves
		int leftIndex = 0;
		int rightIndex = 0;
		int intIndex = 0;
		
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				ints[intIndex] = left[leftIndex]; 
				leftIndex++;
				intIndex++;
			} else {
				ints[intIndex] = right[rightIndex];
				rightIndex++;
				intIndex++;
			}
		}

		while (leftIndex < left.length) {
			ints[intIndex] = left[leftIndex];
			leftIndex++;
			intIndex++;
		}
		while (rightIndex < right.length) {
			ints[intIndex] = right[rightIndex];
			rightIndex++;
			intIndex++;
		}

	}
	
	public static void mergeSort(int[] ints) {
		if (ints.length <= 1) {
			return;
		}

		int[] left = new int[ints.length/2];
		int[] right = new int[ints.length - ints.length/2];
		for (int i = 0; i < ints.length/2; i++) {
			left[i] = ints[i];
		}
		for (int i = ints.length/2; i < ints.length; i++) {
			right[i - ints.length/2] = ints[i];
		}
	
		mergeSort(left);
		mergeSort(right);
		mergeHelper(ints, left, right);
	}






	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static int pivot(int[] ints, int pivot, int low, int high) {
		while (low <= high) {
			if (ints[low] < ints[pivot] && low < pivot) {
				low++;
				continue;
			}

			if (ints[high] > ints[pivot] && high > pivot) {
				high--;
				continue;
			}

			if (low == pivot) {
				if (ints[high] <= ints[pivot]) {
					swap(ints, low, high);
					pivot = high;
					low++;
				} else {
					high--;
				}
				continue;
			}
			if (high == pivot) {
				if (ints[low] >= ints[pivot]) {
					swap(ints, low, high);
					pivot = low;
					high--;
				} else {
					low++;
				}
				continue;
			}

			swap(ints, low, high);
    		low++;
    		high--;
			
			// if (ints[low] >= ints[pivot] && ints[high] <= ints[pivot]) {
			// 	swap(ints, low, high);
			// 	high--;
			// 	low++;
			// } else if (ints[high] < ints[pivot] && ints[low] < ints[pivot]) {
			// 	low++;
			// } else if (ints[high] > ints[pivot] && ints[low] > ints[pivot]) {
			// 	high--;
			// } else {
			// 	high--;
			// 	low++;
			// }
		}
		return pivot;
	}

	private static void swap(int[] ints, int low, int high) {
		int temp = ints[low];
		ints[low] = ints[high];
		ints[high] = temp;
	}
	public static void quickSortHelper(int[] ints, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int pivot = (low + high)/2;
		int newPivot = pivot(ints, pivot, low, high);
	

		quickSortHelper(ints, low, newPivot - 1);
		quickSortHelper(ints, newPivot + 1, high);

	}
	public static void quickSort(int[] ints) {
		//creates two arrays less than or greater than pivot
		//int pivot = ints.length/2;
		quickSortHelper(ints, 0, ints.length - 1);
	}







	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void hanoiHelper(int numOfDisks, int startTower, int endTower, int otherTower) {
		if (numOfDisks == 1) {
			System.out.println(startTower + " -> "  + endTower);
			return;
		}

		hanoiHelper(numOfDisks - 1, startTower, otherTower, endTower);
		System.out.println(startTower + " -> " + endTower);
		hanoiHelper(numOfDisks - 1, otherTower, endTower, startTower);

	}
	public static void solveHanoi(int startingDisks) {
		//solve number of hanoi less than actual number of disks to middle tower
		//move bottom disk to last
		//move tower on middle tower to last
		hanoiHelper(startingDisks, 0, 2, 1);
	}






	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.

	public static int findMaxReward(int num, int[] times, int[] points) {
		if (num >= times.length) {
			return 0;
		}
		//skip or take points
		int skip = findMaxReward(num + 1, times, points);
		int next = points[num] + findMaxReward(findNextTime(num, times, points), times, points);

		if (skip > next) {
			return skip;
		} else {
			return next;
		}
	}

	public static int findNextTime(int timeIndex, int[] times, int[] points) {
		for (int i = timeIndex + 1; i < times.length; i++) {
			if (times[i] >= times[timeIndex] + 5) {
				return i;
			}
		}
		return times.length; // why doesn't return -1 work?
	}
	
	public static int scavHunt(int[] times, int[] points) {
		return findMaxReward(0, times, points);
	}

}
