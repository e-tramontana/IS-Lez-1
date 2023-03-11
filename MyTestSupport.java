public class MyTestSupport {
    private static final String RESET = "\33[0m";
    private static final String GREEN = "\33[1;32m";
    private static final String RED = "\33[1;31m";

    private static final String OK = GREEN + "OK " + RESET;
    private static final String FAIL = RED + "FAILED " + RESET;

    protected void assertEquals(float a, float b, String msg) {
        if (a == b)
            System.out.print(OK);
        else
            System.out.print(FAIL);
        System.out.println(msg);
    }

    protected void assertEquals(int a, int b, String msg) {
        if (a == b)
            System.out.print(OK);
        else
            System.out.print(FAIL);
        System.out.println(msg);
    }

    protected void assertTrue(boolean value, String msg) {
        if (value)
            System.out.print(OK);
        else
            System.out.print(FAIL);
        System.out.println(msg);
    }
}
