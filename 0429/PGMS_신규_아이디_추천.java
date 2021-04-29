package week13;

import java.util.ArrayList;
import java.util.Scanner;

public class PGMS_신규_아이디_추천 {

	public static void main(String[] args) {
		StringBuilder answer = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String new_id = sc.next();
		ArrayList<Character> list = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		for (int i = 0; i < new_id.length(); i++) {
			list.add(new_id.toCharArray()[i]);
		}
		
		String tttt = "ABC";
		while(!tttt.equals(list.toString())) {
	        tttt = list.toString();
			if (!list.isEmpty()) {
				BigtoSmall(list);
				System.out.println("1번"+list.toString());
				removeLetter(list);
				System.out.println("2번"+list.toString());
				no2Dot(list);
	            System.out.println("2-1번"+list.toString());
	            noSEDot(list);
	            System.out.println("3번"+list.toString());
			}
	        if(list.isEmpty()){
	            list.add('a');
	            System.out.println("4번"+list.toString());
	        }
	        if(list.size()>=16){
	            left15Letters(list);
	            System.out.println("5번"+list.toString());
	        }
	        if(list.size()<=2){
	            repeatCopy(list);
	            System.out.println("6번"+list.toString());
	        }
		}

        
//        for(int i=0; i<list.size(); i++){
//            answer.append(list.get(i));
//        }
//		System.out.println(answer);
        System.out.println(list.toString());
	}

	private static void BigtoSmall(ArrayList<Character> list) {
		for (int i = 0; i < list.size(); i++) {
			if ('A' <= list.get(i) && list.get(i) <= 'Z') {
				list.set(i, (char) (list.get(i) + 32));
			}
		}
	}

	private static void removeLetter(ArrayList<Character> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if ('a' <= list.get(i) && list.get(i) <= 'z')
				continue;
			if ('0' <= list.get(i) && list.get(i) <= '9')
				continue;
			if (list.get(i) == '-' || list.get(i) == '_' || list.get(i) == '.')
				continue;
			list.remove(i);
			i -= 1;
			size--;
		}
	}

	private static void no2Dot(ArrayList<Character> list) {
		int size = list.size();
		for (int i = 1; i < size; i++) {
			if (list.get(i) == '.' && list.get(i - 1) == '.') {
				list.set(i - 1, '%');
				
			}
		}
		removeLetter(list);
	}

	private static void noSEDot(ArrayList<Character> list){
		if(list.isEmpty()) return;
        if(list.get(0)=='.'){
            list.remove(0);
        }
        int size = list.size();
        if(size>0&&list.get(size-1)=='.'){
            list.remove(size-1);
        }
    }

	private static void left15Letters(ArrayList<Character> list) {
        int size =list.size();
        for(int i=15; i<size; i++) {
            list.remove(i);
			i-=1;
			size--;
        }
    }

	private static void repeatCopy(ArrayList<Character> list) {
        int size = list.size();
        char temp = list.get(size-1);
        while(list.size()<=2){
                list.add(temp);
        }
    }
}
