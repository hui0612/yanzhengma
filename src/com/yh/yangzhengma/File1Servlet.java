package com.yh.yangzhengma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/File1Servlet")
public class File1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File f = new File("E:\\课件\\77\\day08\\day08\\课件\\images");
        String[] list = f.list();
        System.out.println(list);
        req.getSession().setAttribute("f",list);
        resp.sendRedirect("/file.jsp");
    }
}
