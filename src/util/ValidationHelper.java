package util;

class ValidationHelper {
    static boolean isValidString(String string){
        if(string.isEmpty() || string == null)
            return false;
        return true;
    }

    static boolean isValidNamedData(String name){
        if(isValidString(name) && name.matches("[A-Z][a-z]+"))
            return true;
        return false;
    }

    static boolean isValidNumber(int number){
        if(number < 0 || number > 6)
            return false;
        return true;
    }
}
