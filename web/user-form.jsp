<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>--%>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <h1>User Management</h1>
    <p>Hello, ${name}</p>

    <form action="/update">
        Enter your name <input type="text" name="name">
        Enter id <input type="text" name ="id">
        Enter email <input type="text" name = "email">
        Enter country <input type="text" name="country">
<%--        Long id = Long.parseLong(request.getParameter("id"));--%>
<%--        String name = request.getParameter("name");--%>
<%--        String email = request.getParameter("email");--%>
<%--        String country = request.getParameter("country");--%>
        <input type="submit" value="Submit Query">
    </form>


<%--    <c:set var="pageTitle" value="JSTL Core Tags Example" />--%>
<%--    <c:out value="${pageTitle}">No name</c:out>--%>
<%--    <h2>--%>
<%--        <a href="new">Add New User</a>--%>
<%--        &nbsp;&nbsp;&nbsp;--%>
<%--        <a href="list">List All Users</a>--%>

<%--    </h2>--%>
<%--    <div align="center">--%>
<%--        <c:if test="${user != null}">--%>
<%--        <form action="/update" method="post">--%>
<%--            </c:if>--%>
<%--            <c:if test="${user == null}">--%>
<%--            <form action="insert" method="post">--%>
<%--                </c:if>--%>
<%--                <table border="1" cellpadding="5">--%>
<%--                    <caption>--%>
<%--                        <h2>--%>
<%--                            <c:if test="${user != null}">--%>
<%--                                Edit User--%>
<%--                            </c:if>--%>
<%--                            <c:if test="${user == null}">--%>
<%--                                Add New User--%>
<%--                            </c:if>--%>
<%--                        </h2>--%>
<%--                    </caption>--%>
<%--                    <c:if test="${user != null}">--%>
<%--                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />--%>
<%--                    </c:if>--%>
<%--                    <tr>--%>
<%--                        <th>User Name: </th>--%>
<%--                        <td>--%>
<%--                            <input type="text" name="name" size="45"--%>
<%--                                   value="<c:out value='${user.name}' />"--%>
<%--                            />--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <th>User Email: </th>--%>
<%--                        <td>--%>
<%--                            <input type="text" name="email" size="45"--%>
<%--                                   value="<c:out value='${user.email}' />"--%>
<%--                            />--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <th>Country: </th>--%>
<%--                        <td>--%>
<%--                            <input type="text" name="country" size="15"--%>
<%--                                   value="<c:out value='${user.country}' />"--%>
<%--                            />--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td colspan="2" align="center">--%>
<%--                            <input type="submit" value="Save" />--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </form>--%>
<%--    </div>--%>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>