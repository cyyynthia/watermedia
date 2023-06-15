package me.srrapero720.watermedia.api.media.patch;

import me.srrapero720.watermedia.api.media.patch.util.kick.KickAPI;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

public class KickPatch extends BaseVideoPatch {

    @Override
    public boolean isValid(@NotNull URL url) {
        return url.getHost().contains("kick.com");
    }

    @Override
    public String build(@NotNull URL url) throws Exception {
        super.build(url);

        if (url.getPath().contains("/video/")) {
             var call = KickAPI.NET.getVideoInfo(url.getPath().replace("/video/", ""));
             try {
                 var res = call.execute();
                 if (res.isSuccessful() && res.body() != null) return res.body().url;
             } catch (Exception e) {
                 throw new PatchingUrlException(url.toString(), e);
             }
        } else {
            var call = KickAPI.NET.getChannelInfo(url.getPath().replace("/", ""));
            try {
                var res = call.execute();
                if (res.isSuccessful() && res.body() != null) return res.body().url;
            } catch (Exception e) {
                throw new PatchingUrlException(url.toString(), e);
            }
        }

        return null;
    }
}