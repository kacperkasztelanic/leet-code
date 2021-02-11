package solutions.java;

public class N1344AngleBetweenHandsOfAClock {

    private static final int FULL_CIRCLE = 360;
    private static final int HOURS_ON_CIRCLE = 12;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOUR_ANGLE_IN_HOUR = 360 / 12;
    private static final int MINUTE_ANGLE_IN_MINUTE = 360 / 60;
    private static final double HOUR_ANGLE_IN_MINUTE = ((double) HOUR_ANGLE_IN_HOUR) / MINUTES_IN_HOUR;

    public static double angleClock(int hour, int minutes) {
        double h = (hour % HOURS_ON_CIRCLE * HOUR_ANGLE_IN_HOUR) + (minutes * HOUR_ANGLE_IN_MINUTE);
        int m = minutes * MINUTE_ANGLE_IN_MINUTE;
        double angle = Math.abs(m - h);
        return Math.min(FULL_CIRCLE - angle, angle);
    }

    public static void main(String[] args) {
        assert angleClock(12, 30) == 165;
        assert angleClock(3, 30) == 75;
        assert angleClock(3, 15) == 7.5;
        assert angleClock(4, 50) == 155;
        assert angleClock(12, 0) == 0;
    }
}
