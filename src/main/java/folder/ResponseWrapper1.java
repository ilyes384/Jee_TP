package folder;

import java.util.Locale;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;

public class ResponseWrapper1 extends ServletResponseWrapper
{
    public ResponseWrapper1 (ServletResponse res)
    {
        //Calling the ServletResponseWrapper superclass constructor i.e. ServletResponse interface.
        super (res);
    }
    public Locale getLocale ()
    {
        System.out.println ("Wrapper class called by Filter");
        // Appel de la méthode de la classe parente ServletResponse, getLocale().
        Locale loc = super.getLocale ();
        String country = loc.getCountry ();
        String language = loc.getLanguage ();
        if (!country.equals ("US"))
        {
         Locale loc1 = new Locale ("English, US");
         loc = loc1;
        }
        System.out.println (country);
        System.out.println (language);
        return loc;
    }
}
