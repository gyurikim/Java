package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass14 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 파일로부터 읽어들일 객체의 참조값
			fis = new FileInputStream("c:/myFolder/kim1.png");
			// 파일에 출력할 객체의 참조값
			fos = new FileOutputStream("c:/myFolder/kim111.png");
			// while문에서 사용할 byte[]객체 생성하기
			byte[] buffer = new byte[1024]; // 한번에 1kbyte씩 읽을수 있다
			while (true) {
				/*
				 * .read() 메소드를 호출하면서 byte[]객체를 전달하면 
				 * 읽어들인 byte알갱이가 byte[]객체에 순서대로 담긴다 return 되는
				 * 정수는 몇개를 읽었는지 숫자가 리턴된다 
				 * 1024,1024,1024,...가 리턴되다가 마지막에는 1024보다 작은숫자가 리턴될 가능성이 크다
				 */

				int readedByte = fis.read(buffer);
				if (readedByte == -1)
					break;
				// byte[] 배열에 있는 값을 0번 인덱스부터 읽은만큼 출력한다.
				fos.write(buffer, 0, readedByte);
				fos.flush();
			}
			System.out.println("파일을 복사했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // exception이 발생해도 무조건 실행되는 블럭 >>마무리 작업은 이 블럭에서 하면된다
			try {
				if (fis != null)
					fis.close();// close를 해주지 않으면 만들어지지 않는다
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
