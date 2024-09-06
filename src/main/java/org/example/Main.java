package org.example;

import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.jibx.runtime.BindingDirectory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        try {
            IBindingFactory bindingFactory = BindingDirectory.getFactory(Person.class);
            IUnmarshallingContext unmarshallingContext = bindingFactory.createUnmarshallingContext();

            FileInputStream xmlInput = new FileInputStream("src/main/resources/person.xml");
            Person person = (Person) unmarshallingContext.unmarshalDocument(xmlInput, null);

            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());

        } catch (JiBXException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}