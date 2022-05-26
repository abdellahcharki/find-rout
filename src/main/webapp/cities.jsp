<%@ include file="WEB-INF/header.jsp" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import="models.City" %>
 
  
<%@ page import="models.Rout" %>
 
<%





ArrayList<City> list = (ArrayList<City>) request.getAttribute("cities");

ArrayList<Rout> routs = (ArrayList<Rout>) request.getAttribute("routs");
%>

    <nav class="navbar flex-column py-2 shadow navbar-light navbar-expand-sm ">
        <div class="w-100 d-flex flex-row">
            <a class="navbar-brand p-0" href="/jee"><img height="60" src="resources/img/logo.PNG" alt=""></a>

            <div class="navbar-nav float-left flex-grow-1 mr-auto mt-2 mt-lg-0">
              
                
            </div>

            <div class="collapse flex-grow-0 navbar-collapse" id="collapsibleNavId">
         
                <div class="d-flex">
 
                    <div class="dropdown">
                        <button class="btn mr-1 btn-outline-dark " type="button" id="triggerId" data-toggle="dropdown"  > <i class="fas fa-language"></i> Francais</button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                            <a class="dropdown-item" href="#">Arabic</a>
                            <a class="dropdown-item" href="#">Francais</a>
                            <a class="dropdown-item" href="#">German</a>
                            <a class="dropdown-item" href="#">Englisch</a>
                        </div>
                    </div>

                    <div class="dropdown">
                        <button class="btn mr-1 btn-outline-dark " type="button" id="triggerId" data-toggle="dropdown"  > <i class="fas fa-gas-pump    "></i> Gast</button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                            <a class="dropdown-item" href="#">log in</a>
                            <a class="dropdown-item" href="#">regster</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">After divider action</a>
                        </div>
                    </div>
        
                </div>
         
            </div>
        </div>
        <div class="d-block w-100">
            <ul class="navbar-nav float-left mr-auto mt-2 mt-lg-0">
                <li class="nav-item"><a class="nav-link" href="#">Pupler</a></li>
                <li class="nav-item"><a class="nav-link" href="#">New Places</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Renken</a></li>
                <li class="nav-item"><a class="nav-link" href="#">today</a></li>
                <li class="nav-item"><a class="nav-link" href="#">about</a></li>
            </ul>
            <form method="get" action="traject" class="form-inline float-right my-2 my-lg-0">
                <input name="from" value="${from}" class="form-control " type="text" placeholder="Depart">
                <span class=" text-dark p-2">to</span>
                <input type="hidden" value="self" name="self" >
                <input name="to" value="${to}" class="form-control mr-sm-2" type="text" placeholder="Ariver">
                <button class="btn btn-success my-2 px-4 my-sm-0" type="submit">find <i class="fas fa-long-arrow-alt-right    "></i></button>
            </form>
        </div>
    </nav>

    <main>
    	<div class="container-fluid">
    		<div class="row">
    			<div class="col-6">
		           <div class="traject px-1 pt-3">
		            <h3> Tout Les Villess</h3>
		            <ul>
		            <% for(City c:list){ %>
		                <li><a href="#"><%= c.getId() %> - <%= c.getName() %></a></li>
		           <% } %>
		            </ul>
		        </div>
    			</div>
    			
    			
    			  <div class="col-6">
		           <div class="traject px-1 pt-3">
		            <h3> Tout Les Routes</h3>
		            <ul>
		            <% for(Rout rout:routs){ %>
		                <li><a href="#"><%= rout.getId()%>  <%= rout.getName() %> (<%= rout.getDistance() %> Km)</a></li>
		           <% } %>
		            </ul>
		        </div>
    			</div>
    			
    			
    		</div>
    	</div>
    </main>
    
    

<%@ include file="WEB-INF/footer.jsp" %>