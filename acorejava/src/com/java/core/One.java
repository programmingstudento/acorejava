package com.java.core;

public class One {
    private String name = "Water";
    
    class FirstLevel{
    	public String name = "Air";
    	
    	void display(String name) {
    		System.out.println(name);
    		System.out.println(this.name);
    		System.out.println(One.this.name);
    	}
    }
    
    public static void main(String[] args) {
		One one = new One();
		One.FirstLevel firstLevel = one.new FirstLevel();
		firstLevel.display("Fire");
	}
}
