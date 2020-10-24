package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
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
    private static final String myReposUrl = String.format( "https://api.github.com/users/{%s}/repos", REPO_USER);
    private final RestTemplate restTemplate;

    public GithubService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<GithubRepoDto> allUserRepos(){
      return allReposOfGivenUser("SzymonOlucha");
    }

    public List<GithubRepoDto> allReposOfGivenUser(String reposUser){
        log.info("getting all repos for user [{}]", reposUser);
        Map<String, ?> params= Map.of(REPO_USER,reposUser);
        //    String[].class
        //        List.class
        //        List<String>.class
        //        List<GithubRepoDto>.class
        var requestResult = restTemplate.getForObject(myReposUrl, GithubRepoDto[].class, params);


        return Arrays.asList(requestResult != null ? requestResult : new GithubRepoDto[]{} );
    }


}
