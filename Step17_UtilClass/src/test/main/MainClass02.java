package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 *  기본 data type 은 Generic class  로 지정할수 없다.
		 *  따라서 기본 데이터 type 을 Generic 으로 지정을 하려면
		 *  기본 data type 의 객체형을 사용해야 한다. 
		 */
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		//반복문 돌면서 
		for(int i=0; i<nums.size(); i++) {
			//i 번째 방에 저장된 값 참조해서 
			Integer tmp=nums.get(i);
			//사용하기 
			System.out.println(tmp);
		}
		System.out.println("확장 for 문을 활용하면");
		for(Integer tmp:nums ) {
			System.out.println(tmp);
		}
	}
}














