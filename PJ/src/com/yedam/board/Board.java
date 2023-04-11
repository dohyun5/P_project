package com.yedam.board;

import java.sql.Date;
import java.util.List;
import lombok.Data;

@Data

public class Board {
	
	private String memberId;
	private String memberFname;
	private String memberGrade;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardViews;
	private int boardRepCount;
	
	
}
