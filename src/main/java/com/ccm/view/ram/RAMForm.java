package com.ccm.view.ram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.ccm.view.cpu.CPUForm;
import com.ccm.view.mainboard.MainboardForm;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ccm.color.SetColor;
import com.ccm.controller.FormatToVND;
import com.ccm.controller.TimKiemRAM;
import com.ccm.dao.ChiTietPhieuXuatDAO;
import com.ccm.dao.SanPhamDAO;
import com.ccm.dao.RAMDAO;
import com.ccm.decor.SetTitleForJF;
import com.ccm.font.SetFont;
import com.ccm.model.RAM;

public class RAMForm extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static JTable table;
    private static DefaultTableModel tableModel;
    private final String columName[] = {"ID sản phẩm", "ID RAM", "Tên Ram", "Loại RAM", "Dung lượng", "BUS", "Tồn kho",
            "Đơn giá"};
    private JTextField textField;
    public Font font;
    public Font font_1;
    public Font font1;
    public Font font2;
    private JLabel labelIMG;
    private JLabel labelTen;
    private JLabel labelTien;
    private JLabel labelBaoHanh;
    private JTextArea textArea;
    private JLabel labelDungLuong;
    private JLabel labelBus;
    private JLabel labelLoaiRam;
    private JLabel labelLuot;
    private JLabel labelLuotBan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RAMForm fRAMe = new RAMForm();
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
    public static void loadDataToTable(ArrayList<RAM> r) {
        try {
            tableModel.setRowCount(0);
            for (RAM i : r) {

                DefaultTableCellRenderer df = new DefaultTableCellRenderer();
                df.setHorizontalAlignment(SwingConstants.RIGHT);

                DefaultTableCellRenderer center = new DefaultTableCellRenderer();
                center.setHorizontalAlignment(SwingConstants.CENTER);

                table.getColumnModel().getColumn(7).setCellRenderer(df);
                table.getColumnModel().getColumn(6).setCellRenderer(center);
                table.getColumnModel().getColumn(3).setCellRenderer(center);

                String gia = FormatToVND.vnd(i.getDonGia());

                tableModel.addRow(new Object[]{i.getIdSanPham(), i.getIdRam(), i.getTenRam(), i.getLoai(),
                        i.getDungLuong(), i.getBus(), i.getTonkho(), gia});
            }
        } catch (Exception e) {
        }
    }

    public void setDefaultTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columName);
        table.setDefaultEditor(Object.class, null);
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(500);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(250);
        loadDataToTable(RAMDAO.getInstance().selectAll());
    }

    public RAMForm() {
        SetTitleForJF.setTitle(this, "/icon/icons8-memory-slot-20.png");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(11f);
            font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(14f);
            font1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
            font2 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(22f);

        } catch (Exception e) {
            System.out.println(e);
        }

        setBounds(100, 100, 1200 - 30, 730);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 630, 49);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton_1 = new JButton("Thêm");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemRAM.main(null);
            }
        });
        btnNewButton_1.setFont(font);
        btnNewButton_1.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-add-24.png")));
        btnNewButton_1.setBounds(10, 8, 99, 33);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Xóa");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn RAM để xóa!");
                } else {
                    int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?", "Cảnh báo",
                            JOptionPane.YES_NO_OPTION);
                    if (answ == JOptionPane.YES_OPTION) {
                        RAM RAM = getSelectRAM();
                        RAMDAO.getInstance().delete(RAM);
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        loadDataToTable(RAMDAO.getInstance().selectAll());
                    }
                }
            }
        });
        btnNewButton_2.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-delete-24.png")));
        btnNewButton_2.setFont(font);
        btnNewButton_2.setBounds(119, 8, 99, 33);
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Sửa");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn RAM để chỉnh sửa!");
                } else
                    CapNhatRAM.main(null);
            }
        });
        btnNewButton_3.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-edit-24.png")));
        btnNewButton_3.setFont(font);
        btnNewButton_3.setBounds(228, 8, 87, 33);
        panel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Nhập Excel");
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                int rowBanDau = model.getRowCount();

                File excelFile;
                FileInputStream excelFIS = null;
                BufferedInputStream excelBIS = null;
                XSSFWorkbook excelImportToJTable = null;
                String defaultCurrentDirectoryPath = "C:\\Users\\DELL\\Desktop";
                JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
                excelFileChooser.setDialogTitle("Select Excel File");
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                excelFileChooser.setFileFilter(fnef);
                int excelChooser = excelFileChooser.showOpenDialog(null);
                if (excelChooser == JFileChooser.APPROVE_OPTION) {
                    try {
                        excelFile = excelFileChooser.getSelectedFile();
//		                jExcelFilePath.setText(excelFile.toString());
                        excelFIS = new FileInputStream(excelFile);
                        excelBIS = new BufferedInputStream(excelFIS);
                        excelImportToJTable = new XSSFWorkbook(excelBIS);
                        XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                        for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);
                            XSSFCell id = excelRow.getCell(0);
                            XSSFCell ten = excelRow.getCell(1);
                            XSSFCell loaiRAM = excelRow.getCell(2);
                            XSSFCell dungluong = excelRow.getCell(3);
                            XSSFCell bus = excelRow.getCell(4);
                            XSSFCell dongia = excelRow.getCell(5);

                            model.addRow(new Object[]{id, ten, loaiRAM, dungluong, bus, dongia});
                        }
                        JOptionPane.showMessageDialog(null, "Thêm thành công!");
                        int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
                                JOptionPane.YES_NO_OPTION);
                        if (answ == JOptionPane.YES_OPTION) {
                            for (int i = rowBanDau; i <= model.getRowCount(); i++) {
                                String id = model.getValueAt(i, 0).toString();
                                String idRAM = model.getValueAt(i, 1).toString();
                                String ten = model.getValueAt(i, 2).toString();
                                String loaiRAM = model.getValueAt(i, 3).toString();
                                String dungluong = model.getValueAt(i, 4).toString();
                                String bus = model.getValueAt(i, 5).toString();
                                int tonkho = (int) model.getValueAt(i, 6);
                                double dongia = Double.parseDouble(model.getValueAt(i, 7).toString());
                                String baohanh = model.getValueAt(i, 8).toString();

                                RAM r = new RAM(id, idRAM, ten, loaiRAM, dungluong, bus, tonkho, dongia, baohanh, null);
                                RAMDAO.getInstance().insertNotIMG(r);
                            }
                        }
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, iOException.getMessage());
                    } finally {
                        try {
                            if (excelFIS != null) {
                                excelFIS.close();
                            }
                            if (excelBIS != null) {
                                excelBIS.close();
                            }
                            if (excelImportToJTable != null) {
//								excelImportToJTable.close();
                            }
                        } catch (IOException iOException) {
                            JOptionPane.showMessageDialog(null, iOException.getMessage());
                        }
                    }
                }

            }
        });
        btnNewButton_4.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-import-csv-24.png")));
        btnNewButton_4.setFont(font);
        btnNewButton_4.setBounds(329, 8, 138, 33);
        panel.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Xuất Excel");
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.showSaveDialog(null);
                    File saveFile = jFileChooser.getSelectedFile();
                    if (saveFile != null) {
                        saveFile = new File(saveFile.toString() + ".xlsx");
                        Workbook wb = new XSSFWorkbook();
                        Sheet sheet = wb.createSheet("RAM");

                        Row rowCol = sheet.createRow(0);
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                            cell.setCellValue(table.getColumnName(i));
                        }

                        for (int j = 0; j < table.getRowCount(); j++) {
                            Row row = sheet.createRow(j + 1);
                            for (int k = 0; k < table.getColumnCount(); k++) {
                                org.apache.poi.ss.usermodel.Cell ce = row.createCell(k);
                                if (table.getValueAt(j, k) != null) {
                                    ce.setCellValue(table.getValueAt(j, k).toString());
                                }

                            }
                        }
                        FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                        wb.write(out);
//						wb.close();
                        out.close();
                        openFile(saveFile.toString());
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        btnNewButton_5.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-export-excel-24.png")));
        btnNewButton_5.setFont(font);
        btnNewButton_5.setBounds(477, 8, 142, 33);
        panel.add(btnNewButton_5);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 53, 780, 648);
        getContentPane().add(scrollPane);

        table = new JTable() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component returnComp = super.prepareRenderer(renderer, row, column);
                if (!returnComp.getBackground().equals(getSelectionBackground())) {
                    Color bg = (row % 2 == 0 ? SetColor.blueBaby : Color.WHITE);
                    returnComp.setBackground(bg);
                    bg = null;
                }
                return returnComp;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//				RAM r = getSelectRAM();

                RAM r = RAMDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));

                labelTen.setText(r.getTenRam());
                labelTien.setText(FormatToVND.vnd(r.getDonGia()));
                labelBaoHanh.setText("Bảo hành: " + r.getBaoHanh());
                labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(r.getIdRam()) + "");
                labelLoaiRam.setText("Loại RAM: " + r.getLoai());
                labelDungLuong.setText("Dung lượng: " + r.getDungLuong());
                labelBus.setText("BUS: " + r.getBus());
                textArea.setText(SanPhamDAO.getInstance().selectById(r.getIdSanPham()).getMoTa());

                if (r.getImg() == null) {
                    labelIMG.setIcon(null);
                    labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
                    labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
                } else {
                    labelIMG.setBorder(null);
                    Blob blob = r.getImg();
                    try {
                        byte[] by = blob.getBytes(1, (int) blob.length());
                        ImageIcon ii = new ImageIcon(by);
                        Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
                                Image.SCALE_SMOOTH);
                        ii = new ImageIcon(i);
                        labelIMG.setText("");
                        labelIMG.setIcon(ii);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        table.getTableHeader().setBackground(SetColor.blueOp);
        table.getTableHeader().setFont(SetFont.fontHeaderTable());
        table.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"New column", "New column", "New column", "New column", "New column"}));
        scrollPane.setViewportView(table);

        setDefaultTable();

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(635, 0, 557, 49);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel.setIcon(new ImageIcon(RAMForm.class.getResource("/icon/search-24.png")));
        lblNewLabel.setBounds(475, 14, 48, 22);
        panel_1.add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setFont(font);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"ID sản phẩm", "ID RAM", "Tên RAM",
                "Loại RAM", "Dung lượng", "BUS", "Tồn kho", "Đơn giá"}));
        comboBox.setBounds(146, 8, 99, 33);
        panel_1.add(comboBox);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ArrayList<RAM> list = new ArrayList<RAM>();
                String choose = comboBox.getSelectedItem().toString();
                String key = textField.getText();

                switch (choose) {
                    case "ID sản phẩm":
                        list = TimKiemRAM.byID(key);
                        break;
                    case "ID RAM":
                        list = TimKiemRAM.byIDRAM(key);
                        break;
                    case "Tên RAM":
                        list = TimKiemRAM.byTen(key);
                        break;
                    case "Loại RAM":
                        list = TimKiemRAM.byLoai(key);
                        break;
                    case "Dung lượng":
                        list = TimKiemRAM.byDungLuong(key);
                        break;
                    case "BUS":
                        list = TimKiemRAM.byBus(key);
                        break;
                    case "Tồn kho":
                        list = TimKiemRAM.byTonKho(key);
                        break;
                    case "Đơn giá":
                        list = TimKiemRAM.byGia(key);
                        break;

                    default:
                        break;
                }

                loadDataToTable(list);

            }
        });
        textField.setColumns(10);
        textField.setBounds(258, 8, 270, 33);
        panel_1.add(textField);

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox_1.getSelectedItem().toString().equals("Giá tăng dần")) {
                    loadDataToTable(giaTangDan());
                } else if (comboBox_1.getSelectedItem().toString().equals("Giá giảm dần")) {
                    loadDataToTable(giaGiamDan());
                } else if (comboBox_1.getSelectedItem().toString().equals("Tồn kho giảm dần")) {
                    loadDataToTable(tonKhoGiam());
                } else if (comboBox_1.getSelectedItem().toString().equals("Tồn kho tăng dần")) {
                    loadDataToTable(tonKhoTang());
                }
            }
        });
        comboBox_1.setFont(font);
        comboBox_1.setModel(new DefaultComboBoxModel<String>(
                new String[]{"Sắp xếp", "Giá tăng dần", "Giá giảm dần", "Tồn kho tăng dần", "Tồn kho giảm dần"}));
        comboBox_1.setBounds(10, 8, 127, 33);
        panel_1.add(comboBox_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(790, 53, 372, 648);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        labelTen = new JLabel("Tên RAM");
        labelTen.setFont(SetFont.fontCategory());
        labelTen.setBounds(30, 11, 348, 31);
        panel_2.add(labelTen);

        labelIMG = new JLabel("Ảnh sản phẩm");
        labelIMG.setFont(SetFont.font());
        labelIMG.setIcon(new ImageIcon(RAMForm.class.getResource("/icon/icons8-no-image-14.png")));
        labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
        labelIMG.setBorder(null);
        labelIMG.setBounds(10, 50, 350, 350);
        panel_2.add(labelIMG);

        labelTien = new JLabel("0 đ");
        labelTien.setForeground(new Color(190, 14, 30));
        labelTien.setFont(SetFont.font1());
        labelTien.setBounds(43, 402, 178, 23);
        panel_2.add(labelTien);

        labelBaoHanh = new JLabel("Bảo hành");
        labelBaoHanh.setFont(SetFont.font1());
        labelBaoHanh.setBounds(43, 436, 178, 23);
        panel_2.add(labelBaoHanh);

        textArea = new JTextArea();
        textArea.setFont(SetFont.fontDetails_1());
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBounds(35, 469, 312, 168);
        panel_2.add(textArea);

        labelLuotBan = new JLabel("0");
        labelLuotBan.setForeground(new Color(64, 143, 221));
        labelLuotBan.setFont(SetFont.fontDetails());
        labelLuotBan.setBounds(85, 39, 51, 14);
        panel_2.add(labelLuotBan);

        labelLuot = new JLabel("Lượt bán: ");
        labelLuot.setFont(SetFont.fontDetails());
        labelLuot.setBounds(30, 39, 53, 14);
        panel_2.add(labelLuot);

        labelLoaiRam = new JLabel("Loại: ");
        labelLoaiRam.setFont(SetFont.fontDetails());
        labelLoaiRam.setBounds(231, 402, 131, 14);
        panel_2.add(labelLoaiRam);

        labelDungLuong = new JLabel("Dung lượng: ");
        labelDungLuong.setFont(SetFont.fontDetails());
        labelDungLuong.setBounds(231, 420, 131, 14);
        panel_2.add(labelDungLuong);

        labelBus = new JLabel("BUS: ");
        labelBus.setFont(SetFont.fontDetails());
        labelBus.setBounds(231, 440, 131, 14);
        panel_2.add(labelBus);
    }

    private ArrayList<RAM> giaTangDan() {
        ArrayList<RAM> list = RAMDAO.getInstance().selectAll();
        Collections.sort(list, new Comparator<RAM>() {
            @Override
            public int compare(RAM o1, RAM o2) {
                if (o1.getDonGia() > o2.getDonGia())
                    return 1;
                if (o1.getDonGia() < o2.getDonGia())
                    return -1;
                return 0;
            }
        });
        return list;
    }

    private ArrayList<RAM> giaGiamDan() {
        ArrayList<RAM> list = RAMDAO.getInstance().selectAll();
        Collections.sort(list, new Comparator<RAM>() {
            @Override
            public int compare(RAM o1, RAM o2) {
                if (o1.getDonGia() < o2.getDonGia())
                    return 1;
                if (o1.getDonGia() > o2.getDonGia())
                    return -1;
                return 0;
            }
        });
        return list;
    }

    private ArrayList<RAM> tonKhoTang() {
        ArrayList<RAM> list = RAMDAO.getInstance().selectAll();
        Collections.sort(list, new Comparator<RAM>() {
            @Override
            public int compare(RAM o1, RAM o2) {
                if (o1.getTonkho() > o2.getTonkho())
                    return 1;
                if (o1.getTonkho() < o2.getTonkho())
                    return -1;
                return 0;
            }
        });
        return list;
    }

    private ArrayList<RAM> tonKhoGiam() {
        ArrayList<RAM> list = RAMDAO.getInstance().selectAll();
        Collections.sort(list, new Comparator<RAM>() {
            @Override
            public int compare(RAM o1, RAM o2) {
                if (o1.getTonkho() < o2.getTonkho())
                    return 1;
                if (o1.getTonkho() > o2.getTonkho())
                    return -1;
                return 0;
            }
        });
        return list;
    }

    public static RAM getSelectRAM() {
//		RAM c = RAMDAO.getInstance().selectAll().get(table.getSelectedRow());
        return RAMDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
