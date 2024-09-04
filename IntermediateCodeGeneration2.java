import java.util.*;

class IntermediateCodeGeneration2{
    static int i = 1, j = 0, no = 0;
    static char tmpch = 'Z';
    static String str;
    static char[] left = new char[15];
    static char[] right = new char[15];
    static Exp[] k = new Exp[15];

    static class Exp {
        int pos;
        char op;

        Exp(int pos, char op) {
            this.pos = pos;
            this.op = op;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tIntermediate code generation");
        System.out.print("Enter the expression: ");
        str = scanner.next();
        System.out.println("The Intermediate code:\t\t Expression");

        for (int x = 0; x < 15; x++) {
            k[x] = new Exp(0, '\0');
        }

        findopr();
        explore();
        scanner.close();
    }

    static void findopr() {
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                k[j] = new Exp(i, ':');
                j++;
            }
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                k[j] = new Exp(i, '/');
                j++;
            }
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                k[j] = new Exp(i, '*');
                j++;
            }
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                k[j] = new Exp(i, '+');
                j++;
            }
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                k[j] = new Exp(i, '-');
                j++;
            }
        }
    }

    static void explore() {
        i = 1;
        while (k[i].op != '\0') {
            fleft(k[i].pos);
            fright(k[i].pos);
            str = str.substring(0, k[i].pos) + tmpch-- + str.substring(k[i].pos + 1);
            System.out.print("\t " + str.charAt(k[i].pos) + ":=" + new String(left).trim() + k[i].op + new String(right).trim() + "\t\t");
            for (j = 0; j < str.length(); j++) {
                if (str.charAt(j) != '$') {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
            i++;
        }
        fright(-1);
        if (no == 0) {
            fleft(str.length());
            System.out.println("\t " + new String(right).trim() + ":=" + new String(left).trim());
        }
        System.out.println("\t " + new String(right).trim() + ":=" + str.charAt(k[--i].pos));
    }

    static void fleft(int x) {
        int w = 0;
        boolean flag = false;
        x--;
        while (x != -1 && str.charAt(x) != '+' && str.charAt(x) != '*' && str.charAt(x) != '=' && str.charAt(x) != '\0' && str.charAt(x) != '-' && str.charAt(x) != '/' && str.charAt(x) != ':') {
            if (str.charAt(x) != '$' && !flag) {
                left[w++] = str.charAt(x);
                left[w] = '\0';
                str = str.substring(0, x) + '$' + str.substring(x + 1);
                flag = true;
            }
            x--;
        }
    }

    static void fright(int x) {
        int w = 0;
        boolean flag = false;
        x++;
        while (x != -1 && x < str.length() && str.charAt(x) != '+' && str.charAt(x) != '*' && str.charAt(x) != '=' && str.charAt(x) != '\0' && str.charAt(x) != '-' && str.charAt(x) != '/' && str.charAt(x) != ':') {
            if (str.charAt(x) != '$' && !flag) {
                right[w++] = str.charAt(x);
                right[w] = '\0';
                str = str.substring(0, x) + '$' + str.substring(x + 1);
                flag = true;
            }
            x++;
        }
    }
}
