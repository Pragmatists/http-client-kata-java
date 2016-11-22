package pl.pragmatists.httpclientkata.cityoffice.app.selectoffice;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import pl.pragmatists.httpclientkata.cityoffice.http.Host;
import pl.pragmatists.httpclientkata.cityoffice.http.RestClientWithOkHttp;
import pl.pragmatists.httpclientkata.cityoffice.selectoffice.CityOfficesFetcher;
import pl.pragmatists.httpclientkata.cityoffice.selectoffice.Office;

public class FetchingOfficesTest {

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void fetches_city_offices() throws IOException {
        server.enqueue(new MockResponse().setBody("" +
                "[\n" +
                "    {\n" +
                "        \"name\": \"USC Andersa\",\n" +
                "        \"id\": \"5d2e698a-9c31-456b-8452-7ce33e7deb94\",\n" +
                "        \"favorite\": false\n" +
                "    }\n" +
                "]\n"));
        CityOfficesFetcher officeGroupsFetcher = createCityOfficesFetcher();

        List<Office> offices = officeGroupsFetcher.fetch("user-id");

        assertThat(offices).hasSize(1);
    }

    @Ignore
    @Test
    public void reactsTo500() throws IOException {
        server.enqueue(new MockResponse().setStatus("HTTP/1.1 500 Internal Server Error"));
    }

    @Ignore
    @Test
    public void reactsTo400() throws IOException {
    }

    @Ignore
    @Test
    public void reactsWhenServerUnreachable() throws IOException {
    }

    private CityOfficesFetcher createCityOfficesFetcher() {
        return new CityOfficesFetcher(new RestClientWithOkHttp(getHost()));
    }

    private Host getHost() {
        return new Host("http", server.getHostName(), server.getPort());
    }

}