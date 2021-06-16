<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0
Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Adam Given code sample</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>	
	<?php
	$str = "many birds, fly south, for the WINTER* ";
	function sample($str) {		
		//1) Make the first letter of the first word uppercase
		echo "<p>" . ucfirst($str) . "<br/></p>";
		//2) Convert the entire string to lowercase
		echo "<p>" . strtolower($str) . "<br/></p>";
		//3) Remove all the commas
		echo "<p>" . str_replace("," , " " , $str) . "<br/></p>";
		//4) Replace all the asterisks with exclamations and
		echo "<p>" . str_replace("*" , "!" , $str) . "<br/></p>";
		//5) Clear any whitespace from the end. Make your code a function that can be fed any $str.
		echo "<p>" . rtrim($str," ") . "<br/><br/></p>";;
	  }

	sample($str);
	?>			
	<footer>
		<p>Copyright &copy; &nbsp;  
			<?php 
				date_default_timezone_set('America/Denver');
				echo date("F j, Y, g:i a"); 
			?>
			&nbsp; Adam Given code sample 
		</p>
	</footer>
</body>