package com.lecturador.android.comunicacion;

import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * Created by Dario Pardo on 6/28/2017.
 */
public class MarshalDouble implements Marshal {
    @Override
    public Object readInstance(XmlPullParser xmlPullParser, String s, String s1, PropertyInfo propertyInfo) throws IOException, XmlPullParserException {
        return Double.parseDouble(xmlPullParser.nextText());
    }

    @Override
    public void writeInstance(XmlSerializer xmlSerializer, Object o) throws IOException {
        xmlSerializer.text(o.toString());

    }

    @Override
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "double", double.class, this);
    }
}
