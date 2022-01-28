import java.util.Scanner;

public class ATM14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;

		int[] arId = new int[MAX]; // ���̵�
		int[] arPw = new int[MAX]; // ���
		int[] arMoney = new int[MAX]; // ��

		int count = 0;
		int log = -1;

		while (true) {
			String menu = "=== �ް�IT ATM ===\n";
			menu += "1.ȸ������\n2.ȸ��Ż��\n3.�α���\n4.�α׾ƿ�\n";
			menu += "5.�Ա�\n6.��ü\n7.�ܾ���ȸ\n8.��������\n0.����";
			System.out.println(menu);

			System.out.println("�޴��� �������ּ���.");

			int select = sc.nextInt();

			if (select == 1) // ȸ������
			{
				System.out.println("Id�� �Է����ּ���.");
				int Id = sc.nextInt();

				int check = 1;

				for (int i = 0; i < count; i++) {
					if (arId[i] == Id) {
						check = -1;
					}
				}
				if (check == -1) { // ���̵� �ߺ�üũ
					System.out.println("�ߺ��Ǿ��ִ� Id�Դϴ�.");
				} else {
					System.out.println("Pw�� �Է����ּ���.");
					int Pw = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arPw[i] == Pw) {
							check = -1;
						}
					}
					arId[count] = Id;
					arPw[count] = Pw;
					arMoney[count] = 1000; // ���� �� 1000�� �ο�
					count++;
					System.out.println(Id + " �� ȸ�������� ���������� �̷�������ϴ�.");
				}
			} else if (select == 2) // ȸ��Ż��
			{
				if (log == -1) // �α����� �ƴ� ��
				{
					System.out.println("�α��� �� ���ٶ��ϴ�.");
					System.out.println();
				} else { // �α��� �� ��
					for (int i = log; i < count - 1; i++) {
						arId[i] = arId[i + 1];
						arPw[i] = arPw[i + 1];
						arMoney[i] = arMoney[i + 1];
					}
					System.out.println("ȸ������ Ż��Ǿ����ϴ�.");
					System.out.println();
					count--;
					log = -1;
				}
			} else if (select == 3) // �α���
			{
				if (log == -1) {
					System.out.println("Id�� �Է����ּ���");
					int Id = sc.nextInt();

					int check = -1;

					for (int i = 0; i < count; i++) {
						if (arId[i] == Id) {
							check = 1;
						}
					}
					if (check == -1) {
						System.out.println("Id�� Ȯ�����ּ���.");
					} else {
						System.out.println("��й�ȣ�� �Է����ּ���.");
						int Pw = sc.nextInt();

						for (int i = 0; i < count; i++) {
							if (arPw[i] == Pw) {
								check = -i;
							}
						}
						if (check == -1) {
							System.out.println("��й�ȣ�� Ȯ�����ּ���.");
						} else {
							log = check;
							System.out.println(arId[check] + "�� ȯ���մϴ�.");
							System.out.println();
						}
					}
				} else {
					System.out.println(arId[log] + "���� �α��� �� �Դϴ�.");
					System.out.println();
				}
			} else if (select == 4) // �α׾ƿ�
			{
				if (log == -1) {
					System.out.println("�α����� �Ǿ����� �ʽ��ϴ�.");
				} else {
					System.out.println(arId[log] + "���� �α׾ƿ��Ǿ����ϴ�");
					System.out.println();
					log = -1;
				}
			} else if (select == 5) // �Ա�
			{
				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println("�Ա��� ���� �Է����ּ���");
					int money = sc.nextInt();

					arMoney[log] = arMoney[log] + money;
				}
			} else if (select == 6) { // ��ü
				int send = 0;

				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println("��ü�� ���� �Է����ּ���");
					int money = sc.nextInt();

					System.out.println("��ü�� Id�� �Է����ּ���.");
					int send_Id = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arId[i] == send_Id) {
							send = i;
						}
					}
					if (money > arMoney[log]) {
						System.out.println("�ܰ� �����մϴ�.");
					} else {
						arMoney[log] = arMoney[log] - money;
						arMoney[send] = arMoney[send] + money;
					}
				}
			} else if (select == 7) // �ܾ���ȸ
			{
				if(log == -1)
				{
					System.out.println("�α��� �� ���ٶ��ϴ�.");
				}
				else
				{
					System.out.println(arId[log]+"���� �ܾ��� "+arMoney[log] + " �Դϴ�.");
				}
			} else if (select == 8) // ��������
			{
				System.out.println("�����ڸ� ���� �����մϴ�.");
				System.out.println("������ ���� ��й�ȣ�� �Է����ּ���");
				int Manager_Num = sc.nextInt();
				
				int Manager = 12345;
				
				if(Manager_Num == Manager)
				{
					System.out.println("���� ����Ǿ��ִ� Id");
					for(int i=0;i<count;i++)
					{
						System.out.print(arId[i] + " ");
					}
					System.out.println();
					
					System.out.println("���� ����Ǿ��ִ� Pw");
					for(int i=0;i<count;i++)
					{
						System.out.print(arPw[i] + " ");
					}
					System.out.println();
					
					System.out.println("���� ����Ǿ��ִ� ��");
					for(int i=0;i<count;i++)
					{
						System.out.print(arMoney[i] + " ");
					}
					System.out.println();
				}
				else
				{
					System.out.println("��й�ȣ�� Ȯ�����ּ���");
				}
			} else if (select == 0) // ����
			{
				break;
			}
		}
	}
}
