package com.sist.movie;
import java.io.*;
import java.util.*;

import javax.swing.ListModel;
// ObjectInputStream
public class MovieSystem {
	//영화 정보를 가지고 있다 => 요청 기능
	private static List<Movie> movieList = new ArrayList<Movie>();
	
	static {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\movie_info.txt");
			ois = new ObjectInputStream(fis);
			movieList = (List<Movie>)ois.readObject();
			// => 제어 => List로 사용 
			// => 파일에 다시 저장 
			// remove() => List를 재저장 
			// set()
			// add()
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception e) {}
		}
	}
	//목록
	public List<Movie> movieListData(){
		return movieList;
	}
	//상세보기
	// SELECT * FROM movie WERER mno = 1
	public Movie movidDetailData(int mno) {
		Movie movie = new Movie();
		for(Movie m : movieList) {
			if(m.getMno() == mno) {
				movie = m;
				break;
			}
		}
		return movie;
	}
	//검색 WHERE title LIKE '%fd%' => 네트워크 통신
	// => 웹 (네트워크 통신)
	// => writeObject(Object), Object readObject()
	//						   ------ 형변환후에 사용
	//		직렬화					역직렬화
	//저장되는 데이터는 반드시 implements Serializable 사용
	//일반적으로 사용이 가능 => 직렬화로 사용이 가능
	//객체 생성시에는 FileInputStream / FileOutputStream
	public List<Movie> movidFindData(String title) {
		List<Movie> list = new ArrayList<Movie>();
		for(Movie m : movieList) {
			if(m.getTitle().contains(title)) {
				list.add(m);
			}
		}
		return list;
	}
}
