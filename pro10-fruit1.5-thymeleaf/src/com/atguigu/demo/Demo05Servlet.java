package com.atguigu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo05")
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.getSession().setAttribute("uname", "lili");
        req.getServletContext().setAttribute("uname", "lili");
        // resp.sendRedirect("demo06");
        // req.getRequestDispatcher("demo06").forward(req, resp);
    }
}
