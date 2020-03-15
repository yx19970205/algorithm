package com.algorithm.example.generate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateTest {

    @Autowired
    private Generate generate;
    @Test
    public void generteIntTest() {
        //generate.generateInt(1);
    }
}