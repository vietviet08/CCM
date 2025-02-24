package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.MainBoardDAO;
import com.ccm.model.MainBoard;

//"ID sản phẩm", "ID MainBoard", "Tên MainBoard", "Hãng", "Hỗ trợ CPU",
//"Hỗ trợ RAM", "Kích thước", "Tồn kho", "Đơn giá"

public class TimKiemMainboard {
	public static ArrayList<MainBoard> byIDSP(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byIDMB(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getIdMainboard().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byTen(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getTenMain().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byHang(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getTenHang().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byHoTroCPU(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getHoTroCPU().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byHoTroRAM(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getHoTroRAM().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byKichThuoc(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (mb.getKichThuoc().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byTonKho(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (String.valueOf(mb.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<MainBoard> byDonGia(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> mbs = MainBoardDAO.getInstance().selectAll();
		for (MainBoard mb : mbs) {
			if (String.valueOf(mb.getDonGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

}
