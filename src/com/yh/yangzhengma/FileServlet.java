package com.yh.yangzhengma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/FileServlet")
@MultipartConfig(
        location = "E:\\Servlet下载"
)
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Collection<Part> parts = req.getParts();
        if(parts!=null && !parts.isEmpty()) {
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                if(fileName.equals("")){
                    continue;
                }
                    part.write(fileName);
            }

        }
    }
}
