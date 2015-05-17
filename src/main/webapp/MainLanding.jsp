
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
            <h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Your Profile Tag</h3>
            
            <div class="thumbnail" style="cursor: pointer;">
               <!-- Get Profile Pic Image.-->      
              <img src="Images\\def-ava.png" height = "250" width = "175" alt="No image">
              <div class="caption">
                  <center>
                   <h3><%=uai.getName()%></h3>
                   <p>City : 

                   </p>
                   <p>Country : </p>
                   <p>Address : </p>     
                  </center>                     
              </div>
            </div>
        </div>
        <%
            MatchmakerDAO mDAO = new MatchmakerDAO();
            BooksDAO bDAO = new BooksDAO();
            List<Matchmaker> mm = mDAO.ShowEntriesToUser(uai);
            
        %>
        
        <div class="col-md-6" style="padding-right:20px; border-right: 1px solid #ccc;border-left: 1px solid #ccc;">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Your Transactions</h3></center>
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

        

        
        <div class="col-md-3">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Book Highlights</h3></center>
    
            <%
            List<Books> bks = bDAO.FindAllBooks();
            %>
            
        <div class="coursesContInt">
            <%
                for(Books i: bks){
                    
                
            %>
                
         <div class="pull-right" style="padding-left:20px;padding-top: 20px;">
         <div class="thumbnail" id="target" style="cursor: pointer;" >
            
         <div class="caption">
           <h3><%=i.getBookName()%></h3>
           <hr class="featurette-divider">
           <p><%=i.getBookDescription()%></p>
          
         </div>
          </div>
             
         </div>
         <%
                }
                    %>
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
