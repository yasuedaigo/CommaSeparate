public class CommmaSeparate {

    public static void main(String[] args) throws Exception {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static final String COMMA = ",";
    private static final String MINUS = "-";
    private static final int COMMA_DIGIT = 3;
    private static final int FIRST_COUNT = 0;
    private static final double negativeSignal = -1.0;

    private static String commaSeparatedString(Integer number) {
        StringBuilder sb = new StringBuilder();
        addComma(sb, number);
        addMinus(sb, number);
        return sb.reverse().toString();
    }

    private static StringBuilder addComma(StringBuilder sb, Integer number) {
        int popCount = FIRST_COUNT;
        int commaCount = FIRST_COUNT;
        int commaNumber = getCommaNumber(number);
        String absoluteNumberString = getAbsolute(number);
        for (int i = 0; i < absoluteNumberString.length(); i++) {
            sb.append(getCharacterFromBack(i, absoluteNumberString));
            popCount++;
            if ((popCount % COMMA_DIGIT == FIRST_COUNT) && commaCount < commaNumber) {
                sb.append(COMMA);
                commaCount++;
            }
        }
        return sb;
    }

    private static String getAbsolute(Integer number) {
        Integer absoluteValueNumber = Math.abs(number);
        String absoluteNumberString = absoluteValueNumber.toString();
        return absoluteNumberString;
    }

    private static boolean isNegative(Integer number) {
        return Math.signum(number) == negativeSignal;
    }

    private static int getNumberDigit(Integer number) {
        Integer absoluteValueNumber = Math.abs(number);
        String numberString = absoluteValueNumber.toString();
        return numberString.length();
    }

    private static int getCommaNumber(int number) {
        int commaNumber;
        commaNumber = getNumberDigit(number) / COMMA_DIGIT;
        if ((getNumberDigit(number) % COMMA_DIGIT) == FIRST_COUNT) {
            commaNumber--;
        }
        return commaNumber;
    }

    private static String getCharacterFromBack(int indexFromBack, String numberString) {
        int indexFromFront = numberString.length() - indexFromBack - 1;
        return numberString.substring(indexFromFront, indexFromFront + 1);
    }

    private static StringBuilder addMinus(StringBuilder sb, Integer number) {
        if (isNegative(number)) {
            sb.append(MINUS);
        }
        return sb;
    }
}
