<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "samplerap";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
else
{
echo "connected";
}
//$sql = "INSERT INTO MyGuests (id,value)
//VALUES (1, 'ON')";
$sql = "SELECT id,value FROM rasptable";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "id: ". $row["id"]. "Value: ".$row["value"]. "<br>";
    }
} else {
    echo "0 results";
}

$conn->close();
?> 