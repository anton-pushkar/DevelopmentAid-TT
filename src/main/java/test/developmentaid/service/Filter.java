package test.developmentaid.service;

import java.util.List;
import test.developmentaid.dto.UserResponseDto;
import test.developmentaid.model.Tag;

public class Filter {

    public boolean filterUsers(UserResponseDto item) {
        if (item.getLocation() == null) {
            return false;
        } else {
            return item.getLocation().contains("Romania")
                    || item.getLocation().contains("Moldova")
                    && item.getAnswerCount() >= 1;
        }
    }

    public boolean filterTags(List<Tag> tags) {
        for (Tag tag : tags) {
            if (tag.getName().equals("java") || tag.getName().contains("c#")
                    || tag.getName().contains("C#") || tag.getName().contains(".net")
                    || tag.getName().contains("docker")) {
                return true;
            }
        }
        return false;
    }
}

