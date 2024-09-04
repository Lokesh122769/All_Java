import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cd2{

    // Returns 'true' if the character is a DELIMITER.
    public static boolean isDelimiter(char ch) {
        char[] delimiters = { ' ', '+', '-', '*', '/', ',', ';', '>', '<', '=', '(', ')', '[', ']', '{', '}' };
        for (char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }

    // Returns 'true' if the character is an OPERATOR.
    public static boolean isOperator(char ch) {
        char[] operators = { '+', '-', '*', '/', '>', '<', '=' };
        for (char operator : operators) {
            if (ch == operator) {
                return true;
            }
        }
        return false;
    }

    // Returns 'true' if the string is a VALID IDENTIFIER.
    public static boolean validIdentifier(String str) {
        if (Character.isDigit(str.charAt(0)) || isDelimiter(str.charAt(0))) {
            return false;
        }
        return true;
    }

    // Returns 'true' if the string is a KEYWORD.
    public static boolean isKeyword(String str) {
        String[] keywords = { "if", "else", "while", "do", "break", "continue", "int", "double", "float", "return",
                "char", "case", "sizeof", "long", "short", "typedef", "switch", "unsigned", "void", "static", "struct",
                "goto" };
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        return keywordSet.contains(str);
    }

    // Returns 'true' if the string is an INTEGER.
    public static boolean isInteger(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && !(str.charAt(i) == '-' && i == 0)) {
                return false;
            }
        }
        return true;
    }

    // Returns 'true' if the string is a REAL NUMBER.
    public static boolean isRealNumber(String str) {
        if (str.length() == 0) {
            return false;
        }
        boolean hasDecimal = false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.' && !(str.charAt(i) == '-' && i == 0)) {
                return false;
            }
            if (str.charAt(i) == '.') {
                hasDecimal = true;
            }
        }
        return hasDecimal;
    }

    // Extracts the SUBSTRING.
    public static String subString(String str, int left, int right) {
        return str.substring(left, right + 1);
    }

    // Parsing the input STRING.
    public static void parse(String str) {
        int left = 0, right = 0;
        int len = str.length();

        while (right <= len && left <= right) {
            if (!isDelimiter(str.charAt(right))) {
                right++;
            }

            if (isDelimiter(str.charAt(right)) && left == right) {
                if (isOperator(str.charAt(right))) {
                    System.out.println("'" + str.charAt(right) + "' IS AN OPERATOR");
                }
                right++;
                left = right;
            } else if (isDelimiter(str.charAt(right)) && left != right || (right == len && left != right)) {
                String subStr = subString(str, left, right - 1);

                if (isKeyword(subStr)) {
                    System.out.println("'" + subStr + "' IS A KEYWORD");
                } else if (isInteger(subStr)) {
                    System.out.println("'" + subStr + "' IS AN INTEGER");
                } else if (isRealNumber(subStr)) {
                    System.out.println("'" + subStr + "' IS A REAL NUMBER");
                } else if (validIdentifier(subStr) && !isDelimiter(str.charAt(right - 1))) {
                    System.out.println("'" + subStr + "' IS A VALID IDENTIFIER");
                } else if (!validIdentifier(subStr) && !isDelimiter(str.charAt(right - 1))) {
                    System.out.println("'" + subStr + "' IS NOT A VALID IDENTIFIER");
                }
                left = right;
            }
        }
    }

    // DRIVER FUNCTION
    public static void main(String[] args) {
        String str = "int a = b + 1c; ";
        parse(str); // calling the parse function
    }
}
