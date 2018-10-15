package pizza;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Confirm_Dialog extends JDialog implements ActionListener{
	private JPanel Panel, Content_Panel;
	private JLabel label;
	private JButton Offer;
	
	public Confirm_Dialog(Frame Frame, String str) {
		// TODO Auto-generated constructor stub
		super(Frame, str, true);
		Panel = new JPanel();
		Panel.setLayout(new BorderLayout());
		add(Panel);
		
		Content_Panel = new JPanel();
		label = new JLabel(str);
		Content_Panel.add(label);
		
		Offer = new JButton("주문완료");
		Offer.addActionListener(this);
		
		Content_Panel.add(Offer);
		add(Content_Panel, BorderLayout.CENTER);
		
		setSize(600, 100);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Offer) {
			System.exit(0);
		}
	}

}
