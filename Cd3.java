import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cd3
{

    static class Production
	{
        String nonTerminal;
        List<String> rules;

        Production(String nonTerminal) {
            this.nonTerminal = nonTerminal;
            this.rules = new ArrayList<>();
        }
    }

    public static void main(String[] args) 
	{
		
        Scanner scanner = new Scanner(System.in);

        // Read number of productions
        System.out.print("Enter number of productions: ");
        int numProductions = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Production> productions = new ArrayList<>();
        for (int i = 0; i < numProductions; i++)
		{
            System.out.print("Enter production (e.g., A->Aa|b): ");
            String input = scanner.nextLine();
            String[] parts = input.split("->");
            Production production = new Production(parts[0].trim());
            String[] rules = parts[1].split("\\|");
            for (String rule : rules) 
			{
                production.rules.add(rule.trim());
            }
            productions.add(production);
        }

        eliminateLeftRecursion(productions);
    }

    private static void eliminateLeftRecursion(List<Production> productions)
	{
        for (Production production : productions)
		{
            String nonTerminal = production.nonTerminal;
            String alpha =null;
            String beta=null;

            for (String rule : production.rules)
			{
                if (rule.startsWith(nonTerminal))
				{
                    alpha=rule.substring(nonTerminal.length()).trim();
                }
				else
				{
                    beta=rule;
                }
            }

            if (!alpha.isEmpty())
			{
                // Left recursion found, eliminate it
                String newNonTerminal = nonTerminal + "'";
                System.out.println(nonTerminal + " -> " + beta+""+newNonTerminal);
                System.out.println(newNonTerminal + " -> " + alpha + newNonTerminal + " | e");
            } else {
                // No left recursion, print the original production
                System.out.println(nonTerminal + " -> " + String.join("|",production.rules));
            }
        }
    }
}
