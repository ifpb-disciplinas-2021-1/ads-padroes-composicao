package br.edu.ifpb.composite;

import java.util.ArrayList;
import java.util.List;

/*
       <name attributes>
           value
           <>
           <>
       </name>
    */
public class TagXML {
    private String name = "";
    private String value ="";
    private List<TagXML> tags = new ArrayList<>(); //conjunto

    private StringBuffer attributes = new StringBuffer();
    public TagXML(String name) {
        this.name = name;
    }
    public void value(String value){
        this.value = value;
    }
    public void addAttribute(String attribute, String value){
        attributes.append(" ")
                .append(attribute)
                .append(" = \"")
                .append(value)
                .append("\" ");
    }
    public  void addTag(TagXML tag){
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<").append(name);
        buffer.append(attributes).append(">");
        for(TagXML tag:tags){
            buffer.append(tag.toString());
        }
        buffer.append(value);
        buffer.append("</").append(name).append(">");
        return buffer.toString();
    }
}
