<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="user_header.jsp" />
<c:set var = "isEnrolled" scope="session" value="<%= request.getAttribute(\"isEnrolled\") %>" />

<div class="w-[1200px] mx-auto mt-10">

    <div class="mb-6 flex">
        <c:if test="${role == admin}">
            <form action="/course/<%= request.getAttribute("courseId")%>" method="post">
                <button class="px-4 py-2 bg-blue rounded-lg hover:underline mr-5" type="submit">Delete Course</button>
            </form>
        </c:if>
        <c:if test="${role != student}">
            <a href="/course/<%= request.getAttribute("courseId")%>/enroll">
                <button class="px-4 py-2 bg-yellow rounded-lg hover:underline" type="submit">Enrolled Students</button>
            </a>
        </c:if>
        <c:if test="${role == student}">
            <c:if test="${isEnrolled == false}">
                <form action="/course/${courseId}/enroll" method="post">
                    <button class="px-4 py-2 bg-blue rounded-lg hover:underline" type="submit">Enroll Course</button>
                </form>
            </c:if>
            <c:if test="${isEnrolled == true}">
                <h2 class="px-4 py-2 bg-gray-500 rounded-lg text-white">Enrolled</h2>
            </c:if>
        </c:if>
    </div>


    <div class="flex justify-between">
        <div>
            <h1 class="text-4xl font-semibold"><%= request.getAttribute("courseName") %></h1>
            <h2 class="text-2xl"><%= request.getAttribute("courseDescription") %></h2>
        </div>
        <div>
            <div class="mb-5">
                <h1 class="font-semibold">Course Teacher : </h1>
                <h1 class="text-2xl font-bold"><%= request.getAttribute("courseTeacher") %></h1>
            </div>
            <div>
                <h1 class="font-semibold">Contact Course Teacher : </h1>
                <h2 class="text-2xl"><%= request.getAttribute("courseTeacherEmail") %></h2>
            </div>
        </div>
    </div>
</div>
<jsp:include page="user_footer.jsp" />