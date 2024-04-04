<jsp:include page="../header.jsp" />
<div class="h-screen w-full bg-bg_yellow absolute inset-0 bg-[radial-gradient(#e0c660_1px,transparent_1px)] [background-size:16px_16px]">
    <div class="w-full container mx-auto text-primary_text h-[85%]">
        <div class="nav w-full py-10 h-[20%]">
            <a href="/"><img src="../../images/Crescendo_Header.png" alt="Logo of Crescendo" class="h-[90px] mx-auto"/></a>
        </div>
        <div class="h-[80%] w-[70%] mx-auto">
            <h1 class="text-3xl font-semibold my-6">Login : </h1>
            <h3 class="text-xl font-semibold my-6 text-red">Wrong Credentials. Please Try again. </h3>
            <form action="#" method="post" class="text-primary_text">

                <div class="mb-4">
                    <label for="email" class="block font-bold mb-2">Email:</label>
                    <input type="email" id="email" name="email" placeholder="example@example.com"
                           class="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-primary_text">
                </div>

                <div class="mb-4">
                    <label for="password" class="block font-bold mb-2">Password:</label>
                    <input type="password" id="password" name="password" placeholder="********"
                           class="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-primary_text">
                </div>

                <button type="submit"
                        class="bg-primary_text text-white px-4 py-2 rounded-md hover:underline focus:outline-none transition-all duration-300">
                    Login
                </button>

            </form>
        </div>
    </div>
    <div class="w-full h-[15%] text-primary_text flex flex-col justify-center">
        <h1 class="text-center">&copy; CRESCENDO 2024</h1>
    </div>
</div>
<jsp:include page="../footer.jsp" />