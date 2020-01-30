package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainClass05 {
	public static void main(String[] args) {
		OutputStream os=System.out;
		//2byte
		OutputStreamWriter osw=new OutputStreamWriter(os);
		try {
			osw.write(97);
			osw.write(98);
			osw.write(99);
			osw.write(44032);
			osw.write(44033);
			osw.write("hello");
			osw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
