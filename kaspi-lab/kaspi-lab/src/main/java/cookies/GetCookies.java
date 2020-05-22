package cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] massive = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html>");

        for (Cookie cc:massive)
            pw.println("<h1>" + cc.getName() + " = " + cc.getValue() + "</h1>");
        pw.println("</html>");
    }
}
