# Sample Windows App Test Project

## (Java + Maven + Junit + Allure Report)

- FLOW: Test Runner >> WinAppDriver  >> Windows application

### Running on Local Machine

~~~Text
1. enable windows developer mode;
2. install /tools/WindowsApplicationDriver_1.2.1.msi;
3. run /tools/WinAppDriver.bat to start service;
4. set env=local in env.property;
5. run comand: ./mvnw clean compile test allure:serve; (Run and generate test report);
~~~

### Running on a Remote Machine

~~~Text
1. Remote machine: enable windows developer mode;
2. Remote machine: install /tools/WindowsApplicationDriver_1.2.1.msi;
3. Remote machine: run comand: netsh advfirewall firewall add rule name="WinAppDriverRemote" dir=in action=allow protocol=TCP localport=4723 (Open port);
4. Remote machine: run command: C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe (hostname or ip) 4723/wd/hub;
5. Runner machine: update WinAppDriverURL=http://(hostname or ip):4723/wd/hub in env property file;
6. Runner machine: run comand: ./mvnw clean compile test allure:serve; (Run and generate test report);
~~~

### Notes

~~~Text
- The WinAppDriver v1.2.1 requires Selenium v3 based client for now,
  since Selenium v4 requires W3C spec protocol
  that is not supported by WinAppDriver yet.

- /tools/WinAppDriverUIRecorder/WinAppDriverUiRecorder.exe
  is for capture UI elements and Xpath while developing cases.

- /tools/FlaUInspect/FlaUInspect.exe
  is for capture UI elements and Xpath while developing cases.
~~~

### Reference

- <https://github.com/microsoft/WinAppDriver>
- <http://appium.io/docs/en/drivers/windows/>
