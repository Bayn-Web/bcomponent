package com;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/helloWorldServlet")
public class helloWorldServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       // response.setCharacterEncoding("gb2312");
        response.setHeader("content-type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=UTF-8");
 //       request.setCharacterEncoding("gb2312");
        String input = request.getParameter("inputAAA");
        String url=request.getRequestURI();
        if(Objects.equals(url, "/world")){
            input="world";
        }else if(Objects.equals(url, "/hello")){
            input="hello";
        }
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>");
        pw.println("显示输入内容");
        pw.println("</title></head><body>");
        pw.println(input);
        pw.println("</body></html>");
    }
}
