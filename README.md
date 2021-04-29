# Lucky Draw Service
  Lucky Draw Service is a Java Spring Boot Backend Application which allows users 
  to get Lucky Draw Raffle tickets and use one lucky draw raffle ticket to participate in a lucky draw event.

# Setup
  Any Java IDE(Eclipse,IntelliJ) will work fine for this application and we should have Postgresql 
  as it is used as databse

# Algorithm
  Using Math.random function on array index of participant's list of a lucky draw event to find winner.

# Structure
 Backend is made using Java Spring Boot framework(with JPA)
 
    1 - Controller - There are 3 controllers - 
      a) UserController - Assigns requests to service layer for saving new user, getting user/s etc.
      b) EventController - Assigns requests to service layer for saving new event, getting event/s etc.
      c) LuckyDrawController - Assigns requests to service layer for assigning raffle ticket, making user participate, calculate winner etc.
    
    2 - DTO's(Data Transfer Objects) - 
      a) - There is a DTO for response of NextEventTimingAndPrize API.
      b) - There is another DTO for response of WinnersOfPastWeek API.
      
    3 - Repository - There are 2 repositories for interaction with database - 
    
        a) - EventRepository   b) - UserRepository
        
    4 - Models - There are 2 models classes for Event and User respectively.
    
    5 - Service - There are 3 service for
        a) EventService - This service provides methods for saving new event, getting event/s etc.
        b) UserService - This service provides methods for saving new user, getting user/s etc.
        c) LuckyDrawService - This service provides methods for assigning raffle ticket, making user participate in an event, calculate winner etc.
        
# Corner-Case
 Once a user has participated with a raffle ticket, he/she shouldn’t be able to participate again in the same event.
  
# Thanks
  

      
 


