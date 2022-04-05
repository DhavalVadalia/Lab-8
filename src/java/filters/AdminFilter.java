package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import services.AccountService;


public class AdminFilter implements Filter {
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
       
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = httpRequest.getSession();
        
        String email = (String)session.getAttribute("email");
        AccountService as = new AccountService();
        Role role = as.getRole(email);
        
      
        if( email != null && role.getRoleId() != 1 ){
           httpResponse.sendRedirect("notes");
           return;
        }
        
      
        chain.doFilter(request, response);       
    
    } 
    @Override
    public void destroy()
    {        
    }

    @Override
    public void init(FilterConfig filterConfig) 
    {        
        
    }
}
