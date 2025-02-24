package com.ccm.dao;

import java.util.ArrayList;

import model.screen;

public class ScreenDAO implements DAOInterface<screen>{
	public static ScreenDAO getInstance() {
		return new ScreenDAO();
	}

	@Override
	public int insert(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<screen> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public screen selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
