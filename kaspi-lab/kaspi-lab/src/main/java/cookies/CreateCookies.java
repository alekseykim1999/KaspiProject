package cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie first = new Cookie("first_id", "222");
        Cookie second = new Cookie("second_id", "333");

        first.setMaxAge(24*60*60);
        second.setMaxAge(24*60*60);
        response.addCookie(first);
        response.addCookie(second);

    }

}
