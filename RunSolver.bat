@echo off
title Sigil Puzzle Solver
:: 1. Create a bin folder if it doesn't exist
if not exist "bin" mkdir bin

:: 2. Compile the code (this ensures your latest changes are included)
echo Compiling...
javac -d bin src/Runner.java src/engine/*.java src/solver/*.java

:: 3. Check if compilation worked
if %errorlevel% neq 0 (
    echo.
    echo [!] Compilation Error. Please check your code.
    pause
    exit /b %errorlevel%
)

:: 4. Run the program
cls
echo.
java -cp bin Runner

:: 5. Keep the window open!
echo.
echo -----------------------------------
echo Puzzle processing complete.
pause