package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.CPUDAO;
import com.ccm.model.CPU;

public class TimKiemCPU {
	public static ArrayList<CPU> byID(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getIdSanPham().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}
	
	public static ArrayList<CPU> byIDCPU(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getIdCpu().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}	

	public static ArrayList<CPU> byTen(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getNameCpu().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> byXungNhip(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getXungNhip().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> bySoNhan(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (String.valueOf(CPU.getSoNhan()).contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> bySoLuong(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (String.valueOf(CPU.getSoLuong()).contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> byDienNang(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getDienNangTieuThu().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> byBoNhoDem(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (CPU.getBoNhoDem().toLowerCase().contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}
	
	public static ArrayList<CPU> byTonKho(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (String.valueOf(CPU.getTonKho()).contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}

	public static ArrayList<CPU> byGia(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> listCPU = CPUDAO.getInstance().selectAll();
		for (CPU CPU : listCPU) {
			if (String.valueOf(CPU.getDonGia()).contains(key.toLowerCase())) {
				list.add(CPU);
			}
		}
		return list;
	}
}
