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
        //System.out.println("starting auth for user: "+req.getSession().getAttribute("username"));
        //System.out.println("starting auth for user: "+req.getParameter("username"));
        /*String authHeader = req.getHeader("authorization");
        String encodedAuth = authHeader.substring(authHeader.indexOf(' ')+1);
        String decodedAuth = new String(Base64.getDecoder().decode(encodedAuth));
        String username = decodedAuth.substring(0,decodedAuth.indexOf(':'));
        String password = decodedAuth.substring(decodedAuth.indexOf(':')+1);*/

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //System.out.println(username + ":"+password);
        //System.out.println(req.getSession().getAttribute("username")+":"+req.getSession().getAttribute("password"));
        User loggedInUser = UserBl.getUserFromDB(username);

        //System.out.println("username: "+req.getSession().getAttribute("username"));
        //System.out.println("username: "+req.getParameter("username"));
        //System.out.println("password: "+req.getSession().getAttribute("password"));
        //System.out.println("password: "+req.getParameter("password"));


        /*if (loggedInUser == null){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!password.equalsIgnoreCase(loggedInUser.getPassword())){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }*/



        String token = TokenStore.getInstance().putToken(username);
        //System.out.println(req.getSession().getId());
        req.getSession().setAttribute("username",username);
        req.getSession().setAttribute("token",token);
        req.getSession().setAttribute("role",loggedInUser.getRole().getName());
        //System.out.println(req.getSession().getId());
        //System.out.println("Added attributes to " +req.getSession().getAttribute("username"));
        //System.out.println("Added token: " +req.getSession().getAttribute("token"));
        //System.out.println("Added role: " +req.getSession().getAttribute("role"));
        //System.out.println("Added attributes to " +req.getParameter("username"));

        //resp.sendRedirect("http://localhost:8080/web_shop_java_war_exploded/index.jsp");
        resp.sendRedirect("./index.jsp");
    }
}
