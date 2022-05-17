# Sample Windows App Test Project

## (Java + WinAppDriver + Appnium + Junit)

### Steps

~~~Text
1. enable windows developer mode;
2. install /tools/WindowsApplicationDriver_1.2.1.msi;
3. run C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe;
4. run comand: ./mvnw clean compile test;
~~~

### Notes

~~~Text
- The WinAppDriver v1.2.1 requires Selenium v3 based client for now,
  since Selenium v4 requires W3C spec protocol
  that is not supported by WinAppDriver yet.

- /tools/WinAppDriverUIRecorder/WinAppDriverUiRecorder.exe
  is for capture XPath while developing cases.
~~~

### Reference

<https://github.com/microsoft/WinAppDriver>
