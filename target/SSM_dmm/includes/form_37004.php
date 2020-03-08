<?php	
	if(empty($_POST['name_37004']) && strlen($_POST['name_37004']) == 0 || empty($_POST['email_37004']) && strlen($_POST['email_37004']) == 0 || empty($_POST['message_37004']) && strlen($_POST['message_37004']) == 0)
	{
		return false;
	}
	
	$name_37004 = $_POST['name_37004'];
	$email_37004 = $_POST['email_37004'];
	$message_37004 = $_POST['message_37004'];
	$optin_37004 = $_POST['optin_37004'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from a Blocs website.";
	$email_body = "You have received a new message. \n\n".
				  "Name_37004: $name_37004 \nEmail_37004: $email_37004 \nMessage_37004: $message_37004 \nOptin_37004: $optin_37004 \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: $email_37004";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>