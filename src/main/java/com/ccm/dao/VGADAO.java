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
import com.ccm.model.VGA;
import com.ccm.view.vga.CapNhatVGA;
import com.ccm.view.vga.ThemVGA;

public class VGADAO implements DAOInterface<VGA> {

	public static VGADAO getInstance() {
		return new VGADAO();
	}

	@Override
	public int insert(VGA t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangVGA, bonho, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemVGA.getInsert()));
				ps.setBlob(9, is);
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

	public int insertIMGURL(VGA t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangVGA, bonho, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(9, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(VGA t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO vga (idsanpham, idvga, tenvga, hangVGA, bonho, tonkho, dongia, baohanh) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdVga());
			ps.setString(3, t.getTenVGA());
			ps.setString(4, t.getHangVGA());
			ps.setString(5, t.getBoNho());
			ps.setInt(6, t.getTonKho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(VGA t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangVGA = ?, bonho = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatVGA.getInsert()));
				ps.setBlob(8, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ps.setString(9, t.getIdVga());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(VGA t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangVGA = ?, bonho = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());
			
			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(8, is);
			ps.setString(9, t.getIdVga());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(VGA t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE vga SET idsanpham = ?, tenvga = ?, hangVGA = ?, bonho = ?, tonkho = ?, dongia = ?, baohanh = ? WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenVGA());
			ps.setString(3, t.getHangVGA());
			ps.setString(4, t.getBoNho());
			ps.setInt(5, t.getTonKho());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());
			ps.setString(8, t.getIdVga());

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

			for (ChiTietPhieu productNhap : pn) {
				if (productNhap.getIdRieng().contains("VGA")) {

					String sql = "UPDATE vga SET  tonkho = tonkho + ? WHERE idvga = ?;";
					if(nhapHang == false)
						sql = "UPDATE vga SET  tonkho = tonkho - ? WHERE idvga = ?;";

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
	public int delete(VGA t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM vga WHERE idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<VGA> selectAll() {
		ArrayList<VGA> v = new ArrayList<>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				VGA VGA = new VGA(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getString("hangVGA"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
				v.add(VGA);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public ArrayList<VGA> selectNhapHang() {
		ArrayList<VGA> v = new ArrayList<>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				VGA VGA = new VGA(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				v.add(VGA);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public VGA selectById(String t) {
		VGA v = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM vga where idvga = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v = new VGA(rs.getString("idsanpham"), rs.getString("idvga"), rs.getString("tenvga"),
						rs.getString("hangVGA"), rs.getString("bonho"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}
	
	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(vga.tonkho) AS total\r\n" + "FROM vga";
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
