import java.io.FileReader;
import java.util.Scanner;

public interface Equals {
    public static boolean equalsFiles(String filename, String expectedValue) {
        Scanner scan_gotten = null, scan_expected = null;
        try {
            boolean correct = true;
            String gotten, expected;
            FileReader reader_gotten = new FileReader(filename),
                    reader_expected = new FileReader(expectedValue);
            scan_gotten = new Scanner(reader_gotten);
            scan_expected = new Scanner(reader_expected);
            while (scan_expected.hasNext()) {
                gotten = scan_gotten.nextLine();
                expected = scan_expected.nextLine();
                if (!gotten.equals(expected)) {
                    correct = false;
                    break;
                }
            }
            scan_gotten.close();
            scan_expected.close();
            return correct;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            scan_gotten.close();
            scan_expected.close();
            return false;
        }
    }
}
