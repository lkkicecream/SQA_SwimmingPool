package main;

public class Discount {
	public static Identity identity;
	public static int hour;
	public static int min;
	public static double dis = 0;

	public Discount(Identity identity, String dateTime) throws Throwable {

		identity = identity;
		hour = InputNormalization.extractHour(dateTime);
		min = InputNormalization.extractMin(dateTime);

		checkException();
	}

	public void checkException() throws Throwable {
		if (3 > identity.getAge()) {
			throw new Throwable("Your age is too young.");
		} else if (identity.getAge() > 75) {
			throw new Throwable("Your age doesn't meet the requirements.");
		} else if ((5 > hour || hour > 22) || (hour == 22 && min > 0)) {
			throw new Throwable("Business hours: 05:00-22:00");
		} else {
			queryDiscount(identity, hour);
		}
	}

	private void queryDiscount(Identity identity, int hour) {
		if (identity.isMember()) {
			dis = 0.5;
		} else if (identity.isGroup()) {
			dis = 0.7;
		} else if (12 > identity.getAge() || identity.getAge() >= 60) {
			dis = 0.8;
		} else if (5 <= hour && hour < 7) {
			dis = 0.8;
		} else {
			dis = 1;
		}
	}

	public double getDiscount() {
		return dis;
	}
}
