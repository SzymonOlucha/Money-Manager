package pl.sda.moneymanager.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.sda.moneymanager.dto.GithubRepoDto;
import pl.sda.moneymanager.service.GithubService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/github-int")
public class GitHubIntegrationController {

    private final GithubService githubService;

    public GitHubIntegrationController( GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/my-repos")
    public List<GithubRepoDto> myRepos() {
        log.info("my repos");
        return githubService.allUserRepos();
    }

    @GetMapping("/repos/{userName}")
    public List<GithubRepoDto> userRepos(@PathVariable("userName") String userName){
        log.info("user repos [{}]", userName);

        return githubService.allReposOfGivenUser(userName);
    }

    @PostMapping("/repos")
    public ResponseEntity<GithubRepoDto> createRepo(@RequestBody GithubRepoDto repoToCreate){
        log.info("github repo to create: [{}] ", repoToCreate);

        return ResponseEntity.created(URI.create("/repos/1")).build();
    }
}
