package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dao.inter.BaseDaoImpl;
import com.blog.model.Board;

@Service("boardDao")
public class BoardDao extends BaseDaoImpl {
	//添加留言
	public boolean add(Board board) {
		return save(board);
	}
	
	//删除留言
	public boolean deleteBoard(int boardId) {
		String sql = "delete from board where board_id = " + boardId;
	    return deleteSQLUpdate(sql)==0?false:true;
	}
	
	//查询所有留言
	public List<Board> queryAll() {
		return (List<Board>) getResult("from Board b order by b.boardId desc",null);
	}
	
}
