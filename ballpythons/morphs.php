<h2>Morphs</h2>

<div class = "dynamicContent">
	<p>
		There are many morphs out there and more new morph being hatched all the time. One of the most unique morphs proven by Brian from BHB Reptiles and Animal Bites Tv is the scaleless Ball Python. The Scaleless Ball Python is made by breeding a rare morph know as the scaleless-head 
		Ball Python. When we breed a male scaleless-head to a female scaleless-head we get what is called the super form which in this case is the Scaleless Ball Python. The first image is a Pinstripe Ball Python and the second image 
		is a Woma Ball Python and the third image is a Super bee.		
	</p>
</div>

<div class = "imgcenter">
    <img src = "pin.jpg" alt="pin.jpg">
	<img src = "woma.jpg" alt="woma.jpg">
	<img src = "bee.jpg" alt="bee.jpg">
</div>

<?php
//Shows all the morphs in an html table.
$errors = 0;
$body = "";

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

//Read the database into the html table.
$tabelName = "morphs";
$SQLstring = "SELECT * FROM $tableName";
$queryResult = @mysql_query($SQLstring, $DBConnect);
if(!$queryResult || mysql_num_rows($queryResult) == 0){
	echo "<p>Could not load morphs table</p>";
}
else{
	echo "<table class = 'morphs'>";
	echo "<caption><h2>Dominant with Recessive gene breeding chart</h2></caption>";
	echo "<tr><th>Morph</th><th>Color</th><th>Value</th><th>Popularity</th></tr>";
	while(($row = mysql_fetch_assoc($queryResult)) !== FALSE){
		echo "<tr><th>{$row['morph']}</th>";
		echo "<th>{$row['color']}</th>";
		echo "<th>{$row['value']}</th>";
		echo "<th>{$row['popularity']}</th></tr>";	
	}
	echo "</table>";
}
?>