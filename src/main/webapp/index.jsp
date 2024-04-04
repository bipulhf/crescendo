<jsp:include page="WEB-INF/header.jsp" />
<div class="h-screen w-full bg-bg_yellow absolute inset-0 bg-[radial-gradient(#e0c660_1px,transparent_1px)] [background-size:16px_16px]">
    <div class="w-full container mx-auto text-primary_text h-[75%]">
        <div class="nav w-full py-10 h-[20%]">
            <a href="/"><img src="images/Crescendo_Header.png" alt="Logo of Crescendo" class="h-[90px] mx-auto"/></a>
        </div>
        <div class="grid grid-cols-2 h-[80%] items-center">
            <div>
                <h2 class="text-4xl my-10">Master new <b>skills</b> and unlock your <b>potential</b> with our online course platform.</h2>
            </div>
            <div class="flex justify-center">
                <div class="m-10">
                    <a href="<%= request.getContextPath() %>/register"><button class="rounded-lg w-[230px] h-[90px] bg-primary_text text-white text-2xl hover:underline hover:cursor-pointer hover:font-bold transition-all">Join Now</button></a>
                </div>
                <div class="m-10">
                    <a href="<%= request.getContextPath() %>/login"><button class="rounded-lg w-[230px] h-[90px] p-6 bg-btn_blue text-primary_text text-2xl hover:underline hover:cursor-pointer hover:font-bold transition-all">Login</button></a>
                </div>
            </div>
        </div>
    </div>
    <div class="w-full h-[10%] bg-btn_blue text-primary_text flex flex-col justify-center">
        <h1 class="text-3xl text-center font-bold">Build in-demand skills to advance your career or personal development.</h1>
    </div>
    <div class="w-full h-[15%] text-primary_text flex flex-col justify-center">
        <h1 class="text-center">&copy; CRESCENDO 2024</h1>
    </div>
</div>
<jsp:include page="WEB-INF/footer.jsp" />