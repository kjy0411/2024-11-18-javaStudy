package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class ReplyBoardVO {
	private int no, hit, group_id, group_step, group_tab, root, depth;
	private String name, subject, content, pwd, dbday;
	private Date regdate;
	// TO_CHAR를 이용해서 날짜 형식 변경 => 상세보기 : 날짜 + 시간
	
}
