package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistApi {
    //static String access_token ="BQAcckrFbPGcFG7q6gGJcBW68tXxI2Wblz2CPGnobvDb6AIRdqcEMWF8ZN5klFhvCI4lXCiAaandfZ4kGuvI0Nrwo5tAxa0SfjqVgTP6-p94NsBC8fYH4cESXK4Gi4Wcd9fonKkc4cn3GrGG-e2NYmZ6mW5nwkQUEdzGngs7CkNr7HFOOMMBXvwDLkb9HIEKLXOT3gENOt2r25wS_3s_QDfCItiaawdC__MAZZV7BRIpyR9Vfh427tcMVMbJgtvebLyLT3xpleaYWRra-tdbkWQfbzWEtz2Z5Y27dGpfZxVKzGZi6aJpFiZvXdP_LdDC1BkpRzgPSGZF1P3VZBec3jwzjblrDJcOTT-IFslsUiynwvfncCCaFPlfzI5QsBEPgsa1bpW_A2J8TV9z5Bujro1TwRhjwPGS0MNqlfybz5enw517FguyFnggex";

@Step
    public static Response post(Playlist requestPlaylist){
        return RestResource.post(USERS+"/"+ ConfigLoader.getInstance().getUser() +PLAYLISTS,getToken(),requestPlaylist);
       /* return given(getRequestSpec()).
                body(requestPlaylist).
                when().
                post("users/31lmbccihqs7fzvv42u2ppa356k4/playlists").
                then().spec(getResponseSpec()).
                extract().
                response();*/ //because we created the restresource method for more re-usability.
    }
    public static Response get(String playlistId){
        return RestResource.get(PLAYLISTS+"/"+playlistId,getToken());
       /* return given(getRequestSpec()).
                when().get("/playlists/"+playlistId).
                then().spec(getResponseSpec()).
                extract().response();*/
    }

    public static Response update(String playlistId , Playlist requestPlaylist){
        return RestResource.update(PLAYLISTS+"/"+playlistId,getToken(),requestPlaylist);
        /*return given(getRequestSpec()).
                body(requestPlaylist).
                when().put("/playlists/"+playlistId).
                then().spec(getResponseSpec()).
                extract().response();*/

    }
}
