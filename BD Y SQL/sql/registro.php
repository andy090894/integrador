<?php
	$con = mysqli_connect("localhost","root","","prueba");
	$usuario = $_POST["usuario"];
	$nombre = $_POST["nombre"];
	$apellido = $_POST["apellido"];
	$clave = $_POST["clave"];
	$edad = $_POST["edad"];
	$statement = mysqli_prepare($con,"INSERT INTO user(usuario,nombre,apellido,clave,edad) VALUES
	 (?,?,?,?,?)");

	 mysqli_stmt_bind_param($statement,"ssssi",$usuario,$nombre,$apellido,$clave,$edad );
	 mysqli_stmt_execute($statement);

	 $response = array();
	 $response["success"] = true;

	 echo json_encode($response);
?>