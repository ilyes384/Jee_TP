package folder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Servlet Filter implementation class MyFilter1
 */
public class MyFilter1 implements Filter
{
    public void init (FilterConfig filterConfig)
    { // initialisation du filtre 
    }
    public void destroy ()
    { //Destruction du filtre 
    }
    //Cette méthode est appelée à chaque fois qu'un client demande une ressource Web 
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.println("<b> <i>Filter is filtering the response and passing it to Wrapper class</i> </b> <br/>");
     // Appel du constructeur de la classe d'enveloppe de réponse
        ResponseWrapper1 responseWrapper = new ResponseWrapper1 (response);
        // Cette méthode appelle le filtre suivant dans la chaîne
        chain.doFilter (request, responseWrapper);
    }
}
