package prodsmile.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Bracket {

    public boolean isMatch(String str){
        var stack = new Stack<Character>();

        for(char c : str.toCharArray()) {
            if(c == '{') {
                stack.push(c);
                continue;
            }

            if(c == '}') {
                if(stack.size() == 0) {
                    return false;
                }
                var item = stack.pop();
                if(item != '{') {
                    return false;
                }
            }
        }
        return stack.size() == 0;

    }

    @Test
    public void test(){
        var cases = new String[]{
               "{1}{2}{3}",
                "{{1+2}{{3+4}}}",
                "1*{2+3*{4+5}}",
                "",
                "{",
                "}}{{",
                "{{{}",
        };

        var values = new Boolean[] {
                true,
                true,
                true,
                true,
                false,
                false,
                false
        };

        for(int i = 0; i < cases.length; i++) {
            var c = cases[i];
            assertEquals(values[i], isMatch(c));
        }




    }
}
