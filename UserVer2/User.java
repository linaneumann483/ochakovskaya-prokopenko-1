import java.io.File;
import java.io.Serializable;

class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 107554717113806479L;
private String login, password;
private File proc, done, common;//files of words

public String getLogin(){
	return login;
}

public void setLogin(String login){
	this.login = login;
}

public String getPassword(){
	return password;
}

public void setPassword(String password){
	this.password = password;
}

public File getProc(){
	return proc;
}

public void setProc(File proc){
	this.proc = proc;
}

public File getDone(){
	return done;
}

public void setDone(File done){
	this.done = done;
}

public File getCommon(){
	return common;
}

public void setCommon(File common){
	this.common = common;
}

}
