package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
		
		//위의 세줄을 한줄로 표현할수도 있다
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자입력(한글가능) : ");
		try {
			String line = br.readLine();
			System.out.println("line : " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
