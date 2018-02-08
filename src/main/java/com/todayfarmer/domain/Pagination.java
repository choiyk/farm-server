package com.todayfarmer.domain;

import lombok.Data;

@Data
public class Pagination {

	int ui; //userid
	int bd; //게시판 id
	int pg; //현재 페이지
	int sz; //페이지 당 레코드 수
	int sb; //search by
	int ab; //alarm by
}
