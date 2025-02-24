package com.ccm.dao;

import java.util.ArrayList;

import model.keyboard;

public class KeyBoardDAO implements DAOInterface<keyboard>{
	public static KeyBoardDAO getInstance() {
		return new KeyBoardDAO();
	}

	@Override
	public int insert(keyboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(keyboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(keyboard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<keyboard> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public keyboard selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
