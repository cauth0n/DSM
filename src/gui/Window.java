package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import driver.Matrix;
import java.awt.BorderLayout;

public class Window {
	private JTable viewTable;

	public Window(Matrix matrix) {
		// VisualizationPanel panel;
		List<String> labels = new ArrayList<>();
		for (int l : matrix.getFile().keySet()) {
			labels.add(matrix.getFile().get(l));
		}
		// panel = new VisualizationPanel(vis);
		JFrame frame = new JFrame("Test");

		JScrollPane panel = new JScrollPane();
		panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		DefaultTableModel table = new DefaultTableModel(matrix.getTiles(), matrix.getValueSet().toArray());
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		viewTable = new JTable(table);
		viewTable.addMouseListener(new TableActions(matrix.getFile()));
		panel.setViewportView(viewTable);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(888, 540);
		frame.setVisible(true);
	}

	public JPanel buildLabelPanel(List<String> labels, boolean vert) {
		JPanel panel = new JPanel();
		panel.setDoubleBuffered(true);

		if (!vert)
			panel.setLayout(new GridLayout(labels.size(), 1));
		else
			panel.setLayout(new GridLayout(1, labels.size()));

		for (String l : labels) {
			if (vert) {
				AngleJLabel lab = new AngleJLabel(90, l);
				lab.setDoubleBuffered(true);
				panel.add(lab);
				lab.setHorizontalTextPosition(JLabel.LEFT);
			} else
				panel.add(new JLabel(l));
		}

		return panel;
	}

	class AngleJLabel extends JLabel {

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public void setAngle(int angle) {
			this.angle = angle;
		}

		public AngleJLabel(int angle, String text) {
			super(text);
			this.angle = angle;
		}

		private int angle = 360; // setter and getters
		private String text;

		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			Rectangle rectangle = g2d.getClipBounds();
			g2d.rotate((getAngle() * java.lang.Math.PI) / 180, rectangle.getCenterX(), rectangle.getCenterY());
			super.paintComponent(g);
		}

		public int getAngle() {
			return angle;
		}
	}
}
