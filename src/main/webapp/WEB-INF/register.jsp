<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Home Property | Register</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    
    
    <!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">   
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Fancybox slider -->
    <link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css" media="screen" /> 
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">     

    <!-- Main style sheet -->
    <link href="css/style.css" rel="stylesheet">    

   
    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Vollkorn' rel='stylesheet' type='text/css'>    
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  

  </head>
  <body>   
  <section id="aa-signin">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-signin-area">
            <div class="aa-signin-form">
              <div class="aa-signin-form-title">
                <a class="aa-property-home" href="index.html">Property Home</a>
                <h4>Create your account and Stay with us</h4>
              </div>
              <form action="register.test" method="post">
                    ${existsError}

                    <div class="aa-single-field">
                        ${userError}
                        <label for="username">User name<span style="color: red">*</span></label><br/>
                    <input type="text" name="username" pattern="[a-zA-Z0-9]{6,}" value="${newUser.username}"/>    
                    </div>
                    <div class="aa-single-field">
                         ${passError}
                        <label for="password1">Password<span style="color: red">*</span></label><br/>
                        <input type="password" name="password1" />         
                    </div>
                    <div class="aa-single-field">
                        ${matchError}
                        <label for="password2">Confirm Password</label><br/>
                        <input type="password" name="password2"/>         
                    </div>
                    <div class="aa-single-field">
                        <label for="name">Name<span style="color: red">*</span></label><br/>
                    <input type="text" name="name" value="${newUser.name}"/>   
                    </div>
                    <div class="aa-single-field">
                        ${emailError}
                        <label for="email">Email<span style="color: red">*</span></label><br/>
                        <input type="text" name="email" value="${newUser.email}"/>          
                    </div>
                    <div class="aa-single-field">
                        ${phoneError}
                    <label for="phoneNum">Phone Number<span style="color: red">*</span></label><br/>
                    <input type="text" name="phoneNum" value="${newUser.phoneNum}"/>          
                    </div>
                    <div class="aa-single-field">
                        ${userTypeError}
                    <label for="User Type">User Type<span style="color: red">*</span></label><br/>
                    <label for="Owner">Owner</label>
                    <input type="radio" name="userType" value="Owner"/><br/>
                    <label for="Dealer">Dealer</label>
                    <input type="radio" name="userType"	value="Dealer"/><br/>


                    </div>
                    <div class="aa-single-submit">
                        <input type="submit" value="Submit Form"/>
                    </div>

                    <br/><br/>

                </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section> 


  <!-- jQuery library -->
  <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
  <script src="js/jquery.min.js"></script>   
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.js"></script>   
  <!-- slick slider -->
  <script type="text/javascript" src="js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="js/nouislider.js"></script>
   <!-- mixit slider -->
  <script type="text/javascript" src="js/jquery.mixitup.js"></script>
  <!-- Add fancyBox -->        
  <script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
  <!-- Custom js -->
  <script src="js/custom.js"></script> 
  
  </body>
</html>