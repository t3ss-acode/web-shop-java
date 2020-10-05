package UIL;

import Entities.Product;
import Entities.TokenStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        Product product = (Product) req.getSession().getAttribute(productId);

        ArrayList<Product> shoppingCart;
        if(req.getSession().getAttribute("shoppingcart") != null) {
            shoppingCart = (ArrayList<Product>) req.getSession().getAttribute("shoppingcart");
        } else {
            shoppingCart = new ArrayList<Product>();
        }
        shoppingCart.add(product);

        req.getSession().setAttribute("shoppingcart", shoppingCart);
        resp.sendRedirect("./product.jsp");
    }
}
