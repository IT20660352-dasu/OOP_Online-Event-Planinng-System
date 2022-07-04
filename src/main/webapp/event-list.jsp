<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>


<style>
a:link {
	color: black;
	font-weight: 600;
	text-decoration: none;
}
</style>

<style>
body {
background-image: url('https://onlyvectorbackgrounds.com/wp-content/uploads/2019/02/Minimal-Romantic-Roses-Background-Pink-White.jpg');
}
</style>

<title>Event Planning System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Event
					Planning System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Event</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List Event Details</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					New Event</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Event No</th>
						<th>Event Name</th>
						<th>Event Type</th>
						<th>Decoration</th>
						<th>Catering</th>
						<th>Transportation</th>
						<th>Sound</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="event" items="${listEvent}">

						<tr>
							<td><c:out value="${event.id}" /></td>
							<td><c:out value="${event.no}" /></td>
							<td><c:out value="${event.name}" /></td>
							<td><c:out value="${event.light}" /></td>
							<td><c:out value="${event.decoration}" /></td>
							<td><c:out value="${event.catering}" /></td>
							<td><c:out value="${event.transportation}" /></td>
							<td><c:out value="${event.sound}" /></td>
							<td><button type="button" class="btn btn-warning">
									<a href="edit?id=<c:out value='${event.id}' />">Edit</a>
								</button> &nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-danger">
									<a href="delete?id=<c:out value='${event.id}' />">Delete</a>
								</button></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>