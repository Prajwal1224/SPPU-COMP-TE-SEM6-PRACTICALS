import java.util.*;

public class EightPuzzleSolver {

    static int g = 0;

    public static void printBoard(int[] elements) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println();
            if (elements[i] == -1)
                System.out.print("_ ");
            else
                System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static boolean solvable(int[] start) {
        int inv = 0;
        for (int i = 0; i < 9; i++) {
            if (start[i] <= 1) continue;
            for (int j = i + 1; j < 9; j++) {
                if (start[j] == -1) continue;
                if (start[i] > start[j]) inv++;
            }
        }
        return inv % 2 == 0;
    }

    public static int heuristic(int[] start, int[] goal) {
        int h = 0;
        for (int i = 0; i < 9; i++) {
            if (start[i] == -1) continue;
            for (int j = 0; j < 9; j++) {
                if (start[i] == goal[j]) {
                    h += Math.abs(j - i) / 3 + Math.abs(j - i) % 3;
                    break;
                }
            }
        }
        return h + g;
    }

    public static void moveLeft(int[] arr, int pos) {
        int temp = arr[pos];
        arr[pos] = arr[pos - 1];
        arr[pos - 1] = temp;
    }

    public static void moveRight(int[] arr, int pos) {
        int temp = arr[pos];
        arr[pos] = arr[pos + 1];
        arr[pos + 1] = temp;
    }

    public static void moveUp(int[] arr, int pos) {
        int temp = arr[pos];
        arr[pos] = arr[pos - 3];
        arr[pos - 3] = temp;
    }

    public static void moveDown(int[] arr, int pos) {
        int temp = arr[pos];
        arr[pos] = arr[pos + 3];
        arr[pos + 3] = temp;
    }

    public static void moveTile(int[] start, int[] goal) {
        int emptyAt = -1;
        for (int i = 0; i < 9; i++) {
            if (start[i] == -1) {
                emptyAt = i;
                break;
            }
        }

        int row = emptyAt / 3;
        int col = emptyAt % 3;

        int[] t1 = start.clone();
        int[] t2 = start.clone();
        int[] t3 = start.clone();
        int[] t4 = start.clone();

        int f1 = 100, f2 = 100, f3 = 100, f4 = 100;

        if (col - 1 >= 0) {
            moveLeft(t1, emptyAt);
            f1 = heuristic(t1, goal);
        }
        if (col + 1 < 3) {
            moveRight(t2, emptyAt);
            f2 = heuristic(t2, goal);
        }
        if (row + 1 < 3) {
            moveDown(t3, emptyAt);
            f3 = heuristic(t3, goal);
        }
        if (row - 1 >= 0) {
            moveUp(t4, emptyAt);
            f4 = heuristic(t4, goal);
        }

        int min = Math.min(Math.min(f1, f2), Math.min(f3, f4));

        if (min == f1) moveLeft(start, emptyAt);
        else if (min == f2) moveRight(start, emptyAt);
        else if (min == f3) moveDown(start, emptyAt);
        else moveUp(start, emptyAt);
    }

    public static void solveEight(int[] start, int[] goal) {
        g++;
        moveTile(start, goal);
        printBoard(start);

        if (heuristic(start, goal) == g) {
            System.out.println("Solved in " + g + " moves");
            return;
        }
        solveEight(start, goal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] start = new int[9];
        int[] goal = new int[9];

        System.out.println("Enter the start state: (Use -1 for blank)");
        for (int i = 0; i < 9; i++) {
            start[i] = sc.nextInt();
        }

        System.out.println("Enter the goal state: (Use -1 for blank)");
        for (int i = 0; i < 9; i++) {
            goal[i] = sc.nextInt();
        }

        printBoard(start);

        if (solvable(start)) {
            solveEight(start, goal);
            System.out.println("Solved in " + g + " moves");
        } else {
            System.out.println("Not possible to solve.");
        }

        sc.close();
    }
}

# Enter the start state: (Use -1 for blank)
# 1
# 2
# 3
# 4
# -1
# 5
# 6
# 7
# 8
# Enter the goal state: (Use -1 for blank)
# 1
# 2
# 3
# 4
# 5
# 6
# -1
# 7
# 8

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 2 3 
# 4 _ 5 
# 6 7 8 

# 1 2 3 
# 4 5 _ 
# 6 7 8 

# 1 

# === Execution Halted ===