package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		// 1byte 처리 스트림
		InputStream is = System.in;
		// 2byte 처리 스트림 객체 생성하기
		InputStreamReader isr = new InputStreamReader(is);
		System.out.print("한글자입력 : ");
		try {
			int code = isr.read();
			System.out.println("code : " + code);
			char ch = (char) code;
			System.out.println("ch : " + ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
