package sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Parser {

    public void Parser(File file){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try{
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            PwsHandler handler = new PwsHandler();
            saxParser.parse(file, handler);
        }
        catch (ParserConfigurationException | SAXException | IOException e){e.printStackTrace();}
    }

}

class PwsHandler extends DefaultHandler{
    private boolean bText = false;
    private boolean bFormat = false;
    @Override
    public void startDocument() throws SAXException{}
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) throws SAXException{
        // Font
        String attrs_font = attrs.getValue("font");
        String attrs_size = attrs.getValue("textsize");
        String attrs_bold = attrs.getValue("bold");
        String attrs_italic = attrs.getValue("italic");
        String attrs_underline = attrs.getValue("underline");

        String font;
        int size;
        boolean bold;
        boolean italic;
        boolean underline;

        // Transition
        String attrs_start = attrs.getValue("start");
        String attrs_duration = attrs.getValue("duration");

        String start;
        int duration;

        if(attrs_start != null){
            start = attrs_start;
        }
        else{
            start = "0";
        }

        if(attrs_duration != null){
            duration = Integer.parseInt(attrs_duration);
        }
        else{
            duration = -1;
        }

        // Media
        String attrs_path = attrs.getValue("path");

        String path;

        if(attrs_path != null){
            path = attrs_path;
        }
        else{
            path = "";
        }

        // Colour
        String attrs_color = attrs.getValue("color");
        String attrs_fill = attrs.getValue("fill");

        String color;
        String fill;

        // Position
        String attrs_x = attrs.getValue("x");
        String attrs_y = attrs.getValue("y");
        String attrs_x2 = attrs.getValue("x2");
        String attrs_y2 = attrs.getValue("y2");

        double x;
        double y;
        double x2;
        double y2;

        if(attrs_x != null){
            x = Integer.parseInt(attrs_x);
        }
        else{
            x = 0;
        }

        if(attrs_x2 != null){
            x2 = Integer.parseInt(attrs_x2);
        }
        else{
            x2 = 0;
        }

        if(attrs_y != null){
            y = Integer.parseInt(attrs_y);
        }
        else{
            y = 0;
        }

        if(attrs_y2 != null){
            y2 = Integer.parseInt(attrs_y2);
        }
        else{
            y2 = 0;
        }

        // Meta
        String attrs_key = attrs.getValue("key");
        String attrs_value = attrs.getValue("value");

        String key;
        String value;

        if(attrs_key != null){
            key = attrs_key;
        }
        else{
            key = "";
        }

        if(attrs_value != null){
            value = attrs_value;
        }
        else{
            value = "";
        }

        // Shape
        String attrs_type = attrs.getValue("type");
        String attrs_stroke = attrs.getValue("stroke");

        String type;
        double stroke;

        if(attrs_type != null){
            type = attrs_type;
        }
        else{
            type = "";
        }

        if(attrs_stroke != null){
            stroke = Double.parseDouble(attrs_stroke);
        }
        else{
            stroke = 0;
        }

        switch(qName.toLowerCase()){
            case "presentation": {

                System.out.println("new presentation");

                if(attrs_font != null){ font = attrs_font; }
                else{ font = "Arial"; }

                if(attrs_size != null){ size = Integer.parseInt(attrs_size); }
                else{ size = 14; }

                if(attrs_bold != null){ bold = Boolean.parseBoolean(attrs_bold); }
                else{ bold = false; }

                if(attrs_italic != null){ italic = Boolean.parseBoolean(attrs_italic); }
                else{ italic = false; }

                if(attrs_underline != null){ underline = Boolean.parseBoolean(attrs_underline); }
                else{ underline = false; }

                System.out.println("    text formatting: font: " + font + ", size: " + size + ", bold: " + bold + ", italic: " + italic + ", underline: " + underline);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                System.out.println("    color formatting: color: " + color + ", fill: " + fill);
            }
            break;
            case "meta": {

                System.out.println("    meta: key: " + key + ", value: " + value);

            }
            break;
            case "slide": {

                System.out.println("new slide");

                if(attrs_font != null){ font = attrs_font; }
                else{ font = "Arial"; }

                if(attrs_size != null){ size = Integer.parseInt(attrs_size); }
                else{ size = 14; }

                if(attrs_bold != null){ bold = Boolean.parseBoolean(attrs_bold); }
                else{ bold = false; }

                if(attrs_italic != null){ italic = Boolean.parseBoolean(attrs_italic); }
                else{ italic = false; }

                if(attrs_underline != null){ underline = Boolean.parseBoolean(attrs_underline); }
                else{ underline = false; }

                System.out.println("    text formatting: font: " + font + ", size: " + size + ", bold: " + bold + ", italic: " + italic + ", underline: " + underline);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                System.out.println("    color formatting: color: " + color + ", fill: " + fill);

            }
            break;
            case "text": {
                bText = true;
                System.out.println("new text");

                if(attrs_font != null){ font = attrs_font; }
                else{ font = "Arial"; }

                if(attrs_size != null){ size = Integer.parseInt(attrs_size); }
                else{ size = 14; }

                if(attrs_bold != null){ bold = Boolean.parseBoolean(attrs_bold); }
                else{ bold = false; }

                if(attrs_italic != null){ italic = Boolean.parseBoolean(attrs_italic); }
                else{ italic = false; }

                if(attrs_underline != null){ underline = Boolean.parseBoolean(attrs_underline); }
                else{ underline = false; }

                System.out.println("    text formatting: font: " + font + ", size: " + size + ", bold: " + bold + ", italic: " + italic + ", underline: " + underline);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                System.out.println("    color formatting: color: " + color + ", fill: " + fill);

            }
            break;
            case "format": {
                bFormat = true;
                System.out.println("new format");

                if(attrs_font != null){ font = attrs_font; }
                else{ font = "Arial"; }

                if(attrs_size != null){ size = Integer.parseInt(attrs_size); }
                else{ size = 14; }

                if(attrs_bold != null){ bold = Boolean.parseBoolean(attrs_bold); }
                else{ bold = false; }

                if(attrs_italic != null){ italic = Boolean.parseBoolean(attrs_italic); }
                else{ italic = false; }

                if(attrs_underline != null){ underline = Boolean.parseBoolean(attrs_underline); }
                else{ underline = false; }

                System.out.println("    text formatting: font: " + font + ", size: " + size + ", bold: " + bold + ", italic: " + italic + ", underline: " + underline);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                System.out.println("    color formatting: color: " + color + ", fill: " + fill);

            }
            break;
            case "br": {

                System.out.println("new break");

            }
            break;
            case "shape": {

                System.out.println("new shape");

                System.out.println("    shape: type: " + type + ", stroke: " + stroke);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                System.out.println("    color formatting: color: " + color + ", fill: " + fill);

            }
            break;
            case "image": {

                System.out.println("new image");

                System.out.println("    image: path: " + path);

            }
            break;
            case "audio": {
                System.out.println("new audio");

                System.out.println("    audio: path: " + path);

            }
            break;
            case "video": {
                System.out.println("new video");

                System.out.println("    video: path: " + path);
            }
            break;
        }
    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException{
        switch (qName.toLowerCase()){
            case "text":
                bText = false;
                break;
            case  "format":
                bFormat = false;
                break;
        }
    }
    @Override
    public void endDocument() throws SAXException{}
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        String string = new String(ch, start, length);
        if(bText){
            if(bFormat){
                System.out.println("    text = " + string);
            }
            else {
                System.out.println("    text = " + string.trim());
            }

        }
    }
}