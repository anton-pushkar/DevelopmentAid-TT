package test.developmentaid.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StackoverflowUser {
    private String name;
    private String location;
    private int answerCount;
    private int questionCount;
    private List<Tag> tags;
    private String linkToProfile;
    private String linkToAvatar;
}
