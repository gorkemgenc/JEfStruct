package com.github.gorkemgenc.jEfCheck;

import org.junit.Assert;

import java.util.List;

public class JEfHelper {

    protected static void checkElementByElement(List<List<Integer>> parameter, List<List<Integer>> expectedParameter){

        for(int i=0; i<parameter.size(); i++){
            for(int j=0; j<parameter.get(i).size(); j++){
                Assert.assertEquals(parameter.get(i).get(j), expectedParameter.get(i).get(j));
            }
        }
    }

}
