package Inv.Manage.App.controller;

public class DemoDTO {
	
	private String name;
	private int id;
	
	
	
	
	  public DemoDTO() { super(); }// TODO Auto-generated constructor stub }
	  
	  
	  
	  public DemoDTO(String name, int id) { super(); this.name = name; this.id =
	  id; }
	 



	@Override
	public String toString() {
		return "DemoDTO [name=" + name + ", id=" + id + "]";
	}


	
	  public String getName() { return name; }
	  
	  
	  
	  public void setName(String name) { this.name = name; }
	  
	  
	  
	  public int getId() { return id; }
	  
	  
	  
	  public void setId(int id) { this.id = id; }
	 
	
	
}
