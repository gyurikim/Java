package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass10 {
	public static void main(String[] args) {
		// 이미 만들어진 텍스트 파일에 Access할수있는 객체생성
		File f1 = new File("c:/myFolder/memo.txt");
		try {
			FileWriter fw = new FileWriter(f1, true);
//			fw.write("안녕하세요\n");
//			fw.write("\n");
//			fw.write("반갑씁니다");	//원리 : 계속 run을해도 이전 내용위에 덮어쓴다
			fw.append("하나\r\n\r"); // String의 인터페이스로 CharSequence가 존재한다. 둘의 역할이 비슷하므로 같다고 생각하고 사용할수 있다
			fw.append("두울\n");
			fw.append("세엣\n");
			/*
			 * FileWriter fw=new FileWriter(f1,true); >트루까지 적어주어야 어팬드 했을때 쌓이는걸 볼수있다
			 */
			fw.flush(); // .flush()를 하지 않으면 눈에 보이지 않는다
			fw.close(); // 코드 안에서 사용고 닫아두지 않으면 날라갈수도 있기때문에 닫아주어야한다
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main메소드가 리턴됩니다");
	}
}
