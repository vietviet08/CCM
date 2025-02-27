package com.ccm.view.product;

import com.ccm.color.SetColor;
import com.ccm.dao.*;
import com.ccm.font.SetFont;
import com.ccm.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Blob;
import java.sql.SQLException;

public class ChiTietSP extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;
    private static String id;
    private static JLabel labelIMG;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//					setId(key);
                    ChiTietSP frame = new ChiTietSP();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    if (id.contains("cpu"))
                        setDetailToCPU();
                    else if (id.contains("r"))
                        setDetailToRAM();
                    else if (id.contains("vga"))
                        setDetailToVGA();
                    else if (id.contains("mba"))
                        setDetailToMainboard();
                    else if (id.contains("psu")) {
                        setDetailToPSU();
                    } else if (id.contains("case")) {
                        setDetailToCase();
                    } else if (id.contains("ssd")) {
                        setDetailToSSD();
                    } else if (id.contains("hdd")) {
                        setDetailToHDD();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChiTietSP() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 698, 428);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        contentPane = new JPanel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
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

        textArea = new JTextArea();
        textArea.setFont(SetFont.fontDetails1());
        textArea.setWrapStyleWord(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 39, 361, 300);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("Đóng");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setBackground(SetColor.redB);
                btnNewButton.setForeground(SetColor.whiteFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(SetColor.whiteFont);
                btnNewButton.setForeground(Color.black);

            }
        });
        btnNewButton.setFont(SetFont.font());
        btnNewButton.setBounds(320, 370, 107, 34);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("CHI TIẾT");
        lblNewLabel.setFont(SetFont.fontTitle());
        lblNewLabel.setForeground(SetColor.yellow);
        lblNewLabel.setBounds(10, 11, 378, 26);
        contentPane.add(lblNewLabel);

        labelIMG = new JLabel("Ảnh sản phẩm");
        labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG.setBounds(381, 41, 300, 300);
        contentPane.add(labelIMG);
    }

    private void closeFrame() {
        this.dispose();
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ChiTietSP.id = id;
    }

    private static void setIMGToLabel(Blob blob) {
        try {
            byte[] by = blob.getBytes(1, (int) blob.length());
            ImageIcon ii = new ImageIcon(by);
            Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
            ii = new ImageIcon(i);
            labelIMG.setText("");
            labelIMG.setIcon(ii);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setDetailToCPU() {
        CPU CPU = CPUDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + CPU.getIdSanPham() + "\n-- ID CPU: " + CPU.getIdCpu() + "\n-- Tên CPU: "
                + CPU.getNameCpu() + "\n-- Xung nhịp: " + CPU.getXungNhip() + "\n-- Số nhân: " + CPU.getSoNhan()
                + "\n-- Số luồng: " + CPU.getSoLuong() + "\n-- Điện năng tiêu thụ: " + CPU.getDienNangTieuThu()
                + "\n-- Bộ nhớ đệm: " + CPU.getBoNhoDem());

        if (CPU.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(CPU.getImg());

    }

    private static void setDetailToRAM() {
        RAM ram = RAMDAO.getInstance().selectById(id);
        System.out.println(id);
        textArea.setText("-- ID sản phẩm: " + ram.getIdSanPham() + "\n-- ID RAM: " + ram.getIdRam() + "\n-- Tên RAM: "
                + ram.getTenRam() + "\n-- Loại RAM: " + ram.getLoai() + "\n-- Dung Lượng: " + ram.getDungLuong()
                + "\n-- BUS: " + ram.getBus());

        if (ram.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(ram.getImg());
    }

    private static void setDetailToVGA() {
        VGA VGA = VGADAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + VGA.getIdSanPham() + "\n-- ID VGA: " + VGA.getIdVga() + "\n-- Tên VGA: "
                + VGA.getTenVGA() + "\n-- Hãng VGA: " + VGA.getHangVGA() + "\n-- Bộ nhớ: " + VGA.getBoNho());

        if (VGA.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(VGA.getImg());
    }

    private static void setDetailToMainboard() {
        MainBoard mb = MainBoardDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + mb.getIdSanPham() + "\n-- ID MainBoardboard: " + mb.getIdMainboard()
                + "\n-- Tên MainBoardboard: " + mb.getTenMain() + "\n-- Tên hãng: " + mb.getTenHang() + "\n-- Hỗ trợ CPU: "
                + mb.getHoTroCPU() + "\n-- Hỗ trợ RAM: " + mb.getHoTroRAM() + "\n-- Kích thước: " + mb.getKichThuoc());

        if (mb.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(mb.getImg());
    }

    private static void setDetailToCase() {
        Case c = CaseDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + c.getIdSanPham() + "\n-- ID Case: " + c.getIdCase() + "\n-- Tên Case: "
                + c.getTenCase() + "\n-- Hãng: " + c.getHangCase() + "\n-- Chất liệu: " + c.getChatLieu()
                + "\n-- Kích thước MainBoardboard: " + c.getKichThuocMainboard());
        if (c.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(c.getImg());
    }

    private static void setDetailToPSU() {
        PSU PSU = PSUDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + PSU.getIdSanPham() + "\n-- ID nguồn: " + PSU.getIdNguon()
                + "\n-- Tên nguồn: " + PSU.getTenNguon() + "\n-- Hãng: " + PSU.getHang() + "\n-- Công suất: "
                + PSU.getCongSuat() + "\n-- Chuẩn nguồn: " + PSU.getChuanNguon() + "\n-- Kiểu dây: " + PSU.getKieuDay()
                + "\n-- Kích thước: " + PSU.getKichThuoc());

        if (PSU.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(PSU.getImg());
    }

    private static void setDetailToSSD() {
        SSD SSD = SSDDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + SSD.getIdSanPham() + "\n-- ID SSD: " + SSD.getIdSdd() + "\n-- Tên SSD: "
                + SSD.getTenSsd() + "\n-- Hãng: " + SSD.getHang() + "\n-- Dung lượng: " + SSD.getDungLuong()
                + "\n-- Loại SSD: " + SSD.getLoai() + "\n-- Tốc độ đọc: " + SSD.getTocDoDoc() + "\n-- Tốc độ ghi: "
                + SSD.getTocDoGhi());
        if (SSD.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(SSD.getImg());
    }

    private static void setDetailToHDD() {
        HDD HDD = HDDDAO.getInstance().selectById(id);
        textArea.setText("-- ID sản phẩm: " + HDD.getIdSanPham() + "\n-- ID HDD: " + HDD.getIdhHdd()
                + "\n-- Dung lượng: " + HDD.getDungLuong() + "\n-- Bộ nhớ đệm: " + HDD.getBoNhoDem()
                + "\n-- Tốc độ vòng quay: " + HDD.getTocDoVongQuay());

        if (HDD.getImg() == null) {
            labelIMG.setIcon(null);
            labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
            labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
        } else
            setIMGToLabel(HDD.getImg());
    }
}
