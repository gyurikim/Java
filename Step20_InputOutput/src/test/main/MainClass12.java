package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass12 {
	public static void main(String[] args) {
		File f1 = new File("c:/myFolder/memo.txt");
		try {
			// 파일에서 문자열을 읽어들일 객체생성
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			// 읽고자하는 파일의 크기를 모르기떄문에 무한루프를 돌면서 일정갯수만큼씩 읽어오는 반복문을 돌다가
			// 더이상 읽을 문자열이 없을떄 무한루프를 탈출한다

			// 반복문돌면서 한줄씩 읽어내기
			while (true) {
				// 개행기호뺴고 한줄의 문자열 읽어오기
				String line = br.readLine();
				if (line == null) { // 더이상 읽을게없으면 null로 리턴된다
					break; // 더이상 읽을게 없을때 무한루프 탈출!
				}
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
