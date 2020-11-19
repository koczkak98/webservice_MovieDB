package com.moviedb.webservice_MovieDB.parsing;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class PopularMovie {

    public List getPopularMovies (String rawData) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new StringReader(rawData));

        Element rootElement = document.getRootElement();
        Element popularityChildElement = rootElement.getChild("popularity");
        List<Element> songElements = popularityChildElement.getChildren();

        return songElements;
    }


}
