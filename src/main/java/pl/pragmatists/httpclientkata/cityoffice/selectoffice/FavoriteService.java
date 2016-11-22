package pl.pragmatists.httpclientkata.cityoffice.selectoffice;

import pl.pragmatists.httpclientkata.cityoffice.http.RestClient;

public class FavoriteService {
    private final RestClient restClient;

    public FavoriteService(RestClient restClient) {
        this.restClient = restClient;
    }

    public void toggleFavorite(String userId, String officeId, boolean isFavoriteNow) {
        restClient.postForObject("/users/" + userId + "/offices/" + officeId + "/favorite", new Favorite(!isFavoriteNow));
    }

    public static class Favorite {
        public final boolean favorite;

        public Favorite(boolean favorite) {
            this.favorite = favorite;
        }
    }
}
