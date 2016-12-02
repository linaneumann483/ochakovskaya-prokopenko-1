import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class WorkPanel extends JPanel {

	public WorkPanel() {

		setBackground(Color.black);
		JButton test1 = new JButton("Test 1");
		JButton test2 = new JButton("Test 2");
		JButton test3 = new JButton("Test 3");
		add(test1);
		add(test2);
		add(test3);
		ButtonAction firstTest = new ButtonAction(1);
		ButtonAction secTest = new ButtonAction(2);
		ButtonAction thirdTest = new ButtonAction(3);
		test1.addActionListener(firstTest);
		test2.addActionListener(secTest);
		test3.addActionListener(thirdTest);
	}

	public void Test(int w) {
		switch (w) {
		case 1: {
			Voc[] v = Test1.v;
			Voc[] masW = new Voc[v.length];
			Voc masT = new Voc();
			for (int ii = 0; ii < v.length; ii++) {
				masW[ii] = new Voc();
			}
			masW[0] = v[1];
			masW[1] = v[0];
			masW[2] = v[2];

			int ind = 2;
			masT = masW[ind];

			setBackground(Color.green);

			JLabel text = new JLabel(masT.getTranslation());
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
			add(first);
			add(second);
			add(third);
		}
			break;
		case 2:{
			
			Voc[] v = Test1.v;
			Voc[] masW = new Voc[v.length];
			Voc masT = new Voc();
			for (int ii = 0; ii < v.length; ii++) {
				masW[ii] = new Voc();
			}
			masW[0] = v[2];
			masW[1] = v[0];
			masW[2] = v[1];

			int ind = 1;
			masT = masW[ind];

			setBackground(Color.blue);

			JLabel text = new JLabel(masT.getWord());
			ButtonGroup g = new ButtonGroup();

			JRadioButton first = new JRadioButton(masW[2].getTranslation());
			g.add(first);
			TestCheckAction1 f = new TestCheckAction1  (masW[2], masT);
			first.addActionListener(f);

			JRadioButton second = new JRadioButton(masW[1].getTranslation());
			g.add(second);
			TestCheckAction1 f1 = new TestCheckAction1 (masW[1], masT);
			second.addActionListener(f1);

			JRadioButton third = new JRadioButton(masW[0].getTranslation());
			g.add(third);
			TestCheckAction1 f2 = new TestCheckAction1 (masW[0], masT);
			third.addActionListener(f2);

			add(text);
			add(first);
			add(second);
			add(third);
		}}
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

		public TestCheckAction1 (Voc a, Voc b) {
			this.myanswer = a;
			this.answer = b;
		}

		public void actionPerformed(ActionEvent e) {
			if (answer.getWord().equals(myanswer.getWord())) {
				myanswer.setCorrect(myanswer.getcorrect() + 1);
			}

			System.out.println(myanswer.getWord() + myanswer.getcorrect());
			removeAll();
			Test(1);
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

