
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <body bgcolor="pink">
        <h1>Edit STDUENT Details Here</h1>  
       <form:form method="GET" action="/editandsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden path="rollnumber" /></td>  
         </tr>  
         <tr>    
            <td>Name :</td>    
            <td><form:input path="name" /></td>  
           </tr>  
         <tr>    
          <td>Course : </td>   
          <td><form:input path="course"  /></td>  
         </tr>  
         <tr>    
          <td>Hibernate :</td>    
          <td><form:input path="hibernate" /></td>  
         </tr> 
         <tr>    
            <td>Spring :</td>    
            <td><form:input path="spring" /></td>  
           </tr>  
           <tr>    
            <td>Spring Boot :</td>    
            <td><form:input path="springboot" /></td>  
           </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="EditSave" /></td>    
         </tr>    
        </table>    
       </form:form>  
      
       </body>
