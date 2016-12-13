import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class WorkPanel extends JPanel {
	private static final long serialVersionUID = -5190477996505555780L;
	private static Image im;
	
	public WorkPanel() {
		setMaximumSize(new java.awt.Dimension(600, 400));
		Test(0);
	}
	

	public void Test(int w) {
		switch (w) {
		case 0:{
			removeAll();
			setBackground(Color.green);
			
			JButton test1 = new JButton("Test 1");
			JButton test2 = new JButton("Test 2");
			JButton test3 = new JButton("Test 3");
			add(test1);
			test1.setBounds(100, 150, 100, 50);
			add(test2);
			test2.setBounds(210, 150, 100, 50);
			add(test3);
			test3.setBounds(320, 150, 100, 50);
			ButtonAction firstTest = new ButtonAction(1);
			ButtonAction secTest = new ButtonAction(2);
			ButtonAction thirdTest = new ButtonAction(1);
			test1.addActionListener(firstTest);
			test2.addActionListener(secTest);
			test3.addActionListener(thirdTest);
			
		} break;
		case 1: {
			im = new ImageIcon("1.jpg").getImage();
			Graphics gr = getGraphics();
			gr.drawImage(im, 0, 0, 600, 400, null);
			
			Font font = new Font("Verdana", Font.PLAIN, 25);
			JButton goBack = new JButton("To menu");
			add (goBack);
			goBack.setBounds(10, 10, 100, 20);
			ButtonAction1 act = new ButtonAction1();
			goBack.addActionListener(act);
			
			Voc[] v = Test1.v;
			Voc[] masW = new Voc[3];//local vocabulary, words in this test
			Voc masT = new Voc();//right answer
			
			for (int ii = 0; ii < 3; ii++) {
				masW[ii] = new Voc();
			}
			
			Rand r = new Rand(3,v.length);
			int[] a = r.getNumbers();
			
			masW[0] = v[a[0]];
			masW[1] = v[a[1]];
			masW[2] = v[a[2]];
		
			r = new Rand(1,3);
			int ind = r.getNumbers()[0];
			masT = masW[ind];
			 
			String forText=masT.getRandTransl();

			JLabel text = new JLabel(forText);
			text.setBackground(Color.green);
			text.setOpaque(true);
			text.setFont(font);
			text.setHorizontalAlignment(JLabel.RIGHT);
			ButtonGroup g = new ButtonGroup();

			JRadioButton first = new JRadioButton(masW[2].getWord());
			g.add(first);
			TestCheckAction f = new TestCheckAction(masW[2], masT);
			first.addActionListener(f);

			JRadioButton second = new JRadioButton(masW[1].getWord());
			g.add(second);
			TestCheckAction f1 = new TestCheckAction(masW[1], masT);
			second.addActionListener(f1);

			JRadioButton third = new JRadioButton(masW[0].getWord());
			g.add(third);
			TestCheckAction f2 = new TestCheckAction(masW[0], masT);
			third.addActionListener(f2);
			
			
			add(text);
			text.setBounds(130, 150, 150, 40);
			text.setVisible(true);
			add(first);
			first.setBackground(Color.GREEN);
			first.setFont(font);
			first.setBounds(300, 50, 150, 40);
			first.setVisible(true);
			add(second);
			second.setFont(font);
			second.setBackground(Color.GREEN);
			second.setBounds(300, 150, 150, 40);
			second.setVisible(true);
			add(third);
			third.setFont(font);
			third.setBackground(Color.GREEN);
			third.setBounds(300, 250, 150, 40);
			third.setVisible(true);
		}
			break;
		case 2: {
			im = new ImageIcon("1.jpg").getImage();
			Graphics gr = getGraphics();
			gr.drawImage(im, 0, 0, 600, 400, null);
			
			Font font = new Font("Verdana", Font.PLAIN, 25);
			JButton goBack = new JButton("To menu");
			add (goBack);
			
			ButtonAction1 act = new ButtonAction1();
			goBack.addActionListener(act);

			Voc[] v = Test1.v;
			Voc[] masW = new Voc[3];
			Voc masT = new Voc();
			for (int ii = 0; ii <3; ii++) {
				masW[ii] = new Voc();
			}
			
			Rand r = new Rand(3,v.length);
			int[] a = r.getNumbers();
			
			masW[0] = v[a[0]];
			masW[1] = v[a[1]];
			masW[2] = v[a[2]];
			
			r = new Rand(1,3);
			int ind = r.getNumbers()[0];
			masT = masW[ind];

			JLabel text = new JLabel(masT.getWord());
			text.setFont(font);
			text.setOpaque(true);
			text.setBackground(Color.green);
			text.setHorizontalAlignment(JLabel.RIGHT);
			ButtonGroup g = new ButtonGroup();

			JRadioButton first = new JRadioButton(masW[2].getTransl(0));
			g.add(first);
			TestCheckAction1 f = new TestCheckAction1(masW[2], masT);
			first.addActionListener(f);

			JRadioButton second = new JRadioButton(masW[1].getRandTransl());
			g.add(second);
			TestCheckAction1 f1 = new TestCheckAction1(masW[1], masT);
			second.addActionListener(f1);

			JRadioButton third = new JRadioButton(masW[0].getRandTransl());
			g.add(third);
			TestCheckAction1 f2 = new TestCheckAction1(masW[0], masT);
			third.addActionListener(f2);
			
				add(text);
				text.setBounds(130, 150, 150, 40);
				text.setVisible(true);
				add(first);
				first.setBackground(Color.GREEN);
				first.setFont(font);
				first.setBounds(300, 50, 150, 40);
				first.setVisible(true);
				add(second);
				second.setFont(font);
				second.setBackground(Color.GREEN);
				second.setBounds(300, 150, 150, 40);
				second.setVisible(true);
				add(third);
				third.setFont(font);
				third.setBackground(Color.GREEN);
				third.setBounds(300, 250, 150, 40);
				third.setVisible(true);
		} break;
		case 3:{
			
		} break;
		}
	}

	public void setVis(boolean a) {
		setVisible(a);
	}

	private class TestCheckAction implements ActionListener {
		Voc answer;
		Voc myanswer;

		public TestCheckAction(Voc a, Voc b) {
			this.myanswer = a;
			this.answer = b;
		}

		public void actionPerformed(ActionEvent e) {
			if (answer.getWord().equals(myanswer.getWord())) {
				myanswer.setCorrect(myanswer.getcorrect() + 1);
			}

			System.out.println(myanswer.getWord() + myanswer.getcorrect());
			removeAll();
			Test(2);
			revalidate();
		}
	}

	private class TestCheckAction1 implements ActionListener {
		Voc answer;
		Voc myanswer;

		public TestCheckAction1(Voc a, Voc b) {
			this.myanswer = a;
			this.answer = b;
		}

		public void actionPerformed(ActionEvent e) {
			if (answer.getWord().equals(myanswer.getWord())) {
				myanswer.setCorrect(myanswer.getcorrect() + 1);
				if (answer.getcorrect()>=Test1.num){
					answer.AddToLearnt();
				}
			}

			System.out.println(myanswer.getWord() + myanswer.getcorrect());
			System.out.println(answer.getWord() + answer.getcorrect());
			removeAll();
			Test(1);
			revalidate();
		}
	}
	
	private class ButtonAction1 implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			removeAll();
			Test(0);
			revalidate();
		}		
	}

	private class ButtonAction implements ActionListener {
		private int whatPanel;

		public ButtonAction(int a) {
			whatPanel = a;
		}

		public void actionPerformed(ActionEvent event) {
			removeAll();
			Test(whatPanel);
			revalidate();
		}
	}
}
