package me.cosme.retrofit.githubservice.config;

public class GitHubServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final GitHubErrorMessage gitHubMessage;

    public GitHubServiceException(GitHubErrorMessage message) {
        super(message.getMessage());
        this.gitHubMessage = message;
    }

    public GitHubErrorMessage getGitHubMessage() {
        return gitHubMessage;
    }
}
