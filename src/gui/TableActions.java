package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TableActions implements MouseListener {

	private Map<Integer, String> map;

	public TableActions(Map<Integer, String> map) {
		this.map = map;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		JOptionPane jpane = new JOptionPane();
		jpane.add(new JTextField(map.get(x)));
		System.out.println(x + " " + y);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
