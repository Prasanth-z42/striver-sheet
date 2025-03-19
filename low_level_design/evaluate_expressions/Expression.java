package low_level_design.evaluate_expressions;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    List<Pairs> pairs;

    Expression() {
        pairs = new ArrayList<>();
    }

    public void split(String str) {
        int i, st;
        for (i = 0, st = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (st < i) {
                    pairs.add(split2(str.substring(st, i)));
                }
                st = i;
            }
        }
        if (st < i) {
            pairs.add(split2(str.substring(st, i)));
        }
    }

    public static Pairs split2(String str) {
        int constant = 1;
        int index = 0;
        boolean isNegative = str.charAt(0) == '-';

        if (Character.isDigit(str.charAt(index)) || isNegative) {
            StringBuilder sb = new StringBuilder();
            if (isNegative) {
                sb.append("-");
                index++;
            }
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                sb.append(str.charAt(index));
                index++;
            }
            constant = Integer.parseInt(sb.toString());
        }

        List<Pair> pairList = new ArrayList<>();
        while (index < str.length()) {
            char var = str.charAt(index);
            if (str.charAt(index) >= 97 && str.charAt(index) <= 122)
                var = str.charAt(index);
            index += 2;
            StringBuilder pb = new StringBuilder();
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                pb.append(str.charAt(index));
                index++;
            }
            int power = Integer.parseInt(pb.toString());
            pairList.add(new Pair(var, power));
        }

        return new Pairs(constant, pairList);
    }

    public Expression multiply(Expression other) {
        Expression result = new Expression();

        for (Pairs thisPair : this.pairs) {
            for (Pairs otherPair : other.pairs) {
                int newConstant = thisPair.constant * otherPair.constant;

                List<Pair> newPairList = new ArrayList<>(thisPair.pairList);
                for (Pair otherPairVar : otherPair.pairList) {
                    boolean found = false;
                    for (Pair newPair : newPairList) {
                        if (newPair.var == otherPairVar.var) {
                            newPair.pow += otherPairVar.pow;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        newPairList.add(new Pair(otherPairVar.var, otherPairVar.pow));
                    }
                }

                result.pairs.add(new Pairs(newConstant, newPairList));
            }
        }
        return result;
    }

    public void display(List<Pairs> pairsList) {
        for (Pairs pairs : pairsList) {
            display(pairs);
        }
    }

    public void display(Pairs pairs) {
        System.out.println("--------------------------");
        System.out.println("Constant: " + pairs.constant);
        for (Pair pair : pairs.pairList) {
            System.out.println("Variable: " + pair.var + ", Power: " + pair.pow);
        }
    }
}

class Pairs {
    int constant;
    List<Pair> pairList;

    public Pairs(int constant, List<Pair> pairList) {
        this.constant = constant;
        this.pairList = pairList;
    }
}

class Pair {
    char var;
    int pow;

    public Pair(char var, int pow) {
        this.var = var;
        this.pow = pow;
    }
}