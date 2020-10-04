package UIL;

import BL.ProductBL;
import Entities.Product;
import Entities.TokenStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute("token");
        //String token = (String) req.getParameter("token");
        //System.out.println("doing get product");
        //System.out.println("token: "+token);

        if (!TokenStore.getInstance().checkToken(token)){
            //System.out.println("Token has expired or not valid.");
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        ArrayList<Product> productList = (ArrayList<Product>) ProductBL.getProductsFromDB();
        req.getSession().setAttribute("productList", ProductBL.getProductsFromDB());
        resp.sendRedirect("./product.jsp");
    }
}
