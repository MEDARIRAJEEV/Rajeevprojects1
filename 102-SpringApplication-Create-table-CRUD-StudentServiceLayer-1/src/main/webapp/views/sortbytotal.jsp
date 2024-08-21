<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<table border="1">
    <tr>
        <th>ROLL_NUMBER</th>
        <th>NAME</th>
        <th>COURSE</th>
        <th>HIBERNATE</th>
        <th>SPRING</th>
        <th>SPRING_BOOT</th>
        <th>TOTAL</th>
        <th>PERCENTAGE</th>
        <th>RESULT</th>
        <th>GRADE</th>
        <th>UPDATE</th>
        <TH>DELETE</TH>
    </tr>
    <c:forEach var="student" items="${s}">
        <tr>
            <td>${student.rollnumber}</td>
            <td>${student.name}</td>
            <td>${student.course}</td>
            <td>${student.hibernate}</td>
            <td>${student.spring}</td>
            <td>${student.springboot}</td>
            <td>${student.total}</td>
            <td>${student.percentage}</td>
            <td>${student.result}</td>
            <td>${student.grade}</td>
            <TD>
                <A href="/update/${student.rollnumber}">update</A>
            </TD>
            <TD>
                <A href="/delete/${student.rollnumber}">delete</A>
            </TD>

        </tr>
    </c:forEach>
</table>