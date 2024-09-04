import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cd2
{

    // Define sets for keywords, operators, and delimiters
    private static final Set<String> keywords = new HashSet<>(Arrays.asList("if", "else", "while", "do", "break", "continue", "int", "double", "float","return", "char", "case", "sizeof", "long", "short", "typedef", "switch", "unsigned", "void", "static", "struct", "goto"));

    private static final Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*', '/', '>', '<', '='));

    private static final Set<Character> delimiters = new HashSet<>(Arrays.asList(' ', '+', '-', '*', '/', ',', ';', '>', '<', '=', '(', ')', '[', ']', '{', '}'));

   
	// Checks if the character is a delimiter
    private static boolean isDelimiter(char ch)
	{
        return delimiters.contains(ch);
    }

    
	// Checks if the character is an operator
    private static boolean isOperator(char ch)
	{
        return operators.contains(ch);
    }

    // Checks if the string is a valid identifier
    private static boolean isValidIdentifier(String str)
	{
        if (str == null || str.isEmpty() || Character.isDigit(str.charAt(0)) || isDelimiter(str.charAt(0)))
		{
            return false;
        }
        return true;
    }

    // Checks if the string is a keyword
    private static boolean isKeyword(String str)
	{
        return keywords.contains(str);
    }

    // Checks if the string is an integer
    private static boolean isInteger(String str)
	{
        if (str == null || str.isEmpty())
		{
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            i = 1;
        }
        for (; i < str.length(); i++)
		{
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Checks if the string is a real number
    private static boolean isRealNumber(String str)
	{
        if (str == null || str.isEmpty())
		{
            return false;
        }
        boolean hasDecimal = false;
        int i = 0;
        if (str.charAt(0) == '-')
		{
            if (str.length() == 1) return false;
            i = 1;
        }
        for (; i < str.length(); i++)
		{
            char ch = str.charAt(i);
            if (ch == '.') {
                if (hasDecimal) return false; // Multiple decimals
                hasDecimal = true;
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return hasDecimal;
    }

    // Extracts the substring from the input
    private static String subString(String str, int left, int right) {
        return str.substring(left, right + 1);
    }

    // Parses the input string
    private static void parse(String str)
	{
        int left = 0, right = 0;
        int len = str.length();

        while (right <= len && left <= right)
		{
            if (right < len && !isDelimiter(str.charAt(right)))
			{
                right++;
            }

            if (right == len || isDelimiter(str.charAt(right)))
			{
                if (left != right)
				{
                    String subStr = subString(str, left, right - 1);

                    if (isKeyword(subStr))
					{
                        System.out.println("'" + subStr + "' IS A KEYWORD");
                    }
					else if (isInteger(subStr))
					{
                        System.out.println("'" + subStr + "' IS AN INTEGER");
                    }
					else if (isRealNumber(subStr))
					{
                        System.out.println("'" + subStr + "' IS A REAL NUMBER");
                    }
					else if (isValidIdentifier(subStr))
					{
                        System.out.println("'" + subStr + "' IS A VALID IDENTIFIER");
                    }
					else
					{
                        System.out.println("'" + subStr + "' IS NOT A VALID IDENTIFIER");
                    }
                }
                if(right < len && isOperator(str.charAt(right)))
				{
                    System.out.println("'" + str.charAt(right) + "' IS AN OPERATOR");
                }
                right++;
                left = right;
            }
        }
    }

    // Main function
    public static void main(String[] args)
	{
        String str = "int a = -5 + 1*c; ";
        parse(str); // calling the parse function
    }
}
