# 3__EurekaAndZuul
### Gateway 轉發關卡
 3-1__Zuul: http://localhost:10000/   
### Eureka 注冊中心
 3-2__Eureka: http://localhost:12345/eureka 
### EurekaClient 各種服務
 3-3-1__FeignClientApplication: http://localhost:8000/get-greeting  
 3-3-2__EurekaClientApplication: http://localhost:8010/greeting  
 3-3-2__EurekaClientApplication-2: http://localhost:8011/greeting
 3-3-3__PostNotesApplication: http://localhost:8020/
 3-3-4__CourseApplication: http://localhost:8030/

http://localhost:10000/feign-client-application/get-greeting

http://localhost:10000/eureka-client-application/greeting

http://localhost:10000/postnotes-application/
 get / 
 get /all 
 get /{id} 
 delete /{id}/delete 
 post /search 
 post /edit 
 post /{id}/life 
 post /line 


http://localhost:10000/course-application/
 get / 
 get /all 
 get /{id} 
 delete /{id}/delete 
 post /search 
 post /edit 

 get /s/ 
 get /s/all 
 get /s/{id} 
 delete /s/{id}/delete 
 post /s/search 
 post /s/edit 
