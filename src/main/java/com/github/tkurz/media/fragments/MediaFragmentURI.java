package com.github.tkurz.media.fragments;

import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Represents a media fragment uri (like specified in http://www.w3.org/TR/media-frags/)
 * <p/>
 * Author: Thomas Kurz (tkurz@apache.org)
 */
public class MediaFragmentURI {

    private URI uri;
    private MediaFragment mediaFragment;

    /**
     * Creates a media fragment from string. If no fragment is specified, an empty media fragment is created
     * @param uri_string a uri (may have media fragments)
     * @throws MediaFragmentURISyntaxException
     */
    public MediaFragmentURI(String uri_string) throws MediaFragmentURISyntaxException {
        try {
            this.uri = new URI(uri_string);
            if(uri.getFragment() != null) {
                FragmentParser p1 = new FragmentParser(new StringReader(uri.getFragment()));
                mediaFragment = p1.run();
            } else {
                mediaFragment = new MediaFragment();
            }
        } catch (URISyntaxException | ParseException e) {
            throw new MediaFragmentURISyntaxException(e);
        }
    }

    public String getScheme() {
        return uri.getScheme();
    }

    public String getAuthority() {
        return uri.getAuthority();
    }

    public String getPath() {
        return uri.getPath();
    }

    public String getAbsolutePath() {
        StringBuilder b = new StringBuilder();
        b.append(uri.getScheme());
        b.append("://");
        b.append(uri.getAuthority());
        b.append(uri.getPath());
        return b.toString();
    }

    /**
     * returns the media fragment
     * @return a media fragment
     */
    public MediaFragment getMediaFragment() {
        return mediaFragment;
    }

    public String toString() {
        return mediaFragment != null ? getAbsolutePath() + mediaFragment.toString() : getAbsolutePath();
    }
}
