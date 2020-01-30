package test.mypac;

public class Counter {
	//int type을 저장할 public static field 정의하기
	//public을 붙이지 않으면 다른패키지에서 불러 사용할수 없다
	public static int count=0;
	 
	public static void addCount() {
		//이 메소드가 몇번 호출되었는지 자체적으로 저장하고 싶다면?
		Counter.count++;	//스태틱 메소드 영역 안에서 변수를 사용하고 싶다면 필드에서 정의된 변수에도 스태틱을 붙여줘야한다.
		
	}
}
