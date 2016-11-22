package pl.pragmatists.httpclientkata.cityoffice.selectoffice;

import pl.pragmatists.httpclientkata.cityoffice.http.RestClient;

import java.util.Arrays;
import java.util.List;

public class CityOfficesFetcher {
    private final RestClient restClient;

    public CityOfficesFetcher(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Office> fetch(String userId) {
        Office[] offices = restClient.getForObject("/users/" + userId + "/offices", Office[].class);
        return Arrays.asList(offices);
    }
}
