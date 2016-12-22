import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
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
	private static int numCorrect;
	private static int num;
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
				setBackground(Color.lightGray);
				Font font1 = new Font ("Veranda",Font.PLAIN,18);
				warn = new JLabel("");
				login = new JTextField("", 15);
				password = new JPasswordField("", 15);

				JButton register = new JButton("Регистрация");
				JButton enter = new JButton("Войти");
				JLabel log = new JLabel("Логин");
				JLabel pass = new JLabel("Пароль");

				userfile = new File("users.txt");
				vocfile = new File("vocab.txt");
				add(login);
				login.setFont(font1);
				add(password);
				password.setFont(font1);
				add(register);
				register.setFont(font1);
				add(enter);
				enter.setFont(font1);
				add(log);
				log.setFont(font1);
				add(pass);
				pass.setFont(font1);
				add(warn);
				warn.setFont(font1);
				warn.setForeground(Color.RED);
				warn.setBounds(150, 190, 400, 25);
				log.setBounds(160, 50, 100, 30);
				pass.setBounds(130, 110, 130, 30);
				login.setBounds(230, 50, 140, 25);
				password.setBounds(230, 110, 140, 25);
				register.setBounds(170, 150, 150, 30);
				enter.setBounds(330, 150, 100, 30);

				upAction up = new upAction(userfile);
				register.addActionListener(up);

				inAction in = new inAction(userfile);
				enter.addActionListener(in);
			}
				break;
			case 1: {
				// MENU
				Font font1 = new Font("Times New Romance",Font.BOLD,20);
				setBackground(Color.YELLOW);
				JButton test1 = new JButton("Тесты");
				JButton test2 = new JButton("Неизученные");
				JButton test3 = new JButton("Результаты");
				JButton test5 = new JButton("Настройки");
				JButton test4 = new JButton("Выход");
				add(test1);
				test1.setFont(font1);
				test1.setBounds(200, 50, 200, 50);
				add(test2);
				test2.setFont(font1);
				test2.setBounds(200, 110, 200, 50);
				add(test3);
				test3.setFont(font1);
				test3.setBounds(200, 170, 200, 50);
				add(test4);
				test4.setFont(font1);
				test4.setBounds(200, 290, 200, 50);
				add(test5);
				test5.setFont(font1);
				test5.setBounds(200, 230, 200, 50);

				ButtonAction forTests = new ButtonAction(2);
				ButtonAction forUser = new ButtonAction(6);
				ButtonAction forVocs = new ButtonAction(7);
				ButtonAction forEnter = new ButtonAction(0);
				ButtonAction forFix = new ButtonAction(5);
				test1.addActionListener(forTests);
				test3.addActionListener(forUser);
				test2.addActionListener(forVocs);
				test4.addActionListener(forEnter);
				test5.addActionListener(forFix);

			}
				break;
			case 2: {
				if ((v.size()>0)||(v1.size()>0)){
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
				Rand r = new Rand(3, v1.size());
				int[] a = r.getNumbers();

				masW[0] = v1.get(a[0]);
				masW[1] = v1.get(a[1]);
				masW[2] = v1.get(a[2]);

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
				text.setBounds(50, 150, 200, 40);
				text.setVisible(true);
				add(first);
				first.setBackground(Color.GREEN);
				first.setFont(font);
				first.setBounds(300, 50, 200, 40);
				first.setVisible(true);
				add(second);
				second.setFont(font);
				second.setBackground(Color.GREEN);
				second.setBounds(300, 150, 200, 40);
				second.setVisible(true);
				add(third);
				third.setFont(font);
				third.setBackground(Color.GREEN);
				third.setBounds(300, 250, 200, 40);
				third.setVisible(true);
				}else {
					JLabel OKAY = new JLabel ("Well done!");
					OKAY.setBounds(100,100,100,100);
					add(OKAY);
				} }
				break;
			case 3: {
				if ((v.size()>0)||(v1.size()>0)){
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

				Rand r = new Rand(3, v1.size());
				int[] a = r.getNumbers();

				masW[0] = v1.get(a[0]);
				masW[1] = v1.get(a[1]);
				masW[2] = v1.get(a[2]);

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
				text.setBounds(50, 150, 200, 40);
				text.setVisible(true);
				add(first);
				first.setBackground(Color.GREEN);
				first.setFont(font);
				first.setBounds(300, 50, 200, 40);
				first.setVisible(true);
				add(second);
				second.setFont(font);
				second.setBackground(Color.GREEN);
				second.setBounds(300, 150, 200, 40);
				second.setVisible(true);
				add(third);
				third.setFont(font);
				third.setBackground(Color.GREEN);
				third.setBounds(300, 250, 200, 40);
				third.setVisible(true);
			}else {
				JLabel OKAY = new JLabel ("Well done!");
				OKAY.setBounds(100,100,100,100);
				add(OKAY);
			}}
				break;
			case 4: {
				if ((v.size()>0)||(v1.size()>0)){
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

				Rand r = new Rand(3, v1.size());
				int[] a = r.getNumbers();

				masW[0] = v1.get(a[0]);
				masW[1] = v1.get(a[1]);
				masW[2] = v1.get(a[2]);
				Font myFont = new Font("Times New Roman", Font.BOLD, 17);
				JLabel labe1 = new JLabel("1." + masW[0].getWord());
				labe1.setFont(myFont);
				labe1.setBounds(50, 40, 150, 50);
				labe1.setBackground(Color.green);
				labe1.setVisible(true);

				JLabel labe2 = new JLabel("2." + masW[1].getWord());
				labe2.setFont(myFont);
				labe2.setBounds(50, 100, 150, 50);
				labe2.setBackground(Color.green);
				labe2.setVisible(true);

				JLabel labe3 = new JLabel("3." + masW[2].getWord());
				labe3.setFont(myFont);
				labe3.setBounds(50, 160, 150, 50);
				labe3.setBackground(Color.green);

				r = new Rand(3, 3);
				a = r.getNumbers();

				JLabel labe4 = new JLabel(masW[a[0]].getRandTransl());
				labe4.setFont(myFont);
				labe4.setBounds(250, 40, 150, 50);
				labe4.setBackground(Color.green);
				labe4.setVisible(true);

				JLabel labe5 = new JLabel(masW[a[1]].getRandTransl());
				labe5.setFont(myFont);
				labe5.setBounds(250, 100, 150, 50);
				labe5.setBackground(Color.GREEN);
				labe5.setVisible(true);

				JLabel labe6 = new JLabel(masW[a[2]].getRandTransl());
				labe6.setFont(myFont);
				labe6.setBounds(250, 160, 150, 50);
				labe6.setBackground(Color.GREEN);
				labe6.setVisible(true);

				JTextField fie1 = new JTextField();
				fie1.setFont(myFont);
				fie1.setBounds(405, 40, 50, 50);
				JTextField fie2 = new JTextField();
				fie2.setFont(myFont);
				fie2.setBounds(405, 100, 50, 50);
				JTextField fie3 = new JTextField();
				fie3.setFont(myFont);
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

			}else {
				JLabel OKAY = new JLabel ("Well done!");
				OKAY.setBounds(100,100,100,100);
				add(OKAY);
			}}
				break;
			case 5: {
				// CHECK NUM/NUMCORRECT

				JButton goBack = new JButton("To menu");
				goBack.setBounds(10, 10, 100, 20);
				add(goBack);
				ButtonAction1 act = new ButtonAction1();
				goBack.addActionListener(act);

				setBackground(Color.CYAN);
				JLabel what = new JLabel("Что вы хотите настроить?");
				what.setFont(font);
				what.setBounds(50, 20, 400, 70);
				add(what);

				JLabel laba1 = new JLabel("Количество слов для изучения");
				JLabel laba2 = new JLabel("Количество правильных ответов");
				int a = polzovatel.getNumber();
				JTextField bu1 = new JTextField();
				bu1.setText(Integer.toString(a));
				bu1.setFont(font);
				bu1.setBounds(400, 100, 50, 50);
				add(bu1);
				a = polzovatel.getNumCorrect();
				JTextField bu2 = new JTextField();
				bu2.setText(Integer.toString(a));
				bu2.setFont(font);
				bu2.setBounds(400, 200, 50, 50);
				add(bu2);

				Font myFont = new Font("Verdana", Font.ITALIC, 17);
				laba1.setBounds(50, 100, 300, 50);
				laba1.setFont(myFont);
				laba2.setBounds(50, 200, 300, 50);
				laba2.setFont(myFont);

				add(laba1);
				add(laba2);

				JButton myBut = new JButton("Применить");
				ButtonActionKnop bb1 = new ButtonActionKnop(bu1, bu2);
				myBut.addActionListener(bb1);
				myBut.setFont(font);
				myBut.setBounds(200, 300, 200, 50);
				add(myBut);
			}
				break;
			case 6: {
				JButton goBack = new JButton("To menu");
				goBack.setBounds(10, 10, 100, 20);
				add(goBack);
				ButtonAction1 act = new ButtonAction1();
				goBack.addActionListener(act);

				JButton show = new JButton("Изученные");
				JButton show1 = new JButton("Изучаемые");
				JTextArea txt = new JTextArea(50, 50);
				final JScrollPane pn = new JScrollPane(txt);

				add(show);
				add(show1);
				show.setBounds(20, 40, 150, 30);
				show1.setBounds(20, 80, 130, 30);

				add(pn);
				pn.setBounds(190, 40, 300, 300);
				pn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				pn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pn.setVisible(false);
				showAction sh = new showAction(txt, pn, polzovatel.getDone());
				showAction1 sh1 = new showAction1(txt, pn, polzovatel.getProc());
				show.addActionListener(sh);
				show1.addActionListener(sh1);
			}
			case 7: {
				JButton goBack = new JButton("To menu");
				goBack.setBounds(10, 10, 100, 20);
				add(goBack);
				ButtonAction1 act = new ButtonAction1();
				goBack.addActionListener(act);

				JButton show = new JButton("Show vocab");
				JTextArea txt = new JTextArea(50, 50);
				final JScrollPane pn = new JScrollPane(txt);
				//add(show);
				show.setBounds(20, 40, 130, 30);
				add(pn);
				pn.setBounds(190, 40, 300, 300);
				pn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				pn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				pn.setVisible(true);
				showAction sh = new showAction(txt, pn, polzovatel.getCommon());
				show.addActionListener(sh);
			}break;
			}}

	private class showAction implements ActionListener {
		// SHOW VOC
		JTextArea txt;
		JScrollPane pn;
		File ff;

		showAction(JTextArea a, JScrollPane b, File f) {
			txt = a;
			pn = b;
			ff = f;
			
			ArrayList<Voc> l = new ArrayList<Voc>();
			String text = "";
			InputVoc in = new InputVoc();
			try {
				l = in.readFromVoc(ff);
				try {
					for (int i = 0; i < l.size(); i++) {
						text = text + "  " + l.get(i).getWord() + " - " + l.get(i).getTrans() + "; \n";
					}
					txt.setText(text);
				} catch (NullPointerException e) {
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			pn.setVisible(true);

		}

		public void actionPerformed(ActionEvent event) {
			ArrayList<Voc> l = new ArrayList<Voc>();
			String text = "";
			InputVoc in = new InputVoc();
			try {
				l = in.readFromVoc(ff);
				try {
					for (int i = 0; i < l.size(); i++) {
						text = text + "  " + l.get(i).getWord() + " - " + l.get(i).getTrans() + "; \n";
					}
					txt.setText(text);
				} catch (NullPointerException e) {
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			pn.setVisible(true);

		}
	}
	private class showAction1 implements ActionListener {
		// SHOW VOC
		JTextArea txt;
		JScrollPane pn;
		File ff;

		showAction1(JTextArea a, JScrollPane b, File f) {
			txt = a;
			pn = b;
			ff = f;
		}

		public void actionPerformed(ActionEvent event) {
			ArrayList<Voc> l = new ArrayList<Voc>();
			String text = "";
			InputVoc in = new InputVoc();
			pn.setVisible(false);
			try {
				try {
					l = in.readFromVoc(ff);
					if (l != null) {
						for (int i = 0; i < l.size(); i++) {
							text = text + "  " + (i + 1) + "." + l.get(i).getWord() + " - " + l.get(i).getTrans()
									+ " - правильных ответов:" + l.get(i).getCorrect() + "; \n";
						}
						txt.setText(text);
						pn.setVisible(true);
					} else {
						JLabel ll = new JLabel("Файл пуст :((");
						ll.setFont(font);
						ll.setBounds(200, 200, 200, 50);
						ll.setForeground(Color.DARK_GRAY);
						add(ll);
						ll.setVisible(true);
					}
				} catch (FileNotFoundException e) {
				}
			} catch (ClassNotFoundException | IOException e) {
			}

		}
	}

	public void setVis(boolean a) {
		setVisible(a);
	}

	private class ButtonActionKnop implements ActionListener {
		// SET NUM/NUMCORRECT
		JTextField n;
		JTextField nc;

		public ButtonActionKnop(JTextField a, JTextField b) {
			n = a;
			nc = b;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				if ((Integer.valueOf(n.getText())==0)||(Integer.valueOf(nc.getText())==0)){
					n.setText("No:(");
					nc.setText("No:(");
				} else {
				num = Integer.valueOf(n.getText());
				polzovatel.setNumber(num);
				numCorrect = Integer.valueOf(nc.getText());
				polzovatel.setNumCorrect(numCorrect);
				InputVoc in = new InputVoc();
				try {
					v1 = in.readFromVoc(polzovatel.getProc());
				} catch (ClassNotFoundException | IOException e2) {
					e2.printStackTrace();
				}
				if (v1 == null){
				Rand r = new Rand(num,v.size()-1);
				int[] mas = r.getNumbers();
				for (int ii=0;ii<num;ii++){
				try {
					in.perekidka(v.get(mas[ii]).getWord(), polzovatel.getCommon(), polzovatel.getProc());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}	
				}
				}
				if (v1.size() <= num) {
					String slovo;
					int raz = num - (v1.size());
					Rand r = new Rand(raz,v.size()-1);
					int[] mas = r.getNumbers();
					for (int zz = 0;zz< raz; zz++){
						System.out.println(mas[zz]);
					}
					for (int i = 0; i < raz; i++) {
						if (v.size()>mas[i]){
						slovo = v.get(mas[i]).getWord();
						try {
							in.perekidka(slovo, polzovatel.getCommon(), polzovatel.getProc());
							v = in.readFromVoc(polzovatel.getCommon());
							v1 = in.readFromVoc(polzovatel.getProc());
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}}
					}

				} else {
					String slovo;
					int raz = (v1.size()) - num;
					Rand r = new Rand(raz,v1.size()-1);
					int[] mas = r.getNumbers();
					for (int i = 0; i < raz; i++) {
						slovo = v1.get(mas[i]).getWord();
						v1.get(mas[i]).setCorrect(0);
						try {
							in.perekidka(slovo, polzovatel.getProc(), polzovatel.getCommon());
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				InputVoc inp = new InputVoc();
				try {
					v = inp.readFromVoc(polzovatel.getCommon());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				try {
					v1 = inp.readFromVoc(polzovatel.getProc());
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}} catch (NumberFormatException c) {
				System.out.println("Не считывается нифига");
			}
			removeAll();
			try {
				Test(2);
			} catch (ClassNotFoundException e1) {
				System.out.println("Не найден класс");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("ИОЕ ексепшн");
				e1.printStackTrace();
			}
			repaint();
		}
	}

	private class ButtonActionCh implements ActionListener {
		// CHECK FOR TEST3
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
					InputVoc inp1 = new InputVoc();
					inp1.addToVoc(v, polzovatel.getCommon());
					inp1.addToVoc(v1, polzovatel.getProc());

					if (words[val1].getCorrect() >= numCorrect) {
						words[val1].AddToLearnt(polzovatel);

						try {
							v1 = inp1.readFromVoc(polzovatel.getProc());// obnovit'
																		// v1
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						if (v.size() > 0){
							Rand r = new Rand(1,v.size()-1);
							int[] mas = r.getNumbers();
							v.get(mas[0]).AddToProc(polzovatel);// 1st word
						}											// add to
																		// Proc, del
																		// from
																		// Common
						try {
							v = inp1.readFromVoc(polzovatel.getCommon());
							v1 = inp1.readFromVoc(polzovatel.getProc());
						} catch (ClassNotFoundException | IOException e1) {

							e1.printStackTrace();
						}

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
					InputVoc inp1 = new InputVoc();
					inp1.addToVoc(v, polzovatel.getCommon());
					inp1.addToVoc(v1, polzovatel.getProc());
					if (words[val2].getCorrect() >= numCorrect) {
						words[val2].AddToLearnt(polzovatel);

						try {
							v1 = inp1.readFromVoc(polzovatel.getProc());// obnovit'
																		// v1
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						if (v.size() > 0){
							Rand r = new Rand(1,v.size()-1);
							int[] mas = r.getNumbers();
							v.get(mas[0]).AddToProc(polzovatel);// 1st word
																		// add to
						}											// Proc, del
																		// from
																		// Common
						try {
							v = inp1.readFromVoc(polzovatel.getCommon());
							v1 = inp1.readFromVoc(polzovatel.getProc());
						} catch (ClassNotFoundException | IOException e1) {

							e1.printStackTrace();
						}

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
					InputVoc inp1 = new InputVoc();
					inp1.addToVoc(v, polzovatel.getCommon());
					inp1.addToVoc(v1, polzovatel.getProc());
					if (words[val3].getCorrect() >= numCorrect) {
						words[val3].AddToLearnt(polzovatel);
						try {
							v1 = inp1.readFromVoc(polzovatel.getProc());// obnovit'
																		// v1
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						
						if (v.size() > 0){
							Rand r = new Rand(1,v.size()-1);
							int[] mas = r.getNumbers();
							v.get(mas[0]).AddToProc(polzovatel);// 1st word
																		// add to
						}											// Proc, del
																		// from
																		// Common
						try {
							v = inp1.readFromVoc(polzovatel.getCommon());
							v1 = inp1.readFromVoc(polzovatel.getProc());
						} catch (ClassNotFoundException | IOException e1) {

							e1.printStackTrace();
						}

							System.out.println("Add to learnt");
						}
					}
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
		// CHECK FOR TEST 1
		Voc answer;
		Voc myanswer;

		public TestCheckAction(Voc a, Voc b) {
			this.myanswer = a;
			this.answer = b;
		}

		public void actionPerformed(ActionEvent e) {
			if (answer.getWord().equals(myanswer.getWord())) {
				myanswer.setCorrect(myanswer.getCorrect() + 1);
				InputVoc inp1 = new InputVoc();
				inp1.addToVoc(v, polzovatel.getCommon());// copy v to file
				inp1.addToVoc(v1, polzovatel.getProc());// copy v1 to file
				
				if (myanswer.getCorrect() >= numCorrect) {
					myanswer.AddToLearnt(polzovatel);// otvet moves from Proc to
														// Done
					try {
						v1 = inp1.readFromVoc(polzovatel.getProc());// obnovit'
																	// v1
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					
					if (v.size() > 0){
						Rand r = new Rand(1,v.size()-1);
						int[] mas = r.getNumbers();
						v.get(mas[0]).AddToProc(polzovatel);// 1st word
					}											// add to
																	// Proc, del
																	// from
																	// Common
					try {
						v = inp1.readFromVoc(polzovatel.getCommon());
						v1 = inp1.readFromVoc(polzovatel.getProc());
					} catch (ClassNotFoundException | IOException e1) {

						e1.printStackTrace();
					}

					System.out.println("Add to learnt");
				}
			}

			System.out.println(myanswer.getWord() + myanswer.getCorrect());
			removeAll();
			try {
				Test(3);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			repaint();
		}
	}

	private class TestCheckAction1 implements ActionListener {
		// CHECK TEST 2
		Voc answer;
		Voc myanswer;

		public TestCheckAction1(Voc a, Voc b) {
			this.myanswer = a;
			this.answer = b;
		}

		public void actionPerformed(ActionEvent e) {
			if (answer.getWord().equals(myanswer.getWord())) {
				myanswer.setCorrect(myanswer.getCorrect() + 1);
				InputVoc inp1 = new InputVoc();
				inp1.addToVoc(v, polzovatel.getCommon());
				inp1.addToVoc(v1, polzovatel.getProc());
				if (answer.getCorrect() >= numCorrect) {
					answer.AddToLearnt(polzovatel);
					try {
						v1 = inp1.readFromVoc(polzovatel.getProc());// obnovit'
																	// v1
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					
					if (v.size() > 0)
						v.get(0).AddToProc(polzovatel);// 1st word
																	// add to
																	// Proc, del
																	// from
																	// Common
					try {
						v = inp1.readFromVoc(polzovatel.getCommon());
						v1 = inp1.readFromVoc(polzovatel.getProc());
					} catch (ClassNotFoundException | IOException e1) {

						e1.printStackTrace();
					}


					System.out.println("Add to learnt");
				}
			}

			System.out.println(myanswer.getWord() + myanswer.getCorrect());
			removeAll();
			try {
				Test(4);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
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
				e.printStackTrace();
			}
			repaint();
		}
	}

	private class ButtonAction implements ActionListener {
		// CHANGE PANEL
		private int whatPanel;

		public ButtonAction(int a) {
			whatPanel = a;
		}

		public void actionPerformed(ActionEvent event) {
			removeAll();
			try {
				Test(whatPanel);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

	private class upAction implements ActionListener {
		// AVTORIZATION
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
				txt = "Error! Пустые поля";
				warn.setText(txt);
			}

			else {
				try {
					use2 = a.readFromVoc(ff);
					if (use2 != null) {
						for (int i = 0; i < use2.size(); i++) {
							if (use2.get(i).getLogin().equals(login.getText())) {
								txt = "Error! Такой логин уже существует";
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
									txt = "Успешно зарегестрирован!";
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
						txt = "Успешно зарегестрирован!";
						warn.setText(txt);
					}

				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}

		}

	}

	private class inAction implements ActionListener {
		// ENTER
		private List<User> use2;
		private InputUser a = new InputUser();
		private File ff;

		public inAction(File f) {
			this.ff = f;

		}

		public void actionPerformed(ActionEvent event) {
			String txt = null;
			if ((login.getText().equals("")) || (password.getText().equals(""))) {
				txt = "Error! Поля пусты";
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
								num = polzovatel.getNumber();
								numCorrect = polzovatel.getNumCorrect();

								try {
									v1 = inp.readFromVoc(polzovatel.getProc());
									if (v1.size() < num) {
										int raz = num-v1.size();
										if (v.size() <= raz) {
											Rand r = new Rand(v.size()-1,v.size()-1);
											int[] mas = r.getNumbers();
											for (int ii = 0; ii < v.size(); i++) {
												v.get(mas[ii]).AddToProc(polzovatel);
											}
										} else {
											Rand r = new Rand(raz,v.size()-1);
											int[] mas = r.getNumbers();
											for (int ii = 0; ii < raz; ii++) {
												v.get(mas[ii]).AddToProc(polzovatel);
											}
										}
										v = inp.readFromVoc(polzovatel.getCommon());
										v1 = inp.readFromVoc(polzovatel.getProc());
									} else {
										int raz = v1.size()-num;
										Rand r = new Rand(raz,v1.size()-1);
										int[] mas = r.getNumbers();
										InputVoc innp = new InputVoc();
										for (int ii = 0; ii < raz; ii++) {
											innp.perekidka(v1.get(mas[ii]).getWord(), polzovatel.getProc(), polzovatel.getCommon());
										}
									}
								} catch (NullPointerException e) {
									if (v.size() <= num) {
										Rand r = new Rand(num,v.size()-1);
										int[] mas = r.getNumbers();
										for (int ii = 0; ii < v.size(); ii++) {
											v.get(mas[ii]).AddToProc(polzovatel);
										}
									} else {
										Rand r = new Rand(num,v.size()-1);
										int[] mas = r.getNumbers();
										for (int ii = 0; ii < num; ii++) {
											v.get(mas[ii]).AddToProc(polzovatel);
										}
									}
								}

								v1 = inp.readFromVoc(polzovatel.getProc());
								num = polzovatel.getNumber();
								numCorrect = polzovatel.getNumCorrect();
								removeAll();
								Test(1);
								repaint();
								break;
							} else {
								txt = "Error! Неверный логин и/или пароль";
								warn.setText(txt);
							}
						}
					} else {
						txt = "Error! Пользователей не найдено";
						warn.setText(txt);
					}
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}

	
}