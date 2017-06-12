import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static String readFile(String path)
            throws IOException, URISyntaxException {
        byte[] encoded = Files.readAllBytes(Paths.get(TestUtils.class.getResource(path).toURI()));
        String result = new String(encoded, Charset.defaultCharset());
        if (isWindows()) {
            result = result.replaceAll("\n", "\r\n");
        }
        return result;
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}
