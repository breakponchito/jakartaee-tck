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

package com.sun.ts.tests.signaturetest.jsf;

import com.sun.javatest.Status;
import com.sun.ts.tests.signaturetest.SigTest;

import java.io.PrintWriter;

/*
 * This class is a simple example of a signature test that extends the
 * SigTest framework class.  This signature test is run outside of the
 * Java EE containers.  This class also contains the boilerplate
 * code necessary to create a signature test using the test framework.
 * To see a complete TCK example see the javaee directory for the Java EE
 * TCK signature test class.
 */

public class JSFSigTest extends SigTest {

  /***** Abstract Method Implementation *****/

  /**
   * Returns a list of strings where each string represents a package name. Each
   * package name will have it's signature tested by the signature test
   * framework.
   *
   * @return String[] The names of the packages whose signatures should be
   *         verified.
   */
  protected String[] getPackages() {
    return new String[] { "jakarta.faces", "jakarta.faces.application",
        "jakarta.faces.bean", "jakarta.faces.component",
        "jakarta.faces.component.behavior", "jakarta.faces.component.html",
        "jakarta.faces.component.visit", "jakarta.faces.context",
        "jakarta.faces.convert", "jakarta.faces.el", "jakarta.faces.event",
        "jakarta.faces.flow", "jakarta.faces.flow.builder", "jakarta.faces.lifecycle",
        "jakarta.faces.model", "jakarta.faces.render", "jakarta.faces.validator",
        "jakarta.faces.view", "jakarta.faces.view.facelets", "jakarta.faces.webapp" };
  }

  /**
   * ** Boilerplate Code ****
   */

  /*
   * Initial entry point for JavaTest.
   */
  public static void main(String[] args) {
    JSFSigTest theTests = new JSFSigTest();
    Status s = theTests.run(args, System.out, System.err);
    s.exit();
  }

  public Status run(String[] args, PrintWriter out, PrintWriter err) {
    return super.run(args, out, err);
  }

  /*
   * The following comments are specified in the base class that defines the
   * signature tests. This is done so the test finders will find the right class
   * to run. The implementation of these methods is inherited from the super
   * class which is part of the signature test framework.
   */

  // NOTE: If the API under test is not part of your testing runtime
  // environment,
  // you may use the property sigTestClasspath to specify where the API
  // under test lives. This should almost never be used. Normally the API
  // under test should be specified in the classpath of the VM running the
  // signature tests. Use either the first comment or the one below it depending
  // on which properties your signature tests need. Please do not use both
  // comments.

  /*
   * @class.setup_props: sigTestClasspath, Location of JSF api jar files;
   * ts_home, The base path of this TCK;
   */

  /*
   * @testName: signatureTest
   * 
   * @assertion: A JSF platform must implement the required classes and and APIs
   * specified in the JSF Specification.
   * 
   * @test_Strategy: Using reflection, gather the implementation specific
   * classes and APIs. Compare these results with the expected (required)
   * classes and APIs.
   *
   */

  /*
   * Call the parent class's cleanup method.
   */

} // end class CTSSigTest