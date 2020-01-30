package test.main;

import test.mypac.Animal;
import test.mypac.Animal.Monkey;
import test.mypac.Animal.Rabbit;

public class MainClass01 {
	public static void main(String[] args) {
		// animal 객체를 생ㅇ성해서
		Animal ani = new Animal();
		// 메소드를 이용해서 몽키 객체의 참조값 얻어오기
		Monkey m = ani.getMonkey();
		// 메소드를 이용해서 래빗 객체의 참조값 얻어오기
		Rabbit r = ani.getRabbit();
		m.say();
		r.say();
	}
}
