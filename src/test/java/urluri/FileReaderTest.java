package urluri;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by UDAY on 10/16/2018.
 */
public class FileReaderTest {

    @Test
    public void testReadFileFromUrl() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        //use http link, if you want to read directly from url use 'http://rankandfiled.com/static/export/cusip_ticker.csv'
        // url and uri both gets respected in this implementation, uri is easier to test.
        List<String> dataFromURL = new FileReaderFromURLorURI("file://"+classLoader.getResource("ticker.csv").getFile()).readFileFromUrl();
        Assert.assertEquals(5, dataFromURL.size());
        Assert.assertEquals("ALCOA INC|AA|013817101|4281", dataFromURL.get(0));
    }
}
