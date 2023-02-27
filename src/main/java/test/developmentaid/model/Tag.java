package test.developmentaid.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Tag {
    @JsonAlias(value = "user_id")
    private int id;
    private String name;
}
