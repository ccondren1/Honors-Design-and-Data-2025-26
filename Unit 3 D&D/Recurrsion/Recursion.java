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

	public static void subsetHelper(String str, int index) {
		//break string into pieces
		//combine
		if (index == str.length()) {
			System.out.println(str.substring(index));
		}

		subsetHelper(str, index + 1);
	}

	public static void printSubsets(String str) {
		//calls helper
		//base case: str = "a" subset would be "a" 
		//if str = "ab" subset would be "a", "b", "ab"
		subsetHelper(str, 0);
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
	public static void mergeHelper(int[] n, int[] left, int[] right) {
		
	}
	
	public static void mergeSort(int[] ints) {
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
	public static void quickSortHelper(int[] ints, int midPoint) {
		int[] left = new int[ints.length];
		int[] right = new int[ints.length];

		for (int i = 0; i < ints.length; i++) {
			if (ints[i] < midPoint) {
				left[i] = ints[i];
			} else {
				right[i- ints.length] = ints[i];
			}
		}
		
		quickSortHelper(left, midPoint/2);
		quickSortHelper(right, midPoint/2);

	}
	public static void quickSort(int[] ints) {
		//creates two arrays less than or greater than pivot
		int pivot = ints[ints.length/2];
		quickSortHelper(ints, pivot);
	}







	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void hanoiHelper(int numOfDisks, int startTower, int endTower, int otherTower) {
		if (numOfDisks == 1) {
			return;
		}

		hanoiHelper(numOfDisks - 1, startTower, otherTower, endTower);
		System.out.println("\nMoving disk from " + startTower + " to " + endTower + "\n");
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
		if (findNextTime(num, times, points) == 0 || findNextTime(num, times, points) == times[num]) {
			return points[num];
		}
		return findMaxReward(num, times, points) + findMaxReward(findNextTime(num, times, points), times, points);
	}

	public static int findNextTime(int timeIndex, int[] times, int[] points) {
		int nextTimeIndex = 0;
		for (int i = timeIndex; i < times.length; i++) {
			if (times[i] >= times[timeIndex] + 5) {
				nextTimeIndex = i;
			}
		}
		return nextTimeIndex;
	}
	
	public static int scavHunt(int[] times, int[] points) {
		int value = 0;
		for (int i = 0; i < times.length; i++) {
			if (findMaxReward(i, times, points) > value){
				value = findMaxReward(i, times, points);
			}

		}
		return value;
	}

}
