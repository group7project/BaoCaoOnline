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

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style10.css" />
    <link rel ="stylesheet" href="css/jquery.dataTables.min.css"/>
    <script src="JS/jquery.dataTables.min.js"></script>
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
                        <div class="panel-group" id="accordion">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Danh sách đề tài</a>
                                    </h4>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse in">
                                    <div class="panel-body" id="type_topic">
                                        <div class="list-group" >
                                            <a href="gv_detaiphancongphanbien.html?flag=1" class="list-group-item">Đề tài phản biện</a>
                                            <a href="gv_detaiphanconglamuyvien.html?flag=2" class="list-group-item ">Đề tài ủy viên</a>
                                            <a href="gv_trangchu.html?flag=3" class="list-group-item list-group-item">Tất cả đề tài</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default " id="panel_list">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-parent="#accordion" href="gv_danhsachhoidong.html?flag=3">Danh sách hội đồng</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a href="gv_xembaocao_phanbien.html?flag=4">Xem báo cáo</a>
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
                <div class="panel panel-primary panel-fullheight" id="dsdt">
                    <div class="panel-heading">
                        <h3 class="panel-title"> Danh sách đề tài</h3>
                    </div>
                    <div class="panel-body">
                        <div class="panel panel-default panel_with_table">
                            <!-- Default panel contents -->
                            <div class="panel-body">

                                <table class="table table_list table-striped table-hover" id ="results">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Mã đề tài</th>
                                            <th>Tên đề tài</th>
                                            <th>File báo cáo</th>
                                            <th>Trạng thái</th>
                                            <th>Chi tiết</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	
                                    	<% int counter = 1; %>
                                    	<c:forEach var="row" items="${list_dt}">
                                    	<c:if test="${row != null}" >
	                                        <tr>
	                                            <td scope="row"><%= counter++ %></td>
	                                            <td>${row.maDeTai}</td>
	                                            <td>${row.tenDeTai}</td> 
	                                            <td><a href="downloadFileBaoCao?fileName=${row.filebaocao}&flag=1">${row.filebaocao}</a></td>
	                                            <td>${row.trangThai}</td> 
	                                            <td><a href="#dt-detail" data-target="#dt-detail" data-toggle="modal"
	                                            	data-tendetai="${row.tenDeTai}" data-svth ="${row.svths[0].getHoTen()}"
	                                            	data-ngaybc ="${row.ngayBaoCao}" data-giobc ="${row.gioBaoCao}"
	                                            	data-tgbctd="${row.tgbctd}" data-diem="${row.diem }">Chi tiết</a></td>  
	                                        </tr>
	                                        
	                                        </c:if>
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
                                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /container -->
    
     <div class="modal fade" id="dt-detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Chi tiết đề tài </span></h4>
                </div>
                <div class="modal-body">
                    <form action="updategiangvien" method="POST" class="form-horizontal" role="form">
                        <fieldset class="form-group">
							<label for="" class="col-sm-4">Tên đề tài:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name ="ma-gv" id="tendt">
							</div>
						</fieldset>
						<fieldset class="form-group">
							<label for="" class="col-sm-4">Sinh viên thực hiện:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name="hoten-gv" id="svth-dt" >
							</div>
						</fieldset>
                        <fieldset class="form-group">
							<label for="" class="col-sm-4">Ngày báo cáo:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name="matkhau-gv" id="ngaybc-dt" >
							</div>
						</fieldset>
                        <fieldset class="form-group">
							<label for="" class="col-sm-4">Giờ báo cáo:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name="sdt-gv" id="giobc-dt" >
							</div>
						</fieldset>
						<fieldset class="form-group">
							<label for="" class="col-sm-4">Thời gian báo cáo tối đa:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name="sdt-gv" id="tgbctd-dt" >
							</div>
						</fieldset>
						<fieldset class="form-group">
							<label for="" class="col-sm-4">Điểm:</label>
							<div class="col-sm-8">
								<input disabled readonly type="text" class="form-control input-sm" name="sdt-gv" id="diem-dt" >
							</div>
						</fieldset>
						<div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	                	</div>
                    </form>
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
                    <form data-toggle="validator" action="changpass.html?jspName=GV_TrangChu.jsp" method="POST" class="form-horizontal" role="form">
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
    
    <script>
		$('#dt-detail').on('show.bs.modal', function (event) {
		  var a = $(event.relatedTarget) // Button that triggered the modal
		  var tendetai = a.data('tendetai') // Extract info from data-* attributes
		  var svths = a.data('svth') // Extract info from data-* attributes
		  var ngaybc = a.data('ngaybc') // Extract info from data-* attributes
		  var giobc = a.data('giobc') // Extract info from data-* attributes
		  var tgbctd = a.data('tgbctd') // Extract info from data-* attributes
		  var diem = a.data('diem')
		
		  $('#tendt').val(tendetai);
		  $('#svth-dt').val(svths)
		  $('#ngaybc-dt').val(ngaybc)
		  $('#giobc-dt').val(giobc)
		  $('#tgbctd-dt').val(tgbctd +" phút")
		  $('#diem-dt').val(diem)
		})
	</script>
</body>

</html>