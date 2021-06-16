<h2>Collection</h2>

<?php
//Shows the create collection form button.
function createCollection(){
	?>
	<form action="" method = "post">
	<button class = "formButton" type = "submit" name = "create" value = "create" onclick="this.disable = true;">Create Collection</button>
	</form>
	<?php
}

//Shows the form to add, remove, and show the data in the collection.
function manageCollection(){
	?>
	<form class = "logFont" action="" method = "post">
	<label for="morph">Choose a morph:</label><br />
	<select id="morph" name="morph">
    <option value="Acid">Acid</option>
    <option value="Albino">Albino</option>
    <option value="Axanthic">Axanthic</option>
    <option value="Banana">Banana</option>
	<option value="Black Backed">Black Backed</option>
	<option value="Black Pastel">Black Pastel</option>
	<option value="Blue Eyed Lucy">Blue Eyed Lucy</option>
	<option value="Bongo Pastel">Bongo Pastel</option>
	<option value="Bumblebee">Bumblebee</option>
	<option value="Butter">Butter</option>
	<option value="Candino">Candino</option>
	<option value="Candy">Candy</option>
	<option value="Champagne">Champagne</option>
	<option value="Chocolate">Chocolate</option>
	<option value="Cinnamon">Cinnamon</option>
	<option value="Clown">Clown</option>
	<option value="Coral Glow">Coral Glow</option>
	<option value="Dreamsicle">Dreamsicle</option>
	<option value="Enchi">Enchi</option>
	<option value="Fire">Fire</option>
	<option value="Fire Ivory">Fire Ivory</option>
	<option value="Ghost">Ghost</option>
	<option value="Highway">Highway</option>
	<option value="Ivory">Ivory</option>
	<option value="Lavender">Lavender</option>
	<option value="Lemon Blast">Lemon Blast</option>
	<option value="Lesser">Lesser</option>
	<option value="Mojave">Mojave</option>
	<option value="Pastel">Pastel</option>
	<option value="Pewter">Pewter</option>
	<option value="Phantom">Phantom</option>
	<option value="Piebald">Piebald</option>
	<option value="Pinstripe">Pinstripe</option>
	<option value="Purple Passion">Purple Passion</option>
	<option value="Red">Red</option>
	<option value="Ringer">Ringer</option>
	<option value="Scaleless">Scaleless</option>
	<option value="Spider">Spider</option>
	<option value="Spotnos">Spotnos</option>
	<option value="Stormtrooper">Stormtrooper</option>
	<option value="Sunset">Sunset</option>
	<option value="Super Blast">Super Blast</option>
	<option value="Tiger">Tiger</option>
	<option value="Vanilla">Vanilla</option>
	<option value="White">White</option>
	<option value="Woma">Woma</option>
	<option value="Yellow Belly">Yellow Belly</option>
	</select><br />
	<button class = "formButton" type = "submit" name = "add">Add</button>
	<button class = "formButton" type = "submit" name = "remove">Remove</button>
	<button class = "formButton" type = "submit" name = "show" value = "show">Show Collection</button>
	</form>
	<?php	
}

$tableName = strtok($_SESSION['email'], "@");
$errors = 0;
$body = "";
$create = "";
$add = "";
$remove = "";

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

//Creates a database table to hold the users collection.
if($errors == 0){
	if(isset($_POST['create'])){
		$create = $_POST['create'];
	}
	if($create == "create"){
		$SQLstring = "CREATE TABLE $tableName (morph VARCHAR(40) PRIMARY KEY, color VARCHAR(40), value INT, popularity VARCHAR(40))";
		$queryResult = @mysql_query($SQLstring, $DBConnect);
		if(!$queryResult === FALSE){
			$body .= "<p>Unable to create table.</p>" . "<p>Error code " .
			mysql_errno($DBConnect) . ": " . mysql_error($DBConnect) .
			"</p>";
			
			$create = "";
		}
	}
	
	//Check if the user has created a collection if they have show the add/remove form otherwise show the create button.
	$SQLstring = "SHOW TABLES LIKE '$tableName'";
	$queryResult = @mysql_query($SQLstring, $DBConnect);
	if(!$queryResult || mysql_num_rows($queryResult) == 0){
		createCollection();
	}

	
	else{
		//Add the selected morph to the database.
		if(isset($_POST['add'])){
			$add = $_POST['morph'];
			if($add != ""){
				$SQLstring = "SELECT * FROM morphs WHERE morph = '$add'";
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if(!$queryResult || mysql_num_rows($queryResult) > 0){
					$row = mysql_fetch_array($queryResult, MYSQL_NUM);
					$SQLstring = "INSERT INTO $tableName VALUES('$row[0]', '$row[1]', '$row[2]', '$row[3]')";
					$queryResult = @mysql_query($SQLstring, $DBConnect);
					if($queryResult === FALSE){
						$body .= "<p>Unable to execute the query.</p>" . "<p>Error code " . mysql_errno($DBConnect) .
						": " . mysql_error($DBConnect) . "</p>";
					}
					$add = "";
				}
			}
		}
		
		//remove the selected morph from the database.
		if(isset($_POST['remove'])){
			$remove = $_POST['morph'];
			if($remove != ""){
				$SQLstring = "DELETE FROM $tableName WHERE morph = '$remove'";
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if($queryResult === FALSE){
					$body .= "<p>You do not have $remove morph in your collection</p>";
				}
				$remove = ""; 
			}
		}
		
		//Show the morphs in the user collection in a html table.
		if(isset($_POST['show'])){
			$show = $_POST['show'];
			if($show == "show"){
				$SQLstring = "SELECT morph, color, value, popularity FROM $tableName ORDER BY morph";
				$queryResult = @mysql_query($SQLstring, $DBConnect);
				if(!$queryResult || mysql_num_rows($queryResult) == 0){
					echo "<p>Your collection is empty</p>";
				}
				else{
					echo "<table class = 'collection'>";
					echo "<tr><th>Morph</th><th>Color</th><th>Value</th><th>Popularity</th></tr>";
					while(($row = mysql_fetch_assoc($queryResult)) !== FALSE){
						echo "<tr><th>{$row['morph']}</th>";
						echo "<th>{$row['color']}</th>";
						echo "<th>{$row['value']}</th>";
						echo "<th>{$row['popularity']}</th></tr>";	
					}
					echo "</table>";
				}
			}
		}
		else{
			manageCollection();
		}
	}
	echo $body;
}
?>