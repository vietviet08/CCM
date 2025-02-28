package com.ccm.decor;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRoundThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	private int roundTopLeft = 0;
	private int roundTopRight = 0;
	private int roundBottomLeft = 0;
	private int roundBottomRight = 0;
	private Color colorFrom = new Color(0, 0, 0);
	private Color colorTo = new Color(255, 255, 255);

	public int getRoundTopLeft() {
		return roundTopLeft;
	}

	public void setRoundTopLeft(int roundTopLeft) {
		this.roundTopLeft = roundTopLeft;
		repaint();
	}

	public int getRoundTopRight() {
		return roundTopRight;
	}

	public void setRoundTopRight(int roundTopRight) {
		this.roundTopRight = roundTopRight;
		repaint();
	}

	public int getRoundBottomLeft() {
		return roundBottomLeft;
	}

	public void setRoundBottomLeft(int roundBottomLeft) {
		this.roundBottomLeft = roundBottomLeft;
		repaint();
	}

	public int getRoundBottomRight() {
		return roundBottomRight;
	}

	public void setRoundBottomRight(int roundBottomRight) {
		this.roundBottomRight = roundBottomRight;
		repaint();
	}

	public Color getColorFrom() {
		return colorFrom;
	}

	public void setColorFrom(Color colorFrom) {
		this.colorFrom = colorFrom;
		repaint();
	}

	public Color getColorTo() {
		return colorTo;
	}

	public void setColorTo(Color colorTo) {
		this.colorTo = colorTo;
		repaint();
	}

	public PanelRoundThongKe() {
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		Area area = new Area(createRoundTopLeft());
		if (roundTopRight > 0) {
			area.intersect(new Area(createRoundTopRight()));
		}
		if (roundBottomLeft > 0) {
			area.intersect(new Area(createRoundBottomLeft()));
		}
		if (roundBottomRight > 0) {
			area.intersect(new Area(createRoundBottomRight()));
		}

		Color colorFrom = createColorFrom();
		Color colorTo = createColorTo();
		
		GradientPaint gp = new GradientPaint(0, 0, colorFrom, 280, getHeight(), colorTo);
		g2.setPaint(gp);

		g2.fill(area);
		g2.dispose();
		super.paintComponent(grphcs);
	}

	private Shape createRoundTopLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, roundTopLeft);
		int roundY = Math.min(height, roundTopLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}

	private Shape createRoundTopRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, roundTopRight);
		int roundY = Math.min(height, roundTopRight);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}

	private Shape createRoundBottomLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, roundBottomLeft);
		int roundY = Math.min(height, roundBottomLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}

	private Shape createRoundBottomRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, roundBottomRight);
		int roundY = Math.min(height, roundBottomRight);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}
	
	private Color createColorFrom() {
		return colorFrom;
	}
	
	private Color createColorTo() {
		return colorTo;
	}

}
