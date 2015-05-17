
<%@page import="POJOS.Matchmaker"%>
<%@page import="java.util.List"%>
<%@page import="DAO.MatchmakerDAO"%>
<%@page import="DAO.BooksDAO"%>
<%@page import="POJOS.Books"%>
<%@page import="POJOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <%
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
            
        User uai = (User)session.getAttribute("user");
        String name = uai.getName();     
        int userID = uai.getId();

        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile: <%= name %></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css\bootstrap\css\bootstrap.css" media="screen">
        <style>
        .coursesContInt{
          float:left;
          height: 40%; /* or whatever you want */
          position:relative;
          width: 100%; /* or whatever you want */
        }
        .coursesCont{
          float:left;
          height: 50%; /* or whatever you want */
          position:relative;
          width: 80%; /* or whatever you want */
          margin-left: 10%;
        }
        </style>
    </head>
    
    <body>
                <!-- _____Navbar ____-->
        
    <header class="navbar navbar-default navbar-static-top" role="banner">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="index.html" class="navbar-brand">BookDonate</a>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li>
              <a href="BooksIndex.jsp">Books Index</a>
            </li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="MainLanding.jsp"><%= name%></a>
            </li>
            </ul>
        </nav>
      </div>
    </header>
        <!-- _____Navbar ____-->        
    
    <center><h2 style = "color:#7D7D7D; text-shadow: 1px 1px #2953CF;"> Welcome, <%= name%> </h2></center>
     <hr class="featurette-divider">
    <div class="container">
    <div class="row">
        
        <!-- Edit Profile -->
        
        <%
            
        %>
        
        <div class="col-md-3" >
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Your Profile Tag</h3></center>
            
            <div class="thumbnail" style="cursor: pointer;">
               <!-- Get Profile Pic Image.-->      
              <img src="Images\\def-ava.png" height = "250" width = "175" alt="No image">
              <div class="caption">
                  <center>
                   <h3><%=uai.getName()%></h3>
                   <p>City : <%=uai.getCity()%></p>
                   <p>Country : <%=uai.getCountry()%></p>
                   <p>Address : <%=uai.getAddress()%></p>
                   <p>Email : <%=uai.getEmail()%></p>
                  </center>                     
              </div>
            </div>
        </div>
        <%
            MatchmakerDAO mDAO = new MatchmakerDAO();
            BooksDAO bDAO = new BooksDAO();
            List<Matchmaker> mm = mDAO.ShowEntriesToUser(uai);
            
        %>
        
        <div class="col-md-7" style="padding-right:20px;">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Matchmaking Queue</h3></center>
        <div class="coursesCont">
        <%
            for(Matchmaker entry: mm){
                
            %>
                
          <div class="thumbnail crse" id="<%=entry.getMatchmakerId()%>" style="cursor: pointer;">
               <!-- Get Course Image.-->      
              <img src="Images/def-ava.png" height = "250" width = "175" alt="No image">
              <div class="caption">
                   <h3>Entry by: <%=entry.getUser().getName()%> </h3>
                   <p>Book Name:</p>
                   <p>Description :</p>
                    <!-- get Company University Name-->      
                   <a href="#">Go to Book Page >></a></br>
    
              </div>
          </div>
            <%
                    }
            %>
          
        </div>    
        

            
            
        </div>

        

        
        <div class="col-md-2">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Badges</h3></center>
            <div class="thumbnail" style="cursor: pointer;">
               <!-- Get Profile Pic Image.-->      
              <img src="Images/medal.png" height = "250" width = "175" alt="No image">
              <div class="caption">
                  <div class="caption">
                  <center>
                  
                   <p>Donater: </p>
                   <p>Serial Donater : </p>
                  
                  </center>  
                      </div>
              </div>
            </div>
        </div>
        </div>
        </div>
       
        <script type='text/javascript' src="js/jquery.min.js"></script>
        <script type='text/javascript' src="css/bootstrap/js/bootstrap.js"></script>
        <script type='text/javascript'>
        
        $(document).ready(function() {
            
        $('.crse').click(ajaxCall);
        
        function ajaxCall(){
         $.post("BookInfoServlet",
              {
                ids:"1"

              },
              function(data,status){
              });
           
              }
              
        $( "#target" ).click(function() {
         alert( "Click to view Book Info" );
        });
        
        
        
        });
        
        
        
        </script>        
        
    </body>
</html>
