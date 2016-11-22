package pl.pragmatists.httpclientkata.cityoffice.http.exceptions;

public class RestClientServerError extends RuntimeException {
    public RestClientServerError(String details) {
        super(details);
    }
}
