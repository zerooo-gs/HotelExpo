package servlet;

import bo.BoFactory;
import bo.custom.UserBo;
import com.google.gson.Gson;
import dto.UserDto;
import dto.request.RequestUserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserBo userBo = BoFactory.getInstance().getBo(BoFactory.BoType.USER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestUserDto d = new Gson().fromJson(req.getReader(), RequestUserDto.class);
        UserDto userDto = new UserDto(
                d.getEmail(),d.getfName(),d.getlName(),d.getContact(),d.getPassword(),true
        );
        try {
            if (userBo.createUser(userDto)){
                resp.getWriter().println("<h1>Saved</h1>");
            }else{
                resp.getWriter().println("<h1>Saved</h1>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Do GET</h1>");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Do PUT</h1>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Do DELETE</h1>");
    }
}
