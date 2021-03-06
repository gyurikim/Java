package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File f1 = new File("c:/");
		// File배열객체 리턴받기
		File[] files = f1.listFiles();
		// 반복문돌면서 디렉토리 명이나 파일명 출력해보기
		for (File tmp : files) {
			// File객체의 메소드를 이용해서 이름 얻어오기
			String name = tmp.getName();
			if (tmp.isDirectory()) {
				System.out.println("[ " + name + " ]");
			} else {
				System.out.println(name);
			}
		}
	}
}
