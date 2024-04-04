<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="user_header.jsp" />
<div class="w-[1200px] my-10 mx-auto">
    <div class="mb-5">
        <h2 class="text-4xl font-semibold mb-3">Course Name : ${courseName}</h2>
        <h2 class="text-2xl font-medium mb-3">Course Teacher Name : ${courseTeacher}</h2>
        <h2 class="text-2xl font-medium">Total Enrolled Students : ${enrolledStudents.size()}</h2>
    </div>
    <div class="grid grid-cols-4 gap-5">
        <c:if test="${enrolledStudents.size() < 1}">
            <h2 class="text-3xl font-semibold">No Students Enrolled.</h2>
        </c:if>
        <c:if test="${enrolledStudents.size() > 0}">
            <table class="table-fixed w-[600px] border-2 border-yellow border-collapse text-center">
                <thead>
                    <tr>
                        <th class="border-2 border-yellow w-[300px]">Name</th>
                        <th class="border-2 border-yellow w-[300px]">Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${enrolledStudents}" var="students">
                        <tr>
                            <td class="border-2 border-yellow w-[300px]">${students.name}</td>
                            <td class="border-2 border-yellow w-[300px]">${students.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<jsp:include page="user_footer.jsp" />
