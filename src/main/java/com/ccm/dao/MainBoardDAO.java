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
import com.ccm.model.MainBoard;
import com.ccm.view.mainboard.CapNhatMainboard;
import com.ccm.view.mainboard.ThemMainboard;

public class MainBoardDAO implements DAOInterface<MainBoard> {
	public static MainBoardDAO getInstance() {
		return new MainBoardDAO();
	}

	@Override
	public int insert(MainBoard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into MainBoard (idsanpham, idMainBoard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh, img) values (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemMainboard.getInsert()));
				ps.setBlob(11, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertIMGURL(MainBoard t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into MainBoard (idsanpham, idMainBoard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh, img) values (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			check = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(MainBoard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into MainBoard (idsanpham, idMainBoard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh) values (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(MainBoard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update MainBoard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ?, img = ? where idMainBoard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatMainboard.getInsert()));
				ps.setBlob(9, is);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ps.setString(10, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(MainBoard t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update MainBoard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ?, img = ? where idMainBoard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(9, is);

			ps.setString(10, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(MainBoard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update MainBoard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ? where idMainBoard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());
			ps.setString(9, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE MainBoard SET  tonkho = tonkho + ? WHERE idMainBoard = ?;";
			if (nhapHang == false)
				sql = "UPDATE MainBoard SET  tonkho = tonkho - ? WHERE idMainBoard = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("mba")) {

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
	public int delete(MainBoard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "delete from MainBoard where idMainBoard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdMainboard());
			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<MainBoard> selectAll() {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from MainBoard;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MainBoard mb = new MainBoard(rs.getString("idsanpham"), rs.getString("idMainBoard"),
						rs.getString("tenmain"), rs.getString("tenhang"), rs.getString("hotrocpu"),
						rs.getString("hotroram"), rs.getString("kichthuoc"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));

				list.add(mb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MainBoard selectById(String t) {
		MainBoard mb = null;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from MainBoard where idMainBoard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mb = new MainBoard(rs.getString("idsanpham"), rs.getString("idMainBoard"), rs.getString("tenmain"),
						rs.getString("tenhang"), rs.getString("hotrocpu"), rs.getString("hotroram"),
						rs.getString("kichthuoc"), rs.getInt("tonkho"), rs.getDouble("dongia"), rs.getString("baohanh"),
						rs.getBlob("img"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mb;

	}

	public ArrayList<MainBoard> selectNhapHang() {
		ArrayList<MainBoard> c = new ArrayList<MainBoard>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM MainBoard;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MainBoard mb = new MainBoard(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				c.add(mb);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<MainBoard> selectByIdSanPham(String t) {
		ArrayList<MainBoard> list = new ArrayList<MainBoard>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM MainBoard WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MainBoard mb = new MainBoard(rs.getString("idsanpham"), rs.getString("idMainBoard"),
						rs.getString("tenmain"), rs.getString("tenhang"), rs.getString("hotrocpu"),
						rs.getString("hotroram"), rs.getString("kichthuoc"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				list.add(mb);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(MainBoard.tonkho) AS total\r\n" + "FROM MainBoard";
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
