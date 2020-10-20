import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private int acces;

    @Override
    public void init() throws ServletException {
        super.init();
        acces = 0;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if (session.getAttribute("nb") == null) session.setAttribute("nb", 0);
        session.setAttribute("nb", (Integer) session.getAttribute("nb") + 1);
        acces++;
        out.println("<head><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n</head>");
        out.println("<div class=\"d-flex justify-content-center p-3\"><div class=\"container\"><div class=\"alert alert-primary\" role=\"alert\">\n" +
                session.getAttribute("nb") + "/" + acces +
                "</div></div></div>");
        /*
        try {
            Class.forName(getServletContext().getInitParameter("driver"));
            Connection con = DriverManager.getConnection(getServletContext().getInitParameter("dtb"), getServletContext().getInitParameter("login"), getServletContext().getInitParameter("pwd"));
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        }
        */
    }
}
