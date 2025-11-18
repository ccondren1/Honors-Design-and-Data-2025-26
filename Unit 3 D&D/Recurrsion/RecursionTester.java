public class RecursionTester {
    
    public static void main(String[] args) {

        //testing list inReverse
        System.out.println("Testing printListInReverse:");
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Recursion.printListInReverse(n1);
        System.out.println();

        //testing infect
        System.out.println("Testing infect: ");
        String[][] grid = {
            {"healthy", "healthy", "vaccinated"},
            {"healthy", "healthy", "healthy"},
            {"vaccinated", "healthy", "healthy"}
        };
        Recursion.infect(grid, 0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }


        //testing nonconsecutiveSubsets
        System.out.println("\nTesting countNonConsecutiveSubsets:");
        int n = 4;
        System.out.println(Recursion.countNonConsecutiveSubsets(n));

        //test countWaysToJumpStairs
        System.out.println("\nTestign waysToJumpStairs: for 4 steps ");
        System.out.println(Recursion.countWaysToJumpUpStairs(4));

        //testPrintSubsets
        System.out.println("\nTesting printSubsets: ");
        Recursion.printSubsets("abc");

        //test permutations
        System.out.println("\nTesting permutations: ");
        Recursion.printPermutations("abc");

        //test mergeSort
        System.out.println("\nTesting permutations: ");
        int[] arr = {4, 3, 1, 2, 5, 9, 7, 10, 6};
        Recursion.mergeSort(arr);

        //test quickSort
        System.out.println("\nTesting quickSort: ");
        Recursion.quickSort(arr);

        //testing Hanoi
        int disks = 4;
        System.out.println("Testing hanoi: ");
        Recursion.solveHanoi(disks);
        
        //test ScavHunt
        System.out.println("\nTesting scavHunt: ");
        int[] times = {3, 7, 9, 4};
        int[] points = {20, 15, 30, 5};
        System.out.println(Recursion.scavHunt(times, points));

        }
        
}
