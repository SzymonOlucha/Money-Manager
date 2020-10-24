package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubRepoDto {
    @JsonProperty("id")
    private long projectId;

    @JsonProperty("name")
    private String projectName;

    @JsonProperty("full_name")
    private String projectFullName;

    private ProjectOwnerDto owner;
}
