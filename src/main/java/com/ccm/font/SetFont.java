package com.ccm.font;

import java.awt.Font;
import java.io.File;
import java.io.InputStream;

import com.itextpdf.text.pdf.BaseFont;

public class SetFont {

//	public static Font font;
//	public static Font font_1;
//	public static Font font1;
//	public static Font font2;


    public static Font fontDetails_1() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            if (fontStream != null) {
                f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(13f);
            } else {
                System.out.println("Font file not found in resources");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font fontDetails() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            if (fontStream != null) {
                f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(11f);
            } else {
                System.out.println("Font file not found in resources");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font fontDetails1() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font fontThongKe() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(20f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font fontThongKe1() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(26f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font font() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(11f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font font1_() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(14f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;

    }

    public static Font font1() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font font2() {
        Font f1 = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Medium.ttf");
            assert fontStream != null;
            f1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(22f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static Font fontTitle() {
        Font f = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Oswald-Medium.ttf");
            assert fontStream != null;
            f = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(20f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static Font fontCategory() {
        Font f = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            assert fontStream != null;
            f = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static Font fontCategoryPr() {
        Font f = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Light.ttf");
            assert fontStream != null;
            f = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12.5f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static Font fontHeaderTable() {
        Font f = null;
        try {
            InputStream fontStream = SetFont.class.getResourceAsStream("/font/Roboto-Bold.ttf");
            assert fontStream != null;
            f = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static com.itextpdf.text.Font fontTNR() {
        com.itextpdf.text.Font f = null;
        try {
            String fontPath = SetFont.class.getResource("/font/SVN-Times-New-Roman.ttf").getPath();
            f = new com.itextpdf.text.Font(
                    BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static com.itextpdf.text.Font fontTNRBoldTitle() {
        com.itextpdf.text.Font f = null;
        try {
            String fontPath = SetFont.class.getResource("/font/SVN-Times-New-Roman-Bold.ttf").getPath();
            f = new com.itextpdf.text.Font(
                    BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, true), 18);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static com.itextpdf.text.Font fontTNRBoldNameCompany() {
        com.itextpdf.text.Font f = null;
        try {
            String fontPath = SetFont.class.getResource("/font/SVN-Times-New-Roman-Bold.ttf").getPath();
            f = new com.itextpdf.text.Font(
                    BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, true), 20);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static com.itextpdf.text.Font fontTNRBold() {
        com.itextpdf.text.Font f = null;
        try {
            String fontPath = SetFont.class.getResource("/font/SVN-Times-New-Roman-Bold.ttf").getPath();
            f = new com.itextpdf.text.Font(
                    BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, true), 12);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static com.itextpdf.text.Font fontTNRItalic() {
        com.itextpdf.text.Font f = null;
        try {
            String fontPath = SetFont.class.getResource("/font/SVN-Times-New-Roman-Italic.ttf").getPath();
            f = new com.itextpdf.text.Font(
                    BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, true), 10);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }
}
