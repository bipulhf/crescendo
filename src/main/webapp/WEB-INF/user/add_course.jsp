<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="user_header.jsp" />
<form method="post" action="add-course" class="w-[1200px] mx-auto mt-10">
    <div class="mb-4">
        <label for="course_name" class="block font-bold mb-2">Course Name:</label>
        <input type="text" id="course_name" name="course_name" placeholder="Enter Course Name" required
               class="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-yellow">
    </div>

    <div class="mb-4">
        <label for="course_description"
               class="block font-bold mb-2">Course Description:</label>
        <textarea id="course_description" name="course_description" placeholder="Enter Course Description"
                  rows="4" required
                  class="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-yellow resize-none"></textarea>
    </div>

    <div class="mb-4">
        <label for="assigned_teacher" class="block font-bold mb-2">Assigned
            Teacher:</label>
        <select id="assigned_teacher" name="assigned_teacher"
                class="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-yellow">
            <option value="" disabled selected>Select Assigned Teacher</option>
            <c:forEach items="${teachers}" var="teacher">
                <option value="${teacher.ID}">${teacher.name}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit"
            class="bg-blue px-4 py-2 rounded-md hover:underline">
        Submit
    </button>
</form>
<jsp:include page="user_footer.jsp" />
