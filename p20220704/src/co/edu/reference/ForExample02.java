package co.edu.reference;

import java.util.Scanner;

public class ForExample02 {
	// 메소드 정의 구문.
	public static int sumAry(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum; // 메소드를 호출한 영역으로 sum의 값을 반환하겠습니다.
	}

	public static void main(String[] args) {
		// 메소드 호출 구문.
		

		// 배열 합계.
		int sum = 0;
		double avg = 0;

		int[] intAry = { 34, 23, 56, 22, 99, 28 };
		// intAry 배열의 합과 평균.
		
//		for (int i = 0; i < intAry.length; i++) {
//			sum1 += intAry[i];
//			avg = (double) sum1 / intAry.length;
//		}
		sum = sumAry(intAry);
		avg = (double) sum / intAry.length;
		System.out.printf("intAry 배열의 합: %d, 평균: %.1f\n", sum, avg);

		sum = 0;

		int[] intArray = new int[6];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random() * 100) + 1;
//			sum += intArray[i];
//			
//			System.out.println(intArray[i]);
		}
		
		// intArray 배열의 합과 평균.
		sum = sumAry(intArray);
		avg = (double) sum / intArray.length;
		System.out.printf("intArray 배열의 합: %d, 평균: %.1f\n", sum, avg);

		sum = 0;
		int[] scanArray = new int[5];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < scanArray.length; i++) {
			System.out.println("임의의 수를 입력>>>> ");
			scanArray[i] = scn.nextInt();
//			sum += scanArray[i];
//			avg = (double) sum / scanArray.length;

		}
		// scanArray 배열의 합과 평균.
		sum = sumAry(scanArray);
		avg = (double) sum / scanArray.length;
		System.out.printf("scanArray 배열의 합: %d, 평균: %.1f\n", sum, avg);
		
	}
}
