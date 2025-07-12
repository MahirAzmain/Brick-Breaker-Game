# Brick-Breaker-Game
Java Game Programming for Desktop
<br>
I develop a brick breaker game with Java. I use JFrame and JPanel for drawing different graphics to make this game work perfectly.

**Project Proposal:**
[2007118 Desktop.docx](https://github.com/user-attachments/files/19014022/2007118.Desktop.docx)
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Brick Breaker Game Project Infographic</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700;900&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #F0F8FF;
        }
        .chart-container {
            position: relative;
            width: 100%;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
            height: 300px;
            max-height: 400px;
        }
        @media (min-width: 768px) {
            .chart-container {
                height: 350px;
            }
        }
        .gradient-text {
            background: linear-gradient(90deg, #1E90FF, #0047AB);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
    </style>
</head>
<body class="text-gray-800">

    <div class="container mx-auto p-4 md:p-8">
        
        <header class="text-center my-12">
            <h1 class="text-5xl md:text-7xl font-black gradient-text">Brick Breaker: The Project</h1>
            <p class="text-lg md:text-xl text-gray-600 mt-4 max-w-3xl mx-auto">An analysis of a classic arcade game built with modern Java technologies, featuring robust architecture and engaging gameplay.</p>
        </header>
        
        <main class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">

            <div class="lg:col-span-3 bg-white rounded-lg shadow-lg p-6 md:p-8">
                 <h2 class="text-3xl font-bold text-center mb-6 text-[#0047AB]">Core Gameplay & Advanced Features</h2>
                 <p class="text-center text-gray-600 mb-8 max-w-4xl mx-auto">The game combines timeless arcade mechanics with modern application features to create a complete user experience. From responsive controls to competitive leaderboards, the project covers the full spectrum of game development.</p>
                <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
                    
                    <div class="bg-blue-50 p-6 rounded-lg">
                        <h3 class="text-xl font-bold mb-4 text-[#0047AB]">Gameplay Mechanics</h3>
                        <ul class="space-y-3">
                            <li class="flex items-center"><span class="text-2xl mr-3">🎮</span> Classic arcade fun</li>
                            <li class="flex items-center"><span class="text-2xl mr-3">⌨️</span> Arrow key controls</li>
                            <li class="flex items-center"><span class="text-2xl mr-3">🏆</span> Real-time score tracking</li>
                            <li class="flex items-center"><span class="text-2xl mr-3">🏁</span> Win/Loss conditions</li>
                        </ul>
                    </div>

                    <div class="bg-blue-50 p-6 rounded-lg">
                        <h3 class="text-xl font-bold mb-4 text-[#0047AB]">Application Features</h3>
                         <div class="chart-container h-56 md:h-64">
                            <canvas id="featuresChart"></canvas>
                        </div>
                    </div>
                </div>
            </div>

            <div class="md:col-span-2 lg:col-span-2 bg-white rounded-lg shadow-lg p-6 md:p-8">
                <h2 class="text-3xl font-bold mb-2 text-[#0047AB]">Project Technology Stack</h2>
                <p class="text-gray-600 mb-6">This project is built on the robust and versatile Java platform, utilizing a range of tools and libraries to deliver a comprehensive desktop application. The stack is chosen for its stability in UI development, data handling, and project management.</p>
                <div class="chart-container h-80 md:h-96">
                    <canvas id="techStackChart"></canvas>
                </div>
            </div>
            
            <div class="bg-white rounded-lg shadow-lg p-6 md:p-8">
                <h2 class="text-3xl font-bold mb-2 text-[#0047AB]">Code Quality</h2>
                 <p class="text-gray-600 mb-6">The project's foundation is built on clean, maintainable, and scalable code by adhering to key Object-Oriented Programming (OOP) principles.</p>
                <div class="text-center bg-[#1E90FF] text-white p-8 rounded-lg shadow-inner">
                    <h3 class="text-2xl font-bold">Built with</h3>
                    <p class="text-6xl font-black my-2">OOP</p>
                    <p class="text-lg">Principles</p>
                </div>
                <ul class="mt-6 space-y-2 text-gray-700">
                    <li class="p-3 bg-blue-50 rounded-md"><strong>Encapsulation:</strong> Bundling data and methods.</li>
                    <li class="p-3 bg-blue-50 rounded-md"><strong>Abstraction:</strong> Hiding complex implementation details.</li>
                    <li class="p-3 bg-blue-50 rounded-md"><strong>Inheritance:</strong> Creating new classes from existing ones.</li>
                </ul>
            </div>
            
            <div class="lg:col-span-3 bg-white rounded-lg shadow-lg p-6 md:p-8">
                <h2 class="text-3xl font-bold text-center mb-2 text-[#0047AB]">User & Development Workflow</h2>
                <p class="text-center text-gray-600 mb-8 max-w-4xl mx-auto">The application follows a logical flow from user authentication to gameplay, while the development process is standardized for easy setup and contribution.</p>
                <div class="flex flex-col items-center space-y-4">
                    <div class="w-full max-w-md text-center bg-blue-100 p-4 rounded-lg border-2 border-dashed border-[#6495ED]">Start / Launch</div>
                    <div class="text-3xl text-[#6495ED]">▼</div>
                    <div class="w-full max-w-md text-center bg-blue-100 p-4 rounded-lg border-2 border-dashed border-[#6495ED]">Login / Register</div>
                    <div class="text-3xl text-[#6495ED]">▼</div>
                    <div class="w-full max-w-md text-center bg-blue-100 p-4 rounded-lg border-2 border-dashed border-[#6495ED]">Main Menu</div>
                    <div class="flex flex-col md:flex-row gap-4 w-full justify-center mt-4">
                        <div class="text-2xl text-[#6495ED] hidden md:block">└─►</div>
                        <div class="text-2xl text-[#6495ED] text-center md:hidden">▼</div>
                        <div class="flex-1 text-center bg-green-100 p-4 rounded-lg border-2 border-dashed border-green-400">Select Difficulty</div>
                        <div class="text-2xl text-[#6495ED] hidden md:block">◄──►</div>
                        <div class="text-2xl text-[#6495ED] text-center md:hidden">▼</div>
                        <div class="flex-1 text-center bg-yellow-100 p-4 rounded-lg border-2 border-dashed border-yellow-400">View Leaderboard</div>
                    </div>
                    <div class="text-3xl text-[#6495ED] text-center">▼</div>
                    <div class="w-full max-w-md text-center bg-green-100 p-4 rounded-lg border-2 border-dashed border-green-400">Play Game</div>
                </div>
            </div>

            <div class="lg:col-span-3 bg-white rounded-lg shadow-lg p-6 md:p-8">
                <h2 class="text-3xl font-bold text-center mb-6 text-[#0047AB]">AI-Powered Insights ✨</h2>
                <p class="text-center text-gray-600 mb-8 max-w-4xl mx-auto">Leverage the power of AI to gain insights and creative ideas for the Brick Breaker game project.</p>
                <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                    <div class="bg-blue-50 p-6 rounded-lg flex flex-col items-center">
                        <h3 class="text-xl font-bold mb-4 text-[#0047AB]">Suggest Game Improvements</h3>
                        <button id="suggestImprovementsBtn" class="bg-[#1E90FF] hover:bg-[#0047AB] text-white font-bold py-3 px-6 rounded-lg shadow-md transition duration-300 ease-in-out transform hover:scale-105">
                            Get Ideas ✨
                        </button>
                        <div id="improvementsLoading" class="mt-4 text-gray-600 hidden">Generating ideas...</div>
                        <div id="improvementsOutput" class="mt-4 text-gray-700 text-sm leading-relaxed"></div>
                    </div>
                    <div class="bg-blue-50 p-6 rounded-lg flex flex-col items-center">
                        <h3 class="text-xl font-bold mb-4 text-[#0047AB]">Brainstorm Marketing Slogans</h3>
                        <button id="slogansBtn" class="bg-[#1E90FF] hover:bg-[#0047AB] text-white font-bold py-3 px-6 rounded-lg shadow-md transition duration-300 ease-in-out transform hover:scale-105">
                            Get Slogans ✨
                        </button>
                        <div id="slogansLoading" class="mt-4 text-gray-600 hidden">Brainstorming slogans...</div>
                        <div id="slogansOutput" class="mt-4 text-gray-700 text-sm leading-relaxed"></div>
                    </div>
                </div>
            </div>

        </main>
        
        <footer class="text-center mt-12 py-6 border-t border-gray-300">
            <p class="text-gray-600">Infographic generated based on the Brick Breaker project. All data and processes are derived from its public repository.</p>
        </footer>

    </div>

    <script>
        function wrapLabel(str, maxWidth) {
            if (str.length <= maxWidth) {
                return str;
            }
            const words = str.split(' ');
            const lines = [];
            let currentLine = words[0];

            for (let i = 1; i < words.length; i++) {
                if (currentLine.length + words[i].length + 1 < maxWidth) {
                    currentLine += ' ' + words[i];
                } else {
                    lines.push(currentLine);
                    currentLine = words[i];
                }
            }
            lines.push(currentLine);
            return lines;
        }
        
        const tooltipTitleCallback = (tooltipItems) => {
            const item = tooltipItems[0];
            let label = item.chart.data.labels[item.dataIndex];
            if (Array.isArray(label)) {
              return label.join(' ');
            } else {
              return label;
            }
        };

        const featuresData = {
            labels: ['User Authentication', 'Difficulty Levels', 'Leaderboard', 'Help Section'],
            datasets: [{
                label: 'Advanced Features',
                data: [25, 25, 25, 25],
                backgroundColor: [
                    '#4169E1',
                    '#6495ED',
                    '#1E90FF',
                    '#00BFFF'
                ],
                hoverOffset: 4
            }]
        };
        new Chart(document.getElementById('featuresChart'), {
            type: 'doughnut',
            data: featuresData,
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                           font: {
                               size: 14
                           }
                        }
                    },
                    tooltip: {
                        callbacks: {
                            title: tooltipTitleCallback
                        }
                    }
                }
            }
        });

        const techStackData = {
            labels: ['Java', 'Java AWT/Swing', 'Apache Ant', 'Google Gson', 'NetBeans/IntelliJ'],
            datasets: [{
                label: 'Technology Component',
                data: [100, 90, 70, 60, 80],
                backgroundColor: '#4169E1',
                borderColor: '#0047AB',
                borderWidth: 2,
                borderRadius: 5
            }]
        };
        new Chart(document.getElementById('techStackChart'), {
            type: 'bar',
            data: techStackData,
            options: {
                indexAxis: 'y',
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    x: {
                        beginAtZero: true,
                        ticks: {
                           display: false
                        },
                        grid: {
                           display: false
                        }
                    },
                    y: {
                       grid: {
                           display: false
                        },
                        ticks: {
                           font: {
                               size: 14,
                               weight: '600'
                           }
                        }
                    }
                },
                plugins: {
                    legend: {
                        display: false
                    },
                    tooltip: {
                        callbacks: {
                            title: tooltipTitleCallback
                        }
                    }
                }
            }
        });

        async function callGeminiAPI(prompt, outputElement, loadingElement) {
            outputElement.innerHTML = '';
            loadingElement.classList.remove('hidden');

            let chatHistory = [];
            chatHistory.push({ role: "user", parts: [{ text: prompt }] });
            const payload = { contents: chatHistory };
            const apiKey = "";
            const apiUrl = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=${apiKey}`;

            try {
                const response = await fetch(apiUrl, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(payload)
                });
                const result = await response.json();
                if (result.candidates && result.candidates.length > 0 &&
                    result.candidates[0].content && result.candidates[0].content.parts &&
                    result.candidates[0].content.parts.length > 0) {
                    const text = result.candidates[0].content.parts[0].text;
                    outputElement.innerHTML = text.replace(/\n/g, '<br>');
                } else {
                    outputElement.innerHTML = 'Error: Could not get a valid response from the API.';
                }
            } catch (error) {
                outputElement.innerHTML = 'Error: Failed to connect to the API. ' + error.message;
            } finally {
                loadingElement.classList.add('hidden');
            }
        }

        document.getElementById('suggestImprovementsBtn').addEventListener('click', () => {
            const prompt = `As a game designer, suggest 3-5 innovative improvements or new features for a classic Java Brick Breaker game. Consider aspects like gameplay mechanics, power-ups, level design, visual enhancements, or multiplayer options. The game currently has:
            - Classic arcade fun
            - Arrow key controls
            - Real-time score tracking
            - Win/Loss conditions
            - User authentication
            - Difficulty levels (Easy, Medium, Hard)
            - Leaderboard
            - Help section
            - Built with Java AWT/Swing.`;
            callGeminiAPI(
                prompt,
                document.getElementById('improvementsOutput'),
                document.getElementById('improvementsLoading')
            );
        });

        document.getElementById('slogansBtn').addEventListener('click', () => {
            const prompt = `Brainstorm 5 catchy and engaging marketing slogans for a classic Brick Breaker game. The slogans should appeal to a broad audience and highlight the game's addictive fun and classic feel.`;
            callGeminiAPI(
                prompt,
                document.getElementById('slogansOutput'),
                document.getElementById('slogansLoading')
            );
        });
    </script>

</body>
</html>
