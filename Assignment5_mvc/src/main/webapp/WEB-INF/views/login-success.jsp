<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  import="com.nagarro.springmvc.model.Employee"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">  -->
  
	<style>
	<%@ include file="style.css"%>
	</style>
	
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
    <header>

        <h1 class="color-darkblue">Employees Detail</h1>

        <div class="user-status">
            <a href="../Assignment5_mvc/log-in"><i class="fa fa-close" style="font-size:30px;color:red"></i></a>
            <h4>Welcome "${userName}" !</h4>
        </div>


    </header>
    <main class="container">
        <form action="processuploadform" method="post">
            <fieldset class="employee-fieldset">
                <legend>Employee Listings</legend>

                <div class="action-btn-row">
                    <button type="submit" name="action" value="upload">Upload Employee</button>
                    <button type="submit" name="action" value="download">Download Employee Details</button>
                </div>
                
                <c:if test="${size==0}">
				<h3 align="center">No Result Found</h3>
				</c:if>
				<c:if test="${size!=0}">
              
                <table class="employee-list-table">
                    <tr class="employee-list-tr">
                        <th>Employee Code</th>
                        <th>Employee Name</th>
                        <th>Location</th>
                        <th>Email</th>
                        <th>Date Of Birth</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="employee">
                    
                    <tr>
						<td style="border: 1px solid black"><c:out
								value="${employee.eCode}"></c:out></td>
						<td style="border: 1px solid black"><c:out
								value="${employee.eName}"></c:out></td>
						<td style="border: 1px solid black"><c:out
								value="${employee.location}"></c:out></td>
						<td style="border: 1px solid black"><c:out
								value="${employee.email}"></c:out></td>
						<td style="border: 1px solid black"><c:out
								value="${employee.dob}"></c:out></td>
						<td><a href="<c:url value="/edit/${employee.eCode}" />" >Edit</a></td>
						<%-- <td><a href="edit/${employee.empcode}">Edit</a></td>
						 --%>
					</tr>
				</c:forEach>
			</table>
		</c:if>
                    
        </form>


    </main>
    <footer>
        <h3 class="color-darkblue">
        </h3>
       
    </footer>
</body>

</html>

