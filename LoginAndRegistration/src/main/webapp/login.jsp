<!DOCTYPE html>
<html >
<head>

<title>Sign Up </title>

  
   <link rel="stylesheet" href="regist.css">
   
	
</head>
<body>




	

		<!-- Sing in  Form -->
		
			<div class="container">
				<%-- Display the "invalid" message if the login failed --%>
<%
    String status = (String) request.getAttribute("status");
    if ("failed".equals(status)) {
        String message = (String) request.getAttribute("message");
%>
    <p><%= message %></p>
<%
    }
%>

				
					
					<div >
						<h2 >Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="input-box">
								
								<input type="text" name="username" id="username"
									placeholder="E-Mail"  required/>
									<i class='bx bxs-user'></i>
							</div>
							<div class="input-box">
								 <input
									type="password" name="password" id="password"
									placeholder="Password" required/>
									<i class='bx bxs-lock-alt' ></i>
							</div>
							
							<div >
								<input type="submit" name="signin" id="signin"
									 value="Log in" />
							<div class="register-link">
        <p color="black">Don't have an account?<a href="registration.html">Register</a></p> 
      </div>
						
					</div>
				</div>
		

</body>

</html>