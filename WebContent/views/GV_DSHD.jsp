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
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Danh sách đề tài</a>
                                    </h4>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse out">
                                    <div class="panel-body" id="type_topic">
                                        <div class="list-group" >
                                            <a href="gv_detaiphancongphanbien.html? flag =1" class="list-group-item">Đề tài phân công phản biện</a>
                                            <a href="gv_detaiphanconglamuyvien.html? flag =2" class="list-group-item ">Đề tài phân công làm ủy viên HĐ</a>
                                            <a href="gv_trangchu.html?flag=3" class="list-group-item list-group-item">Tất cả đề tài</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-primary " id="panel_list">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-parent="#accordion" href=gv_danhsachhoidong.html>Danh sách hội đồng</a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a href="gv_xembaocao_phanbien.html">Xem báo cáo</a>
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
								
				               
                                <table class="table table_list table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th class = "col-md-1">#</th>
                                            <th class ="col-md 5">Tên đề tài</th>
                                          	<th class="col-md-2"> Ủy viên</th>
                                          	<th class="col-md-2"> Phản biện</th>
                                          	<th class="col-md-2"> Chủ tịch</th>
                                          	
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% int counter = 1; %>
                              	<c:forEach var="row" items="${list_dt}">
                                    	<c:if test="${row != null}" >
                                        <tr>
                                            <th class ="col-md-1" scope="row"><%= counter++ %></th>
                                            <td class ="col-md-5" ><c:out value="${row.tenDeTai}"></c:out></td>
                                           	<c:forEach var="roww" items="${row.getDshd()}">
                                           	<td class ="col-md-2" >${roww.gv.getHoTen()}</td>
                                           	</c:forEach>
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
                     
                            <!-- Table -->                          
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /container -->
   <!-- Modal -->
                              
    <div class="modal fade" id="chitiethoidong" role="dialog">
                               <div class="modal-dialog">
                                
                                  <!-- Modal content-->
                                  <div class="modal-content">
                                    <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                                      <h4 class="modal-title"><strong>Chi tiết đề tài </strong></h4>
                                    </div>
                                    <div class="modal-body">
                                    <form action="gv_chitiethoidong.html?" method="POST" class="form-horizontal" role="form">
                                       <ul class="list-group list-group-detail">
                                            <li class="list-group-item">
                                                <p><strong>Tên đề tài:</strong> Đề tài 1</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Sinh viên thực hiện:</strong> Nguyễn Văn A</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Giảng viên hướng dẫn:</strong> Phạm Văn B</p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Thành viên hội đồng:</strong></p>
                                                 <table class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td>Nguyễn Văn A</td>
                                                            <td>Ủy viên</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Phạm Văn B</td>
                                                            <td>Phản biện</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Trần Thị C</td>
                                                            <td>Chủ tịch</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Thời gian bắt đầu báo cáo:</strong> 1/1/2016 <strong style="margin-left: 50px">Thời hạn: 120p</strong></p>
                                            </li>
                                            <li class="list-group-item">
                                                <p><strong>Thời gian kết thúc: </strong>17/1/2016</p>
                                            </li>
                                            
                                        </ul>
                                        </form>
                                    </div> 
                                    <div class="modal-footer">
                                      <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
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
                    <form data-toggle="validator" action="changpass.html?jspName=GV_DSHD.jsp" method="POST" class="form-horizontal" role="form">
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