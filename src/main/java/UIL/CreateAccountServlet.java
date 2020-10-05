package UIL;

import BL.UserBl;
import Entities.Role;
import Entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authHeader = req.getParameter("authorization");
        String encodedAuth = authHeader.substring(authHeader.indexOf(' ')+1);
        String decodedAuth = new String(Base64.getDecoder().decode(encodedAuth));
        String[] authArray = decodedAuth.split(":");
        String username = authArray[0];
        String email = authArray[1];
        Long card = Long.valueOf(authArray[2]);
        String password = authArray[3];
        String rePassword = authArray[4];
        String role = req.getParameter("role");

        if (!password.equalsIgnoreCase(rePassword)){
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }

        Role newRole = new Role();
        if (role==null)
            newRole.setName("customer");
        else
            newRole.setName(role);

        User newUser = new User(username, password,email, card, newRole);
        if (UserBl.addUser(newUser)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("./index.jsp");
        }else
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
    }
}
