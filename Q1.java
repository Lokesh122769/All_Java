import java.util.*;

public class Q1{

    public static String smallestLexicographicString(int N, String S, String[] A) {
        // Map to store the binary string to character mapping
        Map<String, Character> binaryToChar = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            binaryToChar.put(A[i], (char) ('a' + i));
        }

        // Count occurrences of each 5-bit binary string in the scrambled message S
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i += 5) {
            String binarySegment = S.substring(i, i + 5);
            count.put(binarySegment, count.getOrDefault(binarySegment, 0) + 1);
        }

        // Construct the lexicographically smallest string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            String binary = A[i];
            if (count.containsKey(binary)) {
                for (int j = 0; j < count.get(binary); j++) {
                    result.append(binaryToChar.get(binary));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the value of N
        System.out.print("Enter the length of the scrambled binary message (N): ");
        int N = scanner.nextInt();

        // Read the binary message S
        System.out.print("Enter the scrambled binary message (S): ");
        scanner.nextLine(); // Consume the newline character
        String S = scanner.nextLine();

        // Read the value of M
        System.out.print("Enter the number of binary strings in array A (M): ");
        int M = scanner.nextInt();

        // Read the binary strings in array A
        String[] A = new String[M];
        System.out.println("Enter the binary strings in array A:");
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextLine();
        }

        // Compute and print the result
        String result = smallestLexicographicString(N, S, A);
        System.out.println("Lexicographically smallest string: " + result);
    }
}
