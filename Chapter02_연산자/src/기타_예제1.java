

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 기타_예제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Scanner scan=new Scanner(System.in);
        	System.out.print("검색어:");
        	String fd=scan.next();
        	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
        	Elements title=doc.select("td.info a.title");
        	for(int i=0;i<title.size();i++)
        	{
        		if(title.get(i).text().contains(fd))
        		{
        		  System.out.println(title.get(i).text());
        		}
        	}
        }catch(Exception ex) {}
	}

}