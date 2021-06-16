<?php
$body = "";
$loggedIn = 0;
$errors = 0;

//Connect to mysql and set active database.
$DBConnect = @mysql_connect("localhost", "root", "");
if($DBConnect === FALSE){
	$body .= "<p>Unable to connect to the database server. " . "Error code " . mysql_errno() . 
	": " . mysql_error() . "</p>\n";
	++$errors;
}
else{
	$DBName = "snakeDB";
	$result = @mysql_select_db($DBName, $DBConnect);
	if($result === FALSE){
		$body .= "<p>Unable to select the database. " . "Error code " . mysql_errno($DBConnect) . 
		": " . mysql_error(DBConnect) . "</p>\n";
		++$errors;
	}
}

//Check login information.
$tableName = "members";
if($errors == 0 && !empty($_POST['email']) && !empty($_POST['password'])){
	$SQLstring = "SELECT countID, email, password FROM $tableName" . " WHERE email = '" . 
		stripslashes($_POST['email']) . "' AND password = '" . 
		md5(stripslashes($_POST['password'])) . "'";
	$queryResult = @mysql_query($SQLstring, $DBConnect);
	if(!$queryResult || mysql_num_rows($queryResult) == 0){
		$body .= "<p>The e-mail address or password entered is not valid.</p>\n";
		++$errors;
	}
	else{
		$loggedIn = 1;
		session_start();
		$_SESSION['email'] = stripslashes($_POST['email']);
		$_SESSION['loggedIn'] = $loggedIn;
		header("Location: main.php");
	}
	mysql_close($DBConnect);
}
?>
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
			<input type = "hidden" name = "PHPSESSID" value = '<?php echo session_id() ?>' />
			<button class = "formButtonTwo" type = "submit" name = "content" value = "home">Submit</button>
			<br />
			<?php echo $body; ?>
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
