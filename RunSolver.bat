@echo off
title Sigil Puzzle Solver
setlocal enabledelayedexpansion

if not exist "bin" mkdir bin
echo Compiling...
javac -d bin src/Runner.java src/engine/*.java src/solver/*.java
if %errorlevel% neq 0 (
    echo [!] Compilation Error.
    pause
    exit /b %errorlevel%
)

cls
echo ===================================
echo       SIGIL PUZZLE SOLVER
echo ===================================

:puzzle_loop
echo.
java -cp bin Runner

echo.
echo -----------------------------------
set /p "again=Solve another puzzle? (y/n): "

set "firstChar=%again:~0,1%"
if /i "%firstChar%"=="y" (
    echo.
    echo ===================================
    echo           NEXT PUZZLE
    echo ===================================
    goto puzzle_loop
)

:end_script
echo.
timeout /t 2 >nul
exit