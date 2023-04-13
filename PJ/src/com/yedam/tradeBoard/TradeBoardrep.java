package com.yedam.tradeBoard;

import java.sql.Date;

import lombok.Data;

@Data 

public class TradeBoardrep {
	private String memberId;
	private String memberFname;
	private int repNo;
	private String repContent;
	private Date repDate;
}
