public class ValidationUtils {
    public static boolean isValidTimeFormat(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }

    public static boolean isOverlap(Task t1, Task t2) {
        int start1 = parseTime(t1.getStartTime());
        int end1 = parseTime(t1.getEndTime());
        int start2 = parseTime(t2.getStartTime());
        int end2 = parseTime(t2.getEndTime());

        return start1 < end2 && start2 < end1;
    }

    private static int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
