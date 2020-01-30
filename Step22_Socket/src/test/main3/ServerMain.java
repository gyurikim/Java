package test.main3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 5000번 port를 사용할 준비를 한다
			serverSocket = new ServerSocket(5550);
			System.out.println("클라이언트의 연결요청을 대기중입니다...");
			while (true) {
				// 5000번 port의 연결요청을 기다린다
				socket = serverSocket.accept();
				// 접속된 클라이언트의 ip주소 얻어오기
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("접속된 클라이언트의 ip" + ip);

				// 접속한 클라이언트로 부터 입력받을 객체
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				// 클라이언트가 전송한 문자열을 한줄 입력받기(개행기호 기준)
				String msg = br.readLine();
				System.out.println(msg);

				// 클라이언트에게 전송할 문자열
				String toClient = "안녕 나는 서버야!";

				// 클라이언트에게 보내기
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);

				bw.write(toClient); // 문자열을 서버에 출력하기
				bw.newLine(); // 개행기호 출력
				bw.flush(); // 밀어내기
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
				if (socket != null)
					socket.close();
			} catch (Exception e) {
			}
		}
		System.out.println("ServerMain 메소드를 종료합니다");
	}
}
