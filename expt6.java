import java.util.*;

public class expt6{
    static String s = "", st = "";

    public static void main(String[] args)
	{
        String[][] tab =
		{
            {"ta", "@", "@", "ta", "@", "@"},
            {"@", "+ta", "@", "@", "!", "!"},
            {"fb", "@", "@", "fb", "@", "@"},
            {"@", "!", "*fb", "@", "!", "!"},
            {"i", "@", "@", "(e)", "@", "@"}
        };
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string:\n");
        s = scanner.nextLine();
        s += "$";
        st = "$e";
        int st_i = 1, s_i = 0;
        StringBuilder temp = new StringBuilder();
        System.out.println("\nStack\t\tInput");

        while (!st.endsWith("$") || !s.endsWith("$")) {
            int s1, s2;
            switch (st.charAt(st_i)) {
                case 'e':
                    s1 = 0;
                    break;
                case 'a':
                    s1 = 1;
                    break;
                case 't':
                    s1 = 2;
                    break;
                case 'b':
                    s1 = 3;
                    break;
                case 'f':
                    s1 = 4;
                    break;
                default:
                    s1 = -1;
            }

            switch (s.charAt(s_i)) {
                case 'i':
                    s2 = 0;
                    break;
                case '+':
                    s2 = 1;
                    break;
                case '*':
                    s2 = 2;
                    break;
                case '(':
                    s2 = 3;
                    break;
                case ')':
                    s2 = 4;
                    break;
                case '$':
                    s2 = 5;
                    break;
                default:
                    s2 = -1;
            }

            if (s1 == -1 || s2 == -1) {
                System.out.println("Failure");
                return;
            }

            if (tab[s1][s2].equals("@")) {
                System.out.println("Failure");
                return;
            }

            if (tab[s1][s2].startsWith("!")) {
                st = st.substring(0, st_i);
                st_i--;
            } else {
                temp.setLength(0);
                for (int k = tab[s1][s2].length() - 1; k >= 0; k--) {
                    temp.append(tab[s1][s2].charAt(k));
                }
                st = st.substring(0, st_i) + temp.toString();
                st_i = st.length() - 1;
            }

            System.out.print(st + "\t\t");
            for (int n = s_i; n < s.length(); n++) {
                System.out.print(s.charAt(n));
            }
            System.out.println();

            if (st.charAt(st_i) == s.charAt(s_i) && s.charAt(s_i) != '$') {
                st = st.substring(0, st_i);
                s_i++;
                st_i--;
            }
        }

        System.out.println("Success");
    }
}
