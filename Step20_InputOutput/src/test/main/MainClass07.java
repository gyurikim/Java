package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		// c:myFolder를 Access하고싶다묜??
		// new File(Access하고싶은 폴더나 파일의 경로)
		File f = new File("c:/myFolder");
		if (f.isDirectory()) {
			System.out.println("디렉토리입니다");
		}
		// 디렉토리 안에있는 파일명이나 디렉토리명을 String[]으로얻어내기
		String[] list = f.list();
		for (String tmp : list) {
			System.out.println(tmp);
		}
	}
}
