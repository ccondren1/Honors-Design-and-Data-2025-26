public class RecursionTester {
    
    public static void main(String[] args) {
    //testing list inReverse
    //     System.out.println("Testing printListInReverse:");
    //     ListNode n3 = new ListNode(3, null);
    //     ListNode n2 = new ListNode(2, n3);
    //     ListNode n1 = new ListNode(1, n2);
    //     Recursion.printListInReverse(n1);
    //     System.out.println();

    // //testing infect
    //     System.out.println("Testing infect: ");
    //     String[][] grid = {
    //         {"healthy", "healthy", "vaccinated"},
    //         {"healthy", "healthy", "healthy"},
    //         {"vaccinated", "healthy", "healthy"}
    //     };
    //     Recursion.infect(grid, 0, 0);
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             System.out.print(grid[i][j] + "\t");
    //         }
    //         System.out.println();
    //     }


    // //testing nonconsecutiveSubsets
    //     System.out.println("\nTesting countNonConsecutiveSubsets:");
    //     int n = 5;
    //     System.out.println(Recursion.countNonConsecutiveSubsets(n));

    //testing Hanoi
        int disks = 6;
        System.out.println("Testing hanoi: ");
        Recursion.solveHanoi(disks);
    }
     
}
