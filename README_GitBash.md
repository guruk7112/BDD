# Using Git Bash in this project

This project includes a small helper batch to open Git Bash in the project folder and instructions to configure Eclipse's Terminal to use Git Bash.

Files added
- `open_git_bash_here.bat` — double-click or run to open Git Bash in this project folder.

How to use the batch
1. From Windows Explorer, double-click `open_git_bash_here.bat` inside the project root (C:\Users\Gurup\git\DophaMine\DophaMine). It will open Git Bash with the current working directory set to the project root.
2. From CMD you can run:

```
C:\Users\Gurup\git\DophaMine\DophaMine\open_git_bash_here.bat
```

Notes about Git installation paths
- The batch attempts to find `git-bash.exe` under `%ProgramFiles%\Git` and `%ProgramFiles(x86)%\Git`.
- If Git for Windows is installed to a different location, edit the batch and set `GITBASH` to the correct absolute path.

Configure Eclipse Terminal to use Git Bash
1. Install the Terminal plugin if you don't already have it: Help > Eclipse Marketplace... → search `TM Terminal` or `Terminal` → Install → Restart Eclipse.
2. Open: Window > Preferences > Terminal > Local Terminal (or Terminal > Local Terminal)
3. Set the Shell location to one of these (choose the one that exists on your machine):
   - For mintty (recommended UI):
     ```
     C:\Program Files\Git\git-bash.exe
     ```
     (No additional arguments required; if the Terminal plugin doesn't accept `git-bash.exe` arguments, use `bash.exe` below.)
   - For console-mode bash (works reliably with arguments):
     ```
     C:\Program Files\Git\bin\bash.exe
     ```
     Arguments: `--login -i`

4. Apply and open a new Local Terminal view. The terminal should be a Bash shell inside Eclipse.

Opening the project folder in Eclipse Terminal
- If the plugin supports variables, set the starting directory to `${workspace_loc:/DophaMine}` or use the terminal view's "Open in" controls.
- Alternatively, use the `open_git_bash_here.bat` from the Project > Show In > System Explorer and double-click it.

Troubleshooting
- If Eclipse refuses to start `git-bash.exe` directly, use `bash.exe --login -i` as the shell location instead.
- Ensure the path is wrapped in quotes because it contains spaces.

If you want, I can also add an Eclipse `.launch` or a small script that starts the terminal inside Eclipse-like environments, or set the exact preferences programmatically — tell me if you'd like that.
