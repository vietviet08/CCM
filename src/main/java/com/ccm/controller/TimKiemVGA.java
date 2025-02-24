package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.VGADAO;
import com.ccm.model.VGA;

public class TimKiemVGA {
	public static ArrayList<VGA> byID(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (VGA.getIdSanPham().toLowerCase().contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}
	
	public static ArrayList<VGA> byIDVGA(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (VGA.getIdVga().toLowerCase().contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}

	public static ArrayList<VGA> byTen(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (VGA.getTenVGA().toLowerCase().contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}

	public static ArrayList<VGA> byHang(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (VGA.getHangVGA().toLowerCase().contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}

	public static ArrayList<VGA> byBoNho(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (VGA.getBoNho().toLowerCase().contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}
	
	public static ArrayList<VGA> byTonKho(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (String.valueOf(VGA.getTonKho()).contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}

	public static ArrayList<VGA> byGia(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> listram = VGADAO.getInstance().selectAll();

		for (VGA VGA : listram) {
			if (String.valueOf(VGA.getDonGia()).contains(key.toLowerCase())) {
				list.add(VGA);
			}
		}
		return list;
	}

}
