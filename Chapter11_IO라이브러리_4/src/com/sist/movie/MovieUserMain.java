package com.sist.movie;

import java.io.*;
import java.util.*;

public class MovieUserMain {

	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			// 키보드 입력값을 읽어온다
			while(true) {
				System.out.println("===== Menu =====");
				System.out.println("1. 영화 목록");
				System.out.println("2. 영화 상세");
				System.out.println("3. 영화 검색");
				System.out.println("9. 종료");
				System.out.println("================");
				System.out.print("메뉴 입력 : ");
				String menu = in.readLine();
				int m = Integer.parseInt(menu);
				// BufferedReader => 값을 읽을 때 문자열로 가지고 온다 => 필요한 데이터형으로 변환 => Wrapper
				if(m == 9) {
					System.out.println("프로그램 종료");
					break;
				}else if(m == 1) {
					List<Movie> list = ms.movieListData();
					for(Movie mo : list) {
						System.out.println(mo.getMno() + "." + mo.getTitle());
					}
				}else if(m == 2) {
					System.out.println("영화 번호 입력(1~1938) : ");
					String mno = in.readLine();
					int mm = Integer.parseInt(mno);
					Movie movie = ms.movidDetailData(mm);
					System.out.println("영화번호 : " + movie.getMno());
					System.out.println("영화명 : " + movie.getTitle());
					System.out.println("영화장르 : " + movie.getGenre());
					System.out.println("영화포스터 : " + movie.getPoster());
					System.out.println("영화배우 : " + movie.getActor());
					System.out.println("영화개봉일 : " + movie.getRegdate());
					System.out.println("영화등급 : " + movie.getGrade());
					System.out.println("영화감독 : " + movie.getDirector());
				}else if(m == 3) {
					System.out.print("검색어 입력 : ");
					String fd = in.readLine();
					List<Movie> list = ms.movidFindData(fd);
					System.out.println("검색결과 : " + list.size() + "건");
					for(Movie mm : list) {
						System.out.println(mm.getMno() + "." + mm.getTitle());
					}
				}else{
					System.out.println("없는 메뉴입니다!!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
