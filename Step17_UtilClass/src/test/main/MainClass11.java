package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainClass11 {
	public static void main(String[] args) {
		// 로또번호 6개 얻어내기
		Random ran = new Random();
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			// 1~45 사이의 랜덤한 숫자 얻어내기
			int ranNum = ran.nextInt(45) + 1;

			// 가변배열에 이미 존재하는지 확인하기
			if (nums.contains(ranNum)) {
				i--;// 제어변수값 되돌리기
			} else {
				nums.add(ranNum);
			}
			// Collections 클래스의 static메소드를 이용해서 정렬하기
			Collections.sort(nums);
			Collections.reverse(nums);	//역순으로 뒤집기

			System.out.println(ranNum);
		}
	}
}
