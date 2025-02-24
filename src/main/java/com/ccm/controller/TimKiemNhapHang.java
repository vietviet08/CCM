package com.ccm.controller;

import java.util.ArrayList;

import com.ccm.dao.CaseDAO;
import com.ccm.dao.CPUDAO;
import com.ccm.dao.HDDDAO;
import com.ccm.dao.MainBoardDAO;
import com.ccm.dao.PSUDAO;
import com.ccm.dao.RAMDAO;
import com.ccm.dao.SSDDAO;
import com.ccm.dao.VGADAO;
import com.ccm.model.Case;
import com.ccm.model.CPU;
import com.ccm.model.HDD;
import com.ccm.model.MainBoard;
import com.ccm.model.PSU;
import com.ccm.model.RAM;
import com.ccm.model.SSD;
import com.ccm.model.VGA;

public class TimKiemNhapHang {
	public static ArrayList<CPU> byCPU(String key) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		ArrayList<CPU> CPUs = CPUDAO.getInstance().selectAll();
		for (CPU CPU : CPUs) {
			if (CPU.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| CPU.getIdCpu().toLowerCase().contains(key.toLowerCase())
					|| CPU.getNameCpu().toLowerCase().contains(key.toLowerCase())
					|| CPU.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(CPU.getTonKho()).contains(key) || String.valueOf(CPU.getDonGia()).contains(key))
				list.add(CPU);
		}
		return list;
	}

	public static ArrayList<RAM> byRAM(String key) {
		ArrayList<RAM> list = new ArrayList<RAM>();
		ArrayList<RAM> RAMs = RAMDAO.getInstance().selectAll();
		for (RAM RAM : RAMs) {
			if (RAM.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| RAM.getIdRam().toLowerCase().contains(key.toLowerCase())
					|| RAM.getTenRam().toLowerCase().contains(key.toLowerCase())
					|| RAM.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(RAM.getTonkho()).contains(key) || String.valueOf(RAM.getDonGia()).contains(key))
				list.add(RAM);
		}
		return list;
	}

	public static ArrayList<VGA> byVGA(String key) {
		ArrayList<VGA> list = new ArrayList<VGA>();
		ArrayList<VGA> VGAs = VGADAO.getInstance().selectAll();
		for (VGA VGA : VGAs) {
			if (VGA.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| VGA.getIdVga().toLowerCase().contains(key.toLowerCase())
					|| VGA.getTenVGA().toLowerCase().contains(key.toLowerCase())
					|| VGA.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(VGA.getTonKho()).contains(key) || String.valueOf(VGA.getDonGia()).contains(key))
				list.add(VGA);
		}
		return list;
	}

	public static ArrayList<MainBoard> byMainboard(String key) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		ArrayList<MainBoard> MainBoards = MainBoardDAO.getInstance().selectAll();
		for (MainBoard MainBoard : MainBoards) {
			if (MainBoard.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| MainBoard.getIdMainboard().toLowerCase().contains(key.toLowerCase())
					|| MainBoard.getTenMain().toLowerCase().contains(key.toLowerCase())
					|| MainBoard.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(MainBoard.getTonKho()).contains(key)
					|| String.valueOf(MainBoard.getDonGia()).contains(key))
				list.add(MainBoard);
		}
		return list;
	}

	public static ArrayList<Case> byCase(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> Cases = CaseDAO.getInstance().selectAll();
		for (Case Case : Cases) {
			if (Case.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| Case.getIdCase().toLowerCase().contains(key.toLowerCase())
					|| Case.getTenCase().toLowerCase().contains(key.toLowerCase())
					|| Case.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(Case.getTonKho()).contains(key) || String.valueOf(Case.getGia()).contains(key))
				list.add(Case);
		}
		return list;
	}

	public static ArrayList<PSU> byNguon(String key) {
		ArrayList<PSU> list = new ArrayList<PSU>();
		ArrayList<PSU> PSUs = PSUDAO.getInstance().selectAll();
		for (PSU PSU : PSUs) {
			if (PSU.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| PSU.getIdNguon().toLowerCase().contains(key.toLowerCase())
					|| PSU.getTenNguon().toLowerCase().contains(key.toLowerCase())
					|| PSU.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(PSU.getTonKho()).contains(key) || String.valueOf(PSU.getDonGia()).contains(key))
				list.add(PSU);
		}
		return list;
	}

	public static ArrayList<SSD> bySSD(String key) {
		ArrayList<SSD> list = new ArrayList<SSD>();
		ArrayList<SSD> SSDs = SSDDAO.getInstance().selectAll();
		for (SSD SSD : SSDs) {
			if (SSD.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| SSD.getIdSdd().toLowerCase().contains(key.toLowerCase())
					|| SSD.getTenSsd().toLowerCase().contains(key.toLowerCase())
					|| SSD.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(SSD.getTonKho()).contains(key) || String.valueOf(SSD.getGia()).contains(key))
				list.add(SSD);
		}
		return list;
	}

	public static ArrayList<HDD> byHDD(String key) {
		ArrayList<HDD> list = new ArrayList<HDD>();
		ArrayList<HDD> HDDs = HDDDAO.getInstance().selectAll();
		for (HDD HDD : HDDs) {
			if (HDD.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| HDD.getIdhHdd().toLowerCase().contains(key.toLowerCase())
					|| HDD.getTenHdd().toLowerCase().contains(key.toLowerCase())
					|| HDD.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(HDD.getTonKho()).contains(key) || String.valueOf(HDD.getGia()).contains(key))
				list.add(HDD);
		}
		return list;
	}

}
