package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GithubService {
    public static final String REPO_USER = "user";
    private static final String myReposUrl = String.format("https://api.github.com/users/{%s}/repos",
        REPO_USER);

    private final RestTemplate restTemplate;
    private final String API_KEY;

    public GithubService(final RestTemplate restTemplate, @Value("${security.key:#null}") String apiKey) {
        this.restTemplate = restTemplate;
        API_KEY = apiKey;

        log.debug("provided key: [{}]", apiKey);
    }

    public List<GithubRepoDto> allUserRepos() {

        return allReposOfGivenUser("mariuszpastuszka");
    }

    public List<GithubRepoDto> allReposOfGivenUser(String repoUser) {
        log.info("getting all repos for user: [{}]", repoUser);

        Map<String, ?> params = Map.of(REPO_USER, repoUser);
//        String[].class
//        List.class
//        List<String>.class
//        List<GithubRepoDto>.class
        var requestResult = restTemplate.getForObject(myReposUrl, GithubRepoDto[].class,
            params);

        log.info("number of elements in result: [{}]", requestResult != null ? requestResult.length : 0);
        log.debug("all repos: {}", Arrays.toString(requestResult));
//        return Arrays.asList(requestResult != null ? requestResult : new GithubRepoDto[]{});
        return requestResult != null ? Arrays.asList(requestResult) : Collections.emptyList();

    }
}
