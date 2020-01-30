package test.main;

/*
 * [연산자]
 * 2. 증감연산자
 * 
 * - 변수에 저장된 숫자를 1씩 증가, 감소 시키고 싶을떄 사용하는 연산자
 * 종류 : ++,--
 */
public class MainClass02 {
	public static void main(String[] args) {
		int num = 0;
		num++;
		num++;
		num++; // 3

		int num2 = 0;
		num2--;
		num2--;
		num2--; // -3

		int num3 = 0;
		int result1 = num3++;    // 0 >> 연산자가 변수 뒤에 있을때 대입을 하고 나서 증감연산자가 작용함
								// 변수 뒤에 증감연산자가 있으면 우선순위가 대입연산자(=) 보다 느리다

		int num4 = 0;
		int result2 = ++num4;    // 1 >> 연산자가 변수 앞에 있을때 증감연산자가 우선 작용함
								// 변수 앞에 증감연산자가 있으면 우선순위가 대입연산자(=) 보다 빠르다
		num = 0;
		num2 = 0;
		num3 = 0;

		int result3 = num-- + ++num2 - --num3;
	}
}
