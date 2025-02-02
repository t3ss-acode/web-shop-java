package UIL;

import BL.TokenStore;
import BL.UserBl;
import EntitiesInfo.UserInfo;

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
        String token = (String) req.getSession().getAttribute("token");
        String creatorRole = (String) req.getSession().getAttribute("role");

        if (!TokenStore.getInstance().checkToken(token)){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!creatorRole.equalsIgnoreCase("admin")){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!password.equalsIgnoreCase(rePassword)){
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }



        if (role==null)
            role ="customer";

        UserInfo newUser = new UserInfo(username, password,email, card, role);
        if (UserBl.addUser(newUser)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("./index.jsp");
        }else
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);

    }
}
