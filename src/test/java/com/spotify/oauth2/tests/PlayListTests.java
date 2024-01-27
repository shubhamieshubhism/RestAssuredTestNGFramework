package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.spotify.oauth2.utils.FakerUtils.generateDescription;
import static com.spotify.oauth2.utils.FakerUtils.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Epic("Spotify Oauth2.0")
@Feature("playlist API")

public class PlayListTests extends BaseTest{
    @Story("Create a playlist story")
    @Link("https://example.org")
    @Link(name="allure",type="mylink")
    @TmsLink("12345")
    @Issue("123456")
    @Description("this is the description")

    @Test(description = "should be able to create a playlist")
    public void shouldbeAbleToCreatePlaylist(){
        Playlist requestPlaylist=playlistBuilder(generateName(),generateDescription(),false);
        Response response=PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
       // assertThat(response.statusCode(),equalTo(201));

       // Playlist responsePlaylist=response.as(Playlist.class);//deserialization
        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);

        /*Playlist responsePlaylist=given(getRequestSpec()).
                body(requestPlaylist).
        when().
                post("users/31lmbccihqs7fzvv42u2ppa356k4/playlists").
        then().spec(getResponseSpec()).
                assertThat().statusCode(201).
                extract().response().as(Playlist.class);*/ //after making methods generic


    }

    @Test
    public void shouldbeAbleToGetPlaylist(){
        Playlist requestPlaylist=playlistBuilder(generateName(),generateDescription(),false);
        Response response=PlaylistApi.get(DataLoader.getInstance().getPlaylistId());
        assertStatusCode(response.statusCode(),StatusCode.CODE_200);

        //Playlist responsePlaylist=response.as(Playlist.class);//deserialization
        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);


        /*Playlist responsePlaylist=given(getRequestSpec()).
                when().get("/playlists/3VBmSG4jPxF6N3beEkDWQV").
                then().spec(getResponseSpec()).
                assertThat().statusCode(200).
                extract().response().as(Playlist.class);*/ //after making methods generic


    }

    @Test
    public void shouldbeAbleToUpdateAPlaylist(){
        Playlist requestPlaylist=playlistBuilder(generateName(),generateDescription(),true);
        Response response=PlaylistApi.update(DataLoader.getInstance().getPlaylistId(), requestPlaylist);
        assertStatusCode(response.statusCode(),StatusCode.CODE_200);




        /*Playlist responsePlaylist=given(getRequestSpec()).
                body(requestPlaylist).
                when().put("/playlists/6PQZ09lK8vblY18wCqBv4v").
                then().spec(getResponseSpec()).
                assertThat().statusCode(200).extract().
                response().as(Playlist.class);
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(),equalTo(requestPlaylist.getPublic()));*/

    }

  /*  @Test
    public void shouldnotbeAbleToCreatePlaylistWithName(){
      Playlist requestPlaylist=new Playlist().
        setName("New Playlist").
        setDescription("New playlist description").
        setPublic(false);

        Error error=given(requestSpecification).
                body(requestPlaylist).
                when().
                post("users/31lmbccihqs7fzvv42u2ppa356k4/playlists").
                then().spec(responseSpecification).
                assertThat().statusCode(400).
                extract().response().as(Error.class);
        assertThat(error.getError().getStatus(),equalTo(400));
        assertThat(error.getError().getMessage(),equalTo("Missing required field: name"));


    }

    @Test
    public void shouldnotbeAbleToCreatePlaylistWithExpiredToken(){
        Playlist requestPlaylist=new Playlist().
        setName("New Playlist").
        setDescription("New playlist description").
        setPublic(false);

        String payload="{\n" +
                "    \"name\": \"New Playlist\",\n" +
                "    \"description\": \"New playlist description\",\n" +
                "    \"public\": false\n" +
                "}";
        Error error=given().
                baseUri("https://api.spotify.com").
                basePath("/v1").
                header("Authorization","Bearer "+"12344").
                contentType(ContentType.JSON).
                log().all().
                body(requestPlaylist).
                when().
                post("users/31lmbccihqs7fzvv42u2ppa356k4/playlists").
                then().spec(responseSpecification).
                assertThat().statusCode(401).
                extract().response().as(Error.class);
        assertThat(error.getError().getStatus(),equalTo(401));
        assertThat(error.getError().getMessage(),equalTo("Invalid access token"));


    }*/
    @Step
  public Playlist playlistBuilder(String name,String description,boolean _public){
      return Playlist.builder().
              name(name).
              description(description).
              _public(_public).
              build();
  }
@Step
    public void assertPlaylistEqual(Playlist responsePlaylist,Playlist requestPlaylist){
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));
    }
@Step
    public void assertStatusCode(int actualStatusCode,StatusCode statusCode){
        assertThat(actualStatusCode,equalTo(statusCode.code));
    }



}
