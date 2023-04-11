package com.yedam.board;

import java.sql.Date;

import lombok.Data;

@Data

public class Boardrep {
	
	private String memberId;
	private String memberFname;
	private int repNo;
	private String repContent;
	private Date repDate;
	
}
