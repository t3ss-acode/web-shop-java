package UIL;

import BL.ProductBL;
import Entities.Product;
import Entities.TokenStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int cost = Integer.parseInt(req.getParameter("cost"));
        String desc = req.getParameter("description");
        String username = (String) req.getSession().getAttribute("username");
        String token = (String) req.getSession().getAttribute("token");
        String role = (String) req.getSession().getAttribute("role");

        if (TokenStore.getInstance().getUsername(username) != token){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!role.equalsIgnoreCase("admin")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (name == null || cost == 0 || desc == null){
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }

        Product newproduct = new Product();
        newproduct.setName(name);
        newproduct.setCost(cost);
        newproduct.setDescription(desc);
        if (ProductBL.addProduct(newproduct)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("./product.jsp");
        }else
            resp.sendError(HttpServletResponse.SC_CONFLICT);
    }
}
