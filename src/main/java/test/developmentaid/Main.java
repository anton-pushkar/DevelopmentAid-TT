package test.developmentaid;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import test.developmentaid.dto.ApiResponseDto;
import test.developmentaid.dto.Mapper;
import test.developmentaid.dto.UserResponseDto;
import test.developmentaid.model.StackoverflowUser;
import test.developmentaid.model.Tag;
import test.developmentaid.service.Filter;
import test.developmentaid.service.HttpClient;
import test.developmentaid.service.TagService;

public class Main {
    private static final String URL_START = "https://api.stackexchange.com/2.3/users?page=";
    private static final String URL_FINISH = "&pagesize=100&order=asc&min=223&sort=reputation"
            + "&site=stackoverflow&filter=!LnNkvqQBDbWWONPMmhaT-7";
    private static final HttpClient client = new HttpClient();
    private static final Filter filter = new Filter();
    private static final Mapper mapper = new Mapper();
    private static final TagService tagService = new TagService();

    public static void main(String[] args) {
        {
            HttpClients.custom()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setCookieSpec(CookieSpecs.STANDARD).build())
                    .build();
        }
        List<StackoverflowUser> result = new ArrayList<>();
        for (int i = 1; i < 2 ; i++) {
        ApiResponseDto users = client.get(URL_START + 4 + URL_FINISH,
                ApiResponseDto.class);
        for (UserResponseDto item : users.getItems()) {
            if (filter.filterUsers(item)) {
                List<Tag> allTAgsByUserId = tagService.getAllTagsByUserId(item.getId());
                if (filter.filterTags(allTAgsByUserId)) {
                    result.add(mapper.toModel(allTAgsByUserId, item));
                }
            }
        }
         }
        for (StackoverflowUser user : result) {
            System.out.println(user);
        }
        System.out.println(result.size());
    }
}
