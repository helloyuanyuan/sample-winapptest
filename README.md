# Sample Windows App Test Project

## (Java + Maven + Junit + Allure Report)

- FLOW: Test Runner >> WinAppDriver  >> Windows application

### Running on Local Machine

~~~Text
1. enable windows developer mode;
2. install /tools/WindowsApplicationDriver_1.2.1.msi;
3. run C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe;
4. run comand: ./mvnw clean compile test allure:serve; (Run and generate test report);
~~~

### Running on a Remote Machine

~~~Text
1. Remote machine: enable windows developer mode;
2. Remote machine: install /tools/WindowsApplicationDriver_1.2.1.msi;
3. Remote machine: run comand: netsh advfirewall firewall add rule name="WinAppDriverRemote" dir=in action=allow protocol=TCP localport=4723 (Open port);
4. Remote machine: run ipconfig.exe to determine the machine's local IP address (10.0.0.136 for example);
5. Remote machine: run command WinAppDriver.exe 10.0.0.136 4723/wd/hub as administrator;
6. Runner machine: update WinAppDriverURL=http://10.0.0.136:4723/wd/hub in env property file;
7. Runner machine: run comand: ./mvnw clean compile test allure:serve; (Run and generate test report);
~~~

### Notes

~~~Text
- The WinAppDriver v1.2.1 requires Selenium v3 based client for now,
  since Selenium v4 requires W3C spec protocol
  that is not supported by WinAppDriver yet.

- /tools/WinAppDriverUIRecorder/WinAppDriverUiRecorder.exe
  is for capture UI elements and Xpath while developing cases.

- /tools/flauinspect/tools/FlaUInspect.exe
  is for capture UI elements and Xpath while developing cases.
~~~

### Reference

- <https://github.com/microsoft/WinAppDriver>
- <http://appium.io/docs/en/drivers/windows/>
