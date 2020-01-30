package test.main;

import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.2", 5000);
			System.out.println("소켓연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (Exception e2) {}
		}
		System.out.println("ClientMain 메소드가 종료됩니다");
	}
}
