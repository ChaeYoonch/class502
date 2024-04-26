package exam03;

// @MyAnno(min=10, max=100) // 에너테이션 또한 클래스에 정의된 구성 요소 중 하나 => Class 클래스에서 확인 O
// @MyAnno(names={"이름1", "이름2"}) // 항목이 1개 인 경우 에는 {} 굳이 사용하지 않아도 됨!
// @MyAnno(value="이름1")
// @MyAnno("이름") // value="이름1" 과 동일 | 1개 일 때만 가능
@MyAnno(value="이름", min=20)
public class Ex02 {
}
