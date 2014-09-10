package com.example.getjson;

public class News {

	private Integer id;
	private String title;
	private Integer timelength;
	public News(){
	}
	public News(Integer id, String title, Integer timelength)
	{
		this.setId(id);
		this.setTitle(title);
		this.setTimelength(timelength);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTimelength() {
		return timelength;
	}
	public void setTimelength(Integer timelength) {
		this.timelength = timelength;
	}
	
	
}
