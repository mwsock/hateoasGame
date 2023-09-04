package pl.mwsock.hateoasgame.namesApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NamesApiService {

    public ResponseEntity<String[]> getNamesFromApi(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.api-ninjas.com/v1/babynames?gender=neutral";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key","fDMVberKJomXhf6dnyNMUA==qVa6w7rFwW7lEXkE");
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String[].class);
        return responseEntity;
    }

}
