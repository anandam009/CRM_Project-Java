<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <%-- new button: add customer--%>
        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button" />

            <!--  add a search box -->
            <form:form action="search" method="POST">
                Search customer: <input type="textbox" name="theSearchName" />

                <input type="submit" value="Search" class="add-button" />
            </form:form>

        <!--  add our html table here -->
            <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">


                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td>
                        <!-- construct an "update" link with customer id-->
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>
                        <!-- construct an "delete" link with customer id-->
                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>
                        <!--display the update link-->
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a>
                    </td>
                </tr>


            </c:forEach>

        </table>

    </div>

</div>
<h3></h3>
<div id="wrap">
    <div id="header2" align="center">
            <h4>&copy; Java Software Development Project, 2017.   </h4>
    </div>
</div>
<div align ="left" >
<img height="70" width="210" src="${pageContext.request.contextPath}/resources/img/spring.jpg" />
</div>
</body>

</html>


<%--<% DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); Date date = Date.from(Instant.now()); String result = dateFormat.format(date);%>--%>
<%--<div><text color="de88e3" align="center"><%=result%></text></div>--%>









