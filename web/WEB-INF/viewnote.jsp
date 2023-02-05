<%-- 
    Document   : viewnote
    Created on : 5-Feb-2023, 2:17:35 AM
    Author     : johnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="get" action="editnote.jsp">
            <b>Title: </b><span name="title">${note.title}</span>
            <br>
            <br>
            <b>Contents:</b>
            <br><span name="content">${note.contents}</span>
            <br><a href="note?editnote.jsp">Edit</a>
        </form>
    </body>
</html>
