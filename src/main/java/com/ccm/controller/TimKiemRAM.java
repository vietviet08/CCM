package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.RAMDAO;
import com.ccm.model.RAM;

public class TimKiemRAM {

	public static ArrayList<RAM> byID(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getIdSanPham().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	
	public static ArrayList<RAM> byIDRAM(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getIdRam().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	
	
	public static ArrayList<RAM> byTen(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getTenRam().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	public static ArrayList<RAM> byLoai(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getLoai().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	public static ArrayList<RAM> byDungLuong(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getDungLuong().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	public static ArrayList<RAM> byBus(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (RAM.getBus().toLowerCase().contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	
	public static ArrayList<RAM> byTonKho(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (String.valueOf(RAM.getTonkho()).contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	
	public static ArrayList<RAM> byGia(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> listRAM = RAMDAO.getInstance().selectAll();

		for (RAM RAM : listRAM) {
			if (String.valueOf(RAM.getDonGia()).contains(key.toLowerCase())) {
				list.add(RAM);
			}
		}
		return list;
	}
	
}
