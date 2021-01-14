package temp;

import java.util.Random;

public final class RandomString {

    public static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBER_CHAR = "0123456789";
    private static StringBuffer sb = new StringBuffer();

    /**
     * return random string (only contains only uppercase and lowercase letters, numbers )
     *
     * @param length length
     * @return random string
     */
    public static String generateString(int length) {
        sb.setLength(0);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * Returns a fixed length random string (contains only numbers)
     *
     * @param length length
     * @return random string
     */
    public static String generateNumberString(int length) {
        sb.setLength(0);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * Returns a fixed-length random plain letter string (only uppercase and lowercase letters)
     *
     * @param length length
     * @return random string
     */
    public static String generateMixString(int length) {
        sb.setLength(0);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * Returns a fixed-length random capital letter string (only uppercase and lowercase letters)
     *
     * @param length length
     * @return random string
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * Returns a fixed-length random lowercase letter string (only case-sensitive letters)
     *
     * @param length length
     * @return random string
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * Generates a fixed length of 0 string
     *
     * @param length length
     * @return random string
     */
    public static String generateZeroString(int length) {
        sb.setLength(0);
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    /**
     * Generate a fixed length string based on the number, the length is not enough in front of 0
     *
     * @param num       number
     * @param fixLength length
     * @return random string
     */
    public static String toFixdLengthString(long num, int fixLength) {
        sb.setLength(0);
        String strNum = String.valueOf(num);
        if (fixLength - strNum.length() >= 0) {
            sb.append(generateZeroString(fixLength - strNum.length()));
        } else {
            throw new RuntimeException("将数字" + num + "转化为长度为" + fixLength + "的字符串发生异常！");
        }
        sb.append(strNum);
        return sb.toString();
    }

    private RandomString() {
    }
}

