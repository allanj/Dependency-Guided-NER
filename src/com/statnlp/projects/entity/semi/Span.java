package com.statnlp.projects.entity.semi;

import java.io.Serializable;

public class Span implements Comparable<Span>, Serializable{
	
	private static final long serialVersionUID = 1849557517361796614L;
	public Label label;
	public int start;
	public int end;

	/**
	 * 
	 * @param start: inclusive
	 * @param end: inclusive
	 * @param label
	 */
	public Span(int start, int end, Label label) {
		if(start>end)
			throw new RuntimeException("Start cannot be larger than end");
		this.start = start;
		this.end = end;
		this.label = label;
	}
	
	public boolean equals(Object o){
		if(o instanceof Span){
			Span s = (Span)o;
			if(start != s.start) return false;
			if(end != s.end) return false;
			return label.equals(s.label);
		}
		return false;
	}

	@Override
	public int compareTo(Span o) {
		if(start < o.start) return -1;
		if(start > o.start) return 1;
		if(end < o.start) return -1;
		if(end > o.end) return 1;
		return label.compareTo(o.label);
	}
	
	public String toString(){
		return String.format("%d,%d %s", start, end, label);
	}

}
