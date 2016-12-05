package me.cosme.retrofit.githubservice.config;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GitHubErrorMessage {

    @XmlElement(name = "message")
    @SerializedName("message")
    private String message;

    @XmlElement(name = "documentation_url")
    @SerializedName("documentation_url")
    private String documentation;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
