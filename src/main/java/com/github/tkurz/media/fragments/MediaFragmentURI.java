package com.github.tkurz.media.fragments;

import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * ...
 * <p/>
 * Author: Thomas Kurz (tkurz@apache.org)
 */
public class MediaFragmentURI {

    private URI uri;
    private MediaFragment mediaFragment;

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

    public MediaFragment getMediaFragment() {
        return mediaFragment;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(uri.getScheme());
        b.append("://");
        if(uri.getAuthority() != null) b.append(uri.getAuthority());
        if(uri.getPort() > -1) {
            b.append(":");
            b.append(uri.getPort());
        }
        b.append(uri.getPath());
        if(mediaFragment != null) b.append(mediaFragment.toString());
        return b.toString();
    }
}