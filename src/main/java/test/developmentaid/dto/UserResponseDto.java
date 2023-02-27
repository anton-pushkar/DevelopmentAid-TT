package test.developmentaid.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserResponseDto {
    @JsonAlias(value = "user_id")
    private int id;
    @JsonAlias(value = "display_name")
    private String displayName;
    private String location;
    @JsonAlias(value = "answer_count")
    private int answerCount;
    @JsonAlias(value = "question_count")
    private int questionCount;
    private String link;
    @JsonAlias(value = "profile_image")
    private String profileImage;
}
