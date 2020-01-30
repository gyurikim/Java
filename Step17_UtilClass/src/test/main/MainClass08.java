package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * HashMap 객체에 담고 싶은 거?
		 */

		Map<Integer, String> songs = new HashMap<Integer, String>();
		songs.put(10, "song1");
		songs.put(20, "song2");
		songs.put(30, "song3");
		songs.put(40, "song4");
		songs.put(50, "song5");

		Scanner scan = new Scanner(System.in);
		System.out.print("재생할 노래의 번호를 입력 : ");
		
		//Scanner type으로 입력받은 scan변수를 int형으로 전환시키기 
		int num = scan.nextInt();
		String song = songs.get(num);
		System.out.println(song + "을 재생합니다");
	}
}
