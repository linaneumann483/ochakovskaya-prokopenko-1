import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

//LEARNING ENGLISH 

public class WorkPanel extends JPanel {
	private static User polzovatel;
	Font font = new Font("Verdana", Font.PLAIN, 25);
	private static ArrayList<Voc> v;
	private static ArrayList<Voc> v1;
	private static ArrayList<Voc> v2;
	private static int numCorrect;
	private static int num;
	private static File myVoc;
	private static final long serialVersionUID = -5190477996505555780L;
	private File userfile, vocfile;
	JLabel warn = new JLabel("");
	JTextField login = new JTextField("", 15);
	JPasswordField password = new JPasswordField("", 15);

	public WorkPanel() throws ClassNotFoundException, IOException {
		setBackground(Color.yellow);
		Test(0);
	}

	public void Test(int w) throws ClassNotFoundException, IOException {
		switch (w) {
		case 0: {
			// LOG IN
			warn = new JLabel("");
			login = new JTextField("", 15);
			password = new JPasswordField("", 15);

			JButton register = new JButton("Sign up");
			JButton enter = new JButton("Sign in");
			JLabel log = new JLabel("login");
			JLabel pass = new JLabel("password");

			userfile = new File("users.txt");
			vocfile = new File("vocab.txt");
			add(login);
			add(password);
			add(register);
			add(enter);
			add(log);
			add(pass);
			add(warn);
			warn.setForeground(Color.RED);
			warn.setBounds(180, 190, 200, 25);
			log.setBounds(130, 50, 100, 25);
			pass.setBounds(100, 110, 100, 25);
			login.setBounds(180, 50, 140, 25);
			password.setBounds(180, 110, 140, 25);
			register.setBounds(120, 150, 100, 30);
			enter.setBounds(280, 150, 100, 30);

			upAction up = new upAction(userfile);
			register.addActionListener(up);

			inAction in = new inAction(userfile);
			enter.addActionListener(in);
		}
			break;
		case 1: {
			// MENU
			JButton test1 = new JButton("Начать обучение");
			JButton test2 = new JButton("Смотреть словари");
			JButton test3 = new JButton("Смотреть результаты");
			JButton test5 = new JButton("Пофиксить");
			JButton test4 = new JButton("Выйти нафиг");
			add(test1);
			test1.setBounds(250, 50, 150, 50);
			add(test2);
			test2.setBounds(250, 110, 150, 50);
			add(test3);
			test3.setBounds(250, 170, 150, 50);
			add(test4);
			test4.setBounds(250, 290, 150, 50);
			add(test5);
			test5.setBounds(250, 230, 150, 50);

			ButtonAction forTests = new ButtonAction(2);
			// ButtonAction forUser = new ButtonAction(6);
			// ButtonAction forVocs = new ButtonAction(7);
			ButtonAction forEnter = new ButtonAction(0);
			ButtonAction forFix = new ButtonAction(5);
			test1.addActionListener(forTests);
			// test2.addActionListener(forUser);
			// test3.addActionListener(forVocs);
			test4.addActionListener(forEnter);
			test5.addActionListener(forFix);

		}
			break;
		case 2: {
			// TEST1
			repaint();
			JButton goBack = new JButton("To menu");
			add(goBack);

			goBack.setBounds(10, 10, 100, 20);
			ButtonAction1 act = new ButtonAction1();
			goBack.addActionListener(act);

			Voc[] masW = new Voc[3];// local vocabulary, words in this test
			Voc masT = new Voc();// right answer

			for (int ii = 0; ii < 3; ii++) {
				masW[ii] = new Voc();
			}

			Rand r = new Rand(3, v.size());
			int[] a = r.getNumbers();

			masW[0] = v.get(a[0]);
			masW[1] = v.get(a[1]);
			masW[2] = v.get(a[2]);

			r = new Rand(1, 3);
			int ind = r.getNumbers()[0];
			masT = masW[ind];

			String forText = masT.getRandTransl();

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
		case 3: {
			// TEST2
			JButton goBack = new JButton("To menu");
			goBack.setBounds(10, 10, 100, 20);
			add(goBack);

			ButtonAction1 act = new ButtonAction1();
			goBack.addActionListener(act);

			Voc[] masW = new Voc[3];
			Voc masT = new Voc();
			for (int ii = 0; ii < 3; ii++) {
				masW[ii] = new Voc();
			}

			Rand r = new Rand(3, v.size());
			int[] a = r.getNumbers();

			masW[0] = v.get(a[0]);
			masW[1] = v.get(a[1]);
			masW[2] = v.get(a[2]);

			r = new Rand(1, 3);
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
		}
			break;
		case 4: {
			// TEST3
			JButton goBack = new JButton("To menu");
			goBack.setBounds(10, 10, 100, 20);
			add(goBack);
			setBackground(Color.yellow);
			ButtonAction1 act = new ButtonAction1();
			goBack.addActionListener(act);

			Voc[] masW = new Voc[3];
			for (int ii = 0; ii < 3; ii++) {
				masW[ii] = new Voc();
			}

			Rand r = new Rand(3, v.size());
			int[] a = r.getNumbers();

			masW[0] = v.get(a[0]);
			masW[1] = v.get(a[1]);
			masW[2] = v.get(a[2]);

			JLabel labe1 = new JLabel("1." + masW[0].getWord());
			labe1.setFont(font);
			labe1.setBounds(50, 40, 150, 50);
			labe1.setBackground(Color.green);
			labe1.setVisible(true);

			JLabel labe2 = new JLabel("2." + masW[1].getWord());
			labe2.setFont(font);
			labe2.setBounds(50, 100, 150, 50);
			labe2.setBackground(Color.green);
			labe2.setVisible(true);

			JLabel labe3 = new JLabel("3." + masW[2].getWord());
			labe3.setFont(font);
			labe3.setBounds(50, 160, 150, 50);
			labe3.setBackground(Color.green);

			r = new Rand(3, 3);
			a = r.getNumbers();

			JLabel labe4 = new JLabel(masW[a[0]].getRandTransl());
			labe4.setFont(font);
			labe4.setBounds(250, 40, 150, 50);
			labe4.setBackground(Color.green);
			labe4.setVisible(true);

			JLabel labe5 = new JLabel(masW[a[1]].getRandTransl());
			labe5.setFont(font);
			labe5.setBounds(250, 100, 150, 50);
			labe5.setBackground(Color.GREEN);
			labe5.setVisible(true);

			JLabel labe6 = new JLabel(masW[a[2]].getRandTransl());
			labe6.setFont(font);
			labe6.setBounds(250, 160, 150, 50);
			labe6.setBackground(Color.GREEN);
			labe6.setVisible(true);

			JTextField fie1 = new JTextField();
			fie1.setFont(font);
			fie1.setBounds(405, 40, 50, 50);
			JTextField fie2 = new JTextField();
			fie2.setFont(font);
			fie2.setBounds(405, 100, 50, 50);
			JTextField fie3 = new JTextField();
			fie3.setFont(font);
			fie3.setBounds(405, 160, 50, 50);

			add(labe1);
			add(labe2);
			add(labe3);
			add(labe4);
			add(labe5);
			add(labe6);
			add(fie1);
			add(fie2);
			add(fie3);

			JButton checkIt = new JButton("Check All");
			ButtonActionCh check = new ButtonActionCh(masW, fie1, fie2, fie3, a);
			checkIt.addActionListener(check);
			checkIt.setFont(font);
			checkIt.setBounds(200, 300, 300, 50);
			add(checkIt);

		}
			break;
		case 5: {
			// CHECK NUM/NUMCORRECT
			setBackground(Color.CYAN);
			JLabel what = new JLabel("Что вы хотите настроить?");
			what.setFont(font);
			what.setBounds(100, 20, 300, 70);
			add(what);

			JLabel laba1 = new JLabel("Количество слов для изучения");
			JLabel laba2 = new JLabel("Количество правильных ответов");

			JTextField bu1 = new JTextField(polzovatel.getNumber());
			bu1.setBounds(200, 100, 50, 50);
			add(bu1);
			JTextField bu2 = new JTextField(polzovatel.getNumCorrect());
			bu2.setBounds(200, 200, 50, 50);
			add(bu2);

			laba1.setBounds(100, 100, 250, 50);
			laba2.setBounds(100, 150, 250, 50);

			add(laba1);
			add(laba2);

			JButton myBut = new JButton();
			ButtonActionKnop bb1 = new ButtonActionKnop(bu1, bu2);
			myBut.addActionListener(bb1);
			myBut.setBounds(300, 100, 50, 50);
			add(myBut);
		}
			break;
		}
	}

	public void setVis(boolean a) {
		setVisible(a);
	}

	private class ButtonActionKnop implements ActionListener {
		JTextField n;
		JTextField nc;

		public ButtonActionKnop(JTextField a, JTextField b) {
			n = a;
			nc = b;
		}

		public void actionPerformed(ActionEvent e) {
			num = Integer.valueOf(n.getText());
			numCorrect = Integer.valueOf(nc.getText());
			removeAll();
			try {
				Test(2);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			repaint();
		}
	}

	private class ButtonActionCh implements ActionListener {
		Voc[] words;
		JTextField f;
		JTextField s;
		JTextField t;
		int[] n;

		public ButtonActionCh(Voc[] x, JTextField y, JTextField c, JTextField z, int[] a) {
			words = x;
			f = y;
			s = c;
			t = z;
			n = a;
		}

		public void actionPerformed(ActionEvent e) {
			int val1, val2, val3;
			try {
				val1 = Integer.valueOf(f.getText()) - 1;
				if (words[val1].getWord().equals(words[n[0]].getWord())) {
					words[val1].setCorrect(words[val1].getCorrect() + 1);
					if (words[val1].getCorrect() >= numCorrect) {
						// words[val1].AddToLearnt();
						System.out.println("Add to learnt");
					}
				}
				System.out
						.println("Val is:" + val1 + " Your answer:" + words[val1].getWord() + words[val1].getCorrect());
			} catch (NumberFormatException c) {
			}

			try {
				val2 = Integer.valueOf(s.getText()) - 1;
				if (words[val2].getWord().equals(words[n[1]].getWord())) {
					words[val2].setCorrect(words[val2].getCorrect() + 1);
					if (words[val2].getCorrect() >= numCorrect) {
						// words[val2].AddToLearnt();
						System.out.println("Add to learnt");
					}
				}
				System.out
						.println("Val is:" + val2 + " Your answer:" + words[val2].getWord() + words[val2].getCorrect());

			} catch (NumberFormatException c) {
			}

			try {
				val3 = Integer.valueOf(t.getText()) - 1;
				if (words[val3].getWord().equals(words[n[2]].getWord())) {
					words[val3].setCorrect(words[val3].getCorrect() + 1);
					if (words[val3].getCorrect() >= numCorrect) {
						// words[val3].AddToLearnt();
						System.out.println("Add to learnt" + words[val3].getCorrect());
					}
				}
				System.out
						.println("Val is:" + val3 + "Your answer:" + words[val3].getWord() + words[val3].getCorrect());
			} catch (NumberFormatException c) {
			}
			removeAll();
			try {
				Test(2);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			repaint();
		}

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
				myanswer.setCorrect(myanswer.getCorrect() + 1);
			}

			System.out.println(myanswer.getWord() + myanswer.getCorrect());
			removeAll();
			try {
				Test(3);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
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
				myanswer.setCorrect(myanswer.getCorrect() + 1);
				if (answer.getCorrect() >= numCorrect) {
					// answer.AddToLearnt();
					System.out.println("Add to learnt");
				}
			}

			System.out.println(myanswer.getWord() + myanswer.getCorrect());
			removeAll();
			try {
				Test(4);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}
	}

	private class ButtonAction1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			removeAll();
			try {
				Test(1);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

	private class ButtonAction implements ActionListener {
		private int whatPanel;

		public ButtonAction(int a) {
			whatPanel = a;
		}

		public void actionPerformed(ActionEvent event) {
			removeAll();
			try {
				Test(whatPanel);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

	private class upAction implements ActionListener {
		private List<User> use2;
		private List<Voc> tmp;
		private InputUser a = new InputUser();
		private InputVoc b = new InputVoc();
		private File ff;

		public upAction(File f) {
			this.ff = f;

		}

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			String txt = null;
			if ((login.getText().equals("")) || (password.getText().equals(""))) {
				txt = "Error! Empty field";
				warn.setText(txt);
			}

			else {
				try {
					use2 = a.readFromVoc(ff);
					if (use2 != null) {
						for (int i = 0; i < use2.size(); i++) {
							if (use2.get(i).getLogin().equals(login.getText())) {
								txt = "Error! This login already exists";
								warn.setText(txt);
								break;
							} else {
								if (i == use2.size() - 1) {
									User e = new User();
									e.setLogin(login.getText());
									e.setPassword(password.getText());
									try {
										tmp = b.Create(vocfile);
										File f2 = new File("" + e.getLogin() + "(1.1).txt");
										b.addToVoc(tmp, f2);
										e.setCommon(f2);
									} catch (ClassNotFoundException | IOException e1) {
										e1.printStackTrace();
									}
									File f3 = new File("" + e.getLogin() + "(1).txt");
									e.setProc(f3);
									File f4 = new File("" + e.getLogin() + "(2).txt");
									e.setDone(f4);
									use2.add(e);
									a.addToVoc(use2, ff);
									txt = "Registration complete!";
									warn.setText(txt);
									break;
								}
							}

						}
					} else {
						User e = new User();
						e.setLogin(login.getText());
						e.setPassword(password.getText());
						try {
							tmp = b.Create(vocfile);
							File f2 = new File("" + e.getLogin() + "(1.1).txt");
							b.addToVoc(tmp, f2);
							e.setCommon(f2);
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						File f3 = new File("" + e.getLogin() + "(1).txt");
						e.setProc(f3);
						File f4 = new File("" + e.getLogin() + "(2).txt");
						e.setDone(f4);
						use2 = new ArrayList<User>();
						use2.add(e);
						a.addToVoc(use2, ff);
						txt = "Registration complete!";
						warn.setText(txt);
					}

				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}

		}

	}

	private class inAction implements ActionListener {
		private List<User> use2;
		private InputUser a = new InputUser();
		private File ff;

		public inAction(File f) {
			this.ff = f;

		}

		public void actionPerformed(ActionEvent event) {
			String txt = null;
			if ((login.getText().equals("")) || (password.getText().equals(""))) {
				txt = "Error! Empty field";
				warn.setText(txt);
			} else {
				try {
					use2 = a.readFromVoc(ff);
					if (use2 != null) {
						for (int i = 0; i < use2.size(); i++) {
							if ((use2.get(i).getLogin().equals(login.getText()))
									&& (use2.get(i).getPassword().equals(password.getText()))) {
								polzovatel = use2.get(i);
								InputVoc inp = new InputVoc();
								v = inp.readFromVoc(polzovatel.getCommon());
								v1 = inp.readFromVoc(polzovatel.getProc());
								v2 = inp.readFromVoc(polzovatel.getDone());
								num = polzovatel.getNumber();
								numCorrect = polzovatel.getNumCorrect();
								removeAll();
								Test(1);
								repaint();
								break;
							} else {
								txt = "Error! Incorrect login or password";
								warn.setText(txt);
							}
						}
					} else {
						txt = "Error! No registered users found";
						warn.setText(txt);
					}
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
}