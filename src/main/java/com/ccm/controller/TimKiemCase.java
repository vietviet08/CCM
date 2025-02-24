package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.CaseDAO;
import com.ccm.model.Case;

public class TimKiemCase implements TimKiemInterface<Case> {
//	"ID SP", "ID Case", "Tên case", "Hãng", "Loại case", "Chất liệu", "Kích thước mb",
//	"Tồn kho", "Giá" 

//	 if (c.getIdCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getTenCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getHangCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getLoaiCase().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getChatLieu().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (c.getKichThuocMainboard().toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (String.valueOf(c.getTonKho()).toLowerCase().contains(key.toLowerCase()))
//		list.add(c);
//	if (String.valueOf(c.getGia()).toLowerCase().contains(key.toLowerCase()))
//		list.add(c);

	public static TimKiemCase getInstance() {
		return new TimKiemCase();
	}

	public ArrayList<Case> byIDSP(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public ArrayList<Case> byTen(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getTenCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public ArrayList<Case> byHang(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getHangCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public ArrayList<Case> byLoai(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getLoaiCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public  ArrayList<Case> byChatLieu(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getChatLieu().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public  ArrayList<Case> byKichThuoc(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getKichThuocMainboard().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public ArrayList<Case> byTonKho(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (String.valueOf(c.getTonKho()).contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	public ArrayList<Case> byGia(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (String.valueOf(c.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	@Override
	public ArrayList<Case> byIDRieng(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> cases = CaseDAO.getInstance().selectAll();
		for (Case c : cases)
			if (c.getIdCase().toLowerCase().contains(key.toLowerCase()))
				list.add(c);
		return list;
	}

	@Override
	public ArrayList<Case> byBaoHanh(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
