package com.ccm.view.hdd;

import com.ccm.controller.Checked;
import com.ccm.controller.LoadIMGURL;
import com.ccm.dao.HDDDAO;
import com.ccm.dao.SanPhamDAO;
import com.ccm.decor.HoverButton;
import com.ccm.font.SetFont;
import com.ccm.model.HDD;
import com.ccm.model.Products;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class CapNhatHDD extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextField tften;
    private static JTextField tfHang;
    private static JTextField tfDungLuong;
    private static JTextField tfBoNhoDem;
    private static JTextField tfTocDoVongQuay;
    private static JTextField tfBaoHanh;
    private static JTextField tfGia;
    private static JTextField tfLink;
    private static JLabel labelIMG;
    private static String insert = "";
    private static JComboBox<String> comboBox_IDSP;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CapNhatHDD frame = new CapNhatHDD();
                    setDefaultText();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CapNhatHDD() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 792, 428);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        contentPane = new JPanel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(102, 125, 182), 0, getHeight(),
                        new Color(0, 130, 200));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }
        };
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID sản phẩm");
        lblNewLabel.setForeground(new Color(254, 254, 254));
        lblNewLabel.setFont(null);
        lblNewLabel.setBounds(21, 58, 112, 30);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("CẬP NHẬT HDD");
        lblNewLabel_2.setForeground(new Color(249, 231, 159));
        lblNewLabel_2.setFont(SetFont.fontTitle());
        lblNewLabel_2.setBounds(10, 11, 267, 36);
        contentPane.add(lblNewLabel_2);

        labelIMG = new JLabel("Ảnh HDD");
        labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
        labelIMG.setBounds(546, 58, 223, 230);
        contentPane.add(labelIMG);

        JButton btnUpload = new JButton("Upload");
        btnUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                insert = LoadIMGURL.loadIMGFromDirecory(labelIMG, insert);
            }
        });
        btnUpload.setFont(SetFont.font());
        btnUpload.setBorder(null);
        btnUpload.setBounds(698, 300, 71, 21);
        contentPane.add(btnUpload);

        JButton btnCancel = new JButton("Hủy");
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                HoverButton.hoverCancel(btnCancel, true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                HoverButton.hoverCancel(btnCancel, false);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCancel.setFont(SetFont.font1());
        btnCancel.setBorder(null);
        btnCancel.setBounds(352, 313, 97, 30);
        contentPane.add(btnCancel);

        JButton btnCpNht = new JButton("Cập nhật");
        btnCpNht.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateHDD();
                closeFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                HoverButton.hoverOK(btnCpNht, true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                HoverButton.hoverCancel(btnCancel, false);
            }
        });
        btnCpNht.setToolTipText("");
        btnCpNht.setFont(SetFont.font1());
        btnCpNht.setBorder(null);
        btnCpNht.setBounds(196, 313, 97, 30);
        contentPane.add(btnCpNht);

        JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(224, 255, 255));
        lblNewLabel_1.setFont(SetFont.font());
        lblNewLabel_1.setBounds(10, 369, 759, 14);
        contentPane.add(lblNewLabel_1);

        tften = new JTextField();
        tften.setFont(SetFont.fontDetails());
        tften.setColumns(10);
        tften.setBounds(396, 58, 141, 30);
        contentPane.add(tften);

        JLabel lblTnHdd = new JLabel("Tên HDD");
        lblTnHdd.setForeground(new Color(254, 254, 254));
        lblTnHdd.setFont(SetFont.font1_());
        lblTnHdd.setBounds(284, 58, 71, 30);
        contentPane.add(lblTnHdd);

        JLabel lblHng_2 = new JLabel("Hãng");
        lblHng_2.setForeground(new Color(254, 254, 254));
        lblHng_2.setFont(SetFont.font1_());
        lblHng_2.setBounds(283, 119, 71, 30);
        contentPane.add(lblHng_2);

        tfHang = new JTextField();
        tfHang.setFont(SetFont.fontDetails());
        tfHang.setColumns(10);
        tfHang.setBounds(395, 119, 141, 30);
        contentPane.add(tfHang);

        tfDungLuong = new JTextField();
        tfDungLuong.setFont(SetFont.fontDetails());
        tfDungLuong.setColumns(10);
        tfDungLuong.setBounds(136, 119, 141, 30);
        contentPane.add(tfDungLuong);

        JLabel lblDungLng = new JLabel("Dung lượng");
        lblDungLng.setForeground(new Color(254, 254, 254));
        lblDungLng.setFont(SetFont.font1_());
        lblDungLng.setBounds(24, 119, 71, 30);
        contentPane.add(lblDungLng);

        JLabel lblHng_2_1 = new JLabel("Bộ nhớ đệm");
        lblHng_2_1.setForeground(new Color(254, 254, 254));
        lblHng_2_1.setFont(SetFont.font1_());
        lblHng_2_1.setBounds(283, 188, 112, 30);
        contentPane.add(lblHng_2_1);

        tfBoNhoDem = new JTextField();
        tfBoNhoDem.setFont(SetFont.fontDetails());
        tfBoNhoDem.setColumns(10);
        tfBoNhoDem.setBounds(395, 188, 141, 30);
        contentPane.add(tfBoNhoDem);

        tfTocDoVongQuay = new JTextField();
        tfTocDoVongQuay.setFont(SetFont.fontDetails());
        tfTocDoVongQuay.setColumns(10);
        tfTocDoVongQuay.setBounds(136, 189, 141, 30);
        contentPane.add(tfTocDoVongQuay);

        JLabel lblTcQv = new JLabel("Tốc độ QV");
        lblTcQv.setForeground(new Color(254, 254, 254));
        lblTcQv.setFont(SetFont.font1_());
        lblTcQv.setBounds(24, 189, 112, 30);
        contentPane.add(lblTcQv);

        JLabel lblHng_2_2 = new JLabel("Bảo hành");
        lblHng_2_2.setForeground(new Color(254, 254, 254));
        lblHng_2_2.setFont(SetFont.font1_());
        lblHng_2_2.setBounds(283, 258, 71, 30);
        contentPane.add(lblHng_2_2);

        tfBaoHanh = new JTextField();
        tfBaoHanh.setFont(SetFont.fontDetails());
        tfBaoHanh.setColumns(10);
        tfBaoHanh.setBounds(395, 258, 141, 30);
        contentPane.add(tfBaoHanh);

        JLabel lblHng_2_2_1 = new JLabel("Đơn giá");
        lblHng_2_2_1.setForeground(new Color(254, 254, 254));
        lblHng_2_2_1.setFont(SetFont.font1_());
        lblHng_2_2_1.setBounds(24, 254, 71, 30);
        contentPane.add(lblHng_2_2_1);

        tfGia = new JTextField();
        tfGia.setFont(SetFont.fontDetails());
        tfGia.setColumns(10);
        tfGia.setBounds(136, 254, 141, 30);
        contentPane.add(tfGia);

        JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
        lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
        lblTnNgun_1_2_1.setFont(SetFont.font1_());
        lblTnNgun_1_2_1.setBounds(287, 11, 108, 21);
        contentPane.add(lblTnNgun_1_2_1);

        tfLink = new JTextField("");
        tfLink.setFont(SetFont.fontDetails());
        tfLink.setColumns(10);
        tfLink.setBounds(396, 11, 317, 20);
        contentPane.add(tfLink);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
            }
        });
        btnNewButton.setBounds(717, 11, 52, 20);
        contentPane.add(btnNewButton);

        ArrayList<Products> list = SanPhamDAO.getIDSanPham("HDD");
        int size = list.size();
        String[] combo = new String[size];
        for (int i = 0; i < size; i++) {
            combo[i] = list.get(i).getIdSanPham();
        }
        comboBox_IDSP = new JComboBox<>(combo);
        comboBox_IDSP.setBounds(133, 58, 144, 30);
        contentPane.add(comboBox_IDSP);
    }

    public static String getInsert() {
        return insert;
    }

    public static void setInsert(String insert) {
        CapNhatHDD.insert = insert;
    }

    private void closeFrame() {
        this.dispose();
    }

    private static HDD getHDDSelect() {
        return HDDForm.getHddSelect();
    }

    private static void setDefaultText() {
        HDD HDD = getHDDSelect();
        comboBox_IDSP.setSelectedItem(HDD.getIdSanPham());
        tften.setText(HDD.getTenHdd());
        tfDungLuong.setText(HDD.getDungLuong());
        tfHang.setText(HDD.getHang());
        tfTocDoVongQuay.setText(HDD.getTocDoVongQuay());
        tfBoNhoDem.setText(HDD.getBoNhoDem());
        tfGia.setText(String.valueOf(HDD.getGia()));
        tfBaoHanh.setText(HDD.getBaoHanh());

        if (HDD.getImg() == null) {
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(CapNhatHDD.class.getResource("/icon/icons8-no-image-14.png")));
        } else {
            Blob blob = HDD.getImg();
            try {
                byte[] by = blob.getBytes(1, (int) blob.length());
                ImageIcon ii = new ImageIcon(by);
                Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
                        Image.SCALE_SMOOTH);
                ii = new ImageIcon(i);
                labelIMG.setIcon(ii);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateHDD() {
        String url = tfLink.getText();

        if (insert.length() > 0 && url.length() > 0)

            JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh");
        else {

            HDD HDD = getHDDSelect();
            String idsp = comboBox_IDSP.getSelectedItem().toString();
            String ten = tften.getText();
            String dungluong = tfDungLuong.getText();
            String hang = tfHang.getText();
            String tocdovongquay = tfTocDoVongQuay.getText();
            String bonhohdem = tfBoNhoDem.getText();
            double gia = Double.parseDouble(tfGia.getText());
            String baohanh = tfBaoHanh.getText();

            HDD newHDD = new HDD(idsp, HDD.getIdhHdd(), ten, hang, dungluong, bonhohdem, tocdovongquay, HDD.getTonKho(),
                    gia, baohanh, null);

            if (insert.equals("") && url.equals("")) {
                int check = HDDDAO.getInstance().updateNotIMG(newHDD);
                insert = Checked.checkedUpdate(check, insert);
            } else {
                if (url.equals("")) {
                    int check = HDDDAO.getInstance().update(newHDD);
                    insert = Checked.checkedUpdate(check, insert);
                } else if (insert.equals("")) {
                    int check = HDDDAO.getInstance().update(newHDD);
                    insert = Checked.checkedUpdate(check, insert);
                }
            }

            HDDForm.loadDataToTable(HDDDAO.getInstance().selectAll());
        }
    }

}
