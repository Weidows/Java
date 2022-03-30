package prodsmile.coding.java8plus;


import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSExample {

    @Test
    public void test_engine() throws ScriptException {

        var jscode = " [1,2,3].map(function(x){return x + 1;}).join('-');";
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        Object result = nashorn.eval(jscode);


        System.out.println(result);

    }
}
