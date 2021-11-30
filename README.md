# Team3BlackjackProject
For application setup & proper running please follow the steps in order
1) Setup the sql database for login & player informatino
  a) With xampp in our case hosting the sql navigate into the bin & use the student_space database using your login
  a) Access the database & clear out existing versions of user & any dependencies tied to it
 b) Run the TeamProjectSQL.sql file using source to setup our table to be used
    b1) should setup 1 table, user with username,password, wins,losses
    
2) Drag the batfiles for the project to the file directory above the package, w/in the project, but up a level from the .java & .class files  
3) Launch the server for the game through the provided bat file.
  a) Will need to enter port
  b) Enter timout time
  c) Select the number of intended players in the game
  d) Click listen
4) Lauch a client through the provided bat file
  a) You will need to first click ip config on the initial screen
    a1) Enter the ip of the server (may need to run ipconfig on host pc to view ip)
    a2) Enter the port that was provided server side (default 8300)
5) Click connect to start connection to server
6) Create an account if needed or login
7) From there the game may be accessed, player info viewed,rules viewed or application exit'd
8) On hitting start to enter the game itself,
  a) play must be hit first to initialize the game itself
  b) From there play blackjack as normal using hit to take another card, busting if u pass 21 and stand ending your turn calculating total to see if you beat the dealer determining win or lose
9) You them must quit & start again if you want to play another match.
