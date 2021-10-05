package com;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("uname");
        String pas =request.getParameter("pass");
        String serch="SELECT * FROM user_table";
        Map<String, Integer> map = new HashMap<>();
        if(uname.isEmpty()){
            request.setAttribute("zhuangtai","账号不能为空");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if(pas.isEmpty()){
            request.setAttribute("zhuangtai","密码不能为空");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        List<String> zhanghao = new ArrayList<>();
        Integer pass = Integer.parseInt(pas);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:MySQL://localhost:3306/java_u?&useSSL=false&serverTimezone=UTC";
            String username ="root";
            String password ="";
            Connection conn = DriverManager.getConnection(url,username,password);
            request.setAttribute("zhuangtai","chenggong");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(serch);
            while(rs.next()){
                String u_n = rs.getString("username");
                Integer u_p = rs.getInt("userpassword");
                map.put(u_n,u_p);
                zhanghao.add(u_n);
            }
            st.close();
            conn.close();
        }catch (Exception x){
            request.setAttribute("zhuangtai",x);
        }
        String temS = null;
        for (String s : zhanghao) {
            temS = s;
            if (temS.equals(uname)) {
                if (Objects.equals(map.get(temS), pass)) {
                    String bac = "欢迎访问：" + uname;
                    request.setAttribute("wel", bac);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("zhuangtai", "错误密码");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }
            }
        }
        request.setAttribute("zhuangtai","找不到该账号");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
//    public class duixiang{
//        public Integer q;
//        public String w;
////        alt+ins 可以插入很多方法
//        public duixiang(Integer q, String w) {
//            this.q = q;
//            this.w = w;
//        }
//
//        public Integer getQ() {
//            return q;
//        }
//
//        public void setQ(Integer q) {
//            this.q = q;
//        }
//
//        public String getW() {
//            return w;
//        }
//
//        public void setW(String w) {
//            this.w = w;
//        }
//
//    }
}
