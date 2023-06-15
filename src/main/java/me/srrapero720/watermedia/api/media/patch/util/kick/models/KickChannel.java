package me.srrapero720.watermedia.api.media.patch.util.kick.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class KickChannel implements Serializable {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("user_id")
    @Expose
    public int userId;

    @SerializedName("slug")
    @Expose
    public String username;

    @SerializedName("playback_url")
    @Expose
    public String url;

    @SerializedName("livestream")
    @Expose
    @Nullable
    public isLive isStreaming;

    public static class isLive implements Serializable {
        @SerializedName("id")
        @Expose
        public int id;

        @SerializedName("is_live")
        @Expose
        public boolean isStreaming;
    }
}