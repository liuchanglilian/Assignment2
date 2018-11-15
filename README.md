# Assignment2
Restful APIs for course selection system
 
## Domain:  http://assignment2hw.us-east-2.elasticbeanstalk.com/

### Announcement
1.GET
  webapi/announcements
  webapi/announcements/[boardId_announcementId]
2.POST
  webapi/announcements
  body:
         {
	"announcementId": "131",
	"announcementText": "Christmas holiday!!",
	"boardId": "131"
       }
3.PUT
  webapi/announcements/[boardId_announcementId]
  body:
          
{
    	 
  	   "boardId": "225"

	  
}
4.DELETE
  webapi/announcements/[boardId_announcementId]
### Board
1.GET
  webapi/boards
  webapi/boards/[boardId]
2.POST
  webapi/boards
  body:
          {
   "boardId":"124",
  
              "courseId":"123"
}
3.PUT
  webapi/boards/[boardId]
  body:
       {
   
           "boardId":"124",
 
           "courseId":"998"

       }
4.DELETE
  webapi/boards/[boardId]
### Course
1.GET
  webapi/courses
  webapi/courses/[courseId]
2.POST
  webapi.courses
  body:
  	{
    
	  "boardId": "123",
    
	  "courseId": "129",
      
    "department": "Math",

          "professorId": "123",

          "taId": "123"

         }
3.PUT:
  webapi/courses/[courseId]
  body:
       {
    
	  "boardId": "123",
    
	  "courseId": "129",
      
    "department": "changeIt",

          "professorId": "123",

          "taId": "123"

         }
4.DELETE:
  webapi/courses/[courseId]
### Professor
1.GET
  webapi/professors
  webapi/professors/[professorId]
2.POST
  webapi/professors
  body:
         {
    
	   "department": "Physics",
    
	   "firstName": "Chang",
       
    "joiningDate": "2019",
 
           "professorId": "127"
         
}
3.PUT
  web/professors/[professorId]
  body:
       {
    
	   "department": "Physics",
    
	   "firstName": "Chang",
       
    "joiningDate": "2019",
 
           "professorId": "127"
         
}
4.DELETE
  web/professors/[professorId]
### Student
1.GET
  webapi/students
  webapi/students/[studentId]
2.POST
  webapi/students
   body:
       {
	"studentId": "129",
	"firstName": "Liliana",
	 "lastName": "Liu",
	 "joiningDate": "2018",
	 "department": "Math"
      }
3.PUT
  webapi/students
  body:
      {
	"studentId": "123",
	"firstName": "Liliana",
	 "lastName": "La",
	 "joiningDate": "2018",
	 "department": "Math"
      }
4.DELETE
  webapi/students/[studentId]
