package common.utils;

public class BooleanUtils {
    public static Boolean fromShort(short value) {
        return value == 1;
    }

    public static short fromBoolean(Boolean value) {
        return value ? (short) 1 : (short) 0;
    }
}
