import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIPAddress {

    public static void main(String[] args) {
        String IP = "172.16.254.1";
        System.out.println (checkForIpV4 ( IP ));

    }
    public String validIPAddress(String IP) {

    return "";

    }

    public static boolean checkForIpV4(String IP){
        Pattern p = Pattern.compile("[0-9][.]*");
        String []arr = IP.split ( "." );
        if ( arr.length ==4 ){
            for ( String n :arr ){

                Matcher matcher = p.matcher ( n );
                if(!matcher.matches ()){
                    return false;
                }
                if ( Integer.valueOf ( n ) > 255 ){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
