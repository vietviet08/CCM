package com.ccm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ccm.db.JDBCUntil;
import com.ccm.model.ChiTietPhieu;
import com.ccm.model.HDD;
import com.ccm.view.CapNhatHDD;
import com.ccm.view.ThemHDD;

public class HDDDAO implements DAOInterface<HDD> {
	public static HDDDAO getInstance() {
		return new HDDDAO();
	}

	@Override
	public int insert(HDD t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into HDD (idsanpham, idHDD, tenHDD, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());
			InputStream is = new FileInputStream(new File(ThemHDD.getInsert()));
			ps.setBlob(11, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int insertIMGURL(HDD t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into HDD (idsanpham, idHDD, tenHDD, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int insertNotIMG(HDD t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into HDD (idsanpham, idHDD, tenHDD, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	@Override
	public int update(HDD t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update HDD set idsanpham = ?, tenHDD = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? where idHDD = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());
			InputStream is = new FileInputStream(new File(CapNhatHDD.getInsert()));
			ps.setBlob(10, is);

			ps.setString(11, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int updateIMGURL(HDD t, String stringUrl) {

		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update HDD set idsanpham = ?, tenHDD = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? where idHDD = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			ps.setString(11, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int updateNotIMG(HDD t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update HDD set idsanpham = ?, tenHDD = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ? where idHDD = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			ps.setString(10, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "UPDATE HDD SET  tonkho = tonkho + ? WHERE idHDD = ?;";
			if (nhapHang == false)
				sql = "UPDATE HDD SET  tonkho = tonkho - ? WHERE idHDD = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("HDD")) {

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
	public int delete(HDD t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from HDD where idHDD = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	@Override
	public ArrayList<HDD> selectAll() {
		ArrayList<HDD> list = new ArrayList<HDD>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from HDD";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
//			idsanpham, idHDD, tenHDD, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img
			while (rs.next()) {
				HDD HDD = new HDD(rs.getString("idsanpham"), rs.getString("idHDD"), rs.getString("tenHDD"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("bonhodem"),
						rs.getString("tocdovongquay"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
				list.add(HDD);
			}

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	@Override
	public HDD selectById(String t) {
		HDD HDD = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from HDD where idHDD = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();
//			idsanpham, idHDD, tenHDD, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img
			while (rs.next()) {
				HDD = new HDD(rs.getString("idsanpham"), rs.getString("idHDD"), rs.getString("tenHDD"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("bonhodem"),
						rs.getString("tocdovongquay"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return HDD;
	}
	
	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(HDD.tonkho) AS total\r\n" + "FROM HDD";
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
