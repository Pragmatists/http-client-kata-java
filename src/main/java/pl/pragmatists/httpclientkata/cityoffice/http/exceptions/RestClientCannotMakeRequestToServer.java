package pl.pragmatists.httpclientkata.cityoffice.http.exceptions;

import java.io.IOException;

public class RestClientCannotMakeRequestToServer extends RuntimeException {
    public RestClientCannotMakeRequestToServer(IOException inner) {
        super(inner);
    }
}
