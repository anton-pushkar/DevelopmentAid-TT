package test.developmentaid.dto;

import java.util.List;
import test.developmentaid.model.StackoverflowUser;
import test.developmentaid.model.Tag;

public class Mapper {
    public StackoverflowUser toModel(List<Tag> tags, UserResponseDto dto) {
        StackoverflowUser user = new StackoverflowUser();
        user.setName(dto.getDisplayName());
        user.setLocation(dto.getLocation());
        user.setAnswerCount(dto.getAnswerCount());
        user.setQuestionCount(dto.getQuestionCount());
        user.setTags(tags);
        user.setLinkToProfile(dto.getLink());
        user.setLinkToAvatar(dto.getProfileImage());
        return user;
    }
}
