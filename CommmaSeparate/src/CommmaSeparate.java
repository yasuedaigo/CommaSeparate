import java.util.ArrayList;
import java.util.function.BiPredicate;

public class CommmaSeparate { 

    public static void main(String[] args) throws Exception {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static final int COMMA_DIGIT = 3;
    private static final int FIRST_COUNT = 0;

    private static String commaSeparatedString(Integer number){
        Integer absoluteValueNumber = Math.abs(number);
        String absoluteNumberString = absoluteValueNumber.toString();
        StringBuilder sb = new StringBuilder();
        int popCount = FIRST_COUNT;
        int commaCount = FIRST_COUNT;
        int commaNumber = getCommaNumber(number);
        for(int i=0;i<absoluteNumberString.length();i++){
            sb.append(getCharacterFromBack(i,absoluteNumberString));
            popCount++;
            if((popCount % COMMA_DIGIT == FIRST_COUNT) && commaCount < commaNumber){
                sb.append(",");
                commaCount++;
            }
        }
        if(isNegative(number)){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    private static boolean isNegative(Integer number){
        return Math.signum(number) == -1.0;
    }

    private static int getNumberDigit(Integer number){
        Integer absoluteValueNumber = Math.abs(number);
        String numberString = absoluteValueNumber.toString();
        return numberString.length();
    }

    private static int getCommaNumber(int number){
        int commaNumber;
        commaNumber = getNumberDigit(number)/COMMA_DIGIT;
        if((getNumberDigit(number) % COMMA_DIGIT) == FIRST_COUNT){
            commaNumber--;
        }
        return commaNumber;
    }

    private static String getCharacterFromBack(int indexFromBack,String numberString){
        int indexFromFront = numberString.length() - indexFromBack -1;
        return numberString.substring(indexFromFront,indexFromFront +1);
    }
}
