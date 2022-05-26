<%@ include file="WEB-INF/header.jsp" %>

<body style="background-image: url(resources/img/bg-1.jpg);">
    <nav class="navbar flex-column   shadow navbar-light navbar-expand-sm ">
        <div class="w-100 d-flex flex-row">
            <a class="navbar-brand p-0" href="/jee"><img height="60" src="resources/img/logo.PNG" alt=""></a>

            <div class="navbar-nav float-left flex-grow-1 mr-auto mt-2 mt-lg-0">
                <ul class="navbar-nav  mr-auto mt-3 ">
                    <li class="nav-item"><a class="nav-link" href="#">Pupler</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">New Places</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Renken</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">today</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">about</a></li>
                </ul>
                
            </div>

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
        <div class="d-block w-100">
           
       
        </div>
    </nav>
    <main class="container">
        <div class="row mt-5" style="justify-content: center;">
            <div class="col-4 "  >
                <form method="POST" action="traject"  class="card-search shadow my-2  my-lg-0">
                    <div class="text-center">
                        <h1>Log in</h1>
                        <hr />
                    </div>
                    <label for="">User Name</label>
                     <div class="input-city" >
                         <input  autocomplete="off" name="username" class="form-control " type="text" placeholder="Username">     
                    </div>
                    
                    <br >
                    <br >
                    
                    <label for="">Password</label>
                    <div class="input-city" >
                         <input  autocomplete="off" name="target" class="form-control mr-sm-2" type="password" placeholder="password">
                         
                    </div>
                    <button class="btn mt-3 btn-success btn-block" type="submit">Log In</button>
                </form>
            </div>

        </div>

    </main>
    
<%@ include file="WEB-INF/footer.jsp" %>