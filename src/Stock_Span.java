import java.util.Arrays;
import java.util.Stack;

public class Stock_Span {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && prices[s.peek()] <= prices[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }

            s.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans:  " + Arrays.toString(result));
    }
}