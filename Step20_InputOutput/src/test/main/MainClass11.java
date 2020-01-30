package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass11 {
	public static void main(String[] args) {
		File f1 = new File("c:/myFolder/memo.txt");
		try {
			// 파일에서 문자열을 읽어들일 객체생성
			FileReader fr = new FileReader(f1);
			// 읽고자하는 파일의 크기를 모르기떄문에 무한루프를 돌면서 일정갯수만큼씩 읽어오는 반복문을 돌다가
			//  더이상 읽을 문자열이 없을떄 무한루프를 탈출한다
			while (true) {
				// FileReader 객체를 통해서 읽어들이고
				int code = fr.read();
				if (code == -1) {	// 더이상 읽을게없으면 -1로 리턴된다
					break;			// 더이상 읽을게 없을때 무한루프 탈출!
				}
				//code값을 char type으로 변환해서 출력하기
				char ch=(char)code;
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
