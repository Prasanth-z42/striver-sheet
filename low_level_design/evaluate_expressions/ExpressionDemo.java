package low_level_design.evaluate_expressions;
import java.util.Scanner;

public class ExpressionDemo {
    public static void main(String[] args) {
        Scanner s;
        s = new Scanner(System.in);

        System.out.println("Enter first expression:");
        String exp1 = s.nextLine();
        System.out.println("Enter second expression:");
        String exp2 = s.nextLine();

        Expression expressionOne = new Expression();
        Expression expressionTwo = new Expression();

        expressionOne.split(exp1);
        expressionTwo.split(exp2);

        System.out.println("Expression 1:");
        expressionOne.display(expressionOne.pairs);

        System.out.println("\nExpression 2:");
        expressionTwo.display(expressionTwo.pairs);

        Expression result = expressionOne.multiply(expressionTwo);

        System.out.println("\nResult of Multiplication:");
        result.display(result.pairs);
    }
}
