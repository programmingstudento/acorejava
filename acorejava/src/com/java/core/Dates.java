package com.java.core;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Dates {

	private static final Map<String, Integer> DATA = new HashMap<>();
	static {
		DATA.put("Monday", 1);
		DATA.put("Tuesday", 2);
		DATA.put("Wednesday", 3);
		DATA.put("Thursday", 4);
		DATA.put("Friday", 5);
		DATA.put("Saturday", 6);
		DATA.put("Sunday", 7);
	}

	public static String[] mostFrequentDays(int year) {
		class Helper {
			public static String getDay(int number) {
				String day = null;
				switch (number) {
				case 1:
					day = "Monday";
					break;
				case 2:
					day = "Tuesday";
					break;
				case 3:
					day = "Wednesday";
					break;
				case 4:
					day = "Thursday";
					break;
				case 5:
					day = "Friday";
					break;
				case 6:
					day = "Saturday";
					break;
				case 7:
					day = "Sunday";
					break;
				}
				return day;
			}
		}
		Map<String, Integer> counter = new HashMap<>();
		counter.put("Monday", 0);
		counter.put("Tuesday", 0);
		counter.put("Wednesday", 0);
		counter.put("Thursday", 0);
		counter.put("Friday", 0);
		counter.put("Saturday", 0);
		counter.put("Sunday", 0);

		String day = null;
		LocalDate start = LocalDate.of(year, 1, 1), end = LocalDate.of(year, 12, 31);
		for (; start.compareTo(end) <= 0; start = start.plus(1, ChronoUnit.DAYS)) {
			day = Helper.getDay(start.getDayOfWeek().getValue());
			counter.put(day, counter.get(day) + 1);
		}

		System.out.println(counter.keySet());
		int max = counter.values().stream().mapToInt(num -> num).max().getAsInt();
		String[] result = counter.keySet().stream().filter(key -> counter.get(key) == max).toArray(String[]::new);
		Arrays.sort(result, (one, two) -> DATA.get(one).compareTo(DATA.get(two)));
		System.out.println(Arrays.toString(result));
		return result;
	}

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDate localDate = date.with(TemporalAdjusters.firstDayOfMonth()).plusDays(2L);
		System.out.println(date + " " + localDate);

		LocalDate date1 = LocalDate.of(1996, 06, 05);
		LocalDate date2 = date1.plusYears(18);
		System.out.println(date2);

		Instant instant = Instant.now();
		System.out.println(instant);

		LocalDate first = LocalDate.of(2021, Month.DECEMBER, 5);
		System.out.println(first);
		System.out.println(LocalDate.of(2012, Month.JANUARY, 1).plusDays(255));
		System.out.println(LocalDate.of(1992, Month.DECEMBER, 3).getDayOfWeek());

		System.out.println(first.until(date, ChronoUnit.YEARS));
		System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1).getDayOfWeek());
		System.out.println("---------------------------------------------");
		first.datesUntil(date).forEach(System.out::println);
		System.out.println(unluckyDays(2015));

		mostFrequentDays(2708);
	}

	public static String ageInDays(int year, int month, int day) {
		long days = ChronoUnit.DAYS.between(LocalDate.of(year, month, day), LocalDate.now());
		return String.format("You are %d day%s old", days, days == 1 ? "" : "s");
	}

	public static int unluckyDays(int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1), endDate = LocalDate.of(year, 12, 31);
		Stream<LocalDate> dates = startDate.datesUntil(endDate);
		return (int) dates.filter(date -> date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY)
				.count();
	}

	public static boolean validateTime(String time) {
		String pattern = "^([01]\\d|2[0123]):([0-5][\\d)$";
		return time.matches(pattern);
	}

}
