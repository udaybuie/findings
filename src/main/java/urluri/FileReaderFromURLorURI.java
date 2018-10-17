package urluri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by UDAY on 10/16/2018.
 */
public class FileReaderFromURLorURI {

    private String uriPath;
    private List<String> fileData = new ArrayList();

    public FileReaderFromURLorURI(String uriPath){
        this.uriPath = uriPath;
    }


    public List<String> readFileFromUrl() throws URISyntaxException, IOException {

        URI uri = new URI(uriPath);
        InputStream inputStream= uri.toURL().openStream();
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        bufferedReader.readLine();
        fileData = bufferedReader.lines().collect(Collectors.<String>toList());
        bufferedReader.close();
        return  fileData;

    }
}
