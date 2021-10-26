package com.yh.yangzhengma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/File2Servlet")
public class File2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名
        String filename = req.getParameter("filename");
        String s1 = "E:\\课件\\77\\day08\\day08\\课件\\images\\"+filename;

       /* resp.setContentType("application/octet-stream");*/
        String content =  "attachment;filename=" + URLEncoder.encode(s1);
        resp.setHeader("content-disposition" , content);

        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType(s1);//获取文件类型
        resp.setHeader("content-type" , mimeType);

        FileInputStream in = new FileInputStream(s1);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len=0;
        while ((len =in.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        in.close();
        /*   //获取文件名
        String filename = req.getParameter("filename");
        //使用字节流的数据加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("E:\\照片" + filename);
        //
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //3
        String mimeType = servletContext.getMimeType(filename);//获取文件类型
        resp.setHeader("content-type" , mimeType);
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //4
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len=0;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();*/
    }
}
