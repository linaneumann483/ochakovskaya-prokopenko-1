
	import java.awt.*;
	import java.awt.event.*;
	import java.io.File;
	import java.io.IOException;
	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;
	import javax.swing.*;

	class ButtonPanel extends JPanel implements Serializable {
		private static final long serialVersionUID = 107554717113806479L;
		private File userfile, vocfile;
		JLabel warn = new JLabel("");
		JTextField login = new JTextField("", 15);
		JPasswordField password = new JPasswordField("", 15);
		JButton register = new JButton("Sign up");
		 JButton enter = new JButton("Sign in");
		 JLabel log = new JLabel("login");
		 JLabel pass = new JLabel("password");
		 
	   public ButtonPanel(){
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
	   
		private class upAction implements ActionListener{
	       private List<User> use2;
	       private InputUser a = new InputUser();
	       private File ff;
	       public upAction(File f){
	    	  this.ff = f;
	    	  
	       }
	       
	       
			public void actionPerformed(ActionEvent event) {
			    String txt = null;
				if((login.getText().equals("")) || (password.getText().equals(""))){
					     txt = "Error! Empty field"; 
					     warn.setText(txt);
					   		}
				
				else{
			    	try {
						use2 = a.readFromVoc(ff);
						if (use2 != null){
					for(int i = 0; i<use2.size(); i++){
						if(use2.get(i).getLogin().equals(login.getText())){
							txt = "Error! This login already exists";
							warn.setText(txt);
							break;
						}
						else{
							if(i == use2.size()-1){
								User e = new User();
					    		e.setLogin(login.getText());
					    		e.setPassword(password.getText());
					    		e.setProc(new File(""+e.getLogin()+"(1).txt"));
					    		e.setDone(new File(""+e.getLogin()+"(2).txt"));
					    	    use2.add(e);
					    	    a.addToVoc(use2, ff);
					    	    txt = "Registration complete!";
					    	    warn.setText(txt);
					    	    break;
							}
						}
							
					}
						}
						else{
							User e = new User();
							e.setLogin(login.getText());
							e.setPassword(password.getText());
							e.setProc(new File(""+e.getLogin()+"(1).txt"));
				    		e.setDone(new File(""+e.getLogin()+"(2).txt"));
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
		
		
		private class inAction implements ActionListener{
			private List<User> use2;
		    private InputUser a = new InputUser();
		    private File ff;
		    public inAction(File f){
		    	  this.ff = f;
		    	  
		       }
			
		    public void actionPerformed(ActionEvent event) {
			    String txt = null;
				if((login.getText().equals("")) || (password.getText().equals(""))){
					     txt = "Error! Empty field"; 
					     warn.setText(txt);
					   		}
				else{
			    	try {
						use2 = a.readFromVoc(ff);
						if (use2 != null){
					for(int i = 0; i<use2.size(); i++){
						if((use2.get(i).getLogin().equals(login.getText())) && (use2.get(i).getPassword().equals(password.getText()))){
							txt = "Welcome to Learning English!";
							warn.setText(txt);
							break;
						}
						else
						{
							txt = "Error! Incorrect login or password";
							warn.setText(txt);
						}
		    }
		}
						else{
							txt = "Error! No registered users found";
							warn.setText(txt);
						}
			    	}
			    	catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
			    		
			    	}
		    }
		}
	}

