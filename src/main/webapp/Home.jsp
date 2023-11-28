<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDo Home</title>
<style>
body{
display: flex;
justify-content: center;
align-items: center;

}
</style>
</head>
<body>
<div>
<h1>ToDo Home</h1>
<table border="1">
<tr>
<th>Task Name</th>
<td><input type="text"></td>
</tr>
<tr>
<th>Task Description</th>
<td><input type="text"></td>
</tr>
<tr>
<th>Date Created</th>
<td><input type="text"></td>
</tr>
<tr>
<th>Status</th>
<td><input type="text"></td>
</tr>
<tr>
<th>Delete</th>
<td><button>Delete</button></td>
</tr>
<tr>
<th>Edit</th>
<td><button>Edit</button></td>
</tr>
<tr>
<a href="./session-add-task"><button>Add task</button></a>
<a href="./logout" name="out"><button>Logout</button></a>
</tr>
<br>

</div>
</body>
</html>