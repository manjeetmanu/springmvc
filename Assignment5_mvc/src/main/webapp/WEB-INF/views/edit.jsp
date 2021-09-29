<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	<%@ include file="style.css"%>
</style>
</head>
<body>

 <header>

        <h1 class="color-darkblue"></h1>

        <div class="user-status">
            <i class="fa fa-close" style="font-size:30px;color:red"></i>
            <h4>Welcome "${userName}" !</h4>
        </div>
		

    </header>
    <main class="container">
        <form action="../editempform" method="POST" modelAttribute="employee">
            <fieldset class="employee-fieldset">
                <legend>Edit Employee Details</legend>
                <table class="employee-edit-table">

                    <tr>

                        <td class="employee-edit-label">
                            <label for="html">
                                <h3>Employee Code:</h3>
                            </label>
                        </td>
                        <td>
                            <input type="number" id="eCode" name="eCode" value="${id}" required>
                        </td>

                    </tr>
                    <tr>
                        <td class="employee-edit-label">
                            <label for="html">
                                <h4>Employee Name:</h4>
                            </label>
                        </td>
                        <td>
                            <input type="text" id="eName" name="eName" required>
                        </td>

                    </tr>

                    <tr>
                        <td class="employee-edit-label">
                            <label for="html">
                                <h4>Location:</h4>
                            </label>
                        </td>
                        <td>
                            <textarea maxlength="500" type="text" id="location" name="location"></textarea>
                        </td>

                    </tr>

                    <tr>
                        <td class="employee-edit-label">
                            <label for="html">
                                <h4>Email:</h4>
                            </label>
                        </td>
                        <td>
                            <input type="text" id="email" name="email" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}" maxlength="100">
                        </td>

                    </tr>
                    <tr>
                        <td class="employee-edit-label">
                            <label for="html">
                                <h4>Date of Birth:</h4>
                            </label>
                        </td>
                        <td>
                            <input type="date" id="dob" name="dob">
                        </td>

                    </tr>
                    <tr>
                        <td class="employee-edit-btn employee-edit-btn-left">
                            <Button>
                                Save
                            </Button>
                        </td>
                        <td class="employee-edit-btn employee-edit-btn-right">
                            <Button>
                                Cancel
                            </Button>
                        </td>

                    </tr>
                </table>
            </fieldset>
        </form>


    </main>
    <footer>
        <h3 class="color-darkblue">
        </h3>

    </footer>
</body>


</body>
</html>