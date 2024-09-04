import java.util.*;

public class LeftFactoringEliminator4{

    static class Production {
        String nonTerminal;
        List<String> rules;

        Production(String nonTerminal)
		{
            this.nonTerminal = nonTerminal;
            this.rules = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of productions
        System.out.print("Enter number of productions: ");
        int numProductions = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Production> productions = new ArrayList<>();
        for (int i = 0; i < numProductions; i++)
		{
            System.out.print("Enter production (e.g., A->Aa|Ab|b): ");
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
        eliminateLeftFactoring(productions);
    }

    private static void eliminateLeftFactoring(List<Production> productions)
	{
        for (Production production : productions) {
            String nonTerminal = production.nonTerminal;
            List<String> rules = production.rules;
			List<String> r=new ArrayList<>();

            String commonPrefix =findCommonPrefix(rules);
            System.out.println("--COMMON PREFIX IS--"+commonPrefix);
            if (commonPrefix.isEmpty()) {
                // No left factoring needed
                System.out.println(nonTerminal + " -> " + String.join(" | ", rules));
            } else {
                // Left factoring needed
                String newNonTerminal = nonTerminal + "'";
               // System.out.println(nonTerminal + " -> " + commonPrefix + "|" + newNonTerminal+ String.join("|",r));
                System.out.println(newNonTerminal + " -> " + String.join(" | ", factorOutPrefix(commonPrefix, rules,r)));
				System.out.println(nonTerminal + " -> " + commonPrefix  + newNonTerminal+"|"+ String.join("|",r));
            }
        }
    }

    private static String findCommonPrefix(List<String> rules)
	{
        if (rules.isEmpty()) {
            return "";
        }
        //Collections.sort(rules);
        String prefix = rules.get(0);
        String s1=rules.get(0);
		String s2=rules.get(1);
		int i=0,j=0;
		while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j))
		{
            i++;
		    j++;
		}
        return s1.substring(0,i);
    }

    private static List<String> factorOutPrefix(String prefix, List<String> rules,List<String> r) {
        List<String> factoredRules = new ArrayList<>();
        for (String rule : rules)
		{
            if (rule.startsWith(prefix))
			{
                String remaining = rule.substring(prefix.length()).trim();
                factoredRules.add(remaining.isEmpty() ? "e" : remaining);
            }
			else
			{
				r.add(rule);
			}
        }
        return factoredRules;
    }
}
