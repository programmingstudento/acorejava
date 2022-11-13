package com.java.core;

public class OuterOne {
	private String one = "Outer";
	private static String two = "Outer Static";

	class InnerTwo {
		void display() {
			System.out.println(one);
			System.out.println(two);
		}
	}

	static class StaticNestedThree {
		void display(OuterOne one) {
			System.out.println(one.one);
			System.out.println(two);
		}
	}

	public static void main(String[] args) {
		OuterOne one = new OuterOne();
		OuterOne.InnerTwo two = one.new InnerTwo();
		two.display();

		StaticNestedThree three = new StaticNestedThree();
		three.display(one);
	}
}
