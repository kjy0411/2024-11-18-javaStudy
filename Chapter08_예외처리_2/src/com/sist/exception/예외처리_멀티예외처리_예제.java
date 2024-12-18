package com.sist.exception;

import java.util.Scanner;

//268page => 형식
/*  270page => 다중 catch
 *  => 예상예외가 많은 경우에는 다중 catch
 */
public class 예외처리_멀티예외처리_예제 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 정수 입력 : ");
			String num1 = scan.next();
			System.out.print("두번째 정수 입력 : ");
			String num2 = scan.next();
			
			// 정수 변환 => 윈도우, 웹 (문자열, 네트워크)
			// <input type = "text">
			// JTextField
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			
			System.out.print(n1 / n2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		*/
		/*
		catch (NumberFormatException|ArithmeticException e) {
			System.out.println(e.getMessage());
		} 
		*/
		/*
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
}
