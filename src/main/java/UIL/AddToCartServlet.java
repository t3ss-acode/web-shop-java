package UIL;

import EntitiesInfo.ProductInfo;

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
        ProductInfo product = (ProductInfo) req.getSession().getAttribute(productId);

        ArrayList<ProductInfo> shoppingCart;
        if(req.getSession().getAttribute("shoppingcart") != null) {
            shoppingCart = (ArrayList<ProductInfo>) req.getSession().getAttribute("shoppingcart");
        } else {
            shoppingCart = new ArrayList<>();
        }
        shoppingCart.add(product);

        req.getSession().setAttribute("shoppingcart", shoppingCart);
        resp.sendRedirect("./product.jsp");
    }
}
