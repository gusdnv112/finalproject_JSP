<%@ page import="dalpeng.UserDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="dalpeng.word" %><%--
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
        ArrayList<word> prod = dao.check2();
        JSONObject json = new JSONObject();
        JSONArray jarray = new JSONArray();

        for(int i=0;i<prod.size();i++){

            JSONObject jobject = new JSONObject();
            jobject.put("no",prod.get(i).getNo());
            jobject.put("word",prod.get(i).getWord());
            jobject.put("mean",prod.get(i).getMean());
            jarray.add(i,jobject);
        }
        json.put("list",jarray);

        out.print(json.toString());
    }catch (Exception e){
        e.printStackTrace();
    }


%>

