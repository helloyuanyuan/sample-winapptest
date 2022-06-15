$ErrorActionPreference = "Stop"

echo "[CiscoAnyConnect][Optional] - Installing CiscoAnyConnect"
Start-Process -FilePath "C:\vagrant\tools\CiscoAnyConnect.msi" -Argument "/passive" -Wait -PassThru

echo "[ICRpilot.Completion] - Installing .NET Framework 3.5"
import-module ServerManager
Install-WindowsFeature NET-Framework-Features -source "C:\vagrant\tools\sxs"

echo "[ICRpilot.Completion] - Installing AccessDatabaseEngine2010 X86"
Start-Process -FilePath "C:\vagrant\tools\AccessDatabaseEngine2010X86.exe" -Argument "/passive" -Wait -PassThru

echo "[WindowsApplicationDriver] - Installing WindowsApplicationDriver 1.2.1"
Start-Process -FilePath "C:\vagrant\tools\WindowsApplicationDriver.msi" -Argument "/passive" -Wait -PassThru

echo "[WindowsApplicationDriver] - Enable Developer Mode"
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\AppModelUnlock" /t REG_DWORD /f /v "AllowDevelopmentWithoutDevLicense" /d "1"

echo "[WindowsApplicationDriver] - Add Firewall Rule For Port 4723"
netsh advfirewall firewall add rule name="WinAppDriverRemote" dir=in action=allow protocol=TCP localport=4723
