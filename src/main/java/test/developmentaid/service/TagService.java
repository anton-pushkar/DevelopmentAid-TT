package test.developmentaid.service;

import java.util.List;
import test.developmentaid.dto.TagsResponse;
import test.developmentaid.model.Tag;

public class TagService {
    private final HttpClient client = new HttpClient();

    public List<Tag> getAllTagsByUserId(int id) {
        TagsResponse userTags = client.get("https://api.stackexchange.com/2.3/users/" + id + "/tags?page=1&pagesize=100&order=desc&sort=popular&site=stackoverflow&filter=!9ewGKXLQS",
                TagsResponse.class);
        List<Tag> items = userTags.getItems();
        boolean hasMore = userTags.isHasMore();
        int i = 2;
        while (hasMore) {
            TagsResponse moreTags = client.get("https://api.stackexchange.com/2.3/users/" + id + "/tags?page=" + i + "&pagesize=100&order=desc&sort=popular&site=stackoverflow&filter=!9ewGKXLQS",
                    TagsResponse.class);
            List<Tag> moreItem = moreTags.getItems();
            hasMore = moreTags.isHasMore();
            if (moreItem != null) {
                items.addAll(moreItem);
                moreItem.clear();
            }
            i++;
        }
        return items;
    }

}
