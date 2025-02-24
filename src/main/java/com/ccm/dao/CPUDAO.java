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
import com.ccm.model.CPU;
import com.ccm.model.ChiTietPhieu;
import com.ccm.view.cpu.CapNhatCPU;
import com.ccm.view.cpu.ThemCPU;

public class CPUDAO implements DAOInterface<CPU> {

	public static CPUDAO getInstance() {
		return new CPUDAO();
	}

	@Override
	public int insert(CPU t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO CPU (idsanpham, idCPU, tenCPU, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemCPU.getInsert()));
				ps.setBlob(12, is);
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

	@SuppressWarnings("deprecation")
	public int insertIMGURL(CPU t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO CPU (idsanpham, idCPU, tenCPU, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			InputStream is;
			URL url;
			url = new URL(stringUrl);
			is = url.openStream();
			ps.setBlob(12, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(CPU t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO CPU (idsanpham, idCPU, tenCPU, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem,tonkho, dongia, baohanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(CPU t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE CPU SET idsanpham = ?, tenCPU = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ?, img = ? WHERE idCPU = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatCPU.getInsert()));
				ps.setBlob(10, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ps.setString(11, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(CPU t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE CPU SET idsanpham = ?, tenCPU = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ?, img = ? WHERE idCPU = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			ps.setString(11, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(CPU t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE CPU SET idsanpham = ?, tenCPU = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ? WHERE idCPU = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());
			ps.setString(10, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

//	cần tạo method update số lượng sản phẩm khi được nhập hàng hoặc xuất hàng

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "";
			if (nhapHang) {
				sql = "UPDATE CPU SET  tonkho = tonkho + ? WHERE idCPU = ?;";

			} else
				sql = "UPDATE CPU SET  tonkho = tonkho - ? WHERE idCPU = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("CPU")) {

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
	public int delete(CPU t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM CPU WHERE idCPU = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<CPU> selectAll() {
		ArrayList<CPU> c = new ArrayList<CPU>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM CPU;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CPU chip = new CPU(rs.getString("idsanpham"), rs.getString("idCPU"), rs.getString("tenCPU"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<CPU> selectNhapHang() {
		ArrayList<CPU> c = new ArrayList<CPU>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM CPU;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CPU chip = new CPU(rs.getString("idsanpham"), rs.getString("idCPU"), rs.getString("tenCPU"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public CPU selectById(String t) {
		CPU c = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM CPU WHERE idCPU = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new CPU(rs.getString("idsanpham"), rs.getString("idCPU"), rs.getString("tenCPU"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public ArrayList<CPU> selectByIdSanPham(String t) {
		ArrayList<CPU> list = new ArrayList<CPU>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM CPU WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CPU c = new CPU(rs.getString("idsanpham"), rs.getString("idCPU"), rs.getString("tenCPU"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				list.add(c);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(CPU.tonkho) AS total\r\n" + "FROM CPU";
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
