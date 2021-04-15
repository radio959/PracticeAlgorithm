import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] ans = new int[N+1];

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> heightstack = new Stack<Integer>();
		stack.push(100000001);
		heightstack.push(0);
		ans[0]=0;
		String temp;

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for (int i = 1; i < N + 1; i++) {
			temp = st.nextToken();
			if (stack.peek() > Integer.parseInt(temp)) {
				ans[i]=heightstack.peek();
				stack.push(Integer.parseInt(temp));
				heightstack.push(i);
			}else if(stack.peek() < Integer.parseInt(temp)){
				while(stack.peek() < Integer.parseInt(temp)) {
				stack.pop();
				heightstack.pop();
				}
				ans[i]=heightstack.peek();
				stack.push(Integer.parseInt(temp));
				heightstack.push(i);
			}
		}
		for(int i=1; i<N+1; i++)
			System.out.print(ans[i]+" ");

	}

}
