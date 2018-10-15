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
		setTitle("피자 주문");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		WelcomePanel = new JPanel();
		JLabel label = new JLabel("자바 피자에 오신것을 환영합니다.");
		WelcomePanel.add(label);
		add(WelcomePanel, BorderLayout.NORTH);
		
		// 종류 
		TypePanel = new JPanel(new GridLayout(3,3));
		
		Combo = new JRadioButton("콤보");
		Potato = new JRadioButton("포테이토");
		Bulgogi = new JRadioButton("불고기");
		
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
		
		Border typeborder = BorderFactory.createTitledBorder("종류");
		TypePanel.setBorder(typeborder);
		
		add(TypePanel, BorderLayout.WEST);
		
		//크기
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
		
		Border sizeborder = BorderFactory.createTitledBorder("크기");
		SizePanel.setBorder(sizeborder);
		
		add(SizePanel, BorderLayout.EAST);
		
		//버튼
		ButtonPanel = new JPanel();
		
		
		Offer = new JButton("주문");
		Cancel = new JButton("취소");
		Offer.addActionListener(this);
		Cancel.addActionListener(this);
		
		ButtonPanel.add(Offer);
		ButtonPanel.add(Cancel);
		
		add(ButtonPanel, BorderLayout.SOUTH);
		
		//토핑
		ToppingPanel = new JPanel(new GridLayout(2,2));
		
		
		GreenPepper = new JCheckBox("피망");
		Pepperoni = new JCheckBox("페퍼로니");
		Cheese = new JCheckBox("치즈");
		Bacon = new JCheckBox("베이컨");
		
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
		
		Border toppingborder = BorderFactory.createTitledBorder("토핑");
		ToppingPanel.setBorder(toppingborder);
		
		add(ToppingPanel, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	private class RadioListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == Combo) {
				TypeResult = "콤보 피자";
				
			}
			if(e.getSource() == Potato) {
				TypeResult = "포테이토 피자";
			}
			if(e.getSource() == Bulgogi) {
				TypeResult = "불고기 피자";
			}
		}
		
	}
	
	private class RadioListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == Small) {
				SizeResult = "Small 사이즈";
				
			}
			if(e.getSource() == Medium) {
				SizeResult = "Medium 사이즈";
			}
			if(e.getSource() == Large) {
				SizeResult = "Large 사이즈";
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = TypeResult+ " " + SizeResult + " 주문하셨습니다. 토핑은 " + ToppingResult + "입니다.";
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
					GreenPepperOP ="피망 ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Pepperoni) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					PepperoniOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					PepperoniOP = "페퍼로니 ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Cheese) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					CheeseOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					CheeseOP ="치즈 ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
			if(topping == Bacon) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					BaconOP = "";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}else {
					BaconOP = "베이컨 ";
					ToppingResult = GreenPepperOP+PepperoniOP+CheeseOP+BaconOP;
				}
			}
		}
		
	}
}
