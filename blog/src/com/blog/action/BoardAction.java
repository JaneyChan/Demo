package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blog.model.Board;
import com.blog.service.BoardService;

public class BoardAction extends BaseAction {
	private Integer boardId;
	private String message;
	private String time;
	private String userName;
	private String email;
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	//添加留言
	public String add() {
		Board b = new Board();
		b.setUserName(userName.trim());
		b.setEmail(email.trim());
		b.setMessage(message.trim());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		b.setTime(date);
		if(boardService.add(b)) {
			System.out.println("success");
			return "addBoardSucc";
		}
		System.out.println("fail");
		return "addBoardFail";
	}
	
	//查找所有留言
	public String findAll() {
		List<Board> listBoard = boardService.queryAll();
		getRequest().setAttribute("listBoard", listBoard);
		return "allBoard";
	}
	
	//按ID删除留言
	public String delete() {
		if(boardService.deleteBoard(boardId)) {
			return "delBoardSucc";
		}
		return "allBoard";
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
