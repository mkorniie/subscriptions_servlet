<%@ page import="ua.mkorniie.entity.Publisher" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="http://localhost:8080/templates/css/style.css">
    <link rel = "icon" href ="https://www.pinclipart.com/picdir/big/163-1634137_brochure-markant-online-books-icons-clipart.png"
          type = "image/x-icon">
</head>
<body>


<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Welcome, My Lord</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/admin-users">Users</a>
        <a class="p-2 text-dark" href="/admin-tables">Tables</a>
        <a class="p-2 text-dark" href="/admin-stats">Statistics</a>
    </nav>
    <a class="btn btn-outline-primary" href="/">Logout</a>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Admin logged in succesfully!</h1>
    <p class="lead">Lorem ipsum</p>
</div>
<div class="wrapper-custom">
    <h3 class="m-4">Publishers</h3>
    <table class="table table-formatting m-4">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Country</th>
            <th scope="col">Description</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <%  ArrayList<Publisher> publishers = (ArrayList<Publisher>) request.getAttribute("publishers");
            for(Publisher publisher : publishers){    %>
                <tr>
                <th scope="row"><%=publisher.getId()%></th>
                <td><%=publisher.getName()%></td>
                <td><%=publisher.getCountry()%></td>
                <td><%=publisher.getDescription()%></td>

                <td>
                    <a href="/admin?method=remove&id=<%=publisher.getId()%>">Remove</a></td>
                </tr>
        <% } %>
        </tbody>
    </table>

    <form action="/admin-update" method="post" class="m-4">
        <div class="form-row">
            <div class="form-group col-6">
                <label for="name">Publisher name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group col-4">
                <label for="country">Country</label>
                <input type="text" class="form-control" id="country" name="country">
            </div>
            <div class="form-group col-2">
                <label for="desc">Description</label>
                <input type="text" class="form-control" id="desc" name="desc">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>

</div>

<%--<div class="container">--%>
<%--    <div class="card-deck mb-3 text-center">--%>
<%--        <div class="card mb-4 box-shadow">--%>
<%--            <div class="card-header">--%>
<%--                <h4 class="my-0 font-weight-normal">Free</h4>--%>
<%--            </div>--%>
<%--            <div class="card-body">--%>
<%--                <h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1>--%>
<%--                <ul class="list-unstyled mt-3 mb-4">--%>
<%--                    <li>10 users included</li>--%>
<%--                    <li>2 GB of storage</li>--%>
<%--                    <li>Email support</li>--%>
<%--                    <li>Help center access</li>--%>
<%--                </ul>--%>
<%--                <button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign up for free</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="card mb-4 box-shadow">--%>
<%--            <div class="card-header">--%>
<%--                <h4 class="my-0 font-weight-normal">Pro</h4>--%>
<%--            </div>--%>
<%--            <div class="card-body">--%>
<%--                <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>--%>
<%--                <ul class="list-unstyled mt-3 mb-4">--%>
<%--                    <li>20 users included</li>--%>
<%--                    <li>10 GB of storage</li>--%>
<%--                    <li>Priority email support</li>--%>
<%--                    <li>Help center access</li>--%>
<%--                </ul>--%>
<%--                <button type="button" class="btn btn-lg btn-block btn-primary">Get started</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="card mb-4 box-shadow">--%>
<%--            <div class="card-header">--%>
<%--                <h4 class="my-0 font-weight-normal">Enterprise</h4>--%>
<%--            </div>--%>
<%--            <div class="card-body">--%>
<%--                <h1 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h1>--%>
<%--                <ul class="list-unstyled mt-3 mb-4">--%>
<%--                    <li>30 users included</li>--%>
<%--                    <li>15 GB of storage</li>--%>
<%--                    <li>Phone and email support</li>--%>
<%--                    <li>Help center access</li>--%>
<%--                </ul>--%>
<%--                <button type="button" class="btn btn-lg btn-block btn-primary">Contact us</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="main">--%>
<%--        <h1>Admin logged in succesfully!</h1>--%>

<%--        <div>List of users with changing admin priveleges (with dropdown menu of enums etc.)--%>
<%--            <br>--%>
<%--            Plus total number of users--%>
<%--        </div>--%>

<%--        <div>publisher management--%>
<%--            <br>--%>

<%--        </div>--%>

<%--        <div>orders list</div>--%>

<%--        <div> changes to orders list - can change status</div>--%>

<%--        <div>Statistics - see: total sum ; total sum per period;--%>
<%--            number of orders; total number of orders per period</div>--%>
<%--    </div>--%>

    <footer class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
            <div class="col-12 col-md">
                <img class="mb-2" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="24" height="24">
                <small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
            </div>
            <div class="col-6 col-md">
                <h5>Features</h5>
                <ul class="list-unstyled text-small">
                    <li><a class="text-muted" href="#">Cool stuff</a></li>
                    <li><a class="text-muted" href="#">Random feature</a></li>
                    <li><a class="text-muted" href="#">Team feature</a></li>
                    <li><a class="text-muted" href="#">Stuff for developers</a></li>
                    <li><a class="text-muted" href="#">Another one</a></li>
                    <li><a class="text-muted" href="#">Last time</a></li>
                </ul>
            </div>
            <div class="col-6 col-md">
                <h5>Resources</h5>
                <ul class="list-unstyled text-small">
                    <li><a class="text-muted" href="#">Resource</a></li>
                    <li><a class="text-muted" href="#">Resource name</a></li>
                    <li><a class="text-muted" href="#">Another resource</a></li>
                    <li><a class="text-muted" href="#">Final resource</a></li>
                </ul>
            </div>
            <div class="col-6 col-md">
                <h5>About</h5>
                <ul class="list-unstyled text-small">
                    <li><a class="text-muted" href="#">Team</a></li>
                    <li><a class="text-muted" href="#">Locations</a></li>
                    <li><a class="text-muted" href="#">Privacy</a></li>
                    <li><a class="text-muted" href="#">Terms</a></li>
                </ul>
            </div>
        </div>
    </footer>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>