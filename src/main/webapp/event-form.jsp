<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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


	<div class="bg-image"
		style="background-image: url('https://c4.wallpaperflare.com/wallpaper/85/270/349/flowers-holiday-roses-pigeons-wallpaper-preview.jpg');">


		<br> <br>


		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">
					<c:if test="${event != null}">
						<form action="update" method="post">
					</c:if>
					<c:if test="${event == null}">
						<form action="insert" method="post">
					</c:if>

					<caption>
						<h3>
							<c:if test="${event != null}">
            			Edit Event
            		</c:if>
							<c:if test="${event == null}">
            			New Event
            		</c:if>
						</h3>
					</caption>
					<br>

					<c:if test="${event != null}">
						<input type="hidden" name="id"
							value="<c:out value='${event.id}' />" />
					</c:if>

				<fieldset class="form-group">
						<label>Event No</label> <input type="text"
							value="<c:out value='${event.no}' />"
							class="form-control" name="no" required="required">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Event Name</label> <input type="text"
							value="<c:out value='${event.name}' />"
							class="form-control" name="name" required="required">
					</fieldset>
					
					
					<div class="form-group">
						<label>Event Type</label> <select id="inputState"
							class="form-control" name="light" required>
							<option selected disabled>Choose Event Type</option>
							<option value="E001 - Wedding">E001 - Wedding</option>
							<option value="E002 - Birthday Party">E002 - Birthday Party</option>
							<option value="E003 - Batch Party">E003 - Batch Party</option>
							<option value="E004 - Beach Party">E004 - Engagement</option>
							<option value="E005 - Concert">E005 - Concert</option>
							<option value="E006 - Sport Meet">E006 - Sport Meet</option>
						</select>
					</div>

					
					<div class="form-group">
						<label>Decoration Package</label> <select id="inputState"
							class="form-control" name="decoration" required>
							<option selected disabled>Choose Decoration Package</option>
							<option value="D001 - Dec_Flwr1">D001 - Dec_Flwr1</option>
							<option value="D002 - Dec_Flwr2">D002 - Dec_Flwr2</option>
							<option value="D003 - Dec_svs">D003 - Dec_svs</option>
							<option value="D004 - Dec_outD">D004 - Dec_outD</option>
							<option value="D005 - Dec_inD">D005 - Dec_inD</option>
							<option value="D006 - Dec_commn">E006 - Dec_commn</option>
						</select>
					</div>


					
					<div class="form-group">
						<label>Catering Package</label> <select id="inputState"
							class="form-control" name="catering" required>
							<option selected disabled>Choose Catering Package</</option>
							<option value="C001 - ctrn_thai">C001 - ctrn_thai</option>
							<option value="C002 - ctrn_chine">C002 - ctrn_chine</option>
							<option value="C003 - ctrn_indn">C003 - ctrn_indn</option>
							<option value="C004 - ctrn_vlge">C004 - ctrn_vlge</option>
							<option value="C005 - ctrn_bufe">C005 - ctrn_bufe</option>
							<option value="C006 - ctrn_outD">C006 - ctrn_outD</option>
						</select>
					</div>
					
					
					<div class="form-group">
						<label>Transportation Package</label> <select id="inputState"
							class="form-control" name="transportation" required>
							<option selected disabled>Choose Transportation Package</option>
							<option value="T001 - Wed">T001 - Wed</option>
							<option value="T002 - TnsNew">T002 - TnsNew</option>
							<option value="T003 -TnsOld">T003 -TnsOld</option>
							<option value="T004 - Tnsshoot">T004 - TnsShoot</option>
							<option value="T005 - Tns_tn">T005 - Tns_tn</option>
							<option value="T006 - Tns_wtr">T006 - Tns_wtr</option>
						</select>
					</div>
					

					<div class="form-group">
						<label>Sound Package</label> <select id="inputState"
							class="form-control" name="sound" required>
							<option selected disabled>Choose Sound Package</option>
							<option value="S001 - sound1">S001 - sound1</option>
							<option value="S002 -sound2">S002 -sound2</option>
							<option value="S003 - sound3">S003 - sound3</option>
							<option value="S004 - sound4">S004 - sound4</option>
							<option value="S005 - sound5">S005 - sound5</option>
							<option value="S006 - sound6">S006 - sound6</option>
						</select>
					</div>



					<button type="submit" class="btn btn-primary">Save</button>
					</form>
				</div>
			</div>
		</div>

		<br> <br>
</body>
</html>