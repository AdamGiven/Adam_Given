<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0
Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Adam's Ball Pythons</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
	<div id = "wrapper">
		<header>
			<h1 class = "headerFont">Ball Pythons</h1>
		</header>
		<main>
			<h2 class = "logFont">Register</h2>
			<form action = "register.php" method = "post">
			<p>Email <input type = "text" name = "email" /></p>
			<p>Password <input type = "text" name = "passwordOne" placeholder = "At least 6 characters"/></p>
			<p>Confirm Password <input type = "text" name = "passwordTwo" placeholder = "Passwords must match"/></p>
			<button class = "formButton" type = "submit" name = "content" value = "home">Submit</button>
			</form>
			<br />
			
			<br />
			<h2 class = "logFont">Login</h2>
			<form action = "login.php" method = "post">
			<p>Email <input type = "text" name = "email" /></p>
			<p>Password <input type = "text" name = "password" placeholder = "At least 6 characters"/></p>
			<button class = "formButtonTwo" type = "submit" name = "content" value = "home">Submit</button>
			<br />
		</main>
		<footer>
		<p>Copyright &copy; 2020 Adam Given &nbsp; Date: 
			<?php 
				date_default_timezone_set('America/Denver');
				echo date("F j, Y, g:i a"); 
			?>
		</p>
		</footer>
	</div>
</body>
	