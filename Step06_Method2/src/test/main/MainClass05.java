package test.main;

import test.mypac.Acorn;

public class MainClass05 {
	public static void main(String[] args) {
		// Acorn객체를 생성해서
		Acorn acorn = new Acorn();
		// 오버로딩되어있는 메소드를 하나씩 호출해보기
		acorn.study();
		acorn.study(100);
		acorn.study("구라");
	}
}
