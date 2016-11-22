package pl.pragmatists.httpclientkata.cityoffice.http;

public interface RestClient {
    <T> T getForObject(String url, Class<T> responseType);

    void postForObject(String url, Object object);
}
