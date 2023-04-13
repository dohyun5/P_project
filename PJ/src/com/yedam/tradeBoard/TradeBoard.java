package com.yedam.tradeBoard;

import java.sql.Date;

import lombok.Data;

@Data

public class TradeBoard {

	private String memberId;
	private String memberFname;
	private String memberGrade;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardViews;
	private int boardRepCount;
	private String tradeIng;
	
}
