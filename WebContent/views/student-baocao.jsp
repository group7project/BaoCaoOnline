<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<title></title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
		crossorigin="anonymous"></script>
	<script src="JS/myj.js" ></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/style.css" />
</head>

<body>
	<div class="container" id="logo_heading">
		<div class="row">
			<form class="form-inline ">
				<a><img class="ute-logo" src="images/logo-spkt.png" width="100px" height="100px" alt="UTE-logo"></a>
				<div class="form-group" id="logo_title">
					<h4 class="s-name">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT THÀNH PHỐ HỒ CHÍ MINH</h4>
						<h5 class="website-name">WEBSITE BÁO CÁO PHẢN BIỆN TRỰC TUYẾN</h5>
				</div>
			</form>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<div class="col-sm-3 col-md-3">
				<c:forEach var="tk" items="${tentaikhoan}">
	                	<c:if test="${tk!=''}">
		                     <ul class="nav navbar-nav navbar-listmenu" style="cursor: pointer;">
		                         <li class="dropdown-toggle" data-toggle="dropdown"><a style="font-size: 13px;"><span style="color: blue;">Xin chào, </span> <span style="color: blue;">${tk}</span> <span class="caret"></span></a></li>
		                         <ul class="dropdown-menu" style="padding-left: 5px; padding-right: 5px;">
		                              <li><a style="color: #000" href="logout.html">Đăng xuất</a></li>
		                         </ul>
		                    </ul>
		                </c:if>
	                </c:forEach>
                </div>
				<ul class="nav navbar-nav navbar-right">
					 <li><a href="#" data-toggle="modal" data-target="#password_modal" >Đổi mật khẩu</a></li>
                    <li><a href="logout.html">Đăng xuất</a></li>
				</ul>
			</div>
		</div>
		<!--/.container-fluid -->
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 panel panel-primary panel-fullheight">
				<div class="row">
				<c:choose>
					<c:when test="${dangBC =='1'}">
					<div class="col-sm-9 col-md-9" style="margin-top: 12px;">
						<video id="video" width="95%" height="90%" ></video>
						
					</div>
					
					<div class="col-md-3" style="margin-top: 10px;">
					
						<div class="info">
							<div><h4 class="text-primary">Đề tài:</h4> ${detai.getTenDeTai()}></div>
							<label>Thời gian báo cáo tối đa: ${detai.getTgbctd() } </label>
							<div class="count-up-timer">
								<label>Thời gian báo cáo:</label>
								<label id="minutes">00</label>:<label id="seconds">00</label>
								<p id="demo"></p>
								<script type="text/javascript">
									var minutesLabel = document.getElementById("minutes");
									var secondsLabel = document.getElementById("seconds");
									var totalSeconds = 0;
									setInterval(setTime, 1000);

									function setTime()
									{
										++totalSeconds;
										
										secondsLabel.innerHTML = pad(totalSeconds%60);
										minutesLabel.innerHTML = pad(parseInt(totalSeconds/60));
								
									}
									function pad(val)
									{
										var valString = val + "";
										if(valString.length < 2)
										{
											return "0" + valString;
										}
										else
										{
											return valString;
										}
									}
								</script>
								<a href = "sv_xemketqua.html" class="btn btn-primary" style="margin-top:70px; ">Xem kết quả báo cáo</a>
							</div>	
						</div>
						
					</div>
					</c:when  >
						<c:when test = "${detai.getTrangThai()=='Đã báo cáo'}">
							  <div class="form-div text-center">
							  	<h3>Đã báo cáo</h3>
							  </div>
						</c:when>
						<c:otherwise>
						 <div class="form-div text-center">
							  	<h3>Chưa tới giờ báo cáo</h3>
							  </div>
						</c:otherwise>
					
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer my-footer ">
		<div class="container ">
			<h5 class="text-muted ">©2016 Đại học Sư Phạm Kỹ Thuật thành phố Hồ Chí Minh</h5>
		</div>
	</footer>
	<div class="modal fade" id="password_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Thay đổi mật khẩu </h4>
                </div>
                <div class="modal-body ">
                    <form data-toggle="validator" action="changpass.html?jspName=student-baocao.jsp" method="POST" class="form-horizontal" role="form">
                        <fieldset class="form-group">
							<label for="" class="col-sm-4">Mật khẩu cũ:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name ="old_pass" required>
							</div>
						</fieldset>
						<fieldset class="form-group">
							<label for="" class="col-sm-4">Mật khẩu mới:</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" name="new_pass" id="password" required>
							</div>
						</fieldset>
                        <fieldset class="form-group">
							<label for="" class="col-sm-4">Nhập lại mật khẩu mới:</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" name="re_newpass"  id="confirm_password" required>
								<div id="message"></div>
							</div>
						</fieldset>
						<div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
		                    <input type="submit" class="btn btn-success" value="Đổi mật khẩu">
	                	</div>
                    </form>
                </div>
                
            </div>
        </div>
    </div>
	<script>
		$('#confirm_password').on('keyup', function () {
	    if ($(this).val() == $('#password').val()) {
	        $('#message').html('Trùng khớp').css('color', 'green');
	    } else $('#message').html('Mật khẩu không trùng nhau').css('color', 'red');
		});
	</script>
	
	<% String changepass_mess = (String)request.getAttribute("changepass-mess");%>
	<script type="text/javascript">
	    var msg = "<%=changepass_mess%>";
	    if(msg == "doi mat khau thanh cong" )
	    	alert("Đổi mật khẩu thành công");
	    else if(msg == "mat khau cu ko chinh xac")
	    	alert("Mật khẩu cũ không chính xác");
	</script>
</body>
</html>