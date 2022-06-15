$ErrorActionPreference = "Stop"

echo "[WindowsApplicationDriver] - Installing WindowsApplicationDriver 1.2.1"
Start-Process -FilePath "C:\vagrant\tools\WindowsApplicationDriver.msi" -Argument "/passive" -Wait -PassThru

echo "[WindowsApplicationDriver] - Enable Developer Mode"
reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\AppModelUnlock" /t REG_DWORD /f /v "AllowDevelopmentWithoutDevLicense" /d "1"

echo "[WindowsApplicationDriver] - Add Firewall Rule For Port 4723"
netsh advfirewall firewall add rule name="WinAppDriverRemote" dir=in action=allow protocol=TCP localport=4723
