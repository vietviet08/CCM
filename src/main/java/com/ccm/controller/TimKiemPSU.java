package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.PSUDAO;
import com.ccm.model.PSU;

public class TimKiemPSU {
//	 "ID sản phẩm", "ID nguồn", "Tên nguồn", "Hãng", "Công suất",
//		"Chuẩn nguồn", "Kiểu dây", "Kích thước", "Tồn kho", "Giá"
	public static ArrayList<PSU> byIDSP(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byIDPSU(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getIdNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byTen(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getTenNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byHang(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byCongSuat(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getCongSuat().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byChuanNguon(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getChuanNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byKieuDay(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getKieuDay().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byKichThuoc(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (PSU.getKichThuoc().toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byTonKho(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (String.valueOf(PSU.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

	public static ArrayList<PSU> byDonGia(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs)
			if (String.valueOf(PSU.getDonGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(PSU);
		return list;
	}

}
