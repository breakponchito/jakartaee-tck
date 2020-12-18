/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.jaxws.wsi.j2w.rpc.literal.R2111;

import java.util.Properties;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.javatest.Status;
import com.sun.ts.lib.harness.ServiceEETest;
import com.sun.ts.tests.jaxws.sharedclients.ClientFactory;
import com.sun.ts.tests.jaxws.sharedclients.SOAPClient;
import com.sun.ts.tests.jaxws.sharedclients.rpclitclient.J2WRLSharedClient;
import com.sun.ts.tests.jaxws.wsi.constants.DescriptionConstants;
import com.sun.ts.tests.jaxws.wsi.constants.SchemaConstants;

public class Client extends ServiceEETest
    implements DescriptionConstants, SchemaConstants {
  /**
   * The client.
   */
  private SOAPClient client;

  static J2WRLShared service = null;

  /**
   * Test entry point.
   * 
   * @param args
   *          the command-line arguments.
   */
  public static void main(String[] args) {
    Client tests = new Client();
    Status status = tests.run(args, System.out, System.err);
    status.exit();
  }

  /**
   * @class.testArgs: -ap jaxws-url-props.dat
   * @class.setup_props: webServerHost; webServerPort; platform.mode;
   *
   * @param args
   * @param properties
   *
   * @throws Fault
   */
  public void setup(String[] args, Properties properties) throws Fault {
    client = ClientFactory.getClient(J2WRLSharedClient.class, properties, this,
        service);
    logMsg("setup ok");
  }

  public void cleanup() {
    logMsg("cleanup");
  }

  /**
   * @testName: testArrayType
   *
   * @assertion_ids: WSI:SPEC:R2111
   *
   * @test_Strategy: Retrieve the WSDL, generated by the Java-to-WSDL tool, and
   *                 examine the complex types, making sure they do not use the
   *                 wsdl:ArrayType.
   *
   * @throws Fault
   */
  public void testArrayType() throws Fault {
    NodeList list = client.getDocument()
        .getElementsByTagNameNS(XSD_NAMESPACE_URI, XSD_ATTRIBUTE_LOCAL_NAME);
    for (int i = 0; i < list.getLength(); i++) {
      verifyAttribute((Element) list.item(i));
    }
  }

  protected void verifyAttribute(Element element) throws Fault {
    Attr attribute = element.getAttributeNodeNS(WSDL_NAMESPACE_URI,
        WSDL_ARRAY_TYPE_ATTR);
    if (attribute != null) {
      throw new Fault(
          "Encountered comple type that uses attribute with 'wsdl:arrayType' (BP-R2111)");
    }
  }
}
