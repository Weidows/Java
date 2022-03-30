package prodsmile.jvm;


public class EmptyObject {




    //-XX:-UseCompressedClassPointers
    //-XX:-UseCompressedOops
    public static void main(String[] argv){
        System.out.println(InstrumentationAgent.getObjectSize(new Object()));
        System.out.println(InstrumentationAgent.getObjectSize(new int[0]));
        System.out.println(InstrumentationAgent.getObjectSize(""));


        Integer y = 1;
        System.out.println(InstrumentationAgent.getObjectSize(y));
        int x = 1;
        System.out.println(InstrumentationAgent.getObjectSize(x));
    }

}


