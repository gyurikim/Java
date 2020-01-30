package test.main4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ServerMain {
	// 클라이언트를 응대하는 스레드 객체의 참조값을 담을 ArrayList
	static List<ServerThread> threadList = new ArrayList<>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 5000번 port를 사용할 준비를 한다
			serverSocket = new ServerSocket(5000);
			System.out.println("클라이언트의 연결요청을 대기중입니다...");
			while (true) {
				// 5000번 port의 연결요청을 기다린다 (블로킹 당하고 있는중!)
				Socket socket = serverSocket.accept();
				// 새로운 스레드를 만들어서 시작 시킨다
				ServerThread t = new ServerThread(socket);
				t.start();
				// 스레드를 arraylist에 누적시키기
				threadList.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
			} catch (Exception e) {
			}
		}
		System.out.println("ServerMain 메소드를 종료합니다");
	}

	// innerClass로 스레드를 생성할 클래스 설계하기
	static class ServerThread extends Thread {
		// 필드
		private Socket socket;
		private BufferedWriter bw;
		private String chatName;

		// 생성자
		public ServerThread(Socket socket) {
			// 생성자의 인자로 전달된 클 클라이언트와 연결된 소켓 객체의 참조값을 필드에 저장한다
			this.socket = socket;
		}

		// 대화명을 리턴해주는 getter메소드 만들기
		public String getChatName() {
			return chatName;
		}

		@Override
		public void run() {
			// 클라이언트를 응대하기
			try {
				// 클라이언트로부터 입력받을 객체의 참조값 얻어오기
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				while (true) {
					// 계속 반복문을 돌면서( 대기상태 ) 전송된 문자열이 있으면! 읽어온다
					String json = br.readLine();
					System.out.println(json);
					// 클라이언트가 전송한 문자열을 json을 이용해서 객체생성
					JSONObject jsonObj = new JSONObject(json);
					String type = jsonObj.getString("type");
					if (type.equals("enter")) {
						// 대화명을 스레드의 필드에 저장하기
						String chatName = jsonObj.getString("chatName");
						this.chatName = chatName;
						// 대화명 중계하기
						broadcastChatName();
					}

					// 반복문 돌면서 모든 스레드의
					for (ServerThread tmp : threadList) {
						// broadcast() 메소드를 호출하면서 문자열 전달
						tmp.broadcast(json);// 클라이언트1이 메세지를 보내면 접속해있는 모든 클라이언트들에게 msg를 broadcast(뿌린다)한다
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 접속종료된 스레드 제거하기
			threadList.remove(this);

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "leave");
			jsonObj.put("chatName", chatName);
			try {
				for (ServerThread tmp : threadList) {
					tmp.broadcast(jsonObj.toString());
				}
				broadcastChatName();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}// run

		// 전송된 문자열을 중계하는 메소드
		public void broadcast(String msg) throws IOException {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}

		// 챗팅방참여자 목록을 중개하는 메소드
		public void broadcastChatName() throws IOException {
			// 참여자 목록을 얻어내서
			List<String> names = new ArrayList<String>();
			for (ServerThread tmp : threadList) {
				names.add(tmp.getChatName());
			}
			// json문자열로 구성하고
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "update");
			jsonObj.put("name", names);
			// 모든 클라이언트에게 중개하기
			for (ServerThread tmp : threadList) {
				tmp.broadcast(jsonObj.toString());
			}
		}
	}// ServerThread
}// ServerMain
