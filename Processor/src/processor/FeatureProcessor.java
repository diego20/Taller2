package processor;

import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.omg.CORBA.OBJ_ADAPTER;

import annotation.Feature;
import generated.And;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Or;
import generated.Struct;
import spoon.processing.AbstractProcessor;
import spoon.reflect.Factory;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;

public class FeatureProcessor extends AbstractProcessor<CtAnnotation<Feature>> {
	
	FeatureModel fm;
	ObjectFactory factory;
	Struct struct;
	
	@Override
	public void init() {
		factory = new ObjectFactory();
		fm = factory.createFeatureModel();
		struct = factory.createStruct();
		
		And root = factory.createAnd();
		root.setName("Biblioteca");
		struct.setAnd(root);
		fm.setStruct(struct);
		// TODO Auto-generated method stub
		super.init();
	}
	
	
	public void process(CtAnnotation<Feature> annotation) {
		if(annotation.getParent() instanceof CtClass)
			System.out.println("Class Found "+annotation.getParent().getSignature());
		else if (annotation.getParent() instanceof CtConstructor)
			System.out.println("Constructor Found "+annotation.getParent().getSignature());
		else if (annotation.getParent() instanceof CtElement)
		{
			System.out.println("Element values: "+annotation.getElementValues()+":"+annotation.getElementValue("obligatorio"));
			
			Or d = factory.createOr();
			And hijo = factory.createAnd();
			hijo.setName(annotation.getElementValue("obligatorio").toString());
			struct.setAnd(hijo);

		}
		
	}	

	@Override
	public void processingDone() {
		// TODO Auto-generated method stub
		jaxbWriter(fm, "./resources/model.xml", "./resources/featureide.xsd");
		super.processingDone();
	}
	
	
	/**
	 * Writes the contents of a JAXB model in an xml file with identation and
	 * blank spaces
	 * 
	 * @param root
	 *            the root of the object to write
	 * @param path
	 *            destination of the file to create
	 */
	private void jaxbWriter(Object root, String path, String schema) {
		try {
			JAXBContext context = JAXBContext.newInstance(root.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			marshaller.marshal(root, new FileWriter(path));
		} catch (JAXBException e) {
			System.err
					.println("Error while preparing to write the JAXB model in: "
							+ path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: "
					+ path);
			e.printStackTrace();
		}
	}
}
