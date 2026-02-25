@echo off
REM Opens Git Bash in the current project folder (DophaMine)
:: Determine Program Files path (handles 32/64-bit)
if exist "%ProgramFiles%\Git\git-bash.exe" (
  set GITBASH="%ProgramFiles%\Git\git-bash.exe"
) else if exist "%ProgramFiles(x86)%\Git\git-bash.exe" (
  set GITBASH="%ProgramFiles(x86)%\Git\git-bash.exe"
) else (
  echo Could not find git-bash.exe in Program Files.
  echo Please install Git for Windows or adjust this batch to the correct path.
  pause
  exit /b 1
)
:: Launch git-bash.exe with --cd to set starting directory to the batch's location
start "Git Bash - DophaMine" %GITBASH% --cd="%~dp0"
exit /b 0
