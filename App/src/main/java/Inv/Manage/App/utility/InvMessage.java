package Inv.Manage.App.utility;



public class InvMessage {

	public enum Type {
	    ERROR, INFO, WARNING
	}
	
	Type type;
	String msg;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public InvMessage(Type type, String msg) {
		
		this.type = type;
		this.msg = msg;
	}
	
	

}
