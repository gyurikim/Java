package test.mypac;
/*
 *  메소드를 1개만 정의하도록 강제하는 어노테이션
 */
@FunctionalInterface
public interface Drill {
	//구멍을 뚤는 기능 
	public void hole();
}
