import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String dept = request.getParameter("dept");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("dept", dept);

        out.println("<h3>Welcome, " + name + "</h3>");
        out.println("<form action='MarksServlet' method='post'>");
        out.println("Subject 1: <input type='number' name='m1'><br><br>");
        out.println("Subject 2: <input type='number' name='m2'><br><br>");
        out.println("Subject 3: <input type='number' name='m3'><br><br>");
        out.println("Subject 4: <input type='number' name='m4'><br><br>");
        out.println("Subject 5: <input type='number' name='m5'><br><br>");
        out.println("Subject 6: <input type='number' name='m6'><br><br>");
        out.println("<input type='submit' value='Generate Result'>");
        out.println("</form>");
    }
}