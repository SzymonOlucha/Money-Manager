package pl.sda.moneymanager.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.dto.GithubRepoDto;
import pl.sda.moneymanager.service.GithubService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/github-int")
@Slf4j
public class GitHubIntegrationController {

    private final GithubService githubService;

    public GitHubIntegrationController(final GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/my-repos")
    public List<GithubRepoDto> myRepos() {
        log.info("my repos");
        return githubService.allUserRepos();
    }

    @GetMapping("/repos/{userName}")
    public List<GithubRepoDto> userRepos(@PathVariable("userName") String userName) {
        log.info("user repos, user name = [{}]", userName);
        return githubService.allReposOfGivenUser(userName);
    }

    // Create = 201 + header location
    @PostMapping("/repos")
    public ResponseEntity<GithubRepoDto> createRepo(@RequestBody GithubRepoDto repoToCreate) {
        log.info("github repo to create: [{}]", repoToCreate);
        return ResponseEntity.created(URI.create("/repos/1")).build();
    }
}
