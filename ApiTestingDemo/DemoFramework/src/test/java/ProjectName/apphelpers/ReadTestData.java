package ProjectName.apphelpers;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

/**
 * Created by piyush on 20/3/17.
 */
public class ReadTestData {

        public static String readDataByTagName(String tagName,String index) throws JDOMException {
            String tagNameValue="";
            String className="";
            String classNametag="";
            StackTraceElement[] elements=Thread.currentThread().getStackTrace();

            for(int iter=0;iter<elements.length;iter++){

                if(elements[iter].getClassName().contains("sun.reflect.NativeMethodAccessorImpl"))
                {
                    className=elements[iter-1].getClassName();
                    classNametag = className;
                    break;
                }

            }
            String[] ClassName=classNametag.split("\\.");
            String classNameTrimmed=ClassName[2]+"_"+ClassName[3];

            String workingDir = System.getProperty("user.dir");
            File fXmlFile = new File(workingDir+"/src/test/java/ProjectName/testdata/"+classNameTrimmed+".xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            try {

                // converted file to document object
                Document document = saxBuilder.build(fXmlFile);
                Element rootNode = document.getRootElement();
                List<Element> allChildren = rootNode.getChildren();
                for(Element ele:allChildren){
                    List<Attribute> list = ele.getAttributes();
                    for(Attribute all:list){
                        if(all.getValue().equals(index)){
                            tagNameValue=ele.getChildText(tagName);
                            break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Exception in method getXml of class ReadXMLData"+e);
            }
            return tagNameValue;
        }
    }


