package test.main3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		System.out.print("서버에 전송할 문자열 : ");
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();

		Socket socket = null;
		try {
			// new Socket("접속한 ip 주소", port번호)
			// 192.168.0.21 > 이 컴퓨터의 ip주소로 접속 콘솔창에 ipconfig를 통해 알수있다
			// 127.0.0.1    : localhost > 자기 ip주소로 접속
			socket = new Socket("127.0.0.1", 5550);
			System.out.println("소켓연결성공");

			// 서버에 출력할수있는 객체의 참조값얻어오기
			// OutputStream으로는 문자열을 읽어올수 없기때문에 OutputStreamWriter > BufferedWriter 를 거쳐 문자열을
			// 읽어와야한다
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(msg); // 문자열을 서버에 출력하기
			bw.newLine(); // 개행기호 출력
			bw.flush(); // 밀어내기

//			String ip = socket.getInetAddress().getHostAddress();
//			System.out.println("접속된 서버의 ip" + ip);

			// 서버의 문자를 받아들이기
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// 서버가 출력한 문자열 읽어들이기(개행기호 기준)
			String msg2 = br.readLine();
			System.out.println("입력한 문자열 : " + msg);
			System.out.println("from Server : " + msg2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (Exception e2) {
			}
		}
		System.out.println("ClientMain 메소드가 종료됩니다");
	}
}
