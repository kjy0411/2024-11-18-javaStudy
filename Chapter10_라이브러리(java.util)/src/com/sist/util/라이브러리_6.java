package com.sist.util;
import java.text.SimpleDateFormat;
import java.util.*; // Date/Calendar/StringTokenizer
public class 라이브러리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
        String today=sdf.format(date);
        // 2024-12-20
        StringTokenizer st=new StringTokenizer(today,"-");
        int year=Integer.parseInt(st.nextToken());
        int month=Integer.parseInt(st.nextToken());
        int day=Integer.parseInt(st.nextToken());
        
        Calendar cal1=Calendar.getInstance();
        // 추상 클래스 => new를 이용할 수 없다
        /*
         *   날짜설정
         *    => set()
         *       cal1.set(Calendar.YEAR, year);
                 cal1.set(Calendar.MONTH, month-1);
                 cal1.set(Calendar.DATE, day);
         *   날짜읽기 
         *    => get()
         *   달의 마지막 날짜  
         *    => getActualMaximum()
         *   요일읽기 
         *    => get(Calendar.DAY_OF_WEEK)
         */
        cal1.set(Calendar.YEAR, year);
        cal1.set(Calendar.MONTH, month-1);
        cal1.set(Calendar.DATE, day);
        
        int week=cal1.get(Calendar.DAY_OF_WEEK);
        week=week-1;
        String[] strWeek={"일","월","화","수","목","금","토"};
        
        System.out.println(year+"년도 "+month+"월 "
        		    +day+"일 "+strWeek[week]+"요일");
        
        int lastday=cal1.getActualMaximum(Calendar.DATE);
        
        Calendar cal2=Calendar.getInstance();
        cal2.set(Calendar.YEAR, year);
        cal2.set(Calendar.MONTH, month-1);
        cal2.set(Calendar.DATE, 1);
        
        int week2=cal2.get(Calendar.DAY_OF_WEEK);
        week2=week2-1;
        
        for(String s:strWeek)
        {
        	System.out.print(s+"\t");
        }
        System.out.println();
        for(int i=1;i<=lastday;i++)
        {
        	if(i==1)
        	{
        		for(int j=0;j<week2;j++)
        		{
        			System.out.print("\t");
        		}
        	}
        	System.out.printf("%2d\t",i);
        	week2++;
        	if(week2>6) // 일요일이면
        	{
        		week2=0;
        		System.out.println();
        	}
        }
        
	}

}