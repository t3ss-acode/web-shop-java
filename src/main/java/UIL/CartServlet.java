package UIL;

import BL.ProductBL;
import Entities.Product;
import Entities.TokenStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute("token");

        if (!TokenStore.getInstance().checkToken(token)){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String testCart = "testCart";
        req.getSession().setAttribute("testParameter", testCart);

        resp.sendRedirect("./cart.jsp");
    }
}
