package sample;


import PWS.*;
import PWS.ImagePws;
import PWS.ShapePws;
import PWS.Slide;
import PWS.VideoPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public Presentation Parser(File file){
        SAXParserFactory spf = SAXParserFactory.newInstance(); //parser constructor
        try{
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            PwsHandler handler = new PwsHandler(); //sets up PWS handler
            saxParser.parse(file, handler); //parses using PWS handler
            return handler.getPresentation(); //returns presentation
        }
        catch (ParserConfigurationException | SAXException | IOException e){ //catching exceptions
            e.printStackTrace();
            return null;
        }
    }
}

class PwsHandler extends DefaultHandler{
    private boolean bText = false; //setting up variables
    private boolean bFormat = false;

    private Presentation presentation;
    private Slide slide;
    private TextView textView;

    private ArrayList<Text> textArrayList;

    private Fonts fonts, formatFonts;
    private Colors colors, formatColors;

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    Presentation getPresentation() {
        return presentation;
    } //defines get presentation method

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) throws SAXException{

        // variable set up for multiple PWS required classes

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
            x2 = width;
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
            y2 = height;
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

                if(attrs_font != null){ font = attrs_font; } //identifying attibutes and parsing to variables
                else{ font = "Arial"; }

                if(attrs_size != null){ size = Integer.parseInt(attrs_size); }
                else{ size = 14; }

                if(attrs_bold != null){ bold = Boolean.parseBoolean(attrs_bold); }
                else{ bold = false; }

                if(attrs_italic != null){ italic = Boolean.parseBoolean(attrs_italic); }
                else{ italic = false; }

                if(attrs_underline != null){ underline = Boolean.parseBoolean(attrs_underline); }
                else{ underline = false; }

                Fonts fonts = new Fonts(font, italic, bold, underline, size);


                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                Colors colors = new Colors(color, fill);


                presentation = new Presentation(fonts, colors);

            }
            break;
            case "meta": {

                presentation.add(new Meta(key, value));

            }
            break;
            case "slide": {


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

                Fonts fonts = new Fonts(font, italic, bold, underline, size);

                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                Colors colors = new Colors(color, fill);

                Transitions transitions = new Transitions(start, duration);

                slide = new Slide(fonts, colors, transitions);
                presentation.add(slide);

            }
            break;
            case "text": {
                bText = true;

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


                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }



                fonts = new Fonts(font, italic, bold, underline, size);
                colors = new Colors(color, fill);

                Transitions transitions = new Transitions(start, duration);

                textArrayList = new ArrayList<>();
                textView = new TextView(x, y, x2-x, y2-y, Font.font(fonts.getFont(), fonts.getBold(), fonts.getItalic(), fonts.getTextsize()), (Color)colors.getColor(), transitions.getStart(), transitions.getDuration());

            }
            break;
            case "format": {
                bFormat = true;


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


                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }


                formatFonts = new Fonts(font, italic, bold, underline, size);
                formatColors = new Colors(color, fill);

            }
            break;
            case "br": {


                textArrayList.add(new Text("\n"));
            }
            break;
            case "shape": {

                Position position = new Position(x, y, x2, y2);


                if(attrs_color != null){ color = attrs_color; }
                else{ color = "#000000"; }

                if(attrs_fill != null){ fill = attrs_fill; }
                else{ fill = "#ffffff"; }

                Colors colors = new Colors(color, fill);


                slide.add(new ShapePws(position, colors, type, stroke));

            }
            break;
            case "image": {

                Position position = new Position(x, y, x2, y2);

                try{
                    slide.add(new ImagePws(position, path));
                }
                catch(NullPointerException e){
                    System.out.println("Image file not found");
                }
            }
            break;
            case "audio": {
                try{
                    slide.add(new Audio(path, false));
                }
                catch(NullPointerException e){
                    System.out.println("Audio file not found");
                }

            }
            break;
            case "video": {
                try{
                    VideoPlayer videoPlayer = new VideoPlayer(path);
                    videoPlayer.enableVideoControls();

                    slide.add(videoPlayer);
                }
                catch (NullPointerException e) {
                    System.out.println("Video file not found.");
                }

            }
            break;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException{

        switch (qName.toLowerCase()){ //compiling text together once end is reached
            case "text":
                bText = false;
                for(Text text : textArrayList){
                    textView.addText(text);
                }
                slide.add(textView);
                break;
            case  "format":
                bFormat = false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        String string = new String(ch, start, length);
        if(bText){ // only checks if in text part of xml file
            if(bFormat){
                Text text = new Text(string); //text parsing if formatted
                text.setFont(Font.font(formatFonts.getFont(), formatFonts.getBold(), formatFonts.getItalic(), formatFonts.getTextsize()));
                text.setUnderline(formatFonts.isUnderline());
                text.setFill(formatColors.getColor());

                textArrayList.add(text);
            }
            else {
                Text text = new Text(string.trim()); // removes unwanted space
                text.setFont(Font.font(fonts.getFont(), fonts.getBold(), fonts.getItalic(), fonts.getTextsize()));
                text.setUnderline(fonts.isUnderline());
                text.setFill(colors.getColor());

                textArrayList.add(text);
            }

        }
    }
}