<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="acres.dto.UserInfo, acres.dto.BuildingInfo"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Home Property | Properties Details</title>

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
  <body class="aa-price-range">  
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
          <a class="navbar-brand aa-logo" href="welcome"> Home <span>Property</span></a>
          <!-- Image based logo -->
          <!-- <a class="navbar-brand aa-logo-img" href="index.html"><img src="img/logo.png" alt="logo"></a> -->                     
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul id="top-menu" class="nav navbar-nav navbar-right aa-main-nav">
            <li><a href="index.html">HOME</a></li>
             <li class="dropdown active">
              <a class="dropdown-toggle" data-toggle="dropdown">PROPERTIES <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">  
                <li><a href="list_properties.test">ALL PROPERTIES</a></li>
                <li><a href="properties-detail.html">COMMERCIAL PROPERTIES</a></li>
                <li><a href="properties-detail.html">RESIDENTIAL PROPERTIES</a></li>
              </ul>
            </li>
            <li><a href="list_property.test">LIST PROPERTY</a></li>
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
            <h2>Properties Details</h2>
            <ol class="breadcrumb">
            <li><a href="welcome">HOME</a></li>            
            <li class="active">PROPERTY DETAILS</li>
          </ol>
          </div>
        </div>
      </div>
    </div>
  </section> 
  <!-- End Property header  -->
  
  
  <!-- Start Properties  -->
  <section id="aa-properties">
    <div class="container">
      <div class="row">
        <div class="col-md-8">
          <div class="aa-properties-content">            
            <!-- Start properties content body -->
            <div class="aa-properties-details">
             <div class="aa-properties-details-img">
               <img src="img/slider/1.jpg" alt="img">
               <img src="img/slider/2.jpg" alt="img">
               <img src="img/slider/3.jpg" alt="img">
             </div>
             <div class="aa-properties-info">
               <h1>${buildingInfo.propertyType}</h1>
               <h2>
               <core:if test="${buildingInfo.propertyType.equals('Residential')}">
               <core:choose>
          				<core:when test="${retBuilding.reBuildingType.equals('Apartment')}">
          					<core:out value="Apartment | "></core:out>
          					<core:out value="${retBuilding.apartmentType}"></core:out>
          				</core:when>
          				<core:when test="${retBuilding.reBuildingType.equals('House')}">
          					<core:out value="House/Villa | "></core:out>
          					<core:out value="${retBuilding.houseType}"></core:out>
          				</core:when>
               </core:choose>
			   </core:if>
               <core:if test="${buildingInfo.propertyType.equals('Commercial')}">
               <core:choose>
               				<core:when test="${retBuilding.comBuildingType.equals('Office')}">
               					<core:out value="Office | "></core:out>
               					<core:out value="${retBuilding.officeType}"></core:out>
               				</core:when>
               				<core:when test="${retBuilding.comBuildingType.equals('Retail')}">
               					<core:out value="Retail | "></core:out>
               					<core:out value="${retBuilding.retailType}"></core:out>
               				</core:when>
               				<core:when test="${retBuilding.comBuildingType.equals('Land')}">
               					<core:out value="Land | "></core:out>
               					<core:out value="${retBuilding.landType}"></core:out>
               				</core:when>
               				<core:when test="${retBuilding.comBuildingType.equals('Storage')}">
               					<core:out value="Industry Storage | "></core:out>
               					<core:out value="${retBuilding.storageType}"></core:out>
               				</core:when>
               				<core:when test="${retBuilding.comBuildingType.equals('Hospitality')}">
               					<core:out value="Hospitality | "></core:out>
               					<core:out value="${retBuilding.hospitalityType}"></core:out>
               				</core:when>
               				<core:otherwise>
               					<core:out value="Other Building Type"></core:out>
               				</core:otherwise>
               	</core:choose>
               	</core:if>
               </h2>
               <h2>${buildingInfo.projectName}</h2>
               
               <core:choose>
               		<core:when test="${buildingInfo.expectedRent != 0}">
               			<span class="aa-price">
               				<core:out value="$ ${buildingInfo.expectedRent} /month"></core:out>
               			</span>
               		</core:when>
               		<core:when test="${buildingInfo.expectedPrice != 0}">
               			<span class="aa-price">
               				<core:out value="$ ${buildingInfo.expectedPrice}"></core:out>
               			</span>
               		</core:when>
               </core:choose>
               <p>${buildingInfo.description}</p>
               <h4>Property Features</h4>
               <ul>
               	 <li>
               	 <core:choose>
	                        <core:when test="${buildings.roomNum}.equals('None')">
	                        	<core:out value="No Rooms"></core:out>
	                        </core:when>
	                        <core:when test="${buildings.roomNum}.equals('1')">
	                        	<core:out value="${buildings.roomNum} Room"></core:out>
	                        </core:when>
	                        <core:otherwise>
	                        	<core:out value="${buildings.roomNum} Rooms"></core:out>
	                        </core:otherwise>
                 </core:choose>
               	 </li>
                 <li>
                 <core:choose>
                        	<core:when test="${buildings.washroomNum}.equals('None')">
                        		<core:out value="No Washroom"></core:out>
                        	</core:when>
                        	<core:when test="${buildings.washroomNum}.equals('Shared')">
                        		<core:out value="Shared Washroom"></core:out>
                        	</core:when>
                        	<core:when test="${buildings.washroomNum}.equals('1')">
                        		<core:out value="1 Washroom"></core:out>
                        	</core:when>
                        	<core:otherwise>
                        		<core:out value="${buildings.washroomNum} Washrooms"></core:out>
                        	</core:otherwise>
                        </core:choose>
                 </li>
                 <core:forEach var="amenities" items="${buildingInfo.amenities}">
                 	<li>
                 		<core:out value="${amenities}"></core:out>
                 	</li>
                 </core:forEach>
               </ul>
               <h4>Property Map</h4>
               <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6851.201919469417!2d-86.11773906635584!3d33.47324776828677!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x888bdb60cc49c571%3A0x40451ca6baf275c7!2s36008+AL-77%2C+Talladega%2C+AL+35160%2C+USA!5e0!3m2!1sbn!2sbd!4v1460452919256" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
             </div>
             <!-- Properties social share -->
             <div class="aa-properties-social">
               <ul>
                 <li>Share</li>
                 <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                 <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                 <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                 <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
               </ul>
             </div>
             <!-- Nearby properties -->
             <div class="aa-nearby-properties">
               <div class="aa-title">
                 <h2>Nearby Properties</h2>
                 <span></span>
               </div>
               <div class="aa-nearby-properties-area">
                 <div class="row">
                   <div class="col-md-6">
                     <article class="aa-properties-item">
                        <a class="aa-properties-item-img" href="#">
                          <img alt="img" src="img/item/1.jpg">
                        </a>
                        <div class="aa-tag for-sale">
                          For Sale
                        </div>
                        <div class="aa-properties-item-content">
                          <div class="aa-properties-info">
                            <span>5 Rooms</span>
                            <span>2 Beds</span>
                            <span>3 Baths</span>
                            <span>1100 SQ FT</span>
                          </div>
                          <div class="aa-properties-about">
                            <h3><a href="#">Appartment Title</a></h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim molestiae vero ducimus quibusdam odit vitae.</p>                      
                          </div>
                          <div class="aa-properties-detial">
                            <span class="aa-price">
                              $35000
                            </span>
                            <a class="aa-secondary-btn" href="#">View Details</a>
                          </div>
                        </div>
                      </article>
                   </div>
                   <div class="col-md-6">
                     <article class="aa-properties-item">
                      <a class="aa-properties-item-img" href="#">
                        <img alt="img" src="img/item/2.jpg">
                      </a>
                      <div class="aa-tag for-sale">
                        For Sale
                      </div>
                      <div class="aa-properties-item-content">
                        <div class="aa-properties-info">
                          <span>5 Rooms</span>
                          <span>2 Beds</span>
                          <span>3 Baths</span>
                          <span>1100 SQ FT</span>
                        </div>
                        <div class="aa-properties-about">
                          <h3><a href="#">Appartment Title</a></h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim molestiae vero ducimus quibusdam odit vitae.</p>                      
                        </div>
                        <div class="aa-properties-detial">
                          <span class="aa-price">
                            $35000
                          </span>
                          <a class="aa-secondary-btn" href="#">View Details</a>
                        </div>
                      </div>
                    </article>
                   </div>
                 </div>
               </div>

             </div>

            </div>           
          </div>
        </div>
        <!-- Start properties sidebar -->
        <div class="col-md-4">
          <aside class="aa-properties-sidebar">
            <!-- Start Single properties sidebar -->
            <div class="aa-properties-single-sidebar">
              <h3>Properties Search</h3>
              <form action="">
                <div class="aa-single-advance-search">
                  <input type="text" placeholder="Type Your Location">
                </div>
                <div class="aa-single-advance-search">
                  <select id="" name="">
                   <option selected="" value="0">Category</option>
                    <option value="1">Flat</option>
                    <option value="2">Land</option>
                    <option value="3">Plot</option>
                    <option value="4">Commercial</option>
                  </select>
                </div>
                <div class="aa-single-advance-search">
                  <select id="" name="">
                    <option selected="" value="0">Type</option>
                    <option value="1">Flat</option>
                    <option value="2">Land</option>
                    <option value="3">Plot</option>
                    <option value="4">Commercial</option>
                  </select>
                </div>
                <div class="aa-single-advance-search">
                  <select id="" name="">
                    <option selected="" value="0">Type</option>
                    <option value="1">Flat</option>
                    <option value="2">Land</option>
                    <option value="3">Plot</option>
                    <option value="4">Commercial</option>
                  </select>
                </div>
                <div class="aa-single-filter-search">
                  <span>AREA (SQ)</span>
                  <span>FROM</span>
                  <span id="skip-value-lower" class="example-val">30.00</span>
                  <span>TO</span>
                  <span id="skip-value-upper" class="example-val">100.00</span>
                  <div id="aa-sqrfeet-range" class="noUi-target noUi-ltr noUi-horizontal noUi-background">
                  </div>                  
                </div>
                <div class="aa-single-filter-search">
                  <span>PRICE ($)</span>
                  <span>FROM</span>
                  <span id="skip-value-lower2" class="example-val">30.00</span>
                  <span>TO</span>
                  <span id="skip-value-upper2" class="example-val">100.00</span>
                  <div id="aa-price-range" class="noUi-target noUi-ltr noUi-horizontal noUi-background">
                  </div>      
                </div>
                <div class="aa-single-advance-search">
                  <input type="submit" value="Search" class="aa-search-btn">
                </div>
              </form>
            </div> 
            <!-- Start Single properties sidebar -->
            <div class="aa-properties-single-sidebar">
              <h3>Popular Properties</h3>
              <div class="media">
                <div class="media-left">
                  <a href="#">
                    <img class="media-object" src="img/item/1.jpg" alt="img">
                  </a>
                </div>
                <div class="media-body">
                  <h4 class="media-heading"><a href="#">This is Title</a></h4>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>                
                  <span>$65000</span>
                </div>              
              </div>
              <div class="media">
                <div class="media-left">
                  <a href="#">
                    <img class="media-object" src="img/item/1.jpg" alt="img">
                  </a>
                </div>
                <div class="media-body">
                  <h4 class="media-heading"><a href="#">This is Title</a></h4>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>                
                  <span>$65000</span>
                </div>              
              </div>
              <div class="media">
                <div class="media-left">
                  <a href="#">
                    <img class="media-object" src="img/item/1.jpg" alt="img">
                  </a>
                </div>
                <div class="media-body">
                  <h4 class="media-heading"><a href="#">This is Title</a></h4>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>                
                  <span>$65000</span>
                </div>              
              </div>
            </div>
          </aside>
        </div>
      </div>
    </div>
  </section>
  <!-- / Properties  -->

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
                <a href="#">Home</a>
                <a href="#">Support</a>
                <a href="#">License</a>
                <a href="#">FAQ</a>
                <a href="#">Privacy & Term</a>
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

  </body>
</html>