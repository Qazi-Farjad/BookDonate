<%-- 
    Document   : BooksIndex
    Created on : May 17, 2015, 8:46:39 AM
    Author     : Farjad
--%>

<%@page import="java.util.List"%>
<%@page import="POJOS.Books"%>
<%@page import="DAO.BooksDAO"%>
<%@page import="POJOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        String user = null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
            
        User uai = (User)session.getAttribute("user");
        String name = uai.getName();
        BooksDAO db = new BooksDAO();
        List<Books> BookList = db.FindAllBooks();
        
        %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css\bootstrap\css\bootstrap.css" media="screen">
        <title>Book Index</title>
        <style>
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
          <a href="index.html" class="navbar-brand">Book Donate</a>
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
    
    
        <h1 style="text-align:center; color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Books</h1>
        
        <div class="col-md-8 col-md-offset-2" style="padding-right:20px; border-right: 1px solid #ccc;border-left: 1px solid #ccc;">
            <div class="coursesCont">
            <%
                for(Books bk: BookList){


                %>

              <div class="thumbnail" id="target_5" style="cursor: pointer;">
                   <!-- Get Course Image.-->      
                  <img src="<% if(bk.getBookImage()!= null){
                       out.print(bk.getBookImage());
                        }
                       else{
                           out.print("Images/def-ava.png");
                       }
                       %>
                          " height = "250" width = "175" alt="No image">
                  <div class="caption">
                      <center>
                       <h3><%=bk.getBookName()%></h3>
                       <p>Author : <%=bk.getAuthor()%></p>
                      </center>
                       
                       <p>Description :<%=bk.getBookDescription()%></p>
                        <!-- get Company University Name-->      
                       <p>Class : <%=bk.getClass_()%></p>
                       <p>Board: <%=bk.getBoard()%></p>

                       <center>
                       <form action="MatchmakingServlet">
                          <input type="hidden"  name="Bookid" value="<%=(int)bk.getBookId()%>">
                          <input type="radio" name="donReq" value="Donate"> Donate <br/>
                          <input type="radio" name="donReq" value="Request"> Request <br/>
                          <input type="submit" class ="btn btn-lg btn-primary" value="Apply for matchmaking">
                          
                       </form>
                       </center>
                  </div>
              </div>
                <%
                }
                %>

            </div>       
        </div>
            
    <!-- ______________________________ -->
    

    
    <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>
    <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
    <script>
    $(document).ready(function() {
        $( ".coursesCont" ).click(function() {
            var id = $(this).Bookid;
            var donReq = $(this).donReq;
            $.post("MatchmakingServlet",
              {
                ids:id
                don:donReq
              },
              function(data,status){
              });
        });
            

        
        });
        
    </script>
    </body>
</html>
