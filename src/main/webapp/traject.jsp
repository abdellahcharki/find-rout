<%@ include file="WEB-INF/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.Node" %>
 
<%

	String source =(String) request.getAttribute("source");
	String target =(String) request.getAttribute("target");
	
	ArrayList<Node> cities = (ArrayList<Node>) request.getAttribute("routes"); 

%>

<body>
    <nav class="navbar flex-column py-2 shadow navbar-light navbar-expand-sm ">
        <div class="w-100 d-flex flex-row">
            <a class="navbar-brand p-0" href="/jee"><img height="60" src="resources/img/logo.PNG" alt=""></a>
          <ul class="navbar-nav float-left mr-auto mt-2 mt-lg-0">
                <li class="nav-item"><a class="nav-link" href="#">Pupler</a></li>
                <li class="nav-item"><a class="nav-link" href="#">New Places</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Renken</a></li>
                <li class="nav-item"><a class="nav-link" href="#">today</a></li>
                <li class="nav-item"><a class="nav-link" href="#">about</a></li>
            </ul>

            <div class="collapse flex-grow-0 navbar-collapse" id="collapsibleNavId">
         
                <div class="d-flex">
                    <div class="dropdown">
                        <button class="btn mr-1 profile-btn  " type="button" id="triggerId" data-toggle="dropdown"  >  Account <i class="fas fa-user    "></i></button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                            <a class="dropdown-item" href="#">log in</a>
                            <a class="dropdown-item" href="#">regster</a>
                        </div>
                    </div>
        
                </div>
         
            </div>
        </div>
        <div style="justify-content: space-between;" class="d-flex  w-100">
  
      		
      		<h4 class="px-3 d-inline-block" ></h4>
                  
            <form method="get" action="traject" class="f-city" class="form-inline flex-grow-1 float-right my-2 my-lg-0">
                  
                
                   <div class="input-city" >
                         <input  autocomplete="off" name="source" value="${source}" class="form-control " type="text" placeholder="Depart">
                         <ul class="shadow proposition"></ul>
                    </div>
                    
                <span class=" text-dark p-2">to</span>
                 <div class="input-city" >
                         <input  autocomplete="off" name="target" value="${target}"  class="form-control " type="text"  placeholder="Ariver">
                         <ul class="shadow proposition"></ul>
                    </div>
                <button class="btn ml-2 btn-success my-2 px-4 my-sm-0" type="submit">find <i class="fas fa-long-arrow-alt-right    "></i></button>
            </form>
        </div>
    </nav>
 
    <main>
        <div class="traject pt-3">
            <h3> <i class="fas fa-map-marked-alt    "></i> Votre Traject   <span class="float-right"> <%= source %> <i class="fas fa-long-arrow-right"></i>  <%= target %></span></h3>
            <ul>
            <% for(Node c:cities){ %>
                <%
                	
                %>
               <% if(c.parent()!=null){ %>
                	<li class="my-2   small"><strong><%= c.d() %> Km</strong>  par la route <strong> NO.  <%= c.getRout().getId() %></strong>   <span class="float-right  "> <%= c.getRout().time() %> </span> </li>
                <%}%>
                <li class=""><%= c.getName() %></li>
                
             <% } %>
            </ul>
        </div>
    </main>
    
    

<%@ include file="WEB-INF/footer.jsp" %>