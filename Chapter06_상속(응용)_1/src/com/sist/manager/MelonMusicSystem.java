package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.MusicVO;

public class MelonMusicSystem extends GenieMusicSystem{
//	public MusicVO[] music = new MusicVO[50];
	public String title = "멜론뮤직 Top50";

	//인스턴스 초기화 블록 => 호출(X), 상속(X)
	{
		//예외처리 => 파일 관련, 네트워크, 데이터베이스
		//URL => 웹 네트워크 ==> 8장
		/*  
		 *  예외 복구
		 *  예외 회피
		 *  예외 임의로 발생 => 견고성
		 *  
		 *  = 가독성
		 *  = 최적화
		 *  = 견고성
		 *  -------
		 */
		try {
			//정상적으로 수행하는 문장
			//int a = 10/0; // 프로그램 종료
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title = doc.select("div.wrap_song_info div.rank01");
			Elements singer = doc.select("div.wrap_song_info div.rank02");
			Elements album = doc.select("div.wrap_song_info div.rank03");
			
			for(int i = 0; i < 50; i++) {
				/*
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("========================================");
				*/
				musics[i] = new MusicVO();
				musics[i].setNo(i + 1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(singer.get(i).text());
				musics[i].setAlbum(album.get(i).text());
				
			}
		} catch (Exception ex) {
			//에러 발생시에 복구 / 에러출력
			//에러를 건너뛴다
		}
	}
	// musicAllData()
	// musicFindData(String fd)
	// static, 생성자, 초기화 블록 제외 => 추가
}
