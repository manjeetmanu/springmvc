<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="css/style.css">
    <title>log-in</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
        <div class="container">
           <!--<a class="navbar-brand" href="#">Image Uploader</a>  --> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>
    
    <main class="login-form">
        <div class="cotainer">
            <div class="row justify-content-center">
                <div class="col-md-8  p-4">
                    <div class="card">
                        <div class="card-header">Registeration</div>
                        <div class="card-body">
                            	<form action=processregisterform method="post">
                                <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">Email</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email_address" class="form-control" name="email" required minlength="5" maxlength="50">
                                    </div>
                                </div>
                                
                                 <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">UserName</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email_address" class="form-control" name="username" required minlength="5" maxlength="50">
                                    </div>
                                </div>
    
                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password" required minlength="5" maxlength="50">
                                    </div>
                                </div>
    
                      

          
    
                                <div class="col-md-6 offset-md-4">
                                    <button type="submit" class="btn btn-primary">
                                        Submit
                                    </button>
                                </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
       </div>
    
    </main>
    
  </body>
</html>