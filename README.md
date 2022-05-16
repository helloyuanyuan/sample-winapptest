# Sample Windows App Test Project

## (Java + WinAppDriver + Appnium + Selenium + Junit)

### Steps

~~~Text
1. install /tools/WindowsApplicationDriver_1.2.1.msi
2. run C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe
3. run comand: ./mvnw clean compile test
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
