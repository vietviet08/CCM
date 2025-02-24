package com.ccm.dao;

import java.util.ArrayList;

import com.ccm.model.Screen;

public class ScreenDAO implements DAOInterface<Screen>{
	public static ScreenDAO getInstance() {
		return new ScreenDAO();
	}

	@Override
	public int insert(Screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Screen> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Screen selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
