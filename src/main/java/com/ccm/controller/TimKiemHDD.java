package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.HDDDAO;
import com.ccm.model.HDD;

public class TimKiemHDD implements TimKiemInterface<HDD> {

	public static TimKiemHDD getInstance() {
		return new TimKiemHDD();
	}

	@Override
	public ArrayList<HDD> byIDSP(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byIDRieng(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getIdhHdd().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byTen(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getTenHdd().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byHang(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byTonKho(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (String.valueOf(HDD.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byGia(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (String.valueOf(HDD.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	@Override
	public ArrayList<HDD> byBaoHanh(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getBaoHanh().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	public ArrayList<HDD> byDungLuong(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getDungLuong().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	public ArrayList<HDD> byBoNhoDem(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getBoNhoDem().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

	public ArrayList<HDD> byTocDoVongQuay(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs)
			if (HDD.getTocDoVongQuay().toLowerCase().contains(key.toLowerCase()))
				list.add(HDD);
		return list;
	}

}
