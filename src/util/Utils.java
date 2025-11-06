package util;

public class Utils {
    public static boolean checkString(String string){
        return ValidationHelper.isValidString(string);
    }

    public static boolean checkNamedData(String namedData){
        return ValidationHelper.isValidNamedData(namedData);
    }

    public static boolean checkNumber(int number){
        return ValidationHelper.isValidNumber(number);
    }
}
