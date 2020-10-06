package UIL;

import EntitiesInfo.ProductInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int listId = Integer.parseInt(req.getParameter("listId"));

        ArrayList<ProductInfo> shoppingCart = (ArrayList<ProductInfo>) req.getSession().getAttribute("shoppingcart");
        shoppingCart.remove(listId);

        req.getSession().setAttribute("shoppingcart", shoppingCart);
        resp.sendRedirect("./cart.jsp");
    }
}
