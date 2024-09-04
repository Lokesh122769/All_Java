import java.util.*;

public class FirstAndFollow{

    static Map<String, List<String>> grammar = new HashMap<>();
    static Map<String, Set<String>> firstSets = new HashMap<>();
    static Map<String, Set<String>> followSets = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of productions:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.println("Enter the productions (in the format A->BC|D):");
        for (int i = 0; i < n; i++) {
            String production = scanner.nextLine();
            String nonTerminal = production.split("->")[0].trim();
            String[] rules = production.split("->")[1].trim().split("\\|");

            grammar.put(nonTerminal, Arrays.asList(rules));
            firstSets.put(nonTerminal, new HashSet<>());
            followSets.put(nonTerminal, new HashSet<>());
        }

        for (String nonTerminal : grammar.keySet()) {
            calculateFirst(nonTerminal);
        }

        String startSymbol = grammar.keySet().iterator().next();
        followSets.get(startSymbol).add("$"); // Add end-of-input symbol to the start symbol's follow set
        for (String nonTerminal : grammar.keySet()) {
            calculateFollow(nonTerminal);
        }

        System.out.println("First sets:");
        for (String nonTerminal : firstSets.keySet()) {
            System.out.println(nonTerminal + ": " + firstSets.get(nonTerminal));
        }

        System.out.println("Follow sets:");
        for (String nonTerminal : followSets.keySet()) {
            System.out.println(nonTerminal + ": " + followSets.get(nonTerminal));
        }

        scanner.close();
    }

    private static void calculateFirst(String nonTerminal) {
        if (!firstSets.get(nonTerminal).isEmpty()) {
            return; // First set already calculated
        }

        for (String production : grammar.get(nonTerminal)) {
            for (int i = 0; i < production.length(); i++) {
                String symbol = String.valueOf(production.charAt(i));

                if (!Character.isUpperCase(symbol.charAt(0))) {
                    firstSets.get(nonTerminal).add(symbol);
                    break;
                } else {
                    calculateFirst(symbol);
                    firstSets.get(nonTerminal).addAll(firstSets.get(symbol));
                    if (!firstSets.get(symbol).contains("e")) {
                        break;
                    }
                }
            }
        }
    }

    private static void calculateFollow(String nonTerminal) {
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            String lhs = entry.getKey();
            for (String production : entry.getValue()) {
                for (int i = 0; i < production.length(); i++) {
                    String symbol = String.valueOf(production.charAt(i));
                    if (symbol.equals(nonTerminal)) {
                        if (i + 1 < production.length()) {
                            String nextSymbol = String.valueOf(production.charAt(i + 1));
                            if (!Character.isUpperCase(nextSymbol.charAt(0))) {
                                followSets.get(nonTerminal).add(nextSymbol);
                            } else {
                                followSets.get(nonTerminal).addAll(firstSets.get(nextSymbol));
                                followSets.get(nonTerminal).remove("e");
                                if (firstSets.get(nextSymbol).contains("e") && !lhs.equals(nonTerminal)) {
                                    calculateFollow(lhs);
                                    followSets.get(nonTerminal).addAll(followSets.get(lhs));
                                }
                            }
                        } else if (!lhs.equals(nonTerminal)) {
                            calculateFollow(lhs);
                            followSets.get(nonTerminal).addAll(followSets.get(lhs));
                        }
                    }
                }
            }
        }
    }
}
