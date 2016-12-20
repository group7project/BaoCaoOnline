<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css" />
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' })
    
  });
  </script>
  
 <script type="text/javascript">
$(document).ready(function(){
	$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
		localStorage.setItem('activeTab', $(e.target).attr('href'));
	});
	var activeTab = localStorage.getItem('activeTab');
	if(activeTab){
		$('#myTab a[href="' + activeTab + '"]').tab('show');
	}
});
</script>

</head>

<body>
    <div class="container" id="logo_heading">
        <div class="row">
            <form class="form-inline ">
                <a><img class="ute-logo" src="images/logo-spkt.png" width="100px" height="100px" alt="UTE-logo"></a>
                <div class="form-group" id="logo_title">
                    <h4 class="s-name">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT THÀNH PHỐ HỒ CHÍ MINH</h3>
                        <h5 class="website-name">WEBSITE BÁO CÁO PHẢN BIỆN TRỰC TUYẾN</h4>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="panel panel-primary panel-fullheight">
                    <div class="panel-heading">
                        <h3 class="panel-title">DANH MỤC</h3>
                    </div>
                    <div class="panel-body">
                        <div class="panel-group" id="accordion">
                             <div class="panel panel-primary ">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="dean_listtopic.html">Danh sách đề tài</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default ">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="dean_listteach.html">Danh sách giảng viên</a>
                                    </h4>
                                </div>
                            </div>
                             <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="dean_rating.html">Xem trùng lặp</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="logout.html">Đăng xuất</a>
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-9">
                <div class="panel panel-primary panel-fullheight">
                    <div class="panel-heading">
                        <h3 class="panel-title"> Chi tiết đề tài: ${detai.tenDeTai}</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="nav active"><a href="#A" data-toggle="tab" aria-expanded="true">Thông tin</a></li>
                            <li class="nav"><a href="#B" data-toggle="tab" aria-expanded="false">Hội đồng</a></li>
                            <li class="nav"><a href="#C" data-toggle="tab" aria-expanded="false">Thời gian</a></li>
                        </ul>
                        <div class="tab-content" id="Tabcontent">
                            <div class="tab-pane fade active in" id="A">
                                <div class="panel panel-default" id="panel-default-nopbai">
                                    <div class="panel-body">
                                        <ul class="list-group list-group-detail">
                                        	<li class="list-group-item">
                                                <p><strong>Tên đề tài:</strong> ${detai.tenDeTai}</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Sinh viên thực hiện:</strong>
                                                  <c:forEach items="${detai.getSvths()}" var="sv">
											        	<span style="margin-right: 20px;">${sv.getHoTen()}</span>  
											      </c:forEach>
											     </p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Giảng viên hướng dẫn:</strong>${detai.gvhd.getHoTen()}</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Thời gian báo cáo: </strong>${detai.gioBaoCao}  |   ${detai.ngayBaoCao} <strong>Thời hạn:</strong> ${detai.tgbctd } phút</p>                                                   </p>
                                            </li>
                                             <li class="list-group-item">
                                                <p><strong>Mô tả:</strong> ${detai.moTa}</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Kết quả: </strong><c:if test = "${detai.diem > 0}">${detai.diem} </c:if></p>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="tab-pane fade" id="B"> 
                                <div class="col-md-content">
                                    <div class="panel panel-default" id="panel-default-tvhd">
                                        <div class="panel-body ">
                                        <form method="post" action="updateHoiDong.html?madt=${detai.maDeTai}">
                                            <table class="table table_list">
                                            	 <thead>
			                                        <tr>
			                                            <th>Vai trò</th>
			                                            <th>Mã GV</th>
			                                            <th>Họ tên</th>
			                                            <th class="btn_float_righ">Thay đổi</th>
			                                        </tr>
			                                    </thead>
                                                <tbody>
                                                    <tr>
                                                    	<th>Chủ tịch</th>
                                                        <td>${chutich.magv}</td>
                                                        <td>${chutich.hoTen }</td>
                                                        <td>
                                                            <select name="chutich">
                                                            	<option value="${chutich.hoTen}">${chutich.hoTen}</option>
					                                            <c:forEach items="${list_gv_khoa}" var="gv">
                                                                 	 <option value="${gv.hoTen}">${gv.hoTen}</option>
                                                                </c:forEach>
					                                        </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                    	<th>Ủy viên</th>
                                                        <td>${uyvien.magv}</td>
                                                        <td>${uyvien.hoTen }</td>
                                                        <td>
                                                            <select name="uyvien">
                                                            	<option value="${uyvien.hoTen}">${uyvien.hoTen}</option>
					                                            <c:forEach items="${list_gv_khoa}" var="gv">
                                                                 	 <option value="${gv.hoTen}">${gv.hoTen}</option>
                                                                </c:forEach>
					                                        </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                    	<th>Phản biện</th>
                                                         <td>${phanbien.magv}</td>
                                                        <td>${phanbien.hoTen }</td>
                                                        <td>
                                                            <select name="phanbien">
                                                            	<option value="${phanbien.hoTen }">${phanbien.hoTen }</option>
					                                            <c:forEach items="${list_gv_khoa}" var="gv">
                                                                 	 <option value="${gv.hoTen}">${gv.hoTen}</option>
                                                                </c:forEach>
					                                        </select>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <div class="btn_float_right " style="margin-top: 20px ">
                                                <input type="submit"  class="btn btn-success" value="Lưu thay đổi">
                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="tab-pane fade " id="C">
                                <div class="panel panel-default ">
                                    <div class="panel-body ">
                                        <form class="form-horizontal" method ="post" action="updateThoiGian.html?madt=${detai.maDeTai}">
                                            <div class="form-group ">
                                                <label class="control-label col-sm-3 " for="">Ngày báo cáo: </label>
                                                <div class="col-sm-9 ">
                                                        <div class="row ">
                                                            <div class='col-sm-7'>
                                                                <div class="input-group date" data-provide="datepicker">
																    <input type="text" class="form-control" name="ngaybc"  id ="datepicker" value="${detai.ngayBaoCao}">
																    <div class="input-group-addon">
																        <span class="glyphicon glyphicon-th"></span>
																    </div>
																</div>
                                                            </div>
                                                        </div>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-sm-3 " for="email ">Giờ báo cáo: </label>
                                                <div class="col-sm-9 ">
                                                    <div class="row ">
                                                        <div class='col-sm-7'>
                                                            <input type="time" class="form-control" name="giobc" value="${detai.gioBaoCao}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-sm-3 " >Thời lượng(Phút):  </label>
                                                <div class="col-sm-9 ">
                                                    <div class="row ">
                                                        <div class='col-sm-7'>
                                                            <input type="text" class="form-control" name="tgbctd" value="${detai.tgbctd}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="btn_float_right " style="margin-top: 20px ">
		                                        <input type="submit" class="btn btn-success " value="Lưu thay đổi">
		                                    </div>
                                        </form>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /container -->
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
                    <form data-toggle="validator" action="changpass.html?jspName=deen_topic_detail.jsp" method="POST" class="form-horizontal" role="form">
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