package com.ccm.dao;

import java.util.ArrayList;

import com.ccm.model.KeyBoard;

public class KeyBoardDAO implements DAOInterface<KeyBoard>{
	public static KeyBoardDAO getInstance() {
		return new KeyBoardDAO();
	}

	@Override
	public int insert(KeyBoard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(KeyBoard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KeyBoard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KeyBoard> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyBoard selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
