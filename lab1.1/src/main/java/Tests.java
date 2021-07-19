import Running.Main;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Tests extends Assert {
    @DataProvider
    public Object[][] arguments() {
        return new Object[][]{
            {"src/test/java/test/test1.txt", "src/test/java/out/out1.txt"},
            {"src/test/java/test/test2.txt", "src/test/java/out/out2.txt"},
            {"src/test/java/test/test3.txt", "src/test/java/out/out3.txt"},
            {"src/test/java/test/test4.txt", "src/test/java/out/out4.txt"},
            {"src/test/java/test/test5.txt", "src/test/java/out/out5.txt"},
            {"src/test/java/test/test6.txt", "src/test/java/out/out6.txt"},
            {"src/test/java/test/test7.txt", "src/test/java/out/out7.txt"},
            {"src/test/java/test/test8.txt", "src/test/java/out/out8.txt"},
            {"src/test/java/test/test9.txt", "src/test/java/out/out9.txt"}
        };
    }

@Test(dataProvider = "arguments")
public void  DataTest(String fileName, String expectedValue) throws NullPointerException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("out.txt"));
            System.setOut(out);
            String[] args = {fileName};
            Main.main(args);
            out.close();
            System.setOut(System.out);
            assertTrue(Equals.equalsFiles("out.txt", expectedValue));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
