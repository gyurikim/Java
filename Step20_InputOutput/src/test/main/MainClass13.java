package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 파일로부터 읽어들일 객체의 참조값
			fis = new FileInputStream("c:/myFolder/kim1.png");
			// 파일에 출력할 객체의 참조값
			fos = new FileOutputStream("c:/myFolder/kim11.png");

			while (true) {
				int data = fis.read();
				if (data == -1)
					break;// 다읽었으면 반복문 탈출
				// 읽어들인 1byte출력하기
				fos.write(data);
				fos.flush();
			}
			System.out.println("파일을 복사했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		// exception이 발생해도 무조건 실행되는 블럭 >>마무리 작업은 이 블럭에서 하면된다
			try {
				if(fis!=null)fis.close();// close를 해주지 않으면 만들어지지 않는다
				if(fos!=null)fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
