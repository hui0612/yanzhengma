package com.yh.yangzhengma;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/filtServlet")
@MultipartConfig(
        location = "E:\\Servlet下载"
)
public class FiltServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Part myfilt = req.getPart("myfile");
        String contentType = myfilt.getContentType();
        System.out.println(contentType);
        String header = myfilt.getHeader("content-disposition");
        System.out.println(header);
        String fileName = myfilt.getSubmittedFileName();
        String name = myfilt.getName();
        System.out.println(name);
        System.out.println(fileName);
        myfilt.write(fileName);
    }
}
