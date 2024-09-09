package org.example;

import org.jibx.runtime.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        try {
//            // Load the JiBX binding factory for HotelSettingUpdateRQ
//            IBindingFactory bfact = BindingDirectory.getFactory(HotelSettingUpdateRQ.class);
//
//            // Create an unmarshalling context
//            IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
//
//            // XML input string
//            String xmlInput = "<HotelSettingUpdateRQ>\n" +
//                    "    <HotelID>1098</HotelID>\n" +
//                    "    <Settings>\n" +
//                    "        <Setting>\n" +
//                    "            <SettingName>Enable Family Pricing</SettingName>\n" +
//                    "            <SettingID>1</SettingID>\n" +
//                    "            <SettingValue>true</SettingValue>\n" +
//                    "        </Setting>\n" +
//                    "        <Setting>\n" +
//                    "            <SettingName>Disable Extended Hold</SettingName>\n" +
//                    "            <SettingID>2</SettingID>\n" +
//                    "            <SettingValue>false</SettingValue>\n" +
//                    "        </Setting>\n" +
//                    "    </Settings>\n" +
//                    "</HotelSettingUpdateRQ>\n";
//
//
//            // Unmarshal XML to Java object
//            HotelSettingUpdateRQ hotelSettingUpdateRQ = (HotelSettingUpdateRQ) uctx.unmarshalDocument(new StringReader(xmlInput), null);
//
//            // Use the unmarshalled object
//            System.out.println("Hotel ID: " + hotelSettingUpdateRQ.getHotelID());
//
//        } catch (JiBXException e) {
//            e.printStackTrace();
//        }

        try {
            IBindingFactory bindingFactory = BindingDirectory.getFactory(HotelSettingUpdateRQ.class);
            IUnmarshallingContext unmarshallingContext = bindingFactory.createUnmarshallingContext();

            FileInputStream xmlInput = new FileInputStream("src/main/resources/HotelSettingUpdateRQ.xml");
            HotelSettingUpdateRQ hotelSettingUpdateRQ = (HotelSettingUpdateRQ) unmarshallingContext.unmarshalDocument(xmlInput, null);

            System.out.println("HotelID: " + hotelSettingUpdateRQ.getHotelID());
            Settings settings = hotelSettingUpdateRQ.getSettings();
            List<Setting> settingsList = settings.getSettingList();
            System.out.println("Settings: ");
            System.out.println("Setting name\tSetting ID\tSetting value");

            for (Setting setting: settingsList){
                System.out.print(setting.getSettingName() + "\t");
                System.out.print(setting.getSettingID() + "\t");
                System.out.println(setting.isSettingValue() + "\t");
            }

            // code for creation of response xml file starts from here
            HotelSettingUpdateRS hotelSettingUpdateRS = new HotelSettingUpdateRS();
            hotelSettingUpdateRS.setHotelID(hotelSettingUpdateRQ.getHotelID());

            List<SettingRS> settingsRSList = new ArrayList<>();
            for (Setting setting: settingsList){
                SettingRS settingRS = new SettingRS();
                settingRS.setSettingID(setting.getSettingID());
                settingRS.setSettingStatus(true);
                settingsRSList.add(settingRS);
            }
            hotelSettingUpdateRS.setSettings(settingsRSList);

            try {
                IBindingFactory bfact = BindingDirectory.getFactory(HotelSettingUpdateRS.class);
                IMarshallingContext mctx = bfact.createMarshallingContext();

                FileOutputStream fos = new FileOutputStream("src/main/resources/HotelSettingUpdateRS.xml");
                mctx.setIndent(2);  // Set indentation for pretty printing
                mctx.marshalDocument(hotelSettingUpdateRS, "UTF-8", null, fos);
                System.out.println("XML generated successfully.");
            } catch (JiBXException | IOException e) {
                e.printStackTrace();
            }

        } catch (JiBXException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}