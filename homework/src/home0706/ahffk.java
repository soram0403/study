package home0706;

import java.util.Scanner;

/*
 * 문제 5: 배열.
 * Scanner 클래스를 사용하여 사용자가 입력한 값을 다음의 배열에서 찾아서 값이 있을 경우에는 해당 값의 저장위치를 값이 없을 경우에는
 * 찾는 값이 없습니다는 메세지를 보여주도록 기능을 작성하세요.
 */

//while(!menuNo.equals("99")) {
public class ahffk {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] fruits = { "사과", "딸기", "감", "수박", "포도", "복숭아" };
		System.out.println("과일 이름을 입력하세요>> ");

		boolean run = true;
		while (run) {
			String fruitsName = scn.nextLine();
			int no = 0; // 존재 하는 과일의 수
			no++;
			if (no >= 1) {
				for (int i = 0; i < fruits.length; i++) {
					if (fruitsName.equals(fruits[i])) {
						fruitsName = fruits[i];
						System.out.println("찾는 과일이 있습니다.");
						System.out.println("과일이름 : " + fruitsName);
					
						break;
					} else if (!(fruitsName.equals(fruits[i]))) {
						no = 0;
						System.out.println("찾는 값이 없습니다.");
						run = false;
					}
				} // end of for

			}
		}
	}

}