<?php
//Return the user to the login page if they are not logged in
$errors = 0;
$body = "";
session_start();
if($_SESSION['loggedIn'] != 1){
	header("Location: login.php");
}

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

//Check that the morphs table exist, if is doesn't create it and load the records from the text file.
$tableName = "morphs";
$SQLstring = "SHOW TABLES LIKE '$tableName'";
if($errors == 0){
	$queryResult = @mysql_query($SQLstring, $DBConnect);
	if(!$queryResult || mysql_num_rows($queryResult) == 0){
		$SQLstring = "CREATE TABLE $tableName (morph VARCHAR(40) PRIMARY KEY, color VARCHAR(40), value INT, popularity VARCHAR(40))";
		$queryResult = @mysql_query($SQLstring, $DBConnect);
		if($queryResult === FALSE){
			$body .= "<p>Unable to create table.</p>" . "<p>Error code " .
			mysql_errno($DBConnect) . ": " . mysql_error($DBConnect) .
			"</p>";
			++$errors;
		}
		else{
			$SQLstring = "LOAD DATA LOCAL INFILE 'morphs.txt' INTO TABLE $tableName
			FIELDS TERMINATED BY ';'(morph, color, value, popularity)";
			if($errors == 0){
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if($queryResult === FALSE){
					$body .= "<p>Unable to load the file</p>";
					++$errors;
				}
			}
		}
	}
}
mysql_close($DBConnect);
echo $body;
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
		<button class = "logOut" onclick="window.location.href = 'login.php';">Log Out</button>
		<header>
			<h1 class = "headerFont">Ball Pythons</h1>
		</header>
		<nav>
			<form action = "main.php" method = "get">
			<button class = "navButton" type = "submit" name = "content" value = "home">Home</button>
			<button class = "navButton" type = "submit" name = "content" value = "collection">Collection</button>
			<button class = "navButton" type = "submit" name = "content" value = "morphs">Morphs</button>
			<button class = "navButton" type = "submit" name = "content" value = "genes">Genes</button>
			</form>
		</nav>
		<main>
			<?php
			//Dynamic content.
			if($body != ""){
				echo $body;
			}
			if(isset($_GET['content'])){
				switch($_GET['content']){
					case 'home':
						include('home.html');
						break;
					case 'collection':
						include('collection.php');
						break;
					case 'morphs':
						include('morphs.php');
						break;
					case 'genes':
						include('genes.html');
						break;
					default:
						include('home.html');
						break;
				}
			}
			else{
				include('home.html');
			}
			?>
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