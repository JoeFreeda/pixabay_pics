package com.example.llyods_project.model;

import java.util.List;

public class Pixabay_Res{
	private List<HitsItem> hits;
	private int total;
	private int totalHits;

	public void setHits(List<HitsItem> hits){
		this.hits = hits;
	}

	public List<HitsItem> getHits(){
		return hits;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setTotalHits(int totalHits){
		this.totalHits = totalHits;
	}

	public int getTotalHits(){
		return totalHits;
	}

}