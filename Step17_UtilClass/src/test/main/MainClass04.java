package test.main;

import java.util.ArrayList;
import java.util.List;

import test.auto.Car;
import test.auto.Engine;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 담을수 있는 가변배열 객체를 생성해서 참조값을 cars
		//라는 지역 변수에 담기
		List<Car> cars=new ArrayList<>();
		//2. cars 배열에 Car  객체를 각각 3개 생성해서 순서대로 담아 보세요.
		cars.add(new Car(new Engine()));
		cars.add(new Car(new Engine()));
		Car car1=new Car(new Engine());
		cars.add(car1);
		//3. 반복문을 이용해서 cars  배열에 저장된 Car 객체의 참조값을 순서대로
		//   참조해서  .drive() 메소드를 호출해 보세요.
		for(Car tmp:cars) {
			tmp.drive();
		}
	}
}




