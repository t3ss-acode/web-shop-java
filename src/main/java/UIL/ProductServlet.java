package UIL;

import BL.ProductBL;
import Entities.Product;
import Entities.TokenStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute("token");

        if (!TokenStore.getInstance().checkToken(token)){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        req.getSession().setAttribute("productList", ProductBL.getProductsFromDB());
        resp.sendRedirect("./product.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute("token");
        String role = (String) req.getSession().getAttribute("role");

        if (!TokenStore.getInstance().checkToken(token)){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!role.equalsIgnoreCase("admin")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if(ProductBL.addProduct((Product) req.getSession().getAttribute("product")))
            resp.setStatus(HttpServletResponse.SC_OK);
        resp.setStatus(HttpServletResponse.SC_CONFLICT);
    }
}
