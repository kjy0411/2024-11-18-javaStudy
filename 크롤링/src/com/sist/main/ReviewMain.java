package com.sist.main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.Date;
import com.sist.dao.*;
public class ReviewMain {
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
		MemberDAO mDao = MemberDAO.newInstance();
		ReviewDAO rDao = ReviewDAO.newInstance();
		for(int i = 1; i <= 10000; i++) {
			try {
				int no = i;
				
				System.out.println(no);
				//리뷰 페이지 MAXPage
				int MAXPage = 1;
				try {
					for(int j = 1;;j++) {
						MAXPage = j;
						Document doc = Jsoup.connect(url + i + "/?filter=review&order_by=like_count&page=" + j + "#series-content-container").get();
						Elements check = doc.select("div.product-title h3");
					}
				} catch (Exception e) {
					MAXPage--;
				}
				System.out.println("리뷰 페이지 : " + MAXPage);
				for(int j = 1; j <= MAXPage; j++) {
					try {
						Document doc = Jsoup.connect(url + i + "/?filter=review&order_by=like_count&page=" + j + "#series-content-container").get();
						Elements comment = doc.select("div.comment");
						for(int k = 0; k <= comment.size(); k++) {
							Elements member = doc.select("div.comment-list h5.name");
							Elements star = doc.select("div.comment-list div.product-rate");
							Elements content = doc.select("div.comment-list div.content-txt");
							Elements regdate = doc.select("div.comment-list div.text-right span.comment_date");
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
							System.out.println("content : " + content.get(k).text());
							System.out.println("regdate : " + regdate.get(k).text());
							System.out.println("up : " + up.text());
							System.out.println("down : " + down.text());
//							System.out.println("profile : " + profile.attr("data-src"));
							
							MemberVO mvo = new MemberVO();
							ReviewVO rvo = new ReviewVO();
							try {
								mvo.setId(id);
								mvo.setNickname(member.get(k).selectFirst("a").text());
								mvo.setPw("1234");
								mvo.setName("더미");
								mvo.setGender("male");
								mvo.setEmail("test" + id + "@test");
								mvo.setAddress1("test");
								mvo.setPhone("010-" + id);
								mDao.MemberInsert(mvo);
								
							} catch (Exception e) {
								// TODO: handle exception
							} finally {
								try {
									rvo.setRno(Integer.parseInt(comment.get(k).attr("id").replaceAll("[^0-9]","")));
									rvo.setNo(no);
									rvo.setUp(Integer.parseInt(up.text()));
									rvo.setDown(Integer.parseInt(down.text()));
									rvo.setStar(Double.parseDouble(star.get(k).selectFirst("span").attr("data-rateit-value")));
									rvo.setId(id);
									rvo.setContent(content.get(k).text());
									String[] str = new String[4]; 
									str = regdate.get(k).text().split(" ");
									String year = str[0].replaceAll("[^0-9]","");
									String month = str[1].replaceAll("[^0-9]","");
									String day = str[2].replaceAll("[^0-9]","");
									System.out.println(year);
									System.out.println(month);
									System.out.println(day);
									String str2 = "" + year + "-" + month + "-" + day;
									System.out.println(rvo.getStrRegdate());
									rvo.setStrRegdate(str2);
									
									rDao.ReviewInsert(rvo);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
							System.out.println("==============================================");
						}
					} catch (Exception e) {}
				}
				System.out.println("==============================================");
			} catch (Exception e) {}
		}
		System.out.println("데이터 등록 완료");
	}

}
