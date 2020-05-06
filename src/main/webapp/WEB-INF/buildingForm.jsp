<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="acres.dto.UserInfo"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Home Property | List a Property</title>

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
      
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
      
    
    <link rel="stylesheet" href="css/page.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  

  </head>
  <body>
 
  <!-- Pre Loader -->
  <div id="aa-preloader-area">
    <div class="pulse"></div>
  </div>
  <!-- SCROLL TOP BUTTON -->
    <a class="scrollToTop" href="#"><i class="fa fa-angle-double-up"></i></a>
  <!-- END SCROLL TOP BUTTON -->


  <!-- Start header section -->
  <header id="aa-header">  
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-header-area">
            <div class="row">
              <div class="col-md-6 col-sm-6 col-xs-6">
                <div class="aa-header-left">
                  <div class="aa-telephone-no">
                    <span class="fa fa-phone"></span>
                    1-900-523-3564
                  </div>
                  <div class="aa-email hidden-xs">
                    <span class="fa fa-envelope-o"></span> info@markups.com
                  </div>
                </div>              
              </div>
              <div class="col-md-6 col-sm-6 col-xs-6">
                <%
				  UserInfo user = (UserInfo) session.getAttribute("currentUser");
				  if(user == null){
						out.print("<div class='aa-header-right' style='display:block'>" +
				                  "<a href='register.test' class='aa-register'>Register</a>" +
				                  "<a href='login.test' class='aa-login'>Login</a> </div>");
				  }else{
						out.print("<div class='aa-header-right' id='loggedIn' style='display:block'>" +
			                	"<a href='user_info' class='aa-register'>" + user.getUsername() + "</a>" +
			                	"<a href='logout.test' class='aa-login'>Logout</a></div>"); 
				  } %>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- End header section -->
  <!-- Start menu section -->
  <section id="aa-menu-area">
    <nav class="navbar navbar-default main-navbar" role="navigation">  
      <div class="container">
        <div class="navbar-header">
          <!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- LOGO -->                                               
          <!-- Text based logo -->
          <a class="navbar-brand aa-logo" href="welcome"> Home<span>Property</span></a>
          <!-- Image based logo -->
          <!-- <a class="navbar-brand aa-logo-img" href="index.html"><img src="img/logo.png" alt="logo"></a> -->                   
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul id="top-menu" class="nav navbar-nav navbar-right aa-main-nav">
            <li><a href="welcome">HOME</a></li>
             <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="properties.test">PROPERTIES<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
              	<li><a href="list_properties.test">ALL PROPERTIES</a></li>               
                <li><a href="residential_properties.test">RESIDENTIAL PROPERTIES</a></li>
                <li><a href="commercial_properties.test">COMMERCIAL PROPERTIES</a></li>                                            
              </ul>
            </li>
            <li class="active"><a href="list_property.test">LIST PROPERTY</a></li>                                         
            <li><a href="contact.html">CONTACT</a></li>          
          </ul>                          
        </div><!--/.nav-collapse -->       
      </div>          
    </nav> 
  </section>
  <!-- End menu section -->

  <!-- Start Proerty header  -->

  <section id="aa-property-header">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-property-header-inner">
            <h2>List Property</h2>
            <ol class="breadcrumb">
            <li><a href="#">HOME</a></li>            
            <li class="active">LIST PROPERTY</li>
          </ol>
          </div>
        </div>
      </div>
    </div>
  </section> 
  <!-- End Property header  -->
  <section id="aa-gallery">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-gallery-area">
            <div class="aa-title">
              <h2>Let's Post Your Property!</h2>
              <span></span>
               <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi commodi eum dolorem aut eos, debitis quaerat reiciendis, officiis consectetur ducimus atque suscipit ab at tempora!</p>
               <% if (user ==  null){
            	   out.print("<a href='login.test' style='text-decoration: underline'>Please Login to List a Property</a><br/>");
               } %>
               ${error}
            </div>
            <!-- Form Start -->
            
            <form id="buildingForm" action="insert_property.test" method="post">
            <!--First Tab-->
            <fieldset id="first" class="tab">
            		<br/>
                    <label>List Property For:<span style="color:red">*</span></label><br/>
                <input type="radio" name="propertyList" value="Sell"/><label>Sell</label><br/>
                <input type="radio" name="propertyList" value="Rent" /><label>Rent</label>
                <br/><br/>
                    <label for="listing_type">Property Type:<span style="color: red">*</span></label><br/>
                <input type="radio" name="propertyType" value="Residential"/><label for="propertyType">Residential</label>
                <input type="radio" name="propertyType" value="Commercial"/><label for="listing_Type">Commercial</label><br/>

                <!--Residential Division-->
                <div class="Residential box" style="display:none">
                    <input type="radio" name="reBuildingType" value="Apartment"/><label for="Apartment">Apartment/Flat/Building Floor</label><br/>
                    <input type="radio" name="reBuildingType" value="Residental Land"/><label for="Residential Land">Residential Land</label><br/>
                    <input type="radio" name="reBuildingType" value="House" required><label for="House">House</label><br/><input type="radio" name="reBuildingType" value="Other">
                    <label for="Other">Other</label><br/><br/>
                    <div class="Apartment box2" style="display:none">
                    	<label>Apartment Type:</label><br/>
	                    <select name="apartmentType" required>
	                    	<option selected disabled hidden=true>Apartment Type</option>
	                        <option value="Studio Apartment">Studio Apartment</option>
	                        <option value="Residential Apartment">Residential Apartment</option>
	                        <option value="Serviced Apartment">Serviced Apartment</option>
	                        <option value="Independent Apartment">Independent/Builder Floor</option>
	                    </select>
                    </div>
                     <div class="House box2" style="display:none">
                     	<label>House Type:</label>
	                    <select name="houseType">
	                    	<option selected disabled hidden=true>House Type</option>
	                        <option value="Independent House / Villa">Independent House / Villa</option>
	                        <option value="Farm House">Farm House</option>
	                    </select><br/>
                    </div>
                </div>
                
                <!--Commercial Division-->
                <div class="Commercial box" style="display:none">
                    <input type="radio" name="comBuildingType" value="Office">
                    <label for="Offices">Offices</label><br/>
                    <input type="radio" name="comBuildingType" value="Retail">
                    <label for="Retail">Retail</label><br/>
                    <input type="radio" name="comBuildingType" value="Land">
                    <label for="Land">Land</label><br/>
                    <input type="radio" name="comBuildingType" value="Storage">
                    <label for="Industry Storage">Industry Storage</label><br/>
                    <input type="radio" name="comBuildingType" value="Hospitality">
                    <label for="Hospitality">Hospitality</label><br/>
                    <input type="radio" name="comBuildingType" value="Others">
                    <label for="Others">Others</label><br/><br/>
                    <div class="Office box3" style="display:none">
                    	<label>Office Type:</label>
	                    <select name="officeType">
	                    	<option selected disabled hidden=true>Office Types</option>
	                        <option value="Commercial Office">Commercial Office</option>
	                        <option value="Office in IT Park">Office in IT Park</option>
	                        <option value="Office in Business Park">Office in Business Park</option>
	                        <option value="Business Center">Business Center</option>
	                        <option value="Time Share">Time Share Office</option>
	                    </select>
                    </div>
                    <div class="Retail box3" style="display:none">
                    	<label>Retail Type:</label>
                    	<select name="retailType">
                    		<option selected disabled hidden=true>Retail Types</option>
	                        <option value="Commercial Shop">Commercial Shop</option>
	                        <option value="Commercial Showroom">Commercial Showroom</option>
	                        <option value="Space in Retail Mall">Space in Retail Mall</option>
                    	</select>
                    </div>
                    <div class="Land box3"style="display:none">
                    	<label>Land Type:</label>
                    	<select name="landType">
                    	<option selected disabled hidden=true>Land Types</option>
                        <option value="Commercial Land">Commercial Land</option>
                        <option value="Agricultural Land">Agricultural Land</option>
                        <option value="Industrial Land">Industrial Land</option>
                    </select>
                    </div>
                    <div class="Storage box3" style="display:none">
                    	<label>Storage Type:</label>
                    	 <select name="industryType">
                    	 <option selected disabled hidden=true>Storage Types</option>
                        <option value="Warehouse">Warehouse</option>
                        <option value="Cold Storage">Cold Storage</option>
                    </select>
                    </div>
                    <div class="Hospitality box3" style="display:none">
	                    <label>Hospitality Type:</label>
	                    <select name="hospitalityType">
	                    	<option selected disabled hidden=true>Hospitality Type</option>
	                        <option value="Hotel / Resorts">Hotel / Resorts</option>
	                        <option value="Guesthouse / Banquet Halls">Guesthouse / Banquet Halls</option>
	                    </select>
                    </div>
                    <br/><br/>
                    <label for="multipleProperty">Multiple Property Units?</label><br/>
                    <input type="radio" name="multipleProperty" value="Yes">
                    <label for="Yes">Yes</label>
                    <input type="radio" name="multipleProperty" value="No">
                    <label for="No">No</label><br/><br/>
                    <br/>
                </div>
                
                <input class="next" type="button" value="Let's Get Started!"/>
            </fieldset>

            <!--Second Tab-->
            <fieldset class="tab">
                   <label for="address">Address<span style="color:red">*</span></label>
                   <input type="text" name="address" placeholder="House Number and Street Name" required><br/>
                    <label for="city">City<span style="color:red">*</span></label>
                   <input type="text" name="city" placeholder="City" required><br/>
                    <label for="state">State<span style="color:red">*</span></label>
                    <select name="state" required>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select><br/>
                    <label for="projectName">Housing Title<span style="color:red">*</span></label>
                   <input type="text" name="projectName" placeholder="Housing Title" required><br/><br/>
                <br/>
                <input type="button" class="previous" value="Previous"/>
                <input type="button" class="next" value="Next">
            </fieldset>

            <!--Third Tab-->
            <fieldset class="tab">
                <label for="plotArea">Plot Area<span style="color:red">*</span></label>
                <input type="text" name="plotArea" placeholder="Plot Area" required>
                <label>sq. ft</label><br/>
                <br/>
                <label for="roomNum">Number of Rooms:<span style="color:red">*</span></label><br/>
                <select name="roomNum" required> 
                	<option value="None">None</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="9+">9+</option>
                </select><br/>
                <label for="washroomNum">Washrooms:<span style="color:red">*</span></label><br/>
                <select name="washroomNum" required>
                    <option value="None">None</option>
                    <option value="Shared">Shared</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="9+">9+</option>
                </select><br/>
                <br/>
                <br/>
                <label for="availability">Availability:<span style="color:red">*</span></label>
                <select name="availability" required>
                	<option value="New Construction">New Construction</option>
                    <option value="Under Construction">Under Construction</option>
                    <option value="Ready to Move">Ready to Move</option>
                </select><br/>
                <label for="possessionBy">Possession By:<span style="color:red">*</span></label>
                <select name="possessionBy" required>
                	<option value="Not Applicable">Not Applicable</option>
                    <option value="Within 3 months">Within 3 months</option>
                    <option value="Within 6 months">Within 6 months</option>
                    <option value="By 2021">By 2021</option>
                    <option value="By 2022">By 2022</option>
                    <option value="By 2023">By 2023</option>
                    <option value="By 2024">By 2024</option>
                    <option value="By 2025">By 2025</option>
                    <option value="By 2026">By 2026</option>
                </select><br/>
                <label for="ageOfProperty">Age of Property:<span style="color:red">*</span></label>
                <select name="ageOfProperty" required>
                    <option value="0-1 year old">0-1 year old</option>
                    <option value="2-3 years old">2-3 years old</option>
                    <option value="4-6 years old">4-6 years old</option>
                    <option value="7-10 years old">7-10 years old</option>
                    <option value="11-15 years old">11-15 years old</option>
                    <option value="16-25 years old">16-25 years old</option>
                    <option value="26+ years old">26+ years old</option>
                </select><br/><br/>
                <input type="button" class="previous" value="Previous"/>
                <input type="button" class="next" value="Next">
            </fieldset>

            <!--Fourth Tab-->
            <fieldset class="tab">
                    <label for="ownership">Ownership:<span style="color:red">*</span></label>
                    <select name="ownership" required>
                        <option value="Freehold">Freehold</option>
                        <option value="Leasehold">Leasehold</option>
                        <option value="Power of Attorney">Power of Attorney</option>
                        <option value="Cooperative Society">Cooperative Society</option>
                    </select><br/><br/>
                    <div class="Rent box4" style="display:none">
                    	<label for="expectedRent">Expected Rent:<span style="color:red">*</span> $</label>
                    	<input type="number" step=0.01 name="expectedRent"><br/><br/>
                    </div>
                    <div class="Sell box4" style="display:none">
                    	<label for="ex pectedPrice">Expected Price:<span style="color:red">*</span> $</label>
                    	<input type="number" step=0.01 name="expectedPrice"><br/>
                    </div>
                    <br/>
                    <label>Provide a description for your property:<span style="color:red">*</span></label><br/>
                    <textarea name="description" rows="13" cols="60" required></textarea><br/><br/>
                    <label for="amenities">Choose amenities that building offers:</label><br/>
                    <input type="checkbox" name="amenities" value="In-Unit Laundry"/><label>In-Unit Laundry</label><br/>
                    <input type="checkbox" name="amenities" value="Nearby Parks"/><label>Nearby Parks</label><br/>
                    <input type="checkbox" name="amenities" value="Free Wifi"/><label>Free Wifi</label><br/>
                    <input type="checkbox" name="amenities" value="Nearby Shopping"/><label>Nearby Shopping</label><br/>
                    <input type="checkbox" name="amenities" value="Public Transportation"/><label>Public Transportation</label><br/>
                    <input type="checkbox" name="amenities" value="Nearby Entertainment"/><label>Nearby Entertainment</label><br/>
                    <input type="checkbox" name="amenities" value="Included Heating"/><label>Included Heating</label><br/>
                    <input type="checkbox" name="amenities" value="Concierge Service"/><label>Concierge Service</label><br/>
                    <input type="checkbox" name="amenities" value="Nearby Restaurants"/><label>Nearby Restaurants</label><br/>
                    <br/>
                    <input type="button" class="previous" value="Previous"/>
                    <input class="submit" type="submit" value="Submit Building">
            </fieldset>
            <ul class="progressbar">
                <span class="progress"></span>
                <span class="progress"></span>
                <span class="progress"></span>
                <span class="progress"></span>
            </ul>
        </form>
        </div>
        </div>
        </div>
        </div>
 </section>

  <!-- Footer -->
  <footer id="aa-footer">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        <div class="aa-footer-area">
          <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="aa-footer-left">
               <p>Designed by <a rel="nofollow" href="http://www.markups.io/">MarkUps.io</a></p>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="aa-footer-middle">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-google-plus"></i></a>
                <a href="#"><i class="fa fa-youtube"></i></a>
              </div>
            </div>
            <div class="col-md-6 col-sm-12 col-xs-12">
              <div class="aa-footer-right">
                <a href="welcome">Home</a>
                <a href="#">Support</a>
                <a href="#">License</a>
                <a href="#">FAQ</a>
                <a href="#">Privacy and Term</a>
              </div>
            </div>            
          </div>
        </div>
      </div>
      </div>
    </div>
  </footer>
  <!-- / Footer -->

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
  <script src="js/page.js"></script>
  
  </body>
</html>