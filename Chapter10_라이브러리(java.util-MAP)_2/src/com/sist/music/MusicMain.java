package com.sist.music;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MusicMain {
	// 지니뮤직
	// 멜론
	// => 공통 (교집합), 차집합 / 합집합
	public Set<String> genieMusic(){
		Set<String> set = new HashSet<String>();
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			//웹서버에 접근
			Elements title = doc.select("table.list-wrap a.title");
			for(int i = 0; i < title.size(); i++) {
				//System.out.println(title);
				set.add(title.get(i).text());
			}
		} catch (Exception e) {}
		return set;
	}
	public Set<String> melonMusic(){
		Set<String> set = new HashSet<String>();
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			//웹서버에 접근
			Elements title = doc.select("div.wrap_song_info div.rank01 a");
			for(int i = 0; i < title.size(); i++) {
				//System.out.println(title);
				set.add(title.get(i).text());
			}
		} catch (Exception e) {}
		return set;
	}
	public static void main(String[] args) {
		MusicMain mm = new MusicMain();
		Set<String> genie = mm.genieMusic();
		for(String music:genie) {
			System.out.println(music);
		}
		System.out.println("==========================");
		Set<String> melone = mm.melonMusic();
		for(String music:melone) {
			System.out.println(music);
		}
		System.out.println("===================== 차집합 =====================");
		// 오라클 => MINUS removeAll()
		// [1,2,3,4,5] - [4,5,6,7,8] = [1,2,3]
		/*
		genie.removeAll(melone);
		for(String music:genie) {
			System.out.println(music);
		}
		*/
		System.out.println("===================== 교집합 =====================");
		// [1,2,3,4,5] [4,5,6,7,8] [4,5]
		// retainAll() => INTERSECT => JOIN
		genie.retainAll(melone);
		System.out.println("동일곡 : " + genie.size());
		for(String music:genie) {
			System.out.println(music);
		}
		
		System.out.println("=================== 멜론 + 지니 ===================");
		// UNION => addALL
		// => 중복된 경우에 1개만 첨부
		List<String> list = new ArrayList<String>();
		list.addAll(genie);
		list.addAll(melone);
		//UNION ALL => 중복된 데이터 포함
		System.out.println("데이터 갯수 : " + list.size());
		for(String music:list) {
			System.out.println(music);
		}
		//중복 제거
		Set<String> hap = new HashSet<String>();
		hap.addAll(list);
		
		System.out.println("=================== 중복없는 곡 ===================");
		System.out.println("데이터 갯수 : " + hap.size());
		for(String music:list) {
			System.out.println(music);
		}
		// addAll() : 합집합 / removeAll() : 차집합 / retainAll() : 교집합
		// => JOIN
	}
	
}
