package UIL;

import BL.UserBl;
import Entities.TokenStore;
import Entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authHeader = req.getParameter("authorization");
        String encodedAuth = authHeader.substring(authHeader.indexOf(' ')+1);
        String decodedAuth = new String(Base64.getDecoder().decode(encodedAuth));
        String username = decodedAuth.substring(0,decodedAuth.indexOf(':'));
        String password = decodedAuth.substring(decodedAuth.indexOf(':')+1);

        User loggedInUser = UserBl.getUserFromDB(username);

        if (loggedInUser == null){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!password.equalsIgnoreCase(loggedInUser.getPassword())){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = TokenStore.getInstance().putToken(username);
        req.getSession().setAttribute("username",username);
        req.getSession().setAttribute("token",token);
        req.getSession().setAttribute("role",loggedInUser.getRole().getName());

        resp.sendRedirect("./index.jsp");
    }
}
