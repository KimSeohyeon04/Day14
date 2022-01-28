import java.util.Scanner;

public class ATM14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;

		int[] arId = new int[MAX]; // 아이디
		int[] arPw = new int[MAX]; // 비번
		int[] arMoney = new int[MAX]; // 돈

		int count = 0;
		int log = -1;

		while (true) {
			String menu = "=== 메가IT ATM ===\n";
			menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
			menu += "5.입금\n6.이체\n7.잔액조회\n8.개인정보\n0.종료";
			System.out.println(menu);

			System.out.println("메뉴를 선택해주세요.");

			int select = sc.nextInt();

			if (select == 1) // 회원가입
			{
				System.out.println("Id를 입력해주세요.");
				int Id = sc.nextInt();

				int check = 1;

				for (int i = 0; i < count; i++) {
					if (arId[i] == Id) {
						check = -1;
					}
				}
				if (check == -1) { // 아이디 중복체크
					System.out.println("중복되어있는 Id입니다.");
				} else {
					System.out.println("Pw를 입력해주세요.");
					int Pw = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arPw[i] == Pw) {
							check = -1;
						}
					}
					arId[count] = Id;
					arPw[count] = Pw;
					arMoney[count] = 1000; // 가입 시 1000원 부여
					count++;
					System.out.println(Id + " 님 회원가입이 정상적으로 이루어졌습니다.");
				}
			} else if (select == 2) // 회원탈퇴
			{
				if (log == -1) // 로그인이 아닐 때
				{
					System.out.println("로그인 후 사용바랍니다.");
					System.out.println();
				} else { // 로그인 일 때
					for (int i = log; i < count - 1; i++) {
						arId[i] = arId[i + 1];
						arPw[i] = arPw[i + 1];
						arMoney[i] = arMoney[i + 1];
					}
					System.out.println("회원님이 탈퇴되었습니다.");
					System.out.println();
					count--;
					log = -1;
				}
			} else if (select == 3) // 로그인
			{
				if (log == -1) {
					System.out.println("Id를 입력해주세요");
					int Id = sc.nextInt();

					int check = -1;

					for (int i = 0; i < count; i++) {
						if (arId[i] == Id) {
							check = 1;
						}
					}
					if (check == -1) {
						System.out.println("Id를 확인해주세요.");
					} else {
						System.out.println("비밀번호를 입력해주세요.");
						int Pw = sc.nextInt();

						for (int i = 0; i < count; i++) {
							if (arPw[i] == Pw) {
								check = -i;
							}
						}
						if (check == -1) {
							System.out.println("비밀번호를 확인해주세요.");
						} else {
							log = check;
							System.out.println(arId[check] + "님 환영합니다.");
							System.out.println();
						}
					}
				} else {
					System.out.println(arId[log] + "님이 로그인 중 입니다.");
					System.out.println();
				}
			} else if (select == 4) // 로그아웃
			{
				if (log == -1) {
					System.out.println("로그인이 되어있지 않습니다.");
				} else {
					System.out.println(arId[log] + "님이 로그아웃되었습니다");
					System.out.println();
					log = -1;
				}
			} else if (select == 5) // 입금
			{
				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println("입금할 돈을 입력해주세요");
					int money = sc.nextInt();

					arMoney[log] = arMoney[log] + money;
				}
			} else if (select == 6) { // 이체
				int send = 0;

				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println("이체할 돈을 입력해주세요");
					int money = sc.nextInt();

					System.out.println("이체할 Id를 입력해주세요.");
					int send_Id = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arId[i] == send_Id) {
							send = i;
						}
					}
					if (money > arMoney[log]) {
						System.out.println("잔고가 부족합니다.");
					} else {
						arMoney[log] = arMoney[log] - money;
						arMoney[send] = arMoney[send] + money;
					}
				}
			} else if (select == 7) // 잔액조회
			{
				if(log == -1)
				{
					System.out.println("로그인 후 사용바랍니다.");
				}
				else
				{
					System.out.println(arId[log]+"님의 잔액은 "+arMoney[log] + " 입니다.");
				}
			} else if (select == 8) // 개인정보
			{
				System.out.println("관리자만 접근 가능합니다.");
				System.out.println("관리자 권한 비밀번호를 입력해주세요");
				int Manager_Num = sc.nextInt();
				
				int Manager = 12345;
				
				if(Manager_Num == Manager)
				{
					System.out.println("현재 저장되어있는 Id");
					for(int i=0;i<count;i++)
					{
						System.out.print(arId[i] + " ");
					}
					System.out.println();
					
					System.out.println("현재 저장되어있는 Pw");
					for(int i=0;i<count;i++)
					{
						System.out.print(arPw[i] + " ");
					}
					System.out.println();
					
					System.out.println("현재 저장되어있는 돈");
					for(int i=0;i<count;i++)
					{
						System.out.print(arMoney[i] + " ");
					}
					System.out.println();
				}
				else
				{
					System.out.println("비밀번호를 확인해주세요");
				}
			} else if (select == 0) // 종료
			{
				break;
			}
		}
	}
}
