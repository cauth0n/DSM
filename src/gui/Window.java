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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import driver.Matrix;

public class Window {

	public Window(Matrix matrix) {
		// VisualizationPanel panel;
		List<String> labels = new ArrayList<>();
		for (int l : matrix.getFile().keySet()) {
			labels.add(matrix.getFile().get(l));
		}
		// panel = new VisualizationPanel(vis);
		JFrame frame = new JFrame("Test");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(scrollPane, Alignment.TRAILING,
				GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(scrollPane, Alignment.TRAILING,
				GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE));

		JList rowNames = new JList(labels.toArray());
		scrollPane.setRowHeaderView(rowNames);

		JList colNames = new JList(labels.toArray());
		scrollPane.setColumnHeaderView(colNames);
		// Group row = new Group(rowNames);

		// groupLayout.setHorizontalGroup(rowNames);

		frame.getContentPane().setLayout(groupLayout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(888, 540);
		frame.pack();
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
