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
		setTitle("숫자 게임");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InputPanel = new JPanel();
		
		InputLabel = new JLabel("숫자를 추측하세요");
		InputText = new JTextField();
		InputText.setColumns(10);
		
		InputPanel.add(InputLabel);
		InputPanel.add(InputText);
		
		add(InputPanel, BorderLayout.NORTH);
		
		//-----------------------------------------
		
		ResultPanel = new JPanel();
		
		TrialLabel = new JLabel("시도횟수: "+i);
		
		TrialText = new JTextField();
		TrialText.setColumns(15);
		TrialText.setEditable(false);
		
		ResultPanel.add(TrialText);
		ResultPanel.add(TrialLabel);
		
		add(ResultPanel, BorderLayout.CENTER);
		
		
		//------------------------------------------
		
		ButtonPanel = new JPanel();
		
		TryAgain = new JButton("다시 한번");
		Exit = new JButton("종료");
		
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
			// 정수값이 아니기 때문에 에러처리 필요
			try{
				int value = Integer.valueOf(InputText.getText());
				// 정수값 확인, 정상 작동
				if(randomNumber < value) { //높을때
					TrialText.setBackground(Color.RED);
					TrialText.setText("너무 높습니다.");
				}
				else if(randomNumber == value) { //맞을때
					TrialText.setBackground(Color.green);
					TrialText.setText("맞았습니다.");
				}
				else if(randomNumber > value) { //낮을때
					TrialText.setBackground(Color.BLUE);
					TrialText.setText("너무 낮습니다. ");
				}
			}
			catch(Exception exp) {
				TrialText.setBackground(null);
				TrialText.setText("정수만 입력하세요");
			}
			finally {
				i++;
				TrialLabel.setText("시도횟수: "+ i);
			}
		}
		if(e.getSource() == Exit) {
			System.exit(0);
		}
	}
}
