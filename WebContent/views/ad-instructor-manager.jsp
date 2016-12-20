<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Adminstrator: -- Quản lý giảng viên</title>
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
    <link rel="stylesheet" href="css/style-T.css" />
    <link rel ="stylesheet" href="css/jquery.dataTables.min.css"/>
   <script type="text/javascript" src="JS/paging.js"></script>
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
                        <div class="panel-group">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a  href= "instructormanager.html">Danh sách giảng viên</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default ">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="studentmanager.html">Danh sách sinh viên </a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="createlistaccount.html">Thêm danh sách tài khoản</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a  href="logout.html">Đăng xuất</a>
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
                        <h3 class="panel-title"> Danh sách giảng viên</h3>
                    </div>
                    <div class="panel-body">
                        <div class="panel panel-default panel_with_table">
                            <!-- Default panel contents -->
                            <div class="panel-body">
                            
                                <table class="table table_list" id ="results">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Mã GV</th>
                                            <th>Họ tên</th>
                                            <th>Số điện thoại</th>
                                            <th>Trạng thái</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% int counter = 1; %>
                                    	<c:forEach var="row" items="${list_gv}">
                                        <tr>
                                            <td scope="row"><%= counter++ %></td>
                                            <td>${row.magv}</td>
                                            <td>${row.hoTen}</td>
                                            <td>${row.sdt}</td>
                                            <td>${row.trangThai}</td>
                                            <td>
                                                <div class="dropdown">
                                                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    Quản lý
                                                    <span class="caret"></span>
                                                  </button>
                                                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                                    <li><a href="#edit-account-modal" data-target="#edit-account-modal" data-toggle="modal"
															data-magv = '${row.magv}' data-matkhau = "${row.matKhau}" 
															data-hoten = "${row.hoTen}" data-sdt = "${row.sdt}">Chỉnh sửa</a></li>
                          
                                                    <li><a href="deleteAccount.html?username=${row.magv}&role-name=GV">Xóa tài khoản</a></li>
                                                     <li role="separator" class="divider"></li>
                                                    <li><a href="blockAccount.html?username=${row.magv}&role-name=GV">Khóa tài khoản</a></li>
                                                    <li><a href="OpenAccount.html?username=${row.magv}&role-name=GV">Mở lại tài khoản</a></li>
                                                    <li role="separator" class="divider"></li>
                                                    <li><a href="#" data-target="#edit-role" data-toggle="modal">Phân quyền</a></li>
                                                  </ul>
                                                </div>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                 <div id="pageNavPosition"></div>
                                <script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
      //--></script>
                            </div>
                            <!-- Table -->
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
                    <form data-toggle="validator" action="changpass.html?jspName=ad-instructor-manager.jsp" method="POST" class="form-horizontal" role="form">
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
	


    <!--modal chinh sua tai khoan -->
    <div class="modal fade" id="edit-account-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Chỉnh sửa tài khoản: <span class="title-name"></span></h4>
                </div>
                <div class="modal-body">
                    <form action="updategiangvien" method="POST" class="form-horizontal" role="form">
                        <fieldset class="form-group">
							<label for="" class="col-sm-3">Mã GV/User:</label>
							<div class="col-sm-9">
								<input readonly  type="text" class="form-control input-sm" name ="input-magv" id="input-magv">
							</div>
						</fieldset>
						<fieldset class="form-group">
							<label for="" class="col-sm-3">Họ tên:</label>
							<div class="col-sm-9">
								<input  type="text" class="form-control input-sm" name="input-hoten" id="input-hoten" >
							</div>
						</fieldset>
                        <fieldset class="form-group">
							<label for="" class="col-sm-3">Mật khẩu:</label>
							<div class="col-sm-9">
								<input  type="text" class="form-control input-sm" name="input-matkhau" id="input-matkhau" >
							</div>
						</fieldset>
                        <fieldset class="form-group">
							<label for="" class="col-sm-3">Số điện thoại:</label>
							<div class="col-sm-9">
								<input  type="text" class="form-control input-sm" name="input-sdt" id="input-sdt" >
							</div>
						</fieldset>
						<div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
		                    <button type="submit" class="btn btn-success" >Chỉnh sửa</button>
	                	</div>
                    </form>
                </div>
                
            </div>
        </div>
    </div>
     <!--modal phan quyen tai khoan -->
    <div class="modal fade" id="edit-role" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Phân quyền</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" id="instructor-check" value="instructor" checked>
                                    Giảng viên
                                </label>
                                <label style ="margin-left: 40px;">
                                    <input  type="radio" name="optionsRadios" id="student-check" value="student">
                                    Trưởng khoa/trưởng bộ môn
                                </label>
                                <label style ="margin-left: 40px;">
                                    <input  type="radio" name="optionsRadios" id="student-check" value="student">
                                    Administrator
                                </label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                    <button type="button" class="btn btn-success">Hoàn tất</button>
                </div>
            </div>
        </div>
    </div>
    
    
	<% String message = (String)request.getAttribute("alertMsg");%>
	<script type="text/javascript">
	    var msg = "<%=message%>";
	    if(msg == "insert thanh cong" )
	    	alert("Thêm danh sách giảng viên thành công");
	</script>
    
    <script>
		$('#edit-account-modal').on('show.bs.modal', function (event) {
		  var a = $(event.relatedTarget) // Button that triggered the modal
		  var magv = a.data('magv') // Extract info from data-* attributes
		  var matkhau = a.data('matkhau') // Extract info from data-* attributes
		  var hoten = a.data('hoten') // Extract info from data-* attributes
		  var sdt = a.data('sdt') // Extract info from data-* attributes
		  
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  $('.title-name').val(magv);
		  $('#input-magv').val(magv)
		  $('#input-matkhau').val(matkhau)
		  $('#input-hoten').val(hoten)
		  $('#input-sdt').val(sdt)
		})
	</script>
    
</body>

</html>