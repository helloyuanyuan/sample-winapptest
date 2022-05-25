package com.yzhang.suites;

import com.yzhang.cases.Calculator;
import com.yzhang.cases.Completion;
import com.yzhang.cases.Notepad;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Calculator.class, Notepad.class, Completion.class})
public class TestSuite {
}
