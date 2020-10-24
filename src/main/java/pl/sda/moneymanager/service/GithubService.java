package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GithubService {


    private static final String myReposUrl = "https://api.github.com/users/mariuszpastuszka/repos";
    private final RestTemplate restTemplate;

    public GithubService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<GithubRepoDto> allUserRepos(){

//        String[].class
//        List.class
//        List<String>.class
//        List<GithubRepoDto>.class
        var requestResult = restTemplate.getForObject(myReposUrl, GithubRepoDto[].class);
        return Arrays.asList(requestResult != null ? requestResult : new GithubRepoDto[]{} );
    }


}
