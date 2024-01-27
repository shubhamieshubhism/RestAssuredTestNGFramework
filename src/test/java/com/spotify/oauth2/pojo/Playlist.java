
package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import javax.annotation.Generated;
//@Data
@Getter @Setter
@Jacksonized
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
public class Playlist {

    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private Object images;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Tracks tracks;



}
