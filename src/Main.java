import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java HW4. Task 1 - Check order of brackets");

        /*
        HW5 Task 1
        Написать метод, определяющую правильность расстановки скобок в выражении.
        Могут содержаться следующие скобки: ()[]{}<>
        () -> true
        []{}((<>)) -> true
        ) -> false
        [) -> false
        []{}(<)> -> false
        */

        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String brackets = in.next();
        System.out.println(isCorrectParentheses(brackets));
        in.close();

    }

    public static boolean isCorrectParentheses(String parentheses) {
        Map<Character, Character> bracket = new HashMap<>();
        bracket.put(')', '(');
        bracket.put('}', '{');
        bracket.put(']', '[');
        bracket.put('>', '<');
        Deque<Character> checkList = new LinkedList<>();
        char[] charsParentheses = parentheses.toCharArray();
        for (char c : charsParentheses) {
            if (bracket.containsValue(c)) {
                checkList.push(c);
            } else if (bracket.containsKey(c)) {
                if (checkList.isEmpty() || checkList.pop() != bracket.get(c)) {
                    return false;
                }
            }
        }
        return checkList.isEmpty();
    }

}