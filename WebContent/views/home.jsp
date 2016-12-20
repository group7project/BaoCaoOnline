<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Website báo cáo phản biện trực tuyến</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="css/style-T.css">

</head>
<body >
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
            </div>
        </div> <!--/.container-fluid -->
    </nav>

    <div class="container login-form" style="min-height: calc( 100vh - 230px );">    
        <div id="loginbox" style="margin-top: 50px;" class=" mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                
            <div class="panel panel-info " >
                    <div class="panel-heading">
                        <div class="panel-title">Đăng nhập</div>
                        <div style="float:right; font-size: 90%; position: relative; top:-10px"><a href="#">Quên mật khẩu?</a></div>
                    </div>     

                    <div style="padding-top:10px" class="panel-body" >
                        <form id="loginform" class="form-horizontal" role="form" method="post" action = "login" >
                        
                            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                             <div class="radio" >
                                <label style="padding-right: 20px;"> <input type="radio" name="rolename"  value ="SV" checked="checked"> Sinh viên</label>
                                <label style="padding-right: 20px;"> <input type="radio" value ="GV" name="rolename" > Giảng viên</label>
                                <label style="padding-right: 20px;"> <input type="radio" value ="TK" name="rolename" > Trưởng khoa</label>
                                <label> <input type="radio" value ="AD" name="rolename"> Admin</label>
                            </div>
                            
                            <div style="padding-top: 10px;">
                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                     <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="Tên đăng nhập">                                        
                                </div>
                                    
                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="login-password" type="password" class="form-control" name="password" placeholder="Mật khẩu">
                                </div>
                                        
                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="remember" value="1" checked="checked"> Ghi nhớ đăng nhập
                                        </label>
                                    </div>
                                </div>


                                <div style="margin-top:10px" class="form-group">
                                        <!-- Button -->
                                    <div class="col-sm-12 controls ">
                                        <input id="btn-login" type="submit" class="btn btn-success" value="&nbsp;&nbsp;Đăng nhập&nbsp;&nbsp;">
                                    </div>
                                </div>
                            </div>
                            
                        </form>     
                    </div>                     
            </div>  
        </div>
    </div> 
 	<footer class= "footer my-footer login-footer">
        <div class="container ">
            <h5 class="text-muted text-center ">©2016 Đại học Sư Phạm Kỹ Thuật thành phố Hồ Chí Minh</h5>
        </div>
    </footer>
    
</body>
     <% String message = (String)request.getAttribute("alertMsg");%>
	<script type="text/javascript">
	    var msg = "<%=message%>";
	    if(msg == "tk bi khoa" )
	    	alert("Tài khoản này đã bị khóa. Xin vui lòng liên hệ quản trị viên để khôi phục");
	    else if(msg == "sai ten dang nhap hoac mat khau")
	    	alert("Sai tên đăng nhập hoặc mật khẩu. Xin vui lòng nhập lại.");
	</script>
</html>