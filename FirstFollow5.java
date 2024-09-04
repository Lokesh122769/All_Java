import java.util.*;

public class FirstFollow5{
    private Map<String, List<String>> grammar = new HashMap<>();
    private Map<String, Set<String>> first = new HashMap<>();
    private Map<String, Set<String>> follow = new HashMap<>();
    private String startSymbol;

    public FirstFollow(String startSymbol) {
        this.startSymbol = startSymbol;
    }

    public void addProduction(String nonTerminal, List<String> production) {
        grammar.computeIfAbsent(nonTerminal, k -> new ArrayList<>()).addAll(production);
    }

    public void computeFirst() {
        // Initialize first sets
        for (String nonTerminal : grammar.keySet()) {
            first.put(nonTerminal, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (String nonTerminal : grammar.keySet()) {
                for (String production : grammar.get(nonTerminal)) {
                    String[] symbols = production.split(" ");
                    for (String symbol : symbols) {
                        if (isTerminal(symbol)) {
                            if (first.get(nonTerminal).add(symbol)) {
                                changed = true;
                            }
                            break;
                        } else {
                            int initialSize = first.get(nonTerminal).size();
                            first.get(nonTerminal).addAll(first.get(symbol));
                            if (first.get(symbol).contains("e")) {
                                continue;
                            }
                            if (first.get(nonTerminal).size() > initialSize) {
                                changed = true;
                            }
                            break;
                        }
                    }
                }
            }
        } while (changed);
    }

    public void computeFollow() {
        // Initialize follow sets
        for (String nonTerminal : grammar.keySet()) {
            follow.put(nonTerminal, new HashSet<>());
        }
        follow.get(startSymbol).add("$");

        boolean changed;
        do {
            changed = false;
            for (String nonTerminal : grammar.keySet()) {
                for (String production : grammar.get(nonTerminal)) {
                    String[] symbols = production.split(" ");
                    for (int i = 0; i < symbols.length; i++) {
                        if (!isTerminal(symbols[i])) {
                            if (i + 1 < symbols.length) {
                                String nextSymbol = symbols[i + 1];
                                if (isTerminal(nextSymbol)) {
                                    if (follow.get(symbols[i]).add(nextSymbol)) {
                                        changed = true;
                                    }
                                } else {
                                    int initialSize = follow.get(symbols[i]).size();
                                    follow.get(symbols[i]).addAll(first.get(nextSymbol));
                                    follow.get(symbols[i]).remove("e");
                                    if (follow.get(symbols[i]).size() > initialSize) {
                                        changed = true;
                                    }
                                    if (first.get(nextSymbol).contains("e")) {
                                        follow.get(symbols[i]).addAll(follow.get(nonTerminal));
                                    }
                                }
                            } else {
                                int initialSize = follow.get(symbols[i]).size();
                                follow.get(symbols[i]).addAll(follow.get(nonTerminal));
                                if (follow.get(symbols[i]).size() > initialSize) {
                                    changed = true;
                                }
                            }
                        }
                    }
                }
            }
        } while (changed);
    }

    public Set<String> getFirst(String nonTerminal) {
        return first.get(nonTerminal);
    }

    public Set<String> getFollow(String nonTerminal) {
        return follow.get(nonTerminal);
    }

    private boolean isTerminal(String symbol) {
        return !grammar.containsKey(symbol);
    }

    public static void main(String[] args) {
        FirstFollow parser = new FirstFollow("S");

        parser.addProduction("S", Arrays.asList("A B"));
        parser.addProduction("A", Arrays.asList("a A", "e"));
        parser.addProduction("B", Arrays.asList("b B", "e"));

        parser.computeFirst();
        parser.computeFollow();

        System.out.println("FIRST sets:");
        for (String nonTerminal : parser.grammar.keySet()) {
            System.out.println(nonTerminal + ": " + parser.getFirst(nonTerminal));
        }

        System.out.println("FOLLOW sets:");
        for (String nonTerminal : parser.grammar.keySet()) {
            System.out.println(nonTerminal + ": " + parser.getFollow(nonTerminal));
        }
    }
}
