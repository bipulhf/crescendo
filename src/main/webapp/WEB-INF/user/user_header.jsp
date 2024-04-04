<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crescendo - Learn . Grow . Thrive .</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=League+Spartan:wght@100..900&display=swap" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        yellow: '#FCDE67',
                        blue: '#5BCCF6',
                        black: '#030E12',
                        red: '#C41E3A'
                    },
                    fontFamily: {
                        "lsp": ['League Spartan', 'sans-serif']
                    }
                }
            }
        }
    </script>
</head>
<body class="font-lsp text-xl w-full text-black">
    <nav class="flex justify-between px-10 py-6 items-center content-center bg-yellow">
        <a href="/dashboard"><img src="../../images/Crescendo_Header.png" alt="Logo of Crescendo" class="h-[50px]"></a>
        <div class="text-center">
            <h2 class="text-2xl"><%= session.getAttribute("role").toString().toUpperCase() %> DASHBOARD</h2>
            <h3 class="text-3xl"><%= session.getAttribute("name") %></h3>
        </div>
        <a href="/logout"><button class="px-6 py-2 rounded-lg bg-black text-white hover:underline">Logout</button></a>
    </nav>