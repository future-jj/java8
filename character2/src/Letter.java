public class Letter {
    public static String addHeader(String text){
        return "From Roal,Mario and Alan:"+text;
    }
    public static String addFooter(String text){
        return text+"Kind regards";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda","lambda");
    }
}
