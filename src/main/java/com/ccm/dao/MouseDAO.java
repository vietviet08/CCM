package com.ccm.dao;

import java.util.ArrayList;

import model.mouse;

public class MouseDAO implements DAOInterface<mouse>{
	public static MouseDAO getInstance() {
		return new MouseDAO();
	}

	@Override
	public int insert(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<mouse> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public mouse selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
