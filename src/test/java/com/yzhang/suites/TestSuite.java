package com.yzhang.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.yzhang.cases.Calculator;
import com.yzhang.cases.Notepad;

@RunWith(Suite.class)
@Suite.SuiteClasses({Calculator.class, Notepad.class})
public class TestSuite {
}
