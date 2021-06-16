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
			
			<?php
			//Get and check email.
			$errors = 0;
			$email = "";
			if(empty($_POST['email'])){
				++$errors;
				echo "<p>You need to enter an e-mail address.</p>\n";
			}
			else{
				$email = stripslashes($_POST['email']);
				if(preg_match("/^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$/i", $email) == 0) {
					++$errors;
					echo "<p>You need to enter a valid e-mail address.</p>\n";
					$email = "";
				}
			}

			//Get password.
			if(empty($_POST['passwordOne'])){
				++$errors;
				echo "<p>You need to enter a password.</p>\n";
				$passwordOne = "";
			}
			else{
				$passwordOne = stripslashes($_POST['passwordOne']);
			}

			//Get confirmation password.
			if(empty($_POST['passwordTwo'])){
				++$errors;
				echo "<p>You need to enter a confirmation password.</p>\n";
				$passwordTwo = "";
			}
			else{
				$passwordTwo = stripslashes($_POST['passwordTwo']);
			}

			//Check that passwords match and has at least 6 characters.
			if((!(empty($passwordOne))) && (!(empty($passwordTwo)))){
				if(strlen($passwordOne) < 6){
					++$errors;
					echo "<p>The passwords is too short.</p>\n";
					$passwordOne = "";
					$passwordTwo = "";
				}
				if($passwordOne <> $passwordTwo){
					++$errors;
					echo "<p>The passwords do not match.</p>\n";
					$passwordOne = "";
					$passwordTwo = "";
				}
			}

			//Connect to mysql and set active database.
			if($errors == 0){
				$DBConnect = @mysql_connect("localhost", "root", "");
				if($DBConnect === FALSE){
					echo "<p>Unable to connect to the database server. " . "Error code " . mysql_errno() . 
					": " . mysql_error() . "</p>\n";
					++$errors;
				}
				else{
					$DBName = "snakeDB";
					$result = @mysql_select_db($DBName, $DBConnect);
					if($result === FALSE){
						$SQLstring = "CREATE DATABASE $DBName";
						$queryResult = @mysql_query($SQLstring, $DBConnect);
						if($queryResult === FALSE){
							echo "<p>Unable to create the database.</p>" . "<p>Error code " . 
							mysql_errno($DBConnect) . "</p>";
						}
						else{
							$result = @mysql_select_db($DBName, $DBConnect);
							if($result === FALSE){
								echo "<p>Unable to connect to the database server. " . "Error code " . mysql_errno() . 
								": " . mysql_error() . "</p>\n";
								++$errors;
							}
						}
					}
				}
			}
			
			//Create the database table if it doens't already exist.
			$tableName = "members";
			$SQLstring = "SHOW TABLES LIKE '$tableName'";
			$queryResult = @mysql_query($SQLstring, $DBConnect);
			if(!$queryResult || mysql_num_rows($queryResult) == 0){
				$SQLstring = "CREATE TABLE $tableName (countID SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY, email VARCHAR(40), password VARCHAR(40))";
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if($queryResult === FALSE){
					echo "<p>Unable to create table.</p>" . "<p>Error code " .
					mysql_errno($DBConnect) . ": " . mysql_error($DBConnect) .
					"</p>";
				}
			}
			
			//Check for errors.
			if($errors > 0){
				echo "<p>Please use you bowser's BACK button to return to the form and fix the errors indicated.</p>\n";
			}

			//Insert user data into the database.
			if($errors == 0){
				$SQLstring = "INSERT INTO $tableName (email, password) VALUES('$email', " . " '" . md5($passwordOne) . "')";
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if($queryResult === FALSE){
					echo "<p>Unable to save your registration information. Error code " .
						mysql_errno($DBConnect) . ": " . mysql_error($DBConnect) . "</p>\n";
					++$errors;
				}
				else{
					$message = "Registration Successful. Use the login form to login.";
					echo "<p> " . $message . " </p>";
				}
				mysql_close($DBConnect);
			}
			?>
			
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