package UIL;

import BL.ProductBL;
import BL.UniqProductBL;
import Entities.Product;
import Entities.TokenStore;
import Entities.UniqProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class ManageProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String token = (String) req.getSession().getAttribute("token");
        String role = (String) req.getSession().getAttribute("role");

        if (TokenStore.getInstance().getUsername(username) != token){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (role.equalsIgnoreCase("customer")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Collection list= UniqProductBL.getUniqProductsFromDB();
        req.getSession().setAttribute("uniqProductList",list);
        resp.sendRedirect("./manageProduct.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String token = (String) req.getSession().getAttribute("token");
        String role = (String) req.getSession().getAttribute("role");

        if (TokenStore.getInstance().getUsername(username) != token){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (role.equalsIgnoreCase("customer")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        UniqProduct editedProduct = (UniqProduct) req.getSession().getAttribute("uniqProduct");
        if (UniqProductBL.updateUniqProduct(editedProduct)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("./manageProduct.jsp.jsp");
        } else
            resp.sendError(HttpServletResponse.SC_CONFLICT);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String token = (String) req.getSession().getAttribute("token");
        String role = (String) req.getSession().getAttribute("role");

        if (TokenStore.getInstance().getUsername(username) != token){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (role.equalsIgnoreCase("customer")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        UniqProduct newProdct = (UniqProduct) req.getSession().getAttribute("uniqProduct");
        if (UniqProductBL.addUniqProduct(newProdct)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("./manageProduct.jsp.jsp");
        } else
            resp.sendError(HttpServletResponse.SC_CONFLICT);
    }
}
