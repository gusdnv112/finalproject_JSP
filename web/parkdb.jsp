<%@ page import="dalpeng.UserDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="dalpeng.User" %><%--
  Created by IntelliJ IDEA.
  User: Park
  Date: 2017-04-15
  Time: 오전 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    try{
        UserDAO dao = new UserDAO();
        ArrayList<User> prod = dao.check();
        JSONObject json = new JSONObject();
        JSONArray jarray = new JSONArray();

        for(int i=0;i<prod.size();i++){

            JSONObject jobject = new JSONObject();
            jobject.put("no",prod.get(i).getNo());
            jobject.put("id",prod.get(i).getId());
            jobject.put("pw",prod.get(i).getPw());
            jarray.add(i,jobject);
        }
        json.put("list",jarray);

        out.print(json.toString());
    }catch (Exception e){
        e.printStackTrace();
    }


%>

