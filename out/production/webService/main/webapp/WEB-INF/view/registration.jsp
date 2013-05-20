<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Hello World with Spring 3 MVC</title>
	</head>
<body>
    <center>
        <form commandName="user" action="add" name="userForm" method="POST">
            <table>
                <tr><td>Name : </td><td><input type="text" name="name" /></td></tr>
                <tr><td>Age : </td><td><input type="text" name="age" /></td></tr>
                <tr><td colspan="2"><input type="submit" value="Save Changes"/>
            </table>
        </form>
    </center>
    <center>
          Name:${users}
    </center>
</body>
</html>