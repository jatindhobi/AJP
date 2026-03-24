package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        Integer userCount = (Integer) context.getAttribute("users");

        if(userCount == null)
            userCount = 0;

        userCount++;

        context.setAttribute("users", userCount);

        System.out.println("User Entered: " + userCount);
    }

    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        Integer userCount = (Integer) context.getAttribute("users");

        if(userCount == null)
            userCount = 0;

        userCount--;

        context.setAttribute("users", userCount);

        System.out.println("User Left: " + userCount);
    }
}