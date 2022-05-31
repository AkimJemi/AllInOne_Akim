package zJavaPractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class javaPractice {

	public static void main(String[] args) {

		int[] intList = new int[5];
		intList[0] = 1;
		intList[1] = 2;
		intList[2] = 3;
		intList[3] = 4;
		intList[4] = 5;
		for(int value : intList){
			System.out.println("intList value : " + value);
		}
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for( int value : arrayList){
			System.out.println("arrayList value : " + value);
		}
		for( int value : list){
			System.out.println("list value : " + value);
		}
		
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("민수", 10);
		hashMap.put("철수", 20);
		hashMap.put("재민", 30);
		hashMap.put("정이", 40);
		for( String names : hashMap.keySet()) {
			System.out.println("hashMap key : " +names +", value : " + hashMap.get(names));
		}
		
		Map<String, Integer> linkedMap = new LinkedHashMap<>();
		linkedMap.put("민수", 10);
		linkedMap.put("철수", 20);
		linkedMap.put("재민", 30);
		linkedMap.put("정이", 40);
		for( String names : linkedMap.keySet()) {
			System.out.println("linkedMap key : " +names +", value : " + linkedMap.get(names));
		}
		
		
		
		
	}

}
