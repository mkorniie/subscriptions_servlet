<%@ page import="ua.mkorniie.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.mkorniie.entity.Roles" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="ua.mkorniie.entity.Language" %><%--
  Created by IntelliJ IDEA.
  User: mkorniie
  Date: 2019-06-11
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="http://localhost:8080/templates/css/style.css">--%>
    <link rel="icon"
          href="https://www.pinclipart.com/picdir/big/163-1634137_brochure-markant-online-books-icons-clipart.png"
          type="image/x-icon">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Role</th>
        <th scope="col">Phone number</th>
        <th scope="col">Email</th>
        <th scope="col">Language</th>
        <th scope="col">Delete</th>
        <th scope="col">Change privileges</th>
    </tr>
    </thead>
    <tbody>
            <%  List<User> users = (List<User>) request.getAttribute("users");
            for(User user : users){    %>
            <tr>
                <th scope="row"><%=user.getId()%>
                </th>
                <td><%=user.getFullName()%></td>
                <td><%=user.getRole()%></td>
                <td><%=user.getPhone()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getLanguage()%></td>
                <td><a href="/admin-users?method=remove&id=<%=user.getId()%>">Remove</a></td>
                <td>
                    <a href="/admin-users?method=priviledge_a&id=<%=user.getId()%>">To Admin</a> |
                    <a href="/admin-users?method=priviledge_u&id=<%=user.getId()%>">To User</a>
                </td>
            </tr>
    <% } %>
    </tbody>
</table>

<div class="m-4">Add user</div>
<form action="/admin-users-update" method="post" class="m-4">
    <div class="form-row">
        <div class="form-group col-2">
            <label for="name">User name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group col-2">
            <label for="pass">Password</label>
            <input type="text" class="form-control" id="pass" name="pass">
        </div>

        <div class="form-group col-2">
            <label for="role">Role</label>
            <select class="browser-default custom-select" id="role" name="role">
                <% List<Roles> roles = Arrays.asList(Roles.values());
                    for (Roles r: roles) {%>
                <option  value="<%=r.toString()%>"><%=r.toString()%></option>
                <% }%>
            </select>
        </div>
        <div class="form-group col-2">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        <div class="form-group col-2">
            <label for="mail">Email</label>
            <input type="text" class="form-control" id="mail" name="mail">
        </div>
        <div class="form-group col-2">
            <label for="lang">Language</label>
            <select class="browser-default custom-select" id="lang" name="lang">
                <% List<Language> languages = Arrays.asList(Language.values());
                    for (Language l: languages) {%>
                <option  value="<%=l.toString()%>"><%=l.toString()%></option>
                <% }%>
            </select>
<%--            <input type="text" class="form-control" id="lang" name="lang">--%>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>

<a href="/admin">Back to main page</a>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
