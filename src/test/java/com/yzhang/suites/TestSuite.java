package com.yzhang.suites;

import com.yzhang.cases.Calculator;
import com.yzhang.cases.Notepad;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Calculator.class, Notepad.class})
public class TestSuite {

}
