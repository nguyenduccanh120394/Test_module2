import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public final String PHONE = "^[0]{1}[0-9]{9,10}$";
    public final String EMAIL = "^[a-zA-Z0-9]*@{1}[a-z]*[m][a][i][l][.][a-z]*$";
    Pattern pattern;
    Matcher matcher;
    public boolean validate(String regex,String REGEX){
        pattern=Pattern.compile(REGEX);
        matcher= pattern.matcher(regex);
        return matcher.matches();
    }
}
