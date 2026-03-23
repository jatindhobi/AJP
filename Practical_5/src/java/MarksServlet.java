import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MarksServlet")
public class MarksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");
        String id = (String) session.getAttribute("id");
        String dept = (String) session.getAttribute("dept");

        int m1 = Integer.parseInt(request.getParameter("m1"));
        int m2 = Integer.parseInt(request.getParameter("m2"));
        int m3 = Integer.parseInt(request.getParameter("m3"));
        int m4 = Integer.parseInt(request.getParameter("m4"));
        int m5 = Integer.parseInt(request.getParameter("m5"));
        int m6 = Integer.parseInt(request.getParameter("m6"));

        boolean pass = m1>=35 && m2>=35 && m3>=35 &&
                       m4>=35 && m5>=35 && m6>=35;

        out.println("<h2>Result</h2>");
        out.println("<h3>Student Name: " + name + "</h3>");
        out.println("ID: " + id + "<br>");
        out.println("Department: " + dept + "<br><br>");

        if (pass) {
            out.println("<h2 style='color:green'>PASS</h2>");
        } else {
            out.println("<h2 style='color:red'>FAIL</h2>");
        }

        session.invalidate();
    }
}