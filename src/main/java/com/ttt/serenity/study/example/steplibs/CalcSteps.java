package com.ttt.serenity.study.example.steplibs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CalcSteps extends ScenarioSteps
{
    private static final long serialVersionUID = 1191855957443965503L;

    private List<Integer> numbers = new ArrayList<Integer>();
    private Integer total = 0;

    public CalcSteps(final Pages pages) {
        super(pages);
    }

    @Step
    public void add(int a, int b) {
        numbers.add(a);
        numbers.add(b);
        this.add();
    }

    @Step
    public void aNum(int num) {
        numbers.add(num);
    }

    @Step
    public void add() {
        for (Integer addend : numbers) {
            total += addend;
        }
    }

    public void checkResult(Integer expected) {
        assertEquals("A + B = C", expected, total);
    }

}

