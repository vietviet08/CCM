package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.SSDDAO;
import com.ccm.model.SSD;

public class TimKiemSSD implements TimKiemInterface<SSD> {

	public static TimKiemSSD getInstance() {
		return new TimKiemSSD();
	}

	@Override
	public ArrayList<SSD> byIDSP(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byIDRieng(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getIdSdd().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byTen(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getTenSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byHang(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byTonKho(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (String.valueOf(SSD.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byGia(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (String.valueOf(SSD.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	@Override
	public ArrayList<SSD> byBaoHanh(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getBaoHanh().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	public ArrayList<SSD> byDungLuong(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getDungLuong().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	public ArrayList<SSD> byLoai(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getLoai().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	public ArrayList<SSD> byTocDoDoc(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getTocDoDoc().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

	public ArrayList<SSD> byTocDoGhi(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs)
			if (SSD.getTocDoGhi().toLowerCase().contains(key.toLowerCase()))
				list.add(SSD);
		return list;
	}

}
