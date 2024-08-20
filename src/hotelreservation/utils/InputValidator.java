package hotelreservation.utils;

public class InputValidator {

	public static boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".");
	}

	public static boolean isValidRoomType(String roomType) {
		return roomType.equalsIgnoreCase("Single") || roomType.equalsIgnoreCase("Double")
				|| roomType.equalsIgnoreCase("Suite");
	}
}
