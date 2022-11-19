package com.java.core;

public class SquareRoot {

	class Util {

		public static double absolute(double num) {
			if (num >= 0) {
				return num;
			}
			return num * -1;
		}

		public static double squareRoot(int number) {
			if (number < 0) {
				throw new IllegalArgumentException("Enter non - negative integer");
			}

			double squareRoot = -1, guess = number;
			boolean shouldContinue = true;
			double limit = 0.00001;

			for (; shouldContinue;) {

				squareRoot = 0.5 * (guess + (number / guess));
				if (absolute(squareRoot - guess) < limit)
					shouldContinue = !shouldContinue;
				guess = squareRoot;
			}

			return isPerfectSquare(squareRoot) ? (int) squareRoot
					: Double.valueOf(String.format("%.3f", new Object[] { squareRoot }));
		}

		public static boolean isPerfectSquare(double root) {
			return root % 1 == 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("Square root of " + 11 + " is " + Util.squareRoot(11));
		System.out.println("Square root of " + 9 + " is " + Util.squareRoot(9));
		System.out.println("Square root of " + 21 + " is " + Util.squareRoot(21));
		System.out.println("Square root of " + 25 + " is " + Util.squareRoot(25));
	}
}
