package 연습문제;

public class Q03 { // 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스클럽 swich ~ case문(5층인 경우 ‘5층 헬스클럽입니다.’)
    public static void main(String[] args) {
        int floor = 10;
        switch(floor) { /* if (floor == 1); */
            case 1:
                System.out.println("1층 약국");
                break;
            case 2:
                System.out.println("2층 정형외과");
                break;
            case 3:
                System.out.println("3층 피부과");
                break;
            case 4:
                System.out.println("4층 치과");
                break;
            case 5:
                System.out.println("5층 헬스클럽");
                break;
            default:
                System.out.println("없는 층입니다.");
        }
    }
}
