package com.sist.main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.NovelDAO;
import com.sist.dao.NovelVO;

public class Main {
/*

no   NUMBER,												1~257167
genre      VARCHAR2(500) CONSTRAINT novel_genre_nn NOT NULL,			div.product-category
title      VARCHAR2(500) CONSTRAINT novel_title_nn NOT NULL,			div.product-title
poster   VARCHAR2(4000),										div.product-image
author   VARCHAR2(200) CONSTRAINT novel_author_nn NOT NULL,			div.product-author
story      CLOB,												div.product-description div.text_holder
avgstar   NUMBER DEFAULT 0,									div.card-header h4
serial      VARCHAR2(500),										div.product-meta a
iscp   CHAR(2),												div.product-title span


rno      NUMBER,
no      NUMBER,
id      VARCHAR2(20),
star      NUMBER CONSTRAINT review_star_nn NOT NULL,
content   CLOB,
regdate   DATE,
up      NUMBER,
down      NUMBER,
profile   VARCHAR2(4000),
CONSTRAINT review_rno_pk PRIMARY KEY(rno),
CONSTRAINT review_no_fk FOREIGN KEY(rno)
REFERENCES novel(no),
CONSTRAINT review_id_fk FOREIGN KEY(rno)
REFERENCES member(id)   

 */
	public static void main(String[] args) {
		String url = "https://ssn.so/series/";
		NovelDAO dao = NovelDAO.newInstance();
		for(int i = 1; i <= 10000; i++) {
			try {
				Document doc = Jsoup.connect(url + i).get();
				int no = i;
				Elements dAvgstar1 = doc.select("div.card-header h4");
				String avgstar = dAvgstar1.text().replaceAll("[^0-9.]", "");
				
				if(avgstar.equals("")) {
					avgstar = "0";
				}else {
					continue;
				}
				
				Element title = doc.selectFirst("div.product-title h3");
				Elements genre = doc.select("div.product-category a");
				Element poster = doc.selectFirst("div.product-image img");
				Element author = doc.selectFirst("div.product-author a");
				Element story = doc.selectFirst("div.product-description div.text_holder");
				Elements serial = doc.select("div.product-meta a");
				Element iscp = doc.selectFirst("div.product-title span");
				
				System.out.println("번호 : " + no);
				System.out.println("제목 : " + title.ownText());
				System.out.println("장르 : " + genre.text());
				System.out.println("표지 : " + poster.attr("src"));
				System.out.println("작가 : " + author.text());
				System.out.println("줄거리(소개) : " + story.text());
				System.out.println("평균 별점 : " + avgstar);
//				System.out.println("평균 별점 : " + (avgstar.equals("") ? "없음" : avgstar));
				System.out.println("연재처 : " + serial.text());
//				System.out.println("완결 : " + iscp);
				System.out.println("완결 : " + (iscp == null ? "없음" : iscp.text()));
//				System.out.println("리뷰수 : " + rCount);
				
				NovelVO vo = new NovelVO();
				vo.setNo(no);
				vo.setTitle(title.ownText());
				vo.setGenre(genre.text());
				vo.setPoster(poster.attr("src"));
				vo.setAuthor(author.text());
				vo.setStory(story.text());
				vo.setAvgstar(Double.parseDouble(avgstar));
				vo.setSerial(serial.text());
				vo.setIscp(iscp == null ? "N" : "Y");
				
				dao.novelInsert(vo);
				/*
				//리뷰 페이지 MAXPage
				int MAXPage = 1;
				try {
					for(int j = 1;;j++) {
						MAXPage = j;
						Document doc2 = Jsoup.connect(url + i + "/?filter=review&order_by=like_count&page=" + j + "#series-content-container").get();
						Elements check = doc2.select("div.product-title h3");
					}
				} catch (Exception e) {
					MAXPage--;
				}
				System.out.println("리뷰 페이지 : " + MAXPage);
				for(int j = 1; j <= MAXPage; j++) {
					try {
						Document doc2 = Jsoup.connect(url + i + "/?filter=review&order_by=like_count&page=" + j + "#series-content-container").get();
						Elements comment = doc2.select("div.comment");
						*/
						/*
rno
no
id
star
content
regdate
up
down
profile 
						 */
				/*
						for(int k = 0; k <= comment.size(); k++) {
							Elements member = doc2.select("div.comment-list h5.name");
							Elements star = doc2.select("div.comment-list div.product-rate");
							Elements content = doc2.select("div.comment-list div.content-txt");
							Elements regdate = doc2.select("div.comment-list div.text-right span.comment_date");
							Element up = doc.select("i.fa-thumbs-up ~ span").get(k);
							Element down = doc.select("i.fa-thumbs-down ~ span").get(k);
							Elements profile = doc.select("div.comment-list div.image img");
							
							String rno = "";
							String id = member.get(k).selectFirst("a").attr("href");
							String regex = "/profile/(\\d+)/home/";
							
							Pattern pattern = Pattern.compile(regex);
							Matcher matcher = pattern.matcher(id);
							if (matcher.find()) {
								id = matcher.group(1);
							}
							System.out.println("ID : " + id);
							System.out.println("nickname : " + member.get(k).selectFirst("a").text());
							System.out.println("rno : " + comment.get(k).attr("id").replaceAll("[^0-9]",""));
							System.out.println("star : " + star.get(k).selectFirst("span").attr("data-rateit-value"));
							System.out.println("star : " + content.get(k).text());
							System.out.println("regdate : " + regdate.get(k).text());
							System.out.println("up : " + up.text());
							System.out.println("down : " + down.text());
							System.out.println("profile : " + profile.attr("data-src"));
							
							System.out.println("==============================================");
						}
					} catch (Exception e) {}
				}
				*/
				System.out.println("==============================================");
			} catch (Exception e) {}
		}
		System.out.println("데이터 등록 완료");
	}

}
