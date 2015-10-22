package xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		XmlBean bean = new XmlBean();
		bean.setName("xml");
		bean.setNick_name("fun_with_xml");
		bean.setNum(100);
		XStreamWithXml xml = new XStreamWithXml();
		xml.xstream.alias("xml",XmlBean.class);
		String xmlStr = xml.xstream.toXML(bean);
		/**
		 * xmlStr value:
		 * <xml>
  		*		<name><![CDATA[xml]]></name>
  		*		<nick_name><![CDATA[fun_with_xml]]></nick_name>
  		*		<num>100</num>
		*	</xml>
		 */
		InputStream   inputStream   =   new   ByteArrayInputStream(xmlStr.getBytes());   
		try {
			Map m = xml.parseXml(inputStream);
			/**
			 * m value:
			 * {nick_name=fun_with_xml, num=100, name=xml}
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
