import testing.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/application")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");


        String name_cart=request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        if(cart==null)
        {
            cart=new Cart();
            cart.setName(name_cart);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart",cart);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculation");
        dispatcher.forward(request,response);


        Integer count = (Integer)session.getAttribute("count");
        if(count==null)
        {
            session.setAttribute("count",1);
        }
        else
        {
            session.setAttribute("count",++count);
        }



        /*
        Checking work
        String answer = request.getParameter("name");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hello Sinner " + answer +  "</h1>");
        pw.println("</html>");


        //response.sendRedirect("https://www.google.com"); Redirect

        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculation");
        dispatcher.forward(request,response); */
    }
}
