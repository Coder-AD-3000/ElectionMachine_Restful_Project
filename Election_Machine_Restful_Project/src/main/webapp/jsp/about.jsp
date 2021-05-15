
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>About</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>     
   
</head>
<body>

   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <a href="../jsp/index.jsp"><i class="material-icons resize1">account_balance</i></a>
        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
        <h2>About</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Introductory statement about the candidates page -->
        <h5>This section covers the team of the 'Global Herald Newspaper' as well as
            the server programming team over at 'HAMK's Finest.'
            <br><br>
            Have a quick read to find out more
            about each team member. In particular, you can find out what aspects of the
            project each team member was primarily responsible for.
        </h5>
        </div>

        <!-- AD - This container customises the heading to the candidate overviews-->
        <div class="container7">
        <h3>Here, let's let the project participants introduce themselves:</h3>
        </div>
    
        <hr>   

        <!-- AD - Team intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>The Product Owner:
                <br><br>
            	<i class = "customAboutHeading">The Global Herald Newspaper ("Global News for a Global Era")</i>
                <br><br>
                <hr>
                <br>
                Overview: During this project, we are the (imaginary) 'Global Herald Newspaper' team! 
                We don't actually exist, yet with this scenario, we are the Newspaper that is supposedly
                running this Election Machine. Our aim is to help election voters get matched with the
                right candidate for them!
                <br><br>
                In order to create this Election Machine, we 'hired' the HAMK's Finest server programming team.
                This team is comprised of student server programmers from Hame University of 
                Applied Sciences, and they created this Election Machine using Java server-side programming.         
                <br><br>
                Read on to meet the server programming team!
            </h5>
        </div>

        <!-- AD - Team member 1 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the project participant -->            
            <h5>(HAMK's Finest) Team member 1:
                <br><br>
                <i class = "customAboutHeading">Ashley Davis (Project Manager)</i>
                <br><br>
                <hr>
                <br>
                Overview: There is no rest in RESTful web services, but it was fun!
                <br><br>
                For most of our team, JPA and RESTful web services were completely 
                new topics to get to grips with. Nevertheless, with a bit of <i>persistence</i> 
                (get it?) and determination, the team worked hard, and things fell into place. 
                During this project, my main contributions were towards creating the
                candidate CRUD system, team management, programming the profile page UI 
                and other UI aspects, as well as creating some of the JavaScript 'dynamic' 
                functionality. Our team worked very well together, despite the project challenges, 
                and it was a real pleasure to be part of such an interesting project 
                and motivated team.
            </h5>   
        </div>

        <!-- AD - Team member 2 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the project participant -->            
             <h5>(HAMK's Finest) Team member 2:
                <br><br>
                <i class = "customAboutHeading">Daniel Kovacs (Server Programmer)</i>
                <br><br>
                <hr>
                <br>
                Overview: A complex task, yet very engaging.
                <br><br>
                Initially, the team had to work hard to absorb a lot of new information. 
                Only then, were we able to formulate, implement and execute a complex 
                programming strategy. Once our research and learning phase was over, 
                however, the team pulled through to produce a nicely, executed finished 
                project. My main contributions to the project, revolved around programming
                the profile page back-end functionality, questionnaire functionality, as well as
                JavaScript and algorithm creation. In addition, 
                I ensured that various disparate project components, were correctly brought 
                together for a smooth overall project execution.
            </h5> 
        </div>

        <!-- AD - Team member 3 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the project participant -->            
              <h5>(HAMK's Finest) Team member 3:
                <br><br>
                <i class = "customAboutHeading">Lorand Heidrich (Server Programmer)</i>
                <br><br>
                <hr>
                <br>
                Overview: Whilst challenging, this project was rewarding in the end!
                <br><br>
                I learned a lot from this project. JPA and RESTful Web Services are 
                certainly challenging at first, but rewarding in the end. 
                I'm sure the database management skills I have acquired 
                will come in handy in my future endeavours. 
                My main contributions to the Election Machine project were 
                revolved around creating the Employee CRUD system, as well as 
                creating some of the JavaScript and UI aspects of the project. In addition,
                I assisted with some of the project planning tasks.                
            </h5>             
        </div>

        <!-- AD - Team member 4 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the project participant -->
            <h5>(HAMK's Finest) Team member 4:
                <br><br>
                <i class = "customAboutHeading">Evangelos Kaikas (Server Programmer)</i>
                <br><br>
                <hr>
                <br>
                Overview: It was hard work, but we are very pleased with the end result.
                <br><br>
                This task was certainly a very ambitious project. Especially, in that the 
                complex task had to be completed within a relatively short period of time. 
                Nevertheless, despite the monumental task at hand, our team learned a lot 
                and we had a lot of fun during this server programming marathon. 
                As a member of the team, my main areas of responsibility revolved around 
                creating the New Question CRUD system, as well as assisting with the creation
                of some of the JavaScript 'dynamic' functionality for the buttons.
                Furthermore, I was responsible for the research and implementation of 
                MySQL foreign keys into the project.
            </h5>
        </div>

        <!-- End ot the candidate intro / overview section-->
        <hr>

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container5">            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>            
            </div>		    
            <hr>      
    
            <!-- AD - button container, containing buttons-->
            <div class="container3">
           
                <button class="button-main button1"><a href="../jsp/index.jsp"><b>Home</b></a></button>
                
                <button class="button-main button1" onclick="window.location.href='/readallquestion'"><b>Take Quiz</b></button>               

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>

    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->