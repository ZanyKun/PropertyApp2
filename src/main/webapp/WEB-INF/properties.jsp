<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="acres.dto.UserInfo, acres.dto.BuildingInfo"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Home Property | Properties</title>

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
			                	"<a href='/users/logout' class='aa-login'>Logout</a></div>"); 
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
            <li><a href="welcome">HOME</a></li>
             <li class="dropdown active">
              <a class="dropdown-toggle" data-toggle="dropdown" href="properties.html">PROPERTIES <span class="caret"></span></a>
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
            <h2>Properties Page</h2>
            <ol class="breadcrumb">
            <li><a href="#">HOME</a></li>            
            <li class="active">PROPERTIES</li>
          </ol>
          </div>
        </div>
      </div>
    </div>
  </section> 
  <!-- End Proerty header  -->

  <!-- Start Properties  -->
  <section id="aa-properties">
    <div class="container">
      <div class="row">
        <div class="col-md-8">
          <div class="aa-properties-content">
            <!-- start properties content head -->
            <div class="aa-properties-content-head">              
              <div class="aa-properties-content-head-right">
                <label style="font-size: 14px">Change the Layout </label>
                <a id="aa-grid-properties" href="#"><span class="fa fa-th"></span></a>
                <a id="aa-list-properties" href="#"><span class="fa fa-list"></span></a>
              </div>            
            </div>
            <!-- Start properties content body -->
            <div class="aa-properties-content-body">
              ${noBuildings}
              <ul class="aa-properties-nav">
              <core:forEach var="buildings" items="${buildings}">
              	<li>
                  <article class="aa-properties-item">
                    <a class="aa-properties-item-img" href="#">
                      <img alt="img" src="img/item/6.jpg"> <!--Image associated with Property-->
                    </a>
                    <div class="aa-tag for-rent">
                      For ${buildings.propertyList}
                    </div>
                    <div class="aa-properties-item-content">
                      <div class="aa-properties-info">
                        <span>
                        <core:choose>
	                        <core:when test="${buildings.roomNum.equals('None')}">
	                        	<core:out value="No Rooms"></core:out>
	                        </core:when>
	                        <core:when test="${buildings.roomNum.equals('1')}">
	                        	<core:out value="${buildings.roomNum} Room"></core:out>
	                        </core:when>
	                        <core:otherwise>
	                        	<core:out value="${buildings.roomNum} Rooms"></core:out>
	                        </core:otherwise>
                        </core:choose>
                        </span>
                        <span>
                        <core:choose>
                        	<core:when test="${buildings.washroomNum.equals('None')}">
                        		<core:out value="No Washroom"></core:out>
                        	</core:when>
                        	<core:when test="${buildings.washroomNum.equals('Shared')}">
                        		<core:out value="Shared Washroom"></core:out>
                        	</core:when>
                        	<core:when test="${buildings.washroomNum.equals('1')}">
                        		<core:out value="1 Washroom"></core:out>
                        	</core:when>
                        	<core:otherwise>
                        		<core:out value="${buildings.washroomNum} Washrooms"></core:out>
                        	</core:otherwise>
                        </core:choose>
                        </span>
                        <span>${buildings.plotArea} sq. ft</span>
                      </div>
                      <div class="aa-properties-about">
                        <h3><a href="#">${buildings.projectName}</a></h3>
                        <p>${buildings.description}</p>                      
                      </div>
                      <div class="aa-properties-detial">
                      	<span class="aa-price">
							<core:choose>
								<core:when test="${buildings.propertyType.equals('Commercial')}">
								<core:choose>
									<core:when test="${buildings.comBuildingType.equals('Office')}">
										<core:out value="${buildings.officeType}"></core:out>
									</core:when>
									<core:when test="${buildings.comBuildingType.equals('Retail')}">
										<core:out value="${buildings.retailType}"></core:out>
									</core:when>
									<core:when test="${buildings.comBuildingType.equals('Land')}">
										<core:out value="${buildings.landType}"></core:out>
									</core:when>
									<core:when test="${buildings.comBuildingType.equals('Storage')}">
										<core:out value="${buildings.storageType}"></core:out>
									</core:when>
									<core:when test="${buildings.comBuildingType.equals('Hospitality')}">
										<core:out value="${buildings.hospitalityType}"></core:out>
									</core:when>
									<core:otherwise>
										<core:out value="${buildings.comBuildingType}"></core:out>
									</core:otherwise>
								</core:choose>
								</core:when>
								<core:when test="${buildings.propertyType.equals('Residential')}">
									<core:choose>
									<core:when test="${buildings.reBuildingType.equals('Apartment')}">
										<core:out value="${buildings.apartmentType}"></core:out>
									</core:when>
									<core:when test="${buildings.reBuildingType.equals('Independent House / Villa')}">
										<core:out value="${buildings.houseType}"></core:out>
									</core:when>
									<core:otherwise>
										<core:out value="${buildings.reBuildingType}"></core:out>
									</core:otherwise>
									</core:choose>
								</core:when>
							</core:choose>
							<core:out value=" | ${buildings.propertyType}"></core:out>
                       </span>
                      </div>
                      <div class="aa-properties-detial">
                        <span class="aa-price">
                          <core:choose>
                          	<core:when test="${buildings.expectedRent != 0}">
                          		<core:out value="$ ${buildings.expectedRent}/month"></core:out>
                          	</core:when> 
                          	<core:when test="${buildings.expectedPrice != 0}">
                          		<core:out value="$ ${buildings.expectedPrice}"></core:out>
                          	</core:when>
                          </core:choose>
                       </span>
                          <spring:form action="/properties/{buildingId}" method="get">
                          	<input type="hidden" name="buildingId" value="${buildings.buildingId}"/>
                          	<input type="submit" class="aa-secondary-btn" value="View Details"/>
                          </spring:form>
                      </div>
                    </div>
                  </article>
                </li>
              </core:forEach>
              </ul>
            </div>
            <!-- Start properties content bottom -->
            <div class="aa-properties-content-bottom">
              <nav>
                <ul class="pagination">
                  <li>
                    <a href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <li  class="active"><a href="">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                  <li>
                    <a href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
        <!-- Start properties sidebar -->
        <div class="col-md-4">
          <aside class="aa-properties-sidebar">
            <!-- Start Single properties sidebar -->
            <div class="aa-properties-single-sidebar">
              <h3>Properties Search</h3>
              <form action="advance_search.test" method="post">
                <div class="aa-single-advance-search">
                  <input type="text" placeholder="Enter City">
                </div>
                <div class="aa-single-advance-search">
                	<select name="state" required>
              			<option>State</option>
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
					</select>
                </div>
                <div class="aa-single-advance-search">
                  <select name="propertyType">
                   <option value="0" selected>Category</option>
                    <option value="1">Residential</option>
                    <option value="2">Commercial</option>
                  </select>
                </div>
                <div class="aa-single-advance-search">
                  <select name="buildingType">
                    <option value="0" selected>Building Type</option>
                    <optgroup label="Residential Listings">
                    	<option value="Studio Apartment">Studio Apartment</option>
                    	<option value="Residential Apartment">Residential Apartment</option>
                    	<option value="Serviced Apartment">Serviced Apartment</option>
                    	<option value="Independent Apartment">Independent Apartment</option>
                    	<option value="Residential Land">Residential Land</option>
                    	<option value="Independent House">Independent House</option>
                    	<option value="Farm House">Farm House</option>
                    </optgroup>
                    <optgroup label="Commercial Listings">
                    	<option value="Commercial Office">Commercial Office</option>
                    	<option value="Office in IT Park">Office in IT Park</option>
                    	<option value="Office in Business Par">Office in Business Park</option>
                    	<option value="Business Center">Business Center</option>
                    	<option value="Time Share">Time Share Office</option>
                    	<option value="Commercial Shop">Commercial Shop</option>
                    	<option value="Commercial Showroom">Commercial Showroom</option>
                    	<option value="Space in Retail Mall">Space in Retail Mall</option>
                    	<option value="Commercial Land">Commercial Land</option>
                    	<option value="Agricultural Land">Agricultural Land</option>
                    	<option value="Industrial Land">Industrial Land</option>
                    	<option value="Warehouse">Warehouse Storage</option>
                    	<option value="Cold">Cold Storage</option>
                    	<option value="Hotel/Resorts">Hotel/Resorts</option>
                    	<option value="Guesthouse/Banquet Halls">Guesthouse/Banquet Halls</option>
                    </optgroup>
                  </select>
                </div>
                <div class="aa-single-advance-search">
                  <select name="listingType">
                    <option value="0" selected>Listing</option>
                    <option value="Sale">Sale</option>
                    <option value="Rent">Rent</option>
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

  </body>
</html>