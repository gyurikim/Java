package test.json;

public class MainClass5 {
	public static void main(String[] args) {
		String info = "num:1, name:김구라, addr:노량진";
		// 위 문자열에서 회원의 정보를 추출해서 JSON을 사용하지 않고 변수에 담아보세요 
		int num = 0;
		String name = null;
		String addr = null;

		// 콤마로 구분해서 배열에 저장시키기
		String[] result = info.split(",");
		num = Integer.parseInt(result[0].split(":")[1]);// String type으로 값을 받아오기때문에 정수형으로 바꿔서 저장해주어야한다
		name = result[1].split(":")[1];
		addr = result[2].split(":")[1];
	}
}
