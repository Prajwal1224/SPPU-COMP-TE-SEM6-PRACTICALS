<?php
require_once 'connection.php';

if (!isset($_POST['username'], $_POST['password'], $_POST['email'])) {
	exit('Please complete the registration form!');
}
if (empty($_POST['username']) || empty($_POST['password']) || empty($_POST['email'])) {
	exit('Please complete the registration form');
}

// Hash password before storing (recommended)
$hashedPassword = password_hash($_POST['password'], PASSWORD_DEFAULT);

// Use ? placeholders for prepared statement
if ($stmt = $con->prepare('INSERT INTO accounts (username, password, email) VALUES (?, ?, ?)')) {
	$stmt->bind_param('sss', $_POST['username'], $hashedPassword, $_POST['email']);
	$stmt->execute();
	echo 'You have successfully registered! You can now login!';
} else {
	echo 'Could not prepare statement!';
}
?>
