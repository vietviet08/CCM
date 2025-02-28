package com.ccm.view;

import com.ccm.chart.ModelPieChart;
import com.ccm.chart.PieChart;
import com.ccm.chart.PieChart.PeiChartType;
import com.ccm.color.SetColor;
import com.ccm.controller.FormatToVND;
import com.ccm.dao.*;
import com.ccm.decor.PanelRoundThongKe;
import com.ccm.font.SetFont;
import com.ccm.model.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeForm extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel labelIMG_1st;
    private JLabel labelGia_1st;
    private JLabel labelTenSP_1st;
    private JLabel labelGia_3rd;
    private JLabel labelTenSP_3rd;
    private JLabel labelIMG_3rd;
    private JLabel labelTenSP_2nd;
    private JLabel labelIMG_2nd;
    private JLabel labelGia_2nd;
    private JLabel labelLuotBan_2nd;
    private JLabel labelLuotBan_1st;
    private JLabel labelLuotBan_3rd;
    private JLabel labelName;
    private JTable table;
    private JLabel labelLoaiSP;
    private JLabel labelTongDong;
    private JLabel labelTongTonKho;
    private JLabel labelTongSP;
    private JLabel labelTongLuotBan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThongKeForm fRAMe = new ThongKeForm();
                    fRAMe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the fRAMe.
     */
    public ThongKeForm() {
        setBounds(100, 100, 1170, 730);
        getContentPane().setLayout(null);

        PanelRoundThongKe panel = new PanelRoundThongKe();
        panel.setColorTo(new Color(42, 8, 69));
        panel.setColorFrom(new Color(100, 65, 165));
        panel.setRoundTopRight(40);
        panel.setRoundTopLeft(40);
        panel.setRoundBottomRight(40);
        panel.setRoundBottomLeft(40);
        panel.setBounds(22, 26, 260, 140);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel tfLoaiSP = new JLabel("Tổng sản phẩm");
        tfLoaiSP.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP.setForeground(SetColor.whiteFont);
        tfLoaiSP.setFont(SetFont.fontThongKe());
        tfLoaiSP.setBounds(0, 0, 172, 68);
        panel.add(tfLoaiSP);

        JLabel tfLoaiSP_1 = new JLabel("");
        tfLoaiSP_1.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-product-75.png")));
        tfLoaiSP_1.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1.setFont(null);
        tfLoaiSP_1.setBounds(156, 26, 94, 68);
        panel.add(tfLoaiSP_1);

        JLabel tfLoaiSP_1_1 = new JLabel(
                String.valueOf(CPUDAO.getInstance().selectAll().size() + RAMDAO.getInstance().selectAll().size()
                        + VGADAO.getInstance().selectAll().size() + CaseDAO.getInstance().selectAll().size()
                        + MainBoardDAO.getInstance().selectAll().size() + PSUDAO.getInstance().selectAll().size()
                        + SSDDAO.getInstance().selectAll().size() + HDDDAO.getInstance().selectAll().size()));
        tfLoaiSP_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_1.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_1.setFont(SetFont.fontThongKe1());
        tfLoaiSP_1_1.setBounds(32, 68, 94, 34);

        panel.add(tfLoaiSP_1_1);

        PanelRoundThongKe panel_1 = new PanelRoundThongKe();
        panel_1.setRoundTopRight(40);
        panel_1.setRoundTopLeft(40);
        panel_1.setRoundBottomRight(40);
        panel_1.setRoundBottomLeft(40);
        panel_1.setColorTo(new Color(248, 54, 0));
        panel_1.setColorFrom(new Color(254, 140, 0));
        panel_1.setBounds(305, 26, 260, 140);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel tfLoaiSP_1_1_1 = new JLabel(String.valueOf(KhachHangDAO.getInstance().selectAll().size()));
        tfLoaiSP_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_1_1.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_1_1.setFont(SetFont.fontThongKe1());
        tfLoaiSP_1_1_1.setBounds(32, 79, 94, 34);
        panel_1.add(tfLoaiSP_1_1_1);

        JLabel lblKhchHng = new JLabel("Khách hàng");
        lblKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
        lblKhchHng.setForeground(new Color(254, 254, 254));
        lblKhchHng.setFont(SetFont.fontThongKe());
        lblKhchHng.setBounds(0, 11, 172, 43);
        panel_1.add(lblKhchHng);

        JLabel tfLoaiSP_1_2 = new JLabel("");
        tfLoaiSP_1_2.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-group-75.png")));
        tfLoaiSP_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_2.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_2.setFont(null);
        tfLoaiSP_1_2.setBounds(156, 37, 94, 68);
        panel_1.add(tfLoaiSP_1_2);

        JLabel lblThamGia = new JLabel("đã tham gia");
        lblThamGia.setHorizontalAlignment(SwingConstants.CENTER);
        lblThamGia.setForeground(new Color(254, 254, 254));
        lblThamGia.setFont(SetFont.fontThongKe());
        lblThamGia.setBounds(0, 37, 172, 43);
        panel_1.add(lblThamGia);

        PanelRoundThongKe panel_1_1 = new PanelRoundThongKe();
        panel_1_1.setRoundTopRight(40);
        panel_1_1.setRoundTopLeft(40);
        panel_1_1.setRoundBottomRight(40);
        panel_1_1.setRoundBottomLeft(40);
        panel_1_1.setColorTo(new Color(0, 114, 225));
        panel_1_1.setColorFrom(new Color(0, 198, 225));
        panel_1_1.setBounds(880, 26, 260, 140);
        getContentPane().add(panel_1_1);
        panel_1_1.setLayout(null);

        JLabel tfLoaiSP_1_1_3 = new JLabel(String.valueOf(PhieuXuatDAO.getInstance().selectAll().size()));
        tfLoaiSP_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_1_3.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_1_3.setFont(SetFont.fontThongKe1());
        tfLoaiSP_1_1_3.setBounds(32, 79, 94, 34);
        panel_1_1.add(tfLoaiSP_1_1_3);

        JLabel lblTngnXut = new JLabel("Tổng đơn xuất");
        lblTngnXut.setHorizontalAlignment(SwingConstants.CENTER);
        lblTngnXut.setForeground(new Color(254, 254, 254));
        lblTngnXut.setFont(SetFont.fontThongKe());
        lblTngnXut.setBounds(0, 11, 172, 68);
        panel_1_1.add(lblTngnXut);

        JLabel tfLoaiSP_1_4 = new JLabel("");
        tfLoaiSP_1_4.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-detail-75 (1).png")));
        tfLoaiSP_1_4.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_4.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_4.setFont(null);
        tfLoaiSP_1_4.setBounds(156, 30, 94, 75);
        panel_1_1.add(tfLoaiSP_1_4);

        PanelRoundThongKe panel_2 = new PanelRoundThongKe();
        panel_2.setRoundTopRight(40);
        panel_2.setRoundTopLeft(40);
        panel_2.setRoundBottomRight(40);
        panel_2.setRoundBottomLeft(40);
        panel_2.setColorTo(new Color(154, 132, 120));
        panel_2.setColorFrom(new Color(30, 19, 12));
        panel_2.setBounds(592, 26, 260, 140);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel tfLoaiSP_1_1_2 = new JLabel(String.valueOf(PhieuNhapDAO.getInstance().selectAll().size()));
        tfLoaiSP_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_1_2.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_1_2.setFont(SetFont.fontThongKe1());
        tfLoaiSP_1_1_2.setBounds(32, 79, 94, 34);
        panel_2.add(tfLoaiSP_1_1_2);

        JLabel lblTngnNhp = new JLabel("Tổng đơn nhập");
        lblTngnNhp.setHorizontalAlignment(SwingConstants.CENTER);
        lblTngnNhp.setForeground(new Color(254, 254, 254));
        lblTngnNhp.setFont(SetFont.fontThongKe());
        lblTngnNhp.setBounds(0, 11, 172, 68);
        panel_2.add(lblTngnNhp);

        JLabel tfLoaiSP_1_3 = new JLabel("");
        tfLoaiSP_1_3.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-detail-75.png")));
        tfLoaiSP_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        tfLoaiSP_1_3.setForeground(new Color(254, 254, 254));
        tfLoaiSP_1_3.setFont(null);
        tfLoaiSP_1_3.setBounds(156, 37, 94, 68);
        panel_2.add(tfLoaiSP_1_3);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(22, 197, 1118, 493);
        getContentPane().add(tabbedPane);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        tabbedPane.addTab("Sản phẩm nổi bật", null, panel_3, null);
        panel_3.setLayout(null);

        labelIMG_1st = new JLabel("Ảnh sản phẩm");
        labelIMG_1st.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG_1st.setBounds(420, 43, 280, 280);
        panel_3.add(labelIMG_1st);

        labelTenSP_1st = new JLabel("Tên sản phẩm");
        labelTenSP_1st.setHorizontalAlignment(SwingConstants.CENTER);
        labelTenSP_1st.setFont(SetFont.fontCategory());
        labelTenSP_1st.setBounds(420, 334, 280, 21);
        panel_3.add(labelTenSP_1st);

        labelGia_1st = new JLabel("1999999vnd");
        labelGia_1st.setHorizontalAlignment(SwingConstants.CENTER);
        labelGia_1st.setFont(SetFont.font1());
        labelGia_1st.setForeground(SetColor.redB);
        labelGia_1st.setBounds(420, 366, 280, 21);
        panel_3.add(labelGia_1st);

        labelIMG_3rd = new JLabel("Ảnh sản phẩm");
        labelIMG_3rd.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG_3rd.setBounds(795, 43, 230, 230);
        panel_3.add(labelIMG_3rd);

        labelIMG_2nd = new JLabel("Ảnh sản phẩm");
        labelIMG_2nd.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG_2nd.setBounds(60, 43, 230, 230);
        panel_3.add(labelIMG_2nd);

        labelTenSP_3rd = new JLabel("Tên sản phẩm");
        labelTenSP_3rd.setHorizontalAlignment(SwingConstants.CENTER);
        labelTenSP_3rd.setFont(SetFont.fontCategory().deriveFont(13f));
        labelTenSP_3rd.setBounds(795, 284, 230, 29);
        panel_3.add(labelTenSP_3rd);

        labelTenSP_2nd = new JLabel("Tên sản phẩm");
        labelTenSP_2nd.setHorizontalAlignment(SwingConstants.CENTER);
        labelTenSP_2nd.setFont(SetFont.fontCategory().deriveFont(13f));
        labelTenSP_2nd.setBounds(60, 284, 230, 29);
        panel_3.add(labelTenSP_2nd);

        labelGia_2nd = new JLabel("1999999vnd");
        labelGia_2nd.setHorizontalAlignment(SwingConstants.CENTER);
        labelGia_2nd.setForeground(new Color(220, 19, 46));
        labelGia_2nd.setFont(SetFont.font1().deriveFont(13f));
        labelGia_2nd.setBounds(60, 314, 230, 29);
        panel_3.add(labelGia_2nd);

        labelGia_3rd = new JLabel("1999999vnd");
        labelGia_3rd.setHorizontalAlignment(SwingConstants.CENTER);
        labelGia_3rd.setForeground(new Color(220, 19, 46));
        labelGia_3rd.setFont(SetFont.font1().deriveFont(13f));
        labelGia_3rd.setBounds(795, 314, 230, 29);
        panel_3.add(labelGia_3rd);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-2nd-place-50.png")));
        lblNewLabel.setBounds(133, 344, 85, 73);
        panel_3.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-1st-place-70.png")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(515, 392, 85, 73);
        panel_3.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(ThongKeForm.class.getResource("/icon/icons8-3rd-place-50.png")));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(868, 344, 85, 73);
        panel_3.add(lblNewLabel_1_1);

        labelLuotBan_2nd = new JLabel("Tổng lượt bán");
        labelLuotBan_2nd.setHorizontalAlignment(SwingConstants.CENTER);
        labelLuotBan_2nd.setFont(SetFont.font1().deriveFont(13f));
        labelLuotBan_2nd.setBounds(60, 11, 230, 29);
        panel_3.add(labelLuotBan_2nd);

        labelLuotBan_3rd = new JLabel("Tổng lượt bán");
        labelLuotBan_3rd.setHorizontalAlignment(SwingConstants.CENTER);
        labelLuotBan_3rd.setFont(SetFont.font1().deriveFont(13f));
        labelLuotBan_3rd.setBounds(795, 11, 230, 29);
        panel_3.add(labelLuotBan_3rd);

        labelLuotBan_1st = new JLabel("Tổng lượt bán");
        labelLuotBan_1st.setHorizontalAlignment(SwingConstants.CENTER);
        labelLuotBan_1st.setFont(SetFont.font1());
        labelLuotBan_1st.setBounds(420, 11, 280, 29);
        panel_3.add(labelLuotBan_1st);

        ArrayList<ChiTietPhieu> spBanChay = ChiTietPhieuXuatDAO.getInstance().sanPhamBanChay();
        String idsp_1st = spBanChay.get(0).getIdRieng();

        setDetalProduct(idsp_1st, spBanChay.get(0).getSoLuong(), labelIMG_1st, labelTenSP_1st, labelGia_1st,
                labelLuotBan_1st);

        String idsp_2nd = spBanChay.get(1).getIdRieng();
        setDetalProduct(idsp_2nd, spBanChay.get(1).getSoLuong(), labelIMG_2nd, labelTenSP_2nd, labelGia_2nd,
                labelLuotBan_2nd);

        String idsp_3rd = spBanChay.get(2).getIdRieng();
        setDetalProduct(idsp_3rd, spBanChay.get(2).getSoLuong(), labelIMG_3rd, labelTenSP_3rd, labelGia_3rd,
                labelLuotBan_3rd);
        /*************************/
        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("Thống kê nhập xuất", null, panel_4, null);
        panel_4.setLayout(null);

        JPanel panelLineChart = new JPanel();
        panelLineChart.setBounds(10, 11, 976, 443);
        panel_4.add(panelLineChart);
        panelLineChart.setLayout(null);


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "Tháng 1");
        dataset.setValue(150, "Amount", "Tháng 2");
        dataset.setValue(18, "Amount", "Tháng 3");
        dataset.setValue(100, "Amount", "Tháng 4");
        dataset.setValue(80, "Amount", "Tháng 5");
        dataset.setValue(250, "Amount", "Tháng 6");
        dataset.setValue(300, "Amount", "Tháng 7");
        dataset.setValue(220, "Amount", "Tháng 8");
        dataset.setValue(150, "Amount", "Tháng 9");
        dataset.setValue(460, "Amount", "Tháng 10");
        dataset.setValue(440, "Amount", "Tháng 11");
        dataset.setValue(390, "Amount", "Tháng 12");

        dataset.setGroup(new DatasetGroup("test"));

        // create chart
        JFreeChart linechart = ChartFactory.createLineChart("", "Tháng", "Tổng giá", dataset, PlotOrientation.VERTICAL,
                false, true, false);

        // create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();

        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        // create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        // create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        lineChartPanel.setBounds(0, 0, 976, 443);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel);
        panelLineChart.validate();
        /*************************/

        JPanel panel_5 = new JPanel();
        tabbedPane.addTab("Thống kê sản phẩm", null, panel_5, null);
        panel_5.setLayout(null);

        ModelPieChart CPU = new ModelPieChart();
        CPU.setName("CPU");
        CPU.setValues(CPUDAO.getInstance().selectAll().size());
        CPU.setColor(new Color(236, 112, 99));
        ModelPieChart RAM = new ModelPieChart();
        RAM.setName("RAM");
        RAM.setValues(RAMDAO.getInstance().selectAll().size());
        RAM.setColor(new Color(165, 105, 189));
        ModelPieChart VGA = new ModelPieChart();
        VGA.setName("VGA");
        VGA.setValues(VGADAO.getInstance().selectAll().size());
        VGA.setColor(new Color(93, 173, 226));
        ModelPieChart Casee = new ModelPieChart();
        Casee.setName("CASE");
        Casee.setValues(CaseDAO.getInstance().selectAll().size());
        Casee.setColor(new Color(69, 179, 157));
        ModelPieChart mb = new ModelPieChart();
        mb.setName("Mainboard");
        mb.setValues(MainBoardDAO.getInstance().selectAll().size());
        mb.setColor(new Color(247, 220, 111));
        ModelPieChart PSU = new ModelPieChart();
        PSU.setName("Nguồn");
        PSU.setValues(PSUDAO.getInstance().selectAll().size());
        PSU.setColor(new Color(235, 152, 78));
        ModelPieChart SSD = new ModelPieChart();
        SSD.setName("SSD");
        SSD.setValues(SSDDAO.getInstance().selectAll().size());
        SSD.setColor(new Color(202, 207, 210));
        ModelPieChart HDD = new ModelPieChart();
        HDD.setName("HDD");
        HDD.setValues(HDDDAO.getInstance().selectAll().size());
        HDD.setColor(new Color(86, 101, 115));

        PieChart chart = new PieChart();
        chart.setChartType(PeiChartType.DONUT_CHART);
        chart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chart.getSelectedIndex() == 0) {
                    labelLoaiSP.setText("CPU");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("CPU").size() + "");
                    labelTongSP.setText(CPUDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(CPUDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("CPU") + "");
                } else if (chart.getSelectedIndex() == 1) {
                    labelLoaiSP.setText("RAM");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("RAM").size() + "");
                    labelTongSP.setText(RAMDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(RAMDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("RAM") + "");
                } else if (chart.getSelectedIndex() == 2) {
                    labelLoaiSP.setText("VGA");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("VGA").size() + "");
                    labelTongSP.setText(VGADAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(VGADAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("VGA") + "");
                } else if (chart.getSelectedIndex() == 4) {
                    labelLoaiSP.setText("Mainboard");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("main").size() + "");
                    labelTongSP.setText(MainBoardDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(MainBoardDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("main") + "");
                } else if (chart.getSelectedIndex() == 5) {
                    labelLoaiSP.setText("PSU");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("PSU").size() + "");
                    labelTongSP.setText(PSUDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(PSUDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("PSU") + "");
                } else if (chart.getSelectedIndex() == 3) {
                    labelLoaiSP.setText("CASE");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("Case").size() + "");
                    labelTongSP.setText(CaseDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(CaseDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("Cases") + "");
                } else if (chart.getSelectedIndex() == 6) {
                    labelLoaiSP.setText("SSD");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("SSD").size() + "");
                    labelTongSP.setText(SSDDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(SSDDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("SSD") + "");
                } else if (chart.getSelectedIndex() == 7) {
                    labelLoaiSP.setText("HDD");
                    labelTongDong.setText(SanPhamDAO.getIDSanPham("HDD").size() + "");
                    labelTongSP.setText(HDDDAO.getInstance().selectAll().size() + "");
                    labelTongTonKho.setText(HDDDAO.tongTonKho() + "");
                    labelTongLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuat("HDD") + "");
                }
            }
        });
        chart.setBounds(0, 0, 400, 400);

        chart.addData(CPU);
        chart.addData(RAM);
        chart.addData(VGA);
        chart.addData(Casee);
        chart.addData(mb);
        chart.addData(PSU);
        chart.addData(SSD);
        chart.addData(HDD);

        panel_5.add(chart);

        labelName = new JLabel("Loại sản phẩm:");
        labelName.setFont(SetFont.fontCategory());
        labelName.setBounds(425, 52, 166, 39);
        panel_5.add(labelName);

        JLabel lblTngCcLoi = new JLabel("Tổng dòng sản phẩm:");
        lblTngCcLoi.setFont(SetFont.fontCategory());
        lblTngCcLoi.setBounds(425, 102, 166, 39);
        panel_5.add(lblTngCcLoi);

        JLabel lblTngTnKho = new JLabel("Tổng các sản phẩm:");
        lblTngTnKho.setFont(SetFont.fontCategory());
        lblTngTnKho.setBounds(425, 152, 166, 39);
        panel_5.add(lblTngTnKho);

        JLabel lblTngLtBn = new JLabel("Tổng lượt bán:");
        lblTngLtBn.setFont(SetFont.fontCategory());
        lblTngLtBn.setBounds(425, 252, 166, 39);
        panel_5.add(lblTngLtBn);

        JLabel lblTngTnKho_1 = new JLabel("Tổng tồn kho:");
        lblTngTnKho_1.setFont(SetFont.fontCategory());
        lblTngTnKho_1.setBounds(425, 202, 166, 39);
        panel_5.add(lblTngTnKho_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(672, 32, 415, 325);
        panel_5.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"New column", "New column", "New column", "New column"}));
        scrollPane.setViewportView(table);

        labelTongDong = new JLabel("0");
        labelTongDong.setFont(SetFont.fontCategory());
        labelTongDong.setBounds(601, 102, 61, 39);
        panel_5.add(labelTongDong);

        labelLoaiSP = new JLabel("Name");
        labelLoaiSP.setFont(SetFont.fontCategory());
        labelLoaiSP.setBounds(601, 52, 61, 39);
        panel_5.add(labelLoaiSP);

        labelTongSP = new JLabel("0");
        labelTongSP.setFont(SetFont.fontCategory());
        labelTongSP.setBounds(601, 152, 61, 39);
        panel_5.add(labelTongSP);

        labelTongTonKho = new JLabel("0");
        labelTongTonKho.setFont(SetFont.fontCategory());
        labelTongTonKho.setBounds(601, 202, 61, 39);
        panel_5.add(labelTongTonKho);

        labelTongLuotBan = new JLabel("0");
        labelTongLuotBan.setFont(SetFont.fontCategory());
        labelTongLuotBan.setBounds(601, 252, 61, 39);
        panel_5.add(labelTongLuotBan);

    }

    private void setDetalProduct(String idsp, int luotban, JLabel labelIMG, JLabel labelTenSp, JLabel labelGia,
                                 JLabel labelLuotBan) {
        if (idsp.contains("CPU")) {
            CPU CPU = CPUDAO.getInstance().selectById(idsp);
            Blob blob = CPU.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(CPU.getNameCpu());
                labelGia.setText(FormatToVND.vnd(CPU.getDonGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("r")) {
            RAM RAM = RAMDAO.getInstance().selectById(idsp);
            Blob blob = RAM.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(RAM.getTenRam());
                labelGia.setText(FormatToVND.vnd(RAM.getDonGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("VGA")) {
            VGA VGA = VGADAO.getInstance().selectById(idsp);
            Blob blob = VGA.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(VGA.getTenVGA());
                labelGia.setText(FormatToVND.vnd(VGA.getDonGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("Case")) {
            Case c = CaseDAO.getInstance().selectById(idsp);
            Blob blob = c.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(c.getTenCase());
                labelGia.setText(FormatToVND.vnd(c.getGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("mba")) {
            MainBoard mb = MainBoardDAO.getInstance().selectById(idsp);
            Blob blob = mb.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(mb.getTenMain());
                labelGia.setText(FormatToVND.vnd(mb.getDonGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("PSU")) {
            PSU PSU = PSUDAO.getInstance().selectById(idsp);
            Blob blob = PSU.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(PSU.getTenNguon());
                labelGia.setText(FormatToVND.vnd(PSU.getDonGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("HDD")) {
            HDD HDD = HDDDAO.getInstance().selectById(idsp);
            Blob blob = HDD.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(HDD.getTenHdd());
                labelGia.setText(FormatToVND.vnd(HDD.getGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idsp.contains("SSD")) {
            SSD SSD = SSDDAO.getInstance().selectById(idsp);
            Blob blob = SSD.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG_1st.getWidth(), labelIMG_1st.getHeight(),
                        Image.SCALE_SMOOTH);
                labelIMG.setIcon(ii = new ImageIcon(i));
                labelTenSp.setText(SSD.getTenSsd());
                labelGia.setText(FormatToVND.vnd(SSD.getGia()));
                labelLuotBan.setText("Tổng lượt bán: " + luotban);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
