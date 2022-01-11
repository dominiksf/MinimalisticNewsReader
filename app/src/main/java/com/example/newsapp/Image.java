package com.example.newsapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "enclosure", strict = false)
public class Image {

    @Attribute String url;

}
