package com.ccm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ccm.db.JDBCUntil;
import com.ccm.model.ChiTietPhieu;
import com.ccm.model.RAM;
import com.ccm.view.CapNhatRAM;
import com.ccm.view.ThemRAM;

public class RAMDAO implements DAOInterface<RAM> {

	public static RAMDAO getInstance() {
		return new RAMDAO();
	}

	@Override
	public int insert(RAM t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO RAM (idsanpham, idRAM, tenRAM, loaiRAM, dungluong, bus, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemRAM.getInsert()));
				ps.setBlob(10, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertIMGURL(RAM t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO RAM (idsanpham, idRAM, tenRAM, loaiRAM, dungluong, bus, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(RAM t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO RAM (idsanpham, idRAM, tenRAM, loaiRAM, dungluong, bus, tonkho, dongia, baohanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(RAM t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE RAM SET idsanpham = ?, tenRAM = ?, loaiRAM = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idRAM = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatRAM.getInsert()));
				ps.setBlob(9, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ps.setString(10, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(RAM t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE RAM SET idsanpham = ?, tenRAM = ?, loaiRAM = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idRAM = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(9, is);

			ps.setString(10, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(RAM t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE RAM SET idsanpham = ?, tenRAM = ?, loaiRAM = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ? WHERE idRAM = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE RAM SET tonkho = tonkho + ? WHERE idRAM = ? ;";
			if (nhapHang == false)
				sql = "UPDATE RAM SET tonkho = tonkho - ? WHERE idRAM = ? ;";

			for (ChiTietPhieu productNhap : pn) {
				if (productNhap.getIdRieng().contains("r")) {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, productNhap.getSoLuong());
					ps.setString(2, productNhap.getIdRieng());
					check = ps.executeUpdate();
				}
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(RAM t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FORM RAM WHERE idRAM = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<RAM> selectAll() {
		ArrayList<RAM> r = new ArrayList<RAM>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM RAM;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				RAM RAM = new RAM(rs.getString("idsanpham"), rs.getString("idRAM"), rs.getString("tenRAM"),
						rs.getString("loaiRAM"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				r.add(RAM);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public ArrayList<RAM> selectNhapHang() {
		ArrayList<RAM> list = new ArrayList<RAM>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM RAM;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				RAM RAM = new RAM(rs.getString("idsanpham"), rs.getString("idRAM"), rs.getString("tenRAM"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				list.add(RAM);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public RAM selectById(String t) {
		RAM r = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM RAM WHERE idRAM = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new RAM(rs.getString("idsanpham"), rs.getString("idRAM"), rs.getString("tenRAM"),
						rs.getString("loaiRAM"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(RAM.tonkho) AS total\r\n" + "FROM RAM";
		try {
			Connection con = JDBCUntil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tonkho = rs.getInt("total");
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tonkho;
	}

}
