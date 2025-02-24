package com.ccm.dao;

import java.util.ArrayList;

import com.ccm.model.Mouse;

public class MouseDAO implements DAOInterface<Mouse>{
	public static MouseDAO getInstance() {
		return new MouseDAO();
	}

	@Override
	public int insert(Mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Mouse> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mouse selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
