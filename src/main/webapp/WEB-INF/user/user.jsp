<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="user_header.jsp" />
<div class="w-[1200px] my-10 mx-auto">
    <c:set var = "role" scope="session" value="<%= session.getAttribute(\"role\") %>" />
    <c:set var = "admin" scope="session" value="admin" />
    <c:set var = "teacher" scope="session" value="teacher" />
    <c:set var = "student" scope="session" value="student" />

    <c:if test = "${role == admin}">
        <div class="flex justify-end mb-6 mr-10">
            <a href="/add-course"><button class="px-6 py-3 rounded-full bg-blue hover:underline">Add New Course</button></a>
        </div>
    </c:if>
    <c:if test = "${role == student}">
        <div class="flex justify-end mb-6 mr-10">
            <a href="/dashboard/registered-course"><button class="px-6 py-3 rounded-full bg-blue hover:underline">Registered Course</button></a>
        </div>
    </c:if>
    <div class="grid grid-cols-4 gap-5">
        <c:if test="${courseList.size() < 1}">
            <h2 class="text-3xl font-semibold">No Courses Available.</h2>
        </c:if>
        <c:forEach items="${courseList}" var="course">
            <a href="/course/${course.courseId}" class="w-[240px] p-4 border-2 border-yellow hover:bg-yellow transition-all duration-300">
                <h2 class="text-3xl font-semibold">${course.courseName}</h2>
                <h2 class="text-base py-2 italic">${course.teacherName}</h2>
                <h2>${course.courseDescription}</h2>
            </a>
        </c:forEach>
    </div>
</div>
<jsp:include page="user_footer.jsp" />
