package com.github.hcsp.polymorphism;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    @CaptureSystemOutput
    public void test1(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("乌龟跑啊跑啊跑"));
        new Main.乌龟().跑();
    }

    @Test
    @CaptureSystemOutput
    public void test2(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("乌龟游啊游啊游"));
        new Main.乌龟().游泳();
    }

    @Test
    public void mixedIn() {
        Assertions.assertTrue(Main.会游泳.class.isAssignableFrom(Main.乌龟.class));
        Assertions.assertTrue(Main.会跑.class.isAssignableFrom(Main.乌龟.class));
    }
}
