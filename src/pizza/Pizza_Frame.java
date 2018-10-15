package pizza;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class Pizza_Frame extends JFrame  implements ActionListener{
	
	private String TypeResult = "", SizeResult = "", ToppingResult="";
	private String GreenPepperOP = "", PepperoniOP ="", CheeseOP = "", BaconOP = "";
	private JPanel WelcomePanel, TypePanel, SizePanel, ButtonPanel, ToppingPanel;
	private JRadioButton Combo, Potato, Bulgogi; 
	private JRadioButton Small, Medium, Large;
	private JButton Offer, Cancel;
	private Confirm_Dialog confirm;
	private JCheckBox GreenPepper, Pepperoni, Cheese, Bacon ;
	
	
	public Pizza_Frame() {
		setTitle("���� �ֹ�");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		WelcomePanel = new JPanel();
		JLabel label = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
		WelcomePanel.add(label);
		add(WelcomePanel, BorderLayout.NORTH);
		
		// ���� 
		TypePanel = new JPanel(new GridLayout(3,3));
		
		Combo = new JRadioButton("�޺�");
		Potato = new JRadioButton("��������");
		Bulgogi = new JRadioButton("�Ұ��");
		
		ButtonGroup type = new ButtonGroup();
		type.add(Combo);
		type.add(Potato);
		type.add(Bulgogi);
		
		Combo.addActionListener(new RadioListener());
		Potato.addActionListener(new RadioListener());
		Bulgogi.addActionListener(new RadioListener());
		
		TypePanel.add(Combo);
		TypePanel.add(Potato);
		TypePanel.add(Bulgogi);
		
		Border typeborder = BorderFactory.createTitledBorder("����");
		TypePanel.setBorder(typeborder);
		
		add(TypePanel, BorderLayout.WEST);
		
		//ũ��
		SizePanel = new JPanel(new GridLayout(3,3));
		
		
		Small = new JRadioButton("Small");
		Medium = new JRadioButton("Medium");
		Large = new JRadioButton("Large");
		
		ButtonGroup size = new ButtonGroup();
		size.add(Small);
		size.add(Medium);
		size.add(Large);
		
		Small.addActionListener(new RadioListener2());
		Medium.addActionListener(new RadioListener2());
		Large.addActionListener(new RadioListener2());
		
		SizePanel.add(Small);
		SizePanel.add(Medium);
		SizePanel.add(Large);
		
		Border sizeborder = BorderFactory.createTitledBorder("ũ��");
		SizePanel.setBorder(sizeborder);
		
		add(SizePanel, BorderLayout.EAST);
		
		//��ư
		ButtonPanel = new JPanel();
		
		
		Offer = new JButton("�ֹ�");
		Cancel = new JButton("���");
		Offer.addActionListener(this);
		Cancel.addActionListener(this);
		
		ButtonPanel.add(Offer);
		ButtonPanel.add(Cancel);
		
		add(ButtonPanel, BorderLayout.SOUTH);
		
		//����
		ToppingPanel = new JPanel(new GridLayout(2,2));
		
		
		GreenPepper = new JCheckBox("�Ǹ�");
		Pepperoni = new JCheckBox("���۷δ�");
		Cheese = new JCheckBox("ġ��");
		Bacon = new JCheckBox("������");
		
		/*
		ButtonGroup topping = new ButtonGroup();
		topping.add(GreenPepper);
		topping.add(Pepperoni);
		topping.add(Bacon);
		topping.add(Cheese);
		*/
		
		GreenPepper.addItemListener(new CheckBoxListener());
		Pepperoni.addItemListener(new CheckBoxListener());
		Cheese.addItemListener(new CheckBoxListener());
		Bacon.addItemListener(new CheckBoxListener());
		
		ToppingPanel.add(GreenPepper);
		ToppingPanel.add(Pepperoni);
		ToppingPanel.add(Cheese);
		ToppingPanel.add(Bacon);
		
		Border toppingborder = BorderFactory.createTitledBorder("����");
		ToppingPanel.setBorder(toppingborder);
		
		add(ToppingPanel, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	private class RadioListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == Combo) {
				TypeResult = "�޺� ����";
				
			}
			if(e.getSource() == Potato) {
				TypeResult = "�������� ����";
			}
			if(e.getSource() == Bulgogi) {
				TypeResult = "�Ұ�� ����";
			}
		}
		
	}
	
	private class RadioListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == Small) {
				SizeResult = "Small ������";
				
			}
			if(e.getSource() == Medium) {
				SizeResult = "Medium ������";
			}
			if(e.getSource() == Large) {
				SizeResult = "Large ������";
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = TypeResult+ " " + SizeResult + " �ֹ��ϼ̽��ϴ�. ������ " + ToppingResult + "�Դϴ�.";
		if(e.getSource() == Offer) {
			if(confirm == null) {
				confirm = new Confirm_Dialog(this, str);
			}
			confirm.setVisible(true);
			Offer.requestFocus();
		}
		if(e.getSource() == Cancel) {
			System.exit(0);
		}
	}
	
	private class CheckBoxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			Object topping = e.getItemSelectable();
			if(topping == GreenPepper) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					GreenPepperOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					GreenPepperOP ="�Ǹ� ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Pepperoni) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					PepperoniOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					PepperoniOP = "���۷δ� ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Cheese) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					CheeseOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					CheeseOP ="ġ�� ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Bacon) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					BaconOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					BaconOP = "������ ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
		}
		
	}
}
