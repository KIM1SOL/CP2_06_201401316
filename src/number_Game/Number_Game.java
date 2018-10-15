package number_Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class Number_Game extends JFrame  implements ActionListener{

	private JPanel InputPanel, ResultPanel, ButtonPanel;
	private JLabel InputLabel, TrialLabel;
	private JTextField InputText, TrialText;
	private int i = 0;
	private JButton TryAgain, Exit;
	Random random = new Random();
	
	
	
	public Number_Game() {
		setTitle("���� ����");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InputPanel = new JPanel();
		
		InputLabel = new JLabel("���ڸ� �����ϼ���");
		InputText = new JTextField();
		InputText.setColumns(10);
		
		InputPanel.add(InputLabel);
		InputPanel.add(InputText);
		
		add(InputPanel, BorderLayout.NORTH);
		
		//-----------------------------------------
		
		ResultPanel = new JPanel();
		
		TrialLabel = new JLabel("�õ�Ƚ��: "+i);
		
		TrialText = new JTextField();
		TrialText.setColumns(15);
		TrialText.setEditable(false);
		
		ResultPanel.add(TrialText);
		ResultPanel.add(TrialLabel);
		
		add(ResultPanel, BorderLayout.CENTER);
		
		
		//------------------------------------------
		
		ButtonPanel = new JPanel();
		
		TryAgain = new JButton("�ٽ� �ѹ�");
		Exit = new JButton("����");
		
		TryAgain.addActionListener(this);
		Exit.addActionListener(this);
		
		ButtonPanel.add(TryAgain);
		ButtonPanel.add(Exit);
		
		add(ButtonPanel, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int randomNumber = random.nextInt(100);
		System.out.println(randomNumber);
		if(e.getSource() == TryAgain) {
			// �������� �ƴϱ� ������ ����ó�� �ʿ�
			try{
				int value = Integer.valueOf(InputText.getText());
				// ������ Ȯ��, ���� �۵�
				if(randomNumber < value) { //������
					TrialText.setBackground(Color.RED);
					TrialText.setText("�ʹ� �����ϴ�.");
				}
				else if(randomNumber == value) { //������
					TrialText.setBackground(Color.green);
					TrialText.setText("�¾ҽ��ϴ�.");
				}
				else if(randomNumber > value) { //������
					TrialText.setBackground(Color.BLUE);
					TrialText.setText("�ʹ� �����ϴ�. ");
				}
			}
			catch(Exception exp) {
				TrialText.setBackground(null);
				TrialText.setText("������ �Է��ϼ���");
			}
			finally {
				i++;
				TrialLabel.setText("�õ�Ƚ��: "+ i);
			}
		}
		if(e.getSource() == Exit) {
			System.exit(0);
		}
	}
}
