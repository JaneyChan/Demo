package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.BoardDao;
import com.blog.model.Article;
import com.blog.model.Board;

@Service("boardService")
public class BoardService {
	@Autowired
	@Qualifier("boardDao")
	private BoardDao boardDao;
	
	//添加留言
	public boolean add(Board board) {
		return boardDao.add(board);
	}
	
	//删除留言
	public boolean deleteBoard(int boardId) {
		return boardDao.deleteBoard(boardId);
	}
	
	//查询所有留言
	public List<Board> queryAll() {
		return boardDao.queryAll();
	}
}
